package com.egfbank.tfemp.actor.worker.module

import akka.actor._
import scala.xml.Elem
import scala.xml.XML
import cfca.safeguard.api.bank.bean.tx.downstream.Tx100203
import java.util.ArrayList
import cfca.safeguard.tx.Attachment
import scala.collection.mutable.HashMap
import com.egfbank.tfemp.util.ToolUtils
import com.egfbank.tfemp.model.TEvent
import com.egfbank.tfemp.actor.ActorHolder
import com.egfbank.tfemp.util.HfbkUtil
import com.egfbank.tfemp.actor.FreezePayFree

/**
 * @author andy
 */

object TestFreezeLiftWithElem extends App {

  val tx100203 = <Response><Head><TxCode>100203</TxCode><MessageFrom>as</MessageFrom><TransSerialNumber>123123123</TransSerialNumber></Head><Body><ApplicationID>12312345</ApplicationID><CaseNumber>12312</CaseNumber><CaseType>normal</CaseType><OriginalApplicationID>234567</OriginalApplicationID><EmergencyLevel>01</EmergencyLevel><BankID>as</BankID><BankName>as</BankName><AccountType>01</AccountType><AccountName>as</AccountName><AccountNumber>62238453201307456_153200100234400011</AccountNumber><WithdrawalRemark>123</WithdrawalRemark><ApplicationTime>20160522101100</ApplicationTime><ApplicationOrgID>6</ApplicationOrgID><ApplicationOrgName>6</ApplicationOrgName><OperatorIDType>01</OperatorIDType><OperatorIDNumber>410825199001127678</OperatorIDNumber><OperatorName>s</OperatorName><OperatorPhoneNumber>410825199001127678</OperatorPhoneNumber><InvestigatorIDType>99</InvestigatorIDType><InvestigatorIDNumber>410825199001127678</InvestigatorIDNumber><InvestigatorName>as</InvestigatorName><Attachments><Attachment><Filename>1</Filename><Content>1</Content></Attachment></Attachments></Body></Response>
   
  ActorHolder.proxyActor ! TEvent[Elem](HfbkUtil.getUUID(), FreezePayFree, tx100203, HfbkUtil.getTime(), Some(null))
} 