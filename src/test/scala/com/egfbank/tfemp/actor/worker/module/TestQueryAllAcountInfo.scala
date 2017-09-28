package com.egfbank.tfemp.actor.worker.module

import akka.actor._
import scala.xml.Elem
import scala.xml.XML
import java.net.ServerSocket
import java.io.DataInputStream
import java.io.DataOutputStream
import cfca.safeguard.api.bank.bean.tx.downstream.Tx100309
import com.egfbank.tfemp.util.ToolUtils
import com.egfbank.tfemp.actor.ActorHolder
import com.egfbank.tfemp.model.TEvent
import com.egfbank.tfemp.util.HfbkUtil
import com.egfbank.tfemp.actor.StopPay
import com.egfbank.tfemp.actor.QueryAccAllInfo

/**
 * @author andy
 */

object TestQueryAllAcountInfo extends App {
  val tx100309 = new Tx100309
  tx100309.setAccountCredentialNumber("370602197405275223")
  tx100309.setAccountCredentialType("01")
  tx100309.setAccountSubjectName("测试")
  tx100309.setApplicationID("123456")
  tx100309.setApplicationOrgID("")
  tx100309.setApplicationOrgName("")
  tx100309.setApplicationTime("123")
  tx100309.setBankID("")
  tx100309.setBankName("")
  tx100309.setCaseNumber("123")
  tx100309.setCaseType("123")
  tx100309.setEmergencyLevel("01")
  tx100309.setFilePath("")
  tx100309.setInquiryMode("02")
  tx100309.setInvestigatorIDNumber("123")
  tx100309.setInvestigatorIDType("123")
  tx100309.setInvestigatorName("123")
  tx100309.setMessageFrom("cfca")
  tx100309.setOperatorIDNumber("123")
  tx100309.setOperatorIDType("123")
  tx100309.setOperatorName("123")
  tx100309.setOperatorPhoneNumber("123")
  tx100309.setReason("123")
  tx100309.setRemark("123")
  tx100309.setSubjectType("123")
  tx100309.setTransSerialNumber("23456789")

  val beanMap = ToolUtils.BeanToMap(tx100309)
  
  ActorHolder.proxyActor ! TEvent[Map[String, Any]](HfbkUtil.getUUID(), QueryAccAllInfo, beanMap, HfbkUtil.getTime(), Some(null))
}