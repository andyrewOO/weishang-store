package com.egfbank.util

import java.io.File
import java.io.FileOutputStream
import java.io.FileInputStream
import scala.xml.XML
import com.egfbank.tfemp.util.XMLUtil
import sun.misc.BASE64Decoder

/**
 * @author andy
 */
object TestFile {
  def main(args: Array[String]): Unit = {

    val file = new File("""F:\MyEclipseWorkSpace\tfemp-app\src\test\scala\com\egfbank\tfemp\actor\worker\module\Freeze""")
    val in = new FileInputStream(file)
    val size = in.available()
    val buffer = new Array[Byte](size)

    in.read(buffer)
    in.close()
    val str = new String(buffer, "GB2312")
    val tx100201 = XML.loadString(str)

    val Attachments = XMLUtil.getFVListMap("Attachments", tx100201.toString, "Body")
    val base = """f:/c/c"""

    Attachments.map { att =>
      val filename = att("Filename") + ".jpg"
      val content = att("Content")

      // 解码
      val decoder = new BASE64Decoder()
      val decoderBytes = decoder.decodeBuffer(content.replace(" ", ""))

      val file1 = new File(base, filename)
      if (file1.getParentFile.exists()) {
        file1.createNewFile()
      } else {
        file1.getParentFile.mkdirs()
        file1.createNewFile()
      }

      val out = new FileOutputStream(file1)
      out.write(decoderBytes)
      out.close()
    }

  }
}