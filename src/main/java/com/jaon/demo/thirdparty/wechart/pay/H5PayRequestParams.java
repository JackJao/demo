package com.jaon.demo.thirdparty.wechart.pay;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.io.Serializable;

/**
 * 下单请求对象
 * 字段名	变量名	必填	类型	示例值	描述
 */
@XStreamAlias("xml")
public class H5PayRequestParams implements Serializable {
    /**
     * 公众账号ID	appid	是	String(32)	wxd678efh567hg6787
     * 微信分配的公众账号ID（企业号corpid即为此appId）
     */
    @XStreamAlias("appid")
    private String appId = "0011";
    /**
     * 商户号	mch_id	是	String(32)	1230000109
     * 微信支付分配的商户号
     */
    @XStreamAlias("mch_id")
    private String mchId = "123456sasa";
    /**
     * 设备号	device_info	否	String(32)	013467007045764
     * 终端设备号(门店号或收银设备ID)，注意：PC网页或公众号内支付请传"WEB"
     */
    @XStreamAlias("device_info")
    private String deviceInfo;
    /**
     * 随机字符串	nonce_str	是	String(32)	5K8264ILTKCH16CQ2502SI8ZNMTM67VS
     * 随机字符串，不长于32位。推荐随机数生成算法
     */
    @XStreamAlias("nonce_str")
    private String nonceStr;
    /**
     * 签名	sign	是	String(32)	C380BEC2BFD727A4B6845133519F3AD6
     * 签名，详见签名生成算法
     */
    private String sign;
    /**
     * 签名类型	sign_type	否	String(32)	HMAC-SHA256
     * 签名类型，目前支持HMAC-SHA256和MD5，默认为MD5
     */
    @XStreamAlias("sign_type")
    private String signType = "MD5";
    /**
     * 商品描述	body	是	String(128)	腾讯充值中心-QQ会员充值
     * 商品简单描述，该字段须严格按照规范传递，具体请见参数规定
     */
    @XStreamAlias("body")
    private String body;
    /**
     * 商品详情	detail	否	String(6000)		单品优惠字段(暂未上线)
     */
    @XStreamAlias("detail")
    private String detail;
    /**
     * 附加数据	attach	否	String(127)	深圳分店
     * 附加数据，在查询API和支付通知中原样返回，该字段主要用于商户携带订单的自定义数据
     */
    @XStreamAlias("attach")
    private String attach;
    /**
     * 商户订单号	out_trade_no	是	String(32)	20150806125346
     * 商户系统内部的订单号,32个字符内、可包含字母, 其他说明见商户订单号
     */
    @XStreamAlias("out_trade_no")
    private String outTradeNo;
    /**
     * 货币类型	fee_type	否	String(16)	CNY
     * 符合ISO 4217标准的三位字母代码，默认人民币：CNY，其他值列表详见货币类型
     */
    @XStreamAlias("fee_type")
    private String feeType = "CNY";
    /**
     * 总金额	total_fee	是	Int	888	订单总金额，单位为分，详见支付金额
     */
    @XStreamAlias("total_fee")
    private int totalFee;
    /**
     * 终端IP	spbill_create_ip	是	String(64)	123.12.12.123
     * 必须传正确的用户端IP,支持ipv4、ipv6格式，获取方式详见获取用户ip指引
     */
    @XStreamAlias("spbill_create_ip")
    private String spbillCreateIp;
    /**
     * 交易起始时间	time_start	否	String(14)	20091225091010
     * 订单生成时间，格式为yyyyMMddHHmmss，如2009年12月25日9点10分10秒表示为20091225091010。其他详见时间规则
     */
    @XStreamAlias("time_start")
    private String timeStart;
    /**
     * 交易结束时间	time_expire	否	String(14)	20091227091010
     * 订单失效时间，格式为yyyyMMddHHmmss，如2009年12月27日9点10分10秒表示为20091227091010。其他详见时间规则
     * 注意：最短失效时间间隔必须大于5分钟
     */
    @XStreamAlias("time_expire")
    private String timeExpire;
    /**
     * 商品标记	goods_tag	否	String(32)	WXG
     * 商品标记，代金券或立减优惠功能的参数，说明详见代金券或立减优惠
     */
    @XStreamAlias("goods_tag")
    private String goodsTag;
    /**
     * 通知地址	notify_url	是	String(256)	http://www.weixin.qq.com/wxpay/pay.php
     * 接收微信支付异步通知回调地址，通知url必须为直接可访问的url，不能携带参数。
     */
    @XStreamAlias("notify_url")
    private String notifyUrl;
    /**
     * 交易类型	trade_type	是	String(16)	MWEB
     * H5支付的交易类型为MWEB
     */
    @XStreamAlias("trade_type")
    private String tradeType = "MWEB";
    /**
     * 商品ID	product_id	否	String(32)	12235413214070356458058
     * trade_type=NATIVE，此参数必传。此id为二维码中包含的商品ID，商户自行定义。
     */
    @XStreamAlias("product_id")
    private String productId;
    /**
     * 指定支付方式	limit_pay	否	String(32)	no_credit
     * no_credit--指定不能使用信用卡支付
     */
    @XStreamAlias("limit_pay")
    private String limitPay;
    /**
     * 用户标识	openid	否	String(128)	oUpF8uMuAJO_M2pxb1Q9zNjWeS6o
     * trade_type=JSAPI，此参数必传，用户在商户appid下的唯一标识。openid如何获取，可参考【获取openid】。
     * 企业号请使用【企业号OAuth2.0接口】获取企业号内成员userid，再调用【企业号userid转openid接口】进行转换
     */
    @XStreamAlias("openid")
    private String openId;
    /**
     * 电子发票入口开放标识	receipt	否	String(8)	Y
     * Y，传入Y时，支付成功消息和支付详情页将出现开票入口。需要在微信支付商户平台或微信公众平台开通电子发票功能，传此字段才可生效
     */
    @XStreamAlias("receipt")
    private String receipt;
    /**
     * 场景信息	scene_info	是	String(256)
     * 示例：
     * IOS移动应用 {"h5_info": {"type":"IOS","app_name": "王者荣耀","bundle_id": "com.tencent.wzryIOS"}}
     * 安卓移动应用 {"h5_info": {"type":"Android","app_name": "王者荣耀","package_name": "com.tencent.tmgp.sgame"}}
     * WAP网站应用 {"h5_info": {"type":"Wap","wap_url": "https://pay.qq.com","wap_name": "腾讯充值"}}
     * 描述：
     * 该字段用于上报支付的场景信息,针对H5支付有以下三种场景,请根据对应场景上报,H5支付不建议在APP端使用，针对场景1，2请接入APP支付，
     * 不然可能会出现兼容性问题
     * 1，IOS移动应用
     * {"h5_info"://h5支付固定传 "h5_info" {"type": "",//场景类型 "app_name": "",//应用名 "bundle_id": ""//bundle_id}}
     * 2，安卓移动应用
     * {"h5_info"://h5支付固定传"h5_info" {"type": "",//场景类型 "app_name": "",//应用名 "package_name": ""//包名}}
     * 3，WAP网站应用
     * {"h5_info"://h5支付固定传"h5_info" {"type": "",//场景类型 "wap_url": "",//WAP网站URL地址 "wap_name": ""//WAP 网站名}}
     */
    @XStreamAlias("scene_info")
    private String sceneInfo;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
    }

    public String getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(String deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getFeeType() {
        return feeType;
    }

    public void setFeeType(String feeType) {
        this.feeType = feeType;
    }

    public int getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(int totalFee) {
        this.totalFee = totalFee;
    }

    public String getSpbillCreateIp() {
        return spbillCreateIp;
    }

    public void setSpbillCreateIp(String spbillCreateIp) {
        this.spbillCreateIp = spbillCreateIp;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public String getTimeExpire() {
        return timeExpire;
    }

    public void setTimeExpire(String timeExpire) {
        this.timeExpire = timeExpire;
    }

    public String getGoodsTag() {
        return goodsTag;
    }

    public void setGoodsTag(String goodsTag) {
        this.goodsTag = goodsTag;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getLimitPay() {
        return limitPay;
    }

    public void setLimitPay(String limitPay) {
        this.limitPay = limitPay;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getReceipt() {
        return receipt;
    }

    public void setReceipt(String receipt) {
        this.receipt = receipt;
    }

    public String getSceneInfo() {
        return sceneInfo;
    }

    public void setSceneInfo(String sceneInfo) {
        this.sceneInfo = sceneInfo;
    }
}