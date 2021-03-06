package com.egfbank.scala

import akka.actor._
import scala.xml.Elem
import scala.xml.XML
import cfca.safeguard.api.bank.bean.tx.downstream.Tx100201
import scala.collection.mutable.HashMap
import com.egfbank.tfemp.util.ToolUtils
import com.egfbank.tfemp.actor.ActorHolder
import com.egfbank.tfemp.model.TEvent
import com.egfbank.tfemp.constant.CFCATradeCode
//import com.egfbank.tfemp.actor.ServiceLoaderActor.socketActor

/**
 * @author andy
 */

object SocketActionTestFreeze extends App {

  val tx100201 = new Tx100201
  tx100201.setAccountName("测试")
  tx100201.setAccountNumber("62238453500098285_100007068900010")
  tx100201.setAccountType("01")
  tx100201.setApplicationID("1234333356")
  tx100201.setApplicationOrgID("Andy")
  tx100201.setApplicationOrgName("Andy")
  tx100201.setApplicationTime("20160522101100")
  tx100201.setBalance("123")
  tx100201.setBankID("hengfeng")
  tx100201.setBankName("hengfeng")
  tx100201.setCaseNumber("normal")
  tx100201.setCaseType("normal")
  tx100201.setCurrency("CNY")
  tx100201.setEmergencyLevel("01")
  tx100201.setExpireTime("20160522101100")
  tx100201.setFilePath("")
  tx100201.setFreezeStartTime("20160522100000")
  tx100201.setFreezeType("01")
  tx100201.setIDNumber("iDNumber")
  tx100201.setIDType("A")
  tx100201.setInvestigatorIDNumber("123")
  tx100201.setInvestigatorIDType("A")
  tx100201.setInvestigatorName("investigatorName")
  tx100201.setMessageFrom("cfca")
  tx100201.setOperatorIDNumber("123")
  tx100201.setOperatorIDType("A")
  tx100201.setOperatorName("operatorName")
  tx100201.setOperatorPhoneNumber("123")
  tx100201.setReason("reason")
  tx100201.setRemark("remark")
  tx100201.setTransSerialNumber("12345sssss6")
  tx100201.setTxCode("100201")

  val beanMapData = ToolUtils.BeanToMap(tx100201)
  val attachmentsMap = Map("attachments" -> List(Map("fileName" -> "weishu", "content" -> "neirong")))
  val beanMap = new HashMap[String, Any]
  beanMap ++= beanMapData
  beanMap ++= attachmentsMap

  val b = beanMap.toMap

 
  //  ActorHolder.proxyActor ! TEvent("11", CFCATradeCode.freeze, beanMap.toMap, "", None)

}


