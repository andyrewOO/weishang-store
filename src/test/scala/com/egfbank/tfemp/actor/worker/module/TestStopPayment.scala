package com.egfbank.tfemp.actor.worker.module

import akka.actor._
import scala.xml.Elem
import scala.xml.XML
import java.net.ServerSocket
import java.io.DataInputStream
import java.io.DataOutputStream
import cfca.safeguard.api.bank.bean.tx.downstream.Tx100101
import scala.collection.mutable.HashMap
import com.egfbank.tfemp.util.ToolUtils
import com.egfbank.tfemp.actor.StopPay
import com.egfbank.tfemp.model.TEvent
import com.egfbank.tfemp.actor.ProxyActor
import com.egfbank.tfemp.util.HfbkUtil
import com.egfbank.tfemp.actor.ProxyActor
import com.egfbank.tfemp.actor.ActorHolder
import com.egfbank.tfemp.actor.ProxyActor

/**
 * @author andy
 */

object TestStopPayment extends App {

  val tx100101 = new Tx100101
  tx100101.setAccountName("asfd")
  tx100101.setAccountNumber("62238453201307456_153200100234400011")
  tx100101.setAccountType("01")
  tx100101.setApplicationID("234567890")
  //  tx100101.setApplicationOrgID("234")
  tx100101.setApplicationOrgID("6")
  tx100101.setApplicationOrgName("name")
  tx100101.setApplicationTime("20160522020202")

  //00-初次提交正常 止付人民币活期账户；
  //01-初次提交正常 止付外币活期账户/人民币、外币定期；

  //02-银行举报案件 止付人民币活期账户；
  //03-银行举报案件 止付外币活期账户/人民币、外币定期；

  //04-后补人民币活期止付流程；
  //05-后补外币活期止付流程
  // 当ApplicationType=00或02时，卡折号为主账号，默认止付主帐号内活期账户；
  // 当ApplicationType=01或03时，帐卡号为定位账户账号主账号+"_"+"帐号识别号"
  tx100101.setApplicationType("01")
  tx100101.setBankID("234")
  tx100101.setBankName("asdf")
  tx100101.setCaseNumber("111")
  tx100101.setCaseType("dsfd")
  tx100101.setCurrency("CNY")
  tx100101.setEmergencyLevel("01")
  tx100101.setExpireTime("20160603330909")
  tx100101.setFilePath("asfsfdsfd")
  tx100101.setInvestigatorIDNumber("410825199001127678")
  tx100101.setInvestigatorIDType("99")
  tx100101.setInvestigatorName("asfdsf")
  tx100101.setMessageFrom("adsfdsf")
  tx100101.setOperatorIDNumber("410825199001127678")
  tx100101.setOperatorIDType("01")
  tx100101.setOperatorName("adsf")
  tx100101.setOperatorPhoneNumber("123232323232323232")
  tx100101.setOriginalApplicationID("23423")
  tx100101.setReason("sfd")
  tx100101.setRemark("asdfsdf")
  tx100101.setStartTime("20161201000000")
  tx100101.setTransferAmount("12")
  tx100101.setTransferOutAccountName("asdfdf")
  tx100101.setTransferOutAccountNumber("sfsdf")
  tx100101.setTransferOutBankID("asdfd")
  tx100101.setTransferOutBankName("asdf")
  tx100101.setTransferTime("20161212233423")
  tx100101.setTransSerialNumber("3324234234234")

  val beanMapData = ToolUtils.BeanToMap(tx100101)
  val attachmentsMap = Map("attachments" -> List(Map("fileName" -> "weishu", "content" -> "neirong")))
  val beanMap = new HashMap[String, Any]
  beanMap ++= beanMapData
  beanMap ++= attachmentsMap
  val bean = beanMap.toMap
  ActorHolder.proxyActor ! TEvent[Map[String, Any]](HfbkUtil.getUUID(), StopPay, bean, HfbkUtil.getTime(), Some(null))
}