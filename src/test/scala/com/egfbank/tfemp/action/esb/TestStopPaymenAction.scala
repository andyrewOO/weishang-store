package com.egfbank.tfemp.action.esb

import scala.xml._

import com.egfbank.tfemp.action.AppAction
import com.egfbank.tfemp.actor._
import com.egfbank.tfemp.model.TEvent
import com.egfbank.tfemp.util.HfbkUtil

import xitrum.Log
import xitrum.SkipCsrfCheck
import xitrum.annotation.POST

/**
 * @author GuoYB
 * 将请求报文封装成Tevent,
 */
@POST("/StopPayment")
class TestStopPaymenAction extends AppAction with SkipCsrfCheck with Log   {

  @Override  def execute = {
   

    try {
      
     log.info("receive stopPayM request: \n" + requestContentString)
      val requestXml: Elem = XML.loadString(requestContentString)
      if (requestXml == null) {
        throw new EsbException("请求的XML格式不正确")
      }

     context.become(receiveResponse)
      
      ActorHolder.proxyActor!TEvent[Elem](HfbkUtil.getUUID(),StopPay,requestXml,HfbkUtil.getTime(), Some(self))

    } catch {
      
      case ex: EsbException => {
        respondText(errorMsg(ex.getMessage))
      }
    }
  }
  
  
    def receiveResponse: Receive = {
    case TEvent(_, _, responseXML, _, _) => {
      responseXML match {
        case xml: Elem => respondXml("""<?xml version="1.0" encoding="UTF-8"?>""" + xml.mkString)
        case _         => respondXml(errorMsg("服务异常"))
      }
    }
    case _ => respondXml(errorMsg("服务异常"))
  }

  private[this] def errorMsg(msg: String) = {
    s"""<?xml version="1.0" encoding="UTF-8"?><service><SYS_HEAD><SvcId/><SvcScnId/><CnsmSysId></CnsmSysId><PrvdSysId/><CnsmSysSeqNo/><PrvdSysSeqNo></PrvdSysSeqNo><Mac/><MacOrgId/><TranDate></TranDate><TranTime></TranTime><TranRetSt/><array><RetInf><RetCode>111</RetCode><RetMsg>${msg}</RetMsg></RetInf></array><PrvdSysSvrId/></SYS_HEAD><APP_HEAD></APP_HEAD><BODY></BODY></service>"""
  }

  
}