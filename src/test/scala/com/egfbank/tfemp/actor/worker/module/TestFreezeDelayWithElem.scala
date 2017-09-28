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

object TestFreezeDelayWithElem extends App {

  val tx100205 = <Response><Head><TxCode>100205</TxCode><MessageFrom>qwe</MessageFrom><TransSerialNumber>123123123123</TransSerialNumber></Head><Body><ApplicationID>7890</ApplicationID><CaseNumber>123</CaseNumber><CaseType>normal</CaseType><OriginalApplicationID>2345678123</OriginalApplicationID><EmergencyLevel>01</EmergencyLevel><BankID>123</BankID><BankName>123</BankName><AccountType>01</AccountType><AccountName>asdf</AccountName><AccountNumber>62238453201307456</AccountNumber><PostponeStartTime>20120202</PostponeStartTime><ExpireTime>20160501121212</ExpireTime><ExtendRemark>123</ExtendRemark><ApplicationTime>20150322121212</ApplicationTime><ApplicationOrgID>6</ApplicationOrgID><ApplicationOrgName>6</ApplicationOrgName><OperatorIDType>99</OperatorIDType><OperatorIDNumber>410825199001127678</OperatorIDNumber><OperatorName>andy</OperatorName><OperatorPhoneNumber>132123123</OperatorPhoneNumber><InvestigatorIDType>01</InvestigatorIDType><InvestigatorIDNumber>410825199001127678</InvestigatorIDNumber><InvestigatorName>andy</InvestigatorName><Attachments><Attachment><Filename>1</Filename><Content>1</Content></Attachment></Attachments></Body></Response>
  ActorHolder.proxyActor ! TEvent[Elem](HfbkUtil.getUUID(), FreezePayDelay, tx100205, HfbkUtil.getTime(), Some(null))
}