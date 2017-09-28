package com.egfbank.tfemp.actor.worker.module

import akka.actor._
import scala.xml.Elem
import scala.xml.XML
import java.net.ServerSocket
import java.io.DataInputStream
import java.io.DataOutputStream
import cfca.safeguard.api.bank.bean.tx.downstream.Tx100301
import com.egfbank.tfemp.actor.QueryAccAllInfo
import com.egfbank.tfemp.model.TEvent
import com.egfbank.tfemp.util.ToolUtils
import com.egfbank.tfemp.actor.ActorHolder
import com.egfbank.tfemp.util.HfbkUtil
import com.egfbank.tfemp.actor.QueryTransDetail

/**
 * @author andy
 */

object TestQueryTransDetailForTD extends App {
  val tx100301 = new Tx100301
  tx100301.setAccountName("123")
  tx100301.setApplicationID("123123123123")
  tx100301.setApplicationOrgID("22")
  tx100301.setApplicationOrgName("22")
  tx100301.setApplicationTime("")
  tx100301.setBankID("22")
  tx100301.setBankName("a")
  tx100301.setCardNumber("1535005887983000076")
  tx100301.setCaseType("d")
  tx100301.setEmergencyLevel("d")
  tx100301.setInquiryMode("02")
  tx100301.setInquiryPeriodEnd("20160603")
  tx100301.setInquiryPeriodStart("20150202")
  tx100301.setInvestigatorIDNumber("123")
  tx100301.setInvestigatorIDType("123")
  tx100301.setInvestigatorName("123")
  tx100301.setMessageFrom("1")
  tx100301.setOperatorIDNumber("123")
  tx100301.setOperatorIDType("123")
  tx100301.setOperatorPhoneNumber("123")
  tx100301.setOperatorName("123")
  tx100301.setTransSerialNumber("1231231")

  val beanMap = ToolUtils.BeanToMap(tx100301)
  ActorHolder.proxyActor ! TEvent[Map[String, Any]](HfbkUtil.getUUID(), QueryTransDetail, beanMap, HfbkUtil.getTime(), Some(null))
}