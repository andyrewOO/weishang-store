package com.egfbank.util

import scala.io.Source
import com.egfbank.tfemp.util.HfbkUtil
import scala.xml.XML
import scala.xml.Elem
import xitrum.Log
import java.sql.ResultSet
import org.apache.commons.dbcp2.BasicDataSourceFactory
import org.apache.commons.dbutils.QueryRunner
import java.sql.SQLException
import java.sql.PreparedStatement
import xitrum.util.Loader
import java.sql.Connection
import javax.sql.DataSource
import java.text.SimpleDateFormat
import com.egfbank.tfemp.util.XMLUtil

/**
 * @author XuHaibin
 */
object TfempInsertData extends Log {
  def main(args: Array[String]): Unit = {
    val source = Source.fromFile(System.getProperty("user.dir") + "/quickstart/applicationid.txt")
    val applicationIDs = source.getLines()
    var count = 0
    for (applicationID <- applicationIDs) {
      println(applicationID)
      val list = query("select XMLCONTENT from TFEMP_CFCA_DOWN where APPLICATIONID=?", Seq(applicationID))
      val xmlContent = list.head.get("XMLCONTENT").get
      val sourceData = XML.loadString(xmlContent)

      if (insertIntoForceMeasureFile(sourceData) == 1) {
        count = count + 1
        log.info(s"applicationID:${applicationID}执行成功！")
      } else {
        log.info(s"applicationID:${applicationID}执行失败！")
      }
    }
    println(s"共成功${count}")
  }

  def insertIntoForceMeasureFile(xml: Elem) = {
    log.info(s"Start insertIntoForceMeasureFile, ApplicationID:${(xml \\ "ApplicationID").text.toString}")

    val ApplicationID = (xml \\ "ApplicationID").text.toString

    val sql = "insert into TFEMP_FORCE_MEASURE_FILE(ID, ApplicationID, FILENAME, FILECONTENT) values(?, ?, ?, ?)"
    // 拿到报文中的法律文书List
    val Attachments = XMLUtil.getFVListMap("Attachments", xml.toString, "Body")

    Attachments.map { attachment =>
      log.debug(s"${sql},parameter:${attachment}")
      executeUpdate(sql, Seq(
        HfbkUtil.getUUID(),
        ApplicationID,
        attachment("Filename"),
        attachment("Content")))
    }
  }

  /**
   * 执行更新或写入
   */
  def executeUpdate(sql: String, v: Seq[Object]): Int = {
    var conn: Connection = null
    var ps: PreparedStatement = null
    var rs: ResultSet = null
    var rtn = 0
    try {
      conn = getConn
      ps = conn.prepareStatement(sql)
      var i: Int = 1
      if (v != null) v.foreach { x => { ps.setObject(i, x); i = i + 1 } }
      rtn = ps.executeUpdate()
    } catch {
      case ex: Exception => log.error(ex.getMessage, ex)
    } finally {
      close(rs, ps, conn)
    }
    rtn
  }

  /**
   * 查询SQL
   */
  def query(sql: String, v: Seq[String]): List[Map[String, String]] = {
    var conn: Connection = null
    var ps: PreparedStatement = null
    var rs: ResultSet = null
    var list: scala.collection.mutable.ArrayBuffer[Map[String, String]] = scala.collection.mutable.ArrayBuffer[Map[String, String]]()
    try {
      conn = getConn
      ps = conn.prepareStatement(sql)
      var i: Int = 1
      if (v != null) v.foreach { x => { ps.setString(i, x); i = i + 1 } }
      rs = ps.executeQuery()
      while (rs.next()) {
        val dm = scala.collection.mutable.Map[String, String]()
        for (i <- 1 to rs.getMetaData.getColumnCount) {
          dm.put(rs.getMetaData.getColumnName(i), rs.getString(i))
        }
        list += dm.toMap
      }
    } catch {
      case ex: Exception => log.error(ex.getMessage, ex)
    } finally {
      close(rs, ps, conn)
    }
    list.toList
  }

  /**
   * 初始化连接池
   */
  val dataSourece: DataSource = BasicDataSourceFactory.createDataSource(Loader.propertiesFromClasspath("dbcp_oracle.properties"))

  /**
   * 获取queryRunner
   * @return
   */
  def getOracleQueryRunner(): QueryRunner = {
    new QueryRunner(dataSourece, true)
  }

  /**
   * 获取连接
   *
   * @return
   */
  def getConn(): Connection = {
    try {
      return dataSourece.getConnection();
    } catch {
      case ex: SQLException => {
        ex.printStackTrace()
      }
    }
    return null;
  }

  /**
   * 释放资源
   *
   * @param rs
   * @param ps
   * @param conn
   */
  def close(rs: ResultSet, ps: PreparedStatement, conn: Connection): Unit = {
    try {
      if (rs != null)
        try {
          rs.close();
        } catch {
          case ex: SQLException => {
            ex.printStackTrace()
          }
        }
    } finally {
      try {
        if (ps != null)
          try {
            ps.close();
          } catch {
            case ex: SQLException => {
              ex.printStackTrace()
            }
          }
      } finally {
        if (conn != null)
          try {
            conn.close();
          } catch {
            case ex: SQLException => {
              ex.printStackTrace()
            }
          }
      }
    }
  }

  def formatData(dateTime: String) = {
    val format = new SimpleDateFormat("yyyyMMddHHmmss")
    format.parse(dateTime).getTime
  }
}