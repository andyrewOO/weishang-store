package com.egfbank.tfemp.actor.worker.module

import akka.actor._
import scala.xml.Elem
import scala.xml.XML
import cfca.safeguard.api.bank.bean.tx.downstream.Tx100203
import java.util.ArrayList
import cfca.safeguard.tx.Attachment
import scala.collection.mutable.HashMap
import com.egfbank.tfemp.util.ToolUtils
import com.egfbank.tfemp.model.TEvent
import com.egfbank.tfemp.actor.ActorHolder
import com.egfbank.tfemp.util.HfbkUtil
import com.egfbank.tfemp.actor.FreezePayFree
//import com.egfbank.tfemp.actor.ServiceLoaderActor.socketActor

/**
 * @author andy
 */

object SocketActionTestFreezeLift extends App {

  val tx100203 = new Tx100203
  tx100203.setAccountName("dsfdsf")
//  tx100203.setAccountNumber("62238453500098285_100007068900010")
  tx100203.setAccountNumber("62238453201307456_153200100234400011")
  tx100203.setAccountType("01")
  tx100203.setApplicationID("sdfd")
  tx100203.setApplicationOrgID("6")
  tx100203.setApplicationOrgName("Andy")
  tx100203.setApplicationTime("20160522101100")
  val atta = new Attachment
  atta.setFilename("1232")
  atta.setContent("12312312")
  val attachments = new ArrayList[Attachment]
  attachments.add(atta)
  tx100203.setAttachments(attachments)
  tx100203.setBankID("hengfeng")
  tx100203.setBankName("hengfeng")
  tx100203.setCaseNumber("asdsd")
  tx100203.setCaseType("normal")
  tx100203.setEmergencyLevel("01")
  tx100203.setFilePath("asds")
  tx100203.setIDNumber("asda")
  tx100203.setIDType("A")
  tx100203.setInvestigatorIDNumber("410825199001127678")
  tx100203.setInvestigatorIDType("01")
  tx100203.setInvestigatorName("asdsd")
  tx100203.setMessageFrom("1232")
  tx100203.setOperatorIDNumber("safsdf")
  tx100203.setOperatorIDType("asdfsf")
  tx100203.setOperatorName("sfsdf")
  tx100203.setOperatorPhoneNumber("123123")
  tx100203.setOriginalApplicationID("410825199001127678")
  tx100203.setTransSerialNumber("00000165")
  tx100203.setWithdrawalRemark("1234")

  val beanMapData = ToolUtils.BeanToMap(tx100203)
  val attachmentsMap = Map("attachments" -> List(Map("fileName" -> "weishu", "content" -> "neirong")))
  val beanMap = new HashMap[String, Any]
  beanMap ++= beanMapData
  beanMap ++= attachmentsMap
  val bean = beanMap.toMap
  ActorHolder.proxyActor ! TEvent[Map[String, Any]](HfbkUtil.getUUID(), FreezePayFree, bean, HfbkUtil.getTime(), Some(null))

}