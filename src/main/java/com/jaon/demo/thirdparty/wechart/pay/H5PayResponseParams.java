package com.jaon.demo.thirdparty.wechart.pay;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 字段名	变量名	必填 	类型	  示例值	  描述
 */
@XStreamAlias("xml")
public class H5PayResponseParams {
    /**
     * 返回状态码	return_code	是	String(16)	SUCCESS
     * SUCCESS/FAIL 此字段是通信标识，非交易标识，交易是否成功需要查看trade_state来判断
     */
    @XStreamAlias("return_code")
    private String returnCode;
    /**
     * 返回信息	return_msg	是	String(128)	OK
     * 当return_code为FAIL时返回信息为错误原因 ，例如 签名失败 参数格式校验错误
     */
    @XStreamAlias("return_msg")
    private String returnMsg;
    /**
     * 以下字段在return_code为SUCCESS的时候有返回======start======
     */
    /**
     * 公众账号ID	appid	是	String(32)	wx8888888888888888	调用接口提交的公众账号ID
     */
    @XStreamAlias("appid")
    private String appId;
    /**
     * 商户号	mch_id	是	String(32)	1900000109	调用接口提交的商户号
     */
    @XStreamAlias("mch_id")
    private String mchId;

    /**
     * 设备号	device_info	否	String(32)	013467007045764	调用接口提交的终端设备号，
     */
    @XStreamAlias("device_info")
    private String deviceInfo;

    /**
     *  随机字符串	nonce_str	是	String(32)	5K8264ILTKCH16CQ2502SI8ZNMTM67VS	微信返回的随机字符串
     */
    @XStreamAlias("nonce_str")
    private String nonceStr;

    /**
     * 签名	sign	是	String(32)	C380BEC2BFD727A4B6845133519F3AD6	微信返回的签名，详见签名算法
     */
    @XStreamAlias("sign")
    private String sign;

    /**
     * 业务结果	result_code	是	String(16)	SUCCESS	SUCCESS/FAIL
     */
    @XStreamAlias("result_code")
    private String resultCode;

    /**
     * 错误代码	err_code	否	String(32)	SYSTEMERROR	详细参见错误列表
     */
    @XStreamAlias("err_code")
    private String errCode;
    /**
     * 错误代码描述	err_code_des	否	String(128)	系统错误	错误返回的信息描述
     */
    @XStreamAlias("err_code_des")
    private String errCodeDes;
    /**
     * 以上字段在return_code为SUCCESS的时候有返回========end======
     */
    /**
     * 以下字段在return_code 和result_code都为SUCCESS的时候有返回======start======
     */
    /**
     * 交易类型	trade_type	是	String(16)	MWEB	调用接口提交的交易类型，取值如下：JSAPI，NATIVE，APP，,H5支付固定传MWEB
     */
    @XStreamAlias("trade_type")
    private String tradeType;
    /**
     * 预支付交易会话标识	prepay_id	是	String(64)	wx201410272009395522657a690389285100
     * 微信生成的预支付回话标识，用于后续接口调用中使用，该值有效期为2小时,针对H5支付此参数无特殊用途
     */
    @XStreamAlias("prepay_id")
    private String prepayId;
    /**
     * 支付跳转链接	mweb_url	是	String(64)
     * https://wx.tenpay.com/cgi-bin/mmpayweb-bin/checkmweb?prepay_id=wx2016121516420242444321ca0631331346&package=1405458241
     * mweb_url为拉起微信支付收银台的中间页面，可通过访问该url来拉起微信客户端，完成支付,mweb_url的有效期为5分钟。
     */
    @XStreamAlias("mweb_url")
    private String mwebUrl;
    /**
     * 以上字段在return_code 和result_code都为SUCCESS的时候有返回========end======
     */

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMsg() {
        return returnMsg;
    }

    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }

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

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrCodeDes() {
        return errCodeDes;
    }

    public void setErrCodeDes(String errCodeDes) {
        this.errCodeDes = errCodeDes;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public String getPrepayId() {
        return prepayId;
    }

    public void setPrepayId(String prepayId) {
        this.prepayId = prepayId;
    }

    public String getMwebUrl() {
        return mwebUrl;
    }

    public void setMwebUrl(String mwebUrl) {
        this.mwebUrl = mwebUrl;
    }
}