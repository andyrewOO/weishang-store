package com.egfbank.tfemp.actor.services

import java.io.FileInputStream
import sun.misc.BASE64Encoder
import java.io.File
import xitrum.util.Loader

/**
 * @author andy
 */
object testFileService {
  def main(args: Array[String]): Unit = {
    println(getCaseReportFiles(List(
        Map("FileName" -> "abc")
    )))
  }

  def getCaseReportFiles(fileNames: List[Map[String, String]]) = {
    val caseReportFilePath = Loader.propertiesFromClasspath("tfemp.properties").getProperty("caseReportFilePath")
    fileNames.map { fileNameMap =>
      val fileName = fileNameMap("FileName")
      getFileContent(caseReportFilePath + fileName)
    }
  }

  def getFileContent(fileName: String) = {
    //若文件不存在，应抛出异常
    val file = new File(fileName)
    val bytes = new Array[Byte](file.length().toInt)

    val in = new FileInputStream(file)
    in.read(bytes)
    in.close()

    val encoder = new BASE64Encoder
    val fileContent = encoder.encode(bytes)

    Map(
      "filename" -> file.getName,
      "content" -> fileContent)
  }
}