package com.egfbank.tfemp.actor.worker.module

import akka.actor._
import scala.xml.Elem
import scala.xml.XML
import cfca.safeguard.api.bank.bean.tx.downstream.Tx100205
import java.util.ArrayList
import cfca.safeguard.tx.Attachment
import scala.collection.mutable.HashMap
import com.egfbank.tfemp.util.ToolUtils
import com.egfbank.tfemp.model.TEvent
import com.egfbank.tfemp.actor.ActorHolder
import com.egfbank.tfemp.util.HfbkUtil
import com.egfbank.tfemp.actor.FreezePayDelay
//import com.egfbank.tfemp.actor.ServiceLoaderActor.socketActor

/**
 * @author andy
 */

object SocketActionTestFreezeDelay extends App {
  val basePath_xml = "com/egfbank/tfemp/upxml/"

  val tx100205 = new Tx100205
  tx100205.setAccountName("and")
  tx100205.setAccountNumber("62238453500098285_100007068900010")
  tx100205.setAccountType("01")
  tx100205.setApplicationID("123231")
  tx100205.setApplicationOrgID("6")
  tx100205.setApplicationOrgName("Andy")
  tx100205.setApplicationTime("20150322121212")

  val atta = new Attachment
  atta.setFilename("1232")
  atta.setContent("12312312")
  val attachments = new ArrayList[Attachment]
  attachments.add(atta)
  tx100205.setAttachments(attachments)

  tx100205.setBalance("123")
  tx100205.setBankID("hengfeng")
  tx100205.setBankName("hengfeng")
  tx100205.setCaseNumber("12323")
  tx100205.setCaseType("normal")
  tx100205.setCurrency("CNY")
  tx100205.setEmergencyLevel("01")
    tx100205.setExpireTime("20160501121212")
//  tx100205.setExpireTime("20160701")
  tx100205.setExtendRemark("3434")
  tx100205.setFilePath("1232")
  tx100205.setFreezeType("01")
  tx100205.setIDNumber("3434")
  tx100205.setIDType("")
  tx100205.setInvestigatorIDNumber("410825199001127678")
  tx100205.setInvestigatorIDType("01")
  tx100205.setInvestigatorName("2343")
  tx100205.setMessageFrom("32434")
  tx100205.setOperatorIDNumber("410825199001127678")
  tx100205.setOperatorIDType("99")
  tx100205.setOperatorName("sdfd")
  tx100205.setOperatorPhoneNumber("dsfd")
  tx100205.setOriginalApplicationID("1234333356")
  tx100205.setPostponeStartTime("12323")
  tx100205.setTransSerialNumber("00000030")

  val beanMapData = ToolUtils.BeanToMap(tx100205)
  val attachmentsMap = Map("attachments" -> List(Map("fileName" -> "weishu", "content" -> "neirong")))
  val beanMap = new HashMap[String, Any]
  beanMap ++= beanMapData
  beanMap ++= attachmentsMap
  val bean = beanMap.toMap
  ActorHolder.proxyActor ! TEvent[Map[String, Any]](HfbkUtil.getUUID(), FreezePayDelay, bean, HfbkUtil.getTime(), Some(null))

}