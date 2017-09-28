package com.egfbank.util

import com.egfbank.tfemp.util.HfbkUtil
import java.text.SimpleDateFormat
import com.egfbank.tfemp.actor.services.ESBService

/**
 * @author andy
 */
object TestEsbService extends ESBService {
  def main(args: Array[String]): Unit = {
    val info =
      <service>
        <SYS_HEAD>
          <SvcId>010030001</SvcId>
          <SvcScnId>01</SvcScnId>
          <TmnlNo/>
          <ChnlType>MID</ChnlType>
          <CnsmSysSeqNo>0102079</CnsmSysSeqNo>
          <TranDate>20151110</TranDate>
          <TranTime>1111111111</TranTime>
          <CnsmSysId>63</CnsmSysId>
          <SubBnkId>2</SubBnkId>
        </SYS_HEAD>
        <APP_HEAD>
          <TellerId>001812</TellerId>
          <BranchId>5351001</BranchId>
        </APP_HEAD>
        <BODY>
          <array>
            <abc>
              <TranCode>T63007</TranCode>
              <AcctNo>1535005887983000076</AcctNo>
              <SubAcctNo>1535005887983000079</SubAcctNo>
              <SortordMode>DESC</SortordMode>
              <BeginNum>1</BeginNum>
              <RqstNum>1</RqstNum>
            </abc>
            <abc>
              <TranCode>T630037</TranCode>
              <AcctNo>1535005887983000076</AcctNo>
              <SubAcctNo>1535005887983000079</SubAcctNo>
              <SortordMode>DESC</SortordMode>
              <BeginNum>1</BeginNum>
              <RqstNum>1</RqstNum>
            </abc>
          </array>
        </BODY>
      </service>

    val abcs = info \\ "abc"
    abcs.map { a => 
      println((a \\ "TranCode").text.toString)  
    }
    
  }
}