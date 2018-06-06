package com.db.entity;

/**
 * 微信 支付 需要 参数
 */
public class PayConfigEntity {

    /**
     * 公众账号ID
     */
    public static String APP_ID = "";

    /**
     * 商户号
     */
    public static String MCH_ID = "";

    /**
     * 商户秘钥
     */
    public static String API_KEY = "";

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
