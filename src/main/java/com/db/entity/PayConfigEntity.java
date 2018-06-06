package com.db.entity;

/**
 * 微信 支付 需要 参数
 */
public class PayConfigEntity {

    /**
     * 公众账号ID
     */
    public static String APP_ID = "wxe8849d77deee350c";

    /**
     * 商户号
     */
    public static String MCH_ID = "1484062732";

    /**
     * 商户秘钥
     */
    public static String API_KEY = "U2017p0228m2017L0228k2017W0228BF";

    /**
     * 下单接口地址
     */
    public static String UFDODER_URL = "https://api.mch.weixin.qq.com/pay/unifiedorder";

    /**
     * 回调 地址
     */
    public static String NOTIFY_URL = "http://feiuil08.55555.io/wxcallback";

    /**
     * 终端ip
     */
    public static String CREATE_IP = "192.168.5.1";

    /**
     * 支付方式
     */
    public static String TRADE_TYPE = "NATIVE";
}
