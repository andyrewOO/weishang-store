

import java.util.List;

import cfca.safeguard.api.bank.ClientEnvironment;
import cfca.safeguard.api.bank.Constants;
import cfca.safeguard.api.bank.SGBusiness;
import cfca.safeguard.api.bank.bean.tx.downstream.Tx100101;
import cfca.safeguard.api.bank.bean.tx.downstream.Tx100103;
import cfca.safeguard.api.bank.bean.tx.downstream.Tx100105;
import cfca.safeguard.api.bank.bean.tx.downstream.Tx100201;
import cfca.safeguard.api.bank.bean.tx.downstream.Tx100203;
import cfca.safeguard.api.bank.bean.tx.downstream.Tx100205;
import cfca.safeguard.api.bank.bean.tx.downstream.Tx100301;
import cfca.safeguard.api.bank.bean.tx.downstream.Tx100303;
import cfca.safeguard.api.bank.bean.tx.downstream.Tx100305;
import cfca.safeguard.api.bank.bean.tx.downstream.Tx100307;
import cfca.safeguard.api.bank.bean.tx.downstream.Tx100309;
import cfca.safeguard.api.bank.util.Base64;
import cfca.safeguard.api.bank.util.ResultUtil;
import cfca.safeguard.api.bank.util.StringUtil;
import cfca.safeguard.tx.TxBase;

/**
 * 向前置机取消息
 */
public class Tx000000Test {
    public static void main(String[] args) throws Exception {
        ClientEnvironment.initTxClientEnvironment("cfca");
        SGBusiness sgBusiness = new SGBusiness();
        String responseXml= sgBusiness.getMessage();
        
        List<String> messageList=null;
        String code = StringUtil.getNodeText(responseXml, Constants.CODE);
        if (Constants.SUCCESS_CODE_VALUE.equals(code)) {
            messageList= StringUtil.getNodeTextList(responseXml, Constants.MESSAGE);
        }else{
            throw new Exception("Get message error! Error code: " + code + ". Error descriptin: " + StringUtil.getNodeText(responseXml, Constants.DESCRIPTION));
        }
        if (messageList == null || messageList.size() == 0) {
            System.out.println("前置机没有收到需要处理的业务消息 ");
            return;
        }
        System.out.println("前置机收到需要处理的业务消息数量=" + messageList.size());
        if (messageList == null || messageList.size() > 0) {
            for (int i = 0; i < messageList.size(); i++) {
                String xml = Base64.decode(messageList.get(i), Constants.DEFAULT_CHARSET);
                TxBase tx = ResultUtil.convertTxFromMessageXML(xml);
                if ("100101".equals(tx.getTxCode())) {
                    // 转换为止付封装类
                    Tx100101 tx100101 = (Tx100101) tx;

                    System.out.println("止付.applicationID=" + tx100101.getApplicationID()+".messageFrom="+tx.getMessageFrom());
                } else if ("100103".equals(tx.getTxCode())) {
                    // 转换为止付解除封装类
                    Tx100103 tx100103 = (Tx100103) tx;

                    System.out.println("止付解除.applicationID=" + tx100103.getApplicationID()+".messageFrom="+tx.getMessageFrom());
                } else if ("100105".equals(tx.getTxCode())) {
                    // 转换为止付延期封装类
                    Tx100105 tx100105 = (Tx100105) tx;

                    System.out.println("止付延期.applicationID=" + tx100105.getApplicationID()+".messageFrom="+tx.getMessageFrom());
                } else if ("100201".equals(tx.getTxCode())) {
                    // 转换为冻结封装类
                    Tx100201 tx100201 = (Tx100201) tx;

                    System.out.println("冻结.applicationID=" + tx100201.getApplicationID()+".messageFrom="+tx.getMessageFrom());
                } else if ("100203".equals(tx.getTxCode())) {
                    // 转换为冻结解除封装类
                    Tx100203 tx100203 = (Tx100203) tx;

                    System.out.println("冻结解除.applicationID=" + tx100203.getApplicationID()+".messageFrom="+tx.getMessageFrom());
                } else if ("100205".equals(tx.getTxCode())) {
                    // 转换为冻结延期封装类
                    Tx100205 tx100205 = (Tx100205) tx;

                    System.out.println("冻结延期.applicationID=" + tx100205.getApplicationID()+".messageFrom="+tx.getMessageFrom());
                } else if ("100301".equals(tx.getTxCode())) {
                    // 转换为账户交易明细查询封装类
                    Tx100301 tx100301 = (Tx100301) tx;

                    System.out.println("账户交易明细查询.applicationID=" + tx100301.getApplicationID()+".messageFrom="+tx.getMessageFrom());
                } else if ("100303".equals(tx.getTxCode())) {
                    // 转换为账户持卡主体查询封装类
                    Tx100303 tx100303 = (Tx100303) tx;

                    System.out.println("账户持卡主体查询.applicationID=" + tx100303.getApplicationID()+".messageFrom="+tx.getMessageFrom());
                } else if ("100305".equals(tx.getTxCode())) {
                    // 转换为账户动态查询封装类
                    Tx100305 tx100305 = (Tx100305) tx;

                    System.out.println("账户动态查询.applicationID=" + tx100305.getApplicationID()+".messageFrom="+tx.getMessageFrom());
                } else if ("100307".equals(tx.getTxCode())) {
                    // 转换为账户动态查询解除封装类
                    Tx100307 tx100307 = (Tx100307) tx;

                    System.out.println("账户动态查询解除.applicationID=" + tx100307.getApplicationID()+".messageFrom="+tx.getMessageFrom());
                } else if ("100309".equals(tx.getTxCode())) {
                    // 转换为客户全账户查询封装类
                    Tx100309 tx100309 = (Tx100309) tx;

                    System.out.println("全账户查询.applicationID=" + tx100309.getApplicationID()+".messageFrom="+tx.getMessageFrom());
                } else {
                    System.out.println("目前没有处理的TXCODE,请自己解析消息报文" + xml);
                }

            }
        }

    }
}
