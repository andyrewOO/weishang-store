package com.egfbank.tfemp.actor.worker.module

import akka.actor._
import scala.xml.Elem
import scala.xml.XML
import cfca.safeguard.api.bank.bean.tx.downstream.Tx100201
import scala.collection.mutable.HashMap
import com.egfbank.tfemp.util.ToolUtils
import com.egfbank.tfemp.actor.ActorHolder
import com.egfbank.tfemp.model.TEvent
import com.egfbank.tfemp.util.HfbkUtil
import com.egfbank.tfemp.actor.FreezePay
import java.io.FileInputStream
import java.io.File
import java.io.FileReader
//import com.egfbank.tfemp.actor.ServiceLoaderActor.socketActor

/**
 * @author andy
 */

object TestFreezeWithElem {

  def main(args: Array[String]): Unit = {

    val file = new File("""F:\MyEclipseWorkSpace\tfemp-app\src\test\scala\com\egfbank\tfemp\actor\worker\module\Freeze""")
    val in = new FileInputStream(file)
    val size = in.available()
    val buffer = new Array[Byte](size)

    in.read(buffer)
    in.close()
    val str = new String(buffer, "GB2312")
    val a = str.replace("${TransSerialNumber}", HfbkUtil.getUUID())
    println(a)
    val tx100201 = XML.loadString(str)
  }

}