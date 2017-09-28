package com.egfbank.tfemp.actor.worker.module

import akka.actor._
import scala.xml.Elem
import scala.xml.XML
import cfca.safeguard.api.bank.bean.tx.downstream.Tx100105
import scala.collection.mutable.HashMap
import cfca.safeguard.api.bank.bean.tx.downstream.Tx100103
import com.egfbank.tfemp.util.ToolUtils
import com.egfbank.tfemp.model.TEvent
import com.egfbank.tfemp.actor.StopPayFree
import com.egfbank.tfemp.actor.ActorHolder
import com.egfbank.tfemp.util.HfbkUtil
//import com.egfbank.tfemp.actor.ServiceLoaderActor.socketActor

/**
 * @author andy
 */

object TestStopPaymentLift extends App {

  val tx100103 = new Tx100103
  tx100103.setAccountName("asdf")
  tx100103.setAccountNumber("1535005887983000076_1535005887983000079")
  tx100103.setAccountType("01")
  tx100103.setApplicationID("123123123123123")
  tx100103.setApplicationOrgID("12")
  tx100103.setApplicationOrgName("name")
  tx100103.setApplicationTime("20160601121212")
  tx100103.setBankID("sdfsdf")
  tx100103.setBankName("sdfsdf")
  tx100103.setCaseNumber("dfsdf")
  tx100103.setCaseType("sdfasd")
  tx100103.setEmergencyLevel("01")
  tx100103.setFilePath("asffd")
  tx100103.setInvestigatorIDNumber("410825199001127678")
  tx100103.setInvestigatorIDType("99")
  tx100103.setInvestigatorName("123123")
  tx100103.setMessageFrom("asfsdf")
  tx100103.setOperatorIDNumber("410825199001127678")
  tx100103.setOperatorIDType("01")
  tx100103.setOperatorName("sdfsdf")
  tx100103.setOperatorPhoneNumber("sdfd")
  tx100103.setOriginalApplicationID("234567890")
  tx100103.setTransSerialNumber("00000169")
  tx100103.setWithdrawalRemark("sdfsdf")

  val beanMapData = ToolUtils.BeanToMap(tx100103)
  val attachmentsMap = Map("attachments" -> List(Map("fileName" -> "weishu", "content" -> "neirong")))
  val beanMap = new HashMap[String, Any]
  beanMap ++= beanMapData
  beanMap ++= attachmentsMap

  val bean = beanMap.toMap
  ActorHolder.proxyActor ! TEvent[Map[String, Any]](HfbkUtil.getUUID(), StopPayFree, bean, HfbkUtil.getTime(), Some(null))

}