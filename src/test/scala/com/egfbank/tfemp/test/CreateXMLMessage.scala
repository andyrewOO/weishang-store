package com.egfbank.tfemp.test

import akka.actor._
import com.egfbank.tfemp.util.HfbkUtil
import java.io.FileInputStream
import java.io.File
import java.io.FileOutputStream
//import com.egfbank.tfemp.actor.ServiceLoaderActor.socketActor

/**
 * @author andy
 */

object CreateXMLMessage {

  def main(args: Array[String]): Unit = {
    for (i <- 1 to 2) {
      for (j <- 1 to 1000) {
        createXMlmessage(file = "200301", count = i)
      }
    }

    for (i <- 1 to 2) {
      for (j <- 1 to 1000) {
        createXMlmessage(file = "200309", count = i)
      }
    }

    for (i <- 1 to 2) {
      for (j <- 1 to 1000) {
        createXMlmessage(file = "200101", count = i)
      }
    }
  }

  def createXMlmessage(path: String = """F:\MyEclipseWorkSpace\tfemp-app\src\test\scala\com\egfbank\tfemp\test\""", file: String, count: Int) = {
    val filePath = new File(path + file)
    val in = new FileInputStream(filePath)
    val size = in.available()
    val buffer = new Array[Byte](size)

    in.read(buffer)
    in.close()
    val str = new String(buffer, "GB2312")
    val a = str.replace("${TransSerialNumber}", HfbkUtil.getUUID()).replace("${ApplicationID}", HfbkUtil.getUUID())
    val filename = file + "_" + HfbkUtil.getUUID() + ".xml"

    val outFile = new File("""f:\test\""" + file + "-" + count + """\""", filename)

    if (outFile.getParentFile.exists()) {
      outFile.createNewFile()
      outFile.canWrite()
    } else {
      outFile.getParentFile.mkdirs()
      outFile.createNewFile()
      outFile.canWrite()
    }

    // 向文件中写入内容
    val out = new FileOutputStream(outFile)
    out.write(a.getBytes)
    out.close()
  }

}