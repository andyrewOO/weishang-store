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

object TestStopPaymentLiftWithElem extends App {

  val tx100103 = <Response><Head><TxCode>100103</TxCode><MessageFrom>cfca</MessageFrom><TransSerialNumber>123</TransSerialNumber></Head><Body><ApplicationID>0987634</ApplicationID><CaseNumber>123</CaseNumber><CaseType>123</CaseType><OriginalApplicationID>0987</OriginalApplicationID><EmergencyLevel>01</EmergencyLevel><BankID>andrew</BankID><BankName>asdfa</BankName><AccountType>01</AccountType><AccountName>123</AccountName><AccountNumber>62238453201307456_153200100234400011</AccountNumber><WithdrawalRemark>asf</WithdrawalRemark><ApplicationTime>20160601121212</ApplicationTime><ApplicationOrgID>6</ApplicationOrgID><ApplicationOrgName>6</ApplicationOrgName><OperatorIDType>01</OperatorIDType><OperatorIDNumber>410825199001127678</OperatorIDNumber><OperatorName>andy</OperatorName><OperatorPhoneNumber>123123</OperatorPhoneNumber><InvestigatorIDType>99</InvestigatorIDType><InvestigatorIDNumber>410825199001127678</InvestigatorIDNumber><InvestigatorName>andfy</InvestigatorName><Attachments><Attachment><Filename>1</Filename><Content>1</Content></Attachment></Attachments></Body></Response>
    
  ActorHolder.proxyActor ! TEvent[Elem](HfbkUtil.getUUID(), StopPayFree, tx100103, HfbkUtil.getTime(), Some(null))

}