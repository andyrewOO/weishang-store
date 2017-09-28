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
import com.egfbank.tfemp.actor.QueryCardOwner

/**
 * @author andy
 */

object TestQueryAccountMain extends App {
  val tx100303 = <Response><Head><TxCode>100303</TxCode><MessageFrom>123123123123</MessageFrom><TransSerialNumber>123123123123123123123</TransSerialNumber></Head><Body><ApplicationID>123123123123</ApplicationID><CaseNumber>123123</CaseNumber><CaseType>01</CaseType><EmergencyLevel>01</EmergencyLevel><SubjectType>01</SubjectType><BankID>12</BankID><BankName>12</BankName><AccountName>12</AccountName><CardNumber>62238453500098285</CardNumber><Reason>62238453500098285</Reason><Remark>62238453500098285</Remark><ApplicationTime>20120919</ApplicationTime><ApplicationOrgID>12</ApplicationOrgID><ApplicationOrgName>and</ApplicationOrgName><OperatorIDType>01</OperatorIDType><OperatorIDNumber>410825199001127678</OperatorIDNumber><OperatorName>andy</OperatorName><OperatorPhoneNumber>13277043398</OperatorPhoneNumber><InvestigatorIDType>99</InvestigatorIDType><InvestigatorIDNumber>410825199001127678</InvestigatorIDNumber><InvestigatorName></InvestigatorName><Attachments><Attachment><Filename>1</Filename><Content></Content></Attachment></Attachments></Body></Response>

  ActorHolder.proxyActor! TEvent[Elem](HfbkUtil.getUUID(), QueryCardOwner, tx100303, HfbkUtil.getTime(), Some(null))
}