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

object TestStopPaymentDelayWithElem extends App {

  val tx100105 = <Response><Head><TxCode>100105</TxCode><MessageFrom>cfca</MessageFrom><TransSerialNumber>8098098098098098</TransSerialNumber></Head><Body><ApplicationID>89087766</ApplicationID><CaseNumber>123</CaseNumber><CaseType>123</CaseType><OriginalApplicationID>0987</OriginalApplicationID><EmergencyLevel>01</EmergencyLevel><BankID>123</BankID><BankName>123</BankName><AccountType>01</AccountType><AccountName>ads</AccountName><AccountNumber>62238453201307456_153200100234400011</AccountNumber><PostponeStartTime>20151209192323</PostponeStartTime><ExpireTime>20160612091209</ExpireTime><ExtendRemark>afsdfa</ExtendRemark><ApplicationTime>20160601121212</ApplicationTime><ApplicationOrgID>6</ApplicationOrgID><ApplicationOrgName>6</ApplicationOrgName><OperatorIDType>01</OperatorIDType><OperatorIDNumber>410825199001127678</OperatorIDNumber><OperatorName>andy</OperatorName><OperatorPhoneNumber>1231231</OperatorPhoneNumber><InvestigatorIDType>99</InvestigatorIDType><InvestigatorIDNumber>410825199001127678</InvestigatorIDNumber><InvestigatorName>adny</InvestigatorName><Attachments><Attachment><Filename>1</Filename><Content>1</Content></Attachment></Attachments></Body></Response>
  ActorHolder.proxyActor ! TEvent[Elem](HfbkUtil.getUUID(), StopPayDelay, tx100105, HfbkUtil.getTime(), Some(null))

}