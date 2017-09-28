

import cfca.safeguard.api.bank.ClientEnvironment;
import cfca.safeguard.api.bank.Constants;
import cfca.safeguard.api.bank.SGBusiness;
import cfca.safeguard.Result;
import cfca.safeguard.api.bank.bean.tx.upstream.Tx100102;
import cfca.safeguard.api.bank.util.ResultUtil;

/**
 * 止付反馈
 */
public class Tx100102Test {
    public static void main(String[] args) throws Exception {
        ClientEnvironment.initTxClientEnvironment("config");
        SGBusiness sgBusiness = new SGBusiness();

        String to="dmmps";
        Tx100102 tx100102 = new Tx100102();

        String transSerialNumber = "dmbank10010220160418";
        tx100102.setTransSerialNumber(transSerialNumber);
        tx100102.setApplicationID("20010120160325200101005");
        tx100102.setResult("0000");
        tx100102.setAccountType("01");
        tx100102.setAccountNumber("6225198286614325");
        tx100102.setCardNumber("6225198286614325");
        tx100102.setAccountBalance("10000");
        tx100102.setStartTime("20160125104600");
        tx100102.setExpireTime("20170125104600");
        tx100102.setFailureCause("测试");
        tx100102.setFeedbackRemark("测试");
        tx100102.setFeedbackOrgName("cfca");
        tx100102.setOperatorName("徐");
        tx100102.setOperatorPhoneNumber("1101010");
        
 
        
        String requestXML=sgBusiness.tx100102(tx100102,to);
        String responseXML = sgBusiness.sendPackagedRequestXML(requestXML);
        
        Result result=ResultUtil.chageXMLToResult(responseXML);
        
        if (Constants.SUCCESS_CODE_VALUE.equals(result.getCode())) {
            System.out.println("止付反馈成功");
        } else {
            System.out.println(result.getResponseXML());
            System.out.println("止付反馈失败,错误码=" + result.getCode() + ",错误信息=" + result.getDescription());
        }
    }
}
