package com.db.controller;

import com.db.entity.PayConfigEntity;
import com.db.util.HttpUtil;
import com.db.util.PayCommonUtil;
import com.db.util.XMLUtil;
import org.jdom.JDOMException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;

@Controller
public class WeiXinPay {

    @RequestMapping(value = "/wxcallback")
    public void weixin_notify(HttpServletRequest request, HttpServletResponse response) throws Exception{
        //读取参数
        InputStream inputStream ;
        StringBuffer sb = new StringBuffer();
        inputStream = request.getInputStream();
        String s ;
        BufferedReader in = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        while ((s = in.readLine()) != null){
            sb.append(s);
        }
        in.close();
        inputStream.close();

        //解析xml成map
        Map<String, String> m = new HashMap<String, String>();
        m = XMLUtil.doXMLParse(sb.toString());

        //过滤空 设置 TreeMap
        SortedMap<Object,Object> packageParams = new TreeMap<Object,Object>();
        Iterator it = m.keySet().iterator();
        while (it.hasNext()) {
            String parameter = (String) it.next();
            String parameterValue = m.get(parameter);

            String v = "";
            if(null != parameterValue) {
                v = parameterValue.trim();
            }
            packageParams.put(parameter, v);
        }

        // 账号信息
        String key = PayConfigEntity.API_KEY; // key

//        logger.info(packageParams);
        System.err.println(packageParams);
        //判断签名是否正确
        if(PayCommonUtil.isTenpaySign("UTF-8", packageParams,key)) {
            //------------------------------
            //处理业务开始
            //------------------------------
            String resXml = "";
            if("SUCCESS".equals((String)packageParams.get("result_code"))){
                // 这里是支付成功
                //////////执行自己的业务逻辑////////////////
                String mch_id = (String)packageParams.get("mch_id");
                String openid = (String)packageParams.get("openid");
                String is_subscribe = (String)packageParams.get("is_subscribe");
                String out_trade_no = (String)packageParams.get("out_trade_no");

                String total_fee = (String)packageParams.get("total_fee");

                System.err.println("mch_id:"+mch_id);
                System.err.println("openid:"+openid);
                System.err.println("is_subscribe:"+is_subscribe);
                System.err.println("out_trade_no:"+out_trade_no);
                System.err.println("total_fee:"+total_fee);
//                logger.info("mch_id:"+mch_id);
//                logger.info("openid:"+openid);
//                logger.info("is_subscribe:"+is_subscribe);
//                logger.info("out_trade_no:"+out_trade_no);
//                logger.info("total_fee:"+total_fee);

                //////////执行自己的业务逻辑////////////////

                System.err.println("支付成功");
//                logger.info("支付成功");
                //通知微信.异步确认成功.必写.不然会一直通知后台.八次之后就认为交易失败了.
                resXml = "<xml>" + "<return_code><![CDATA[SUCCESS]]></return_code>"
                        + "<return_msg><![CDATA[OK]]></return_msg>" + "</xml> ";

            } else {
//                logger.info("支付失败,错误信息：" + packageParams.get("err_code"));
                System.err.println("支付失败,错误信息：" + packageParams.get("err_code"));
                resXml = "<xml>" + "<return_code><![CDATA[FAIL]]></return_code>"
                        + "<return_msg><![CDATA[报文为空]]></return_msg>" + "</xml> ";
            }
            //------------------------------
            //处理业务完毕
            //------------------------------
            BufferedOutputStream out = new BufferedOutputStream(
                    response.getOutputStream());
            out.write(resXml.getBytes());
            out.flush();
            out.close();
        } else{
//            logger.info("通知签名验证失败");
            System.err.println("通知签名验证失败");
        }
    }

    /**
     * 微信 支付
     * @return
     * @throws JDOMException
     * @throws IOException
     */
    @RequestMapping(value = "/weixin_pay")
    public String weixin_pay() throws JDOMException, IOException {
        //生成订单信息
        String appid = PayConfigEntity.APP_ID;
        String mch_id = PayConfigEntity.MCH_ID;
        String key = PayConfigEntity.API_KEY;

        /**
         * 获取当前时间
         */
        String currTime = PayCommonUtil.getCurrTime();
        String strTime = currTime.substring(8, currTime.length());

        /**
         * 取出一个指定长度大小的随机正整数
         */
        String buildRandom = PayCommonUtil.buildRandom(4)+"";
        /**
         * 微信支付需要的随机数字段
         */
        String nonce_str = PayCommonUtil.generateNonceStr();
        /**
         * 微信支付需要的金额字段
         */
        String order_price = 100000+"";
        /**
         * 微信支付需要的商品描述字段
         */
        String body = "该商品只需要你扫一扫二维码";
        /**
         * 微信支付需要的商户订单号字段
         */
        String out_trade_no = "KBS"+strTime+buildRandom;
        /**
         * 微信支付需要的终端IP字段
         */
        String spbill_create_ip = PayConfigEntity.CREATE_IP;
        /**
         * 微信支付需要的通知地址字段
         */
        String notify_url = PayConfigEntity.NOTIFY_URL;
        /**
         * 微信支付需要的交易类型字段
         */
        String trade_type = PayConfigEntity.TRADE_TYPE;

        /**
         * 转换 Map
         */
        SortedMap<Object,Object> packageParams = new TreeMap<Object,Object>();
        packageParams.put("appid", appid);
        packageParams.put("mch_id", mch_id);
        packageParams.put("sub_mch_id","37759651");
        packageParams.put("nonce_str", nonce_str);
        packageParams.put("body", body);
        packageParams.put("out_trade_no", out_trade_no);
        packageParams.put("total_fee", order_price);
        packageParams.put("fee_type","CNY");
        packageParams.put("spbill_create_ip", spbill_create_ip);
        packageParams.put("notify_url", notify_url);
        packageParams.put("trade_type", trade_type);


        /**
         * 生成签名
         */
        String sign = PayCommonUtil.createSign("UTF-8", packageParams, key);
        packageParams.put("sign", sign);

        /**
         * 转换xml格式
         */
        String requestXml = PayCommonUtil.getRequestXml(packageParams);
        System.err.println(requestXml);
        String postData = HttpUtil.postData(PayConfigEntity.UFDODER_URL, requestXml);
        Map doXMLParse = XMLUtil.doXMLParse(postData);
        String codeUrl = (String) doXMLParse.get("code_url");


        System.err.println(codeUrl);

        return codeUrl;
    }
}
