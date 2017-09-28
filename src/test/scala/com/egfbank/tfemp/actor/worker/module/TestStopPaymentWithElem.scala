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

object TestStopPaymentWithElem extends App {

  val tx10010 = <Response><Head><TxCode>100101</TxCode><MessageFrom>cfva</MessageFrom><TransSerialNumber>123123123123123</TransSerialNumber></Head><Body><ApplicationID>0987</ApplicationID><ApplicationType>01</ApplicationType><OriginalApplicationID></OriginalApplicationID><CaseNumber>123</CaseNumber><CaseType>123</CaseType><EmergencyLevel>01</EmergencyLevel><TransferOutBankID>123</TransferOutBankID><TransferOutBankName>123</TransferOutBankName><TransferOutAccountName>123</TransferOutAccountName><TransferOutAccountNumber>123</TransferOutAccountNumber><Currency>CNY</Currency><TransferAmount>12</TransferAmount><TransferTime>20161212233423</TransferTime><BankID>123</BankID><BankName>123</BankName><AccountType>01</AccountType><AccountName>andy</AccountName><AccountNumber>62238453200251549</AccountNumber><Reason>123</Reason><Remark>123123</Remark><StartTime>20161201000000</StartTime><ExpireTime>20160603330909</ExpireTime><ApplicationTime>20160522020202</ApplicationTime><ApplicationOrgID>6</ApplicationOrgID><ApplicationOrgName>6</ApplicationOrgName><OperatorIDType>01</OperatorIDType><OperatorIDNumber>410825199001127678</OperatorIDNumber><OperatorName>adf</OperatorName><OperatorPhoneNumber>123123</OperatorPhoneNumber><InvestigatorIDType>99</InvestigatorIDType><InvestigatorIDNumber>410825199001127678</InvestigatorIDNumber><InvestigatorName>asf</InvestigatorName><Attachments><Attachment><Filename>1</Filename><Content>1</Content></Attachment></Attachments></Body></Response>
  ActorHolder.proxyActor ! TEvent[Elem](HfbkUtil.getUUID(), StopPay, tx10010, HfbkUtil.getTime(), Some(null))
}