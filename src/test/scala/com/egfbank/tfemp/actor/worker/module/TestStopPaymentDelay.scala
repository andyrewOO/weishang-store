package com.egfbank.tfemp.actor.worker.module

import akka.actor._
import scala.xml.Elem
import scala.xml.XML
import cfca.safeguard.api.bank.bean.tx.downstream.Tx100103
import scala.collection.mutable.HashMap
import cfca.safeguard.api.bank.bean.tx.downstream.Tx100105
import com.egfbank.tfemp.util.ToolUtils
import com.egfbank.tfemp.model.TEvent
import com.egfbank.tfemp.util.HfbkUtil
import com.egfbank.tfemp.actor.StopPayDelay
import com.egfbank.tfemp.actor.ActorHolder
//import com.egfbank.tfemp.actor.ServiceLoaderActor.socketActor

/**
 * @author andy
 */

object SocketActionTestStopPaymentDelay extends App {

  val tx100105 = new Tx100105
  tx100105.setAccountName("sdfsdf")
  tx100105.setAccountNumber("1535005887983000076_1535005887983000079")
  tx100105.setAccountType("sdfdsf")
  tx100105.setApplicationID("sdd22323")
  tx100105.setApplicationOrgID("6")
  tx100105.setApplicationOrgName("name")
  tx100105.setApplicationTime("20160601121212")
  tx100105.setBankID("sdfsdf")
  tx100105.setBankName("sdfsdf")
  tx100105.setCaseNumber("sdfdsf")
  tx100105.setCaseType("sdfsdf")
  tx100105.setEmergencyLevel("01")
//  tx100105.setExpireTime("20160612091209")
  tx100105.setExpireTime("20160616")
  tx100105.setExtendRemark("sdfsdf")
  tx100105.setFilePath("sdfsdf")
  tx100105.setInvestigatorIDNumber("410825199001127678")
  tx100105.setInvestigatorIDType("99")
  tx100105.setInvestigatorName("sdfsdf")
  tx100105.setMessageFrom("sdfsdf")
  tx100105.setOperatorIDNumber("410825199001127678")
  tx100105.setOperatorIDType("01")
  tx100105.setOperatorName("sdfsdf")
  tx100105.setOperatorPhoneNumber("sdfd")
  tx100105.setOriginalApplicationID("234567890")
  tx100105.setPostponeStartTime("20151209192323")
  tx100105.setTransSerialNumber("00000169")

  val beanMapData = ToolUtils.BeanToMap(tx100105)
  val attachmentsMap = Map("attachments" -> List(Map("fileName" -> "weishu", "content" -> "neirong")))
  val beanMap = new HashMap[String, Any]
  beanMap ++= beanMapData
  beanMap ++= attachmentsMap
  val bean = beanMap.toMap
  ActorHolder.proxyActor ! TEvent[Map[String, Any]](HfbkUtil.getUUID(), StopPayDelay, bean, HfbkUtil.getTime(), Some(null))

}