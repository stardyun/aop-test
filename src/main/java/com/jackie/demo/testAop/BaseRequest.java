package com.jackie.demo.testAop;


import lombok.Data;

/**
 * 重构原RequestBase
 * @author Jackie
 */
@Data
public class BaseRequest<T> {

	/**
	 * 系统渠道
	 */
	private String sysChannel;
	/**
	 * 业务渠道
	 */
	private String bussChannel;
	/**
	 * 版本号
	 */
	private String appVersion;
	/**
	 * 业务流水号
	 */
	private String bussSeqNo;
	/**
	 * 请求时间
	 */
	private String reqTime;
	/**
	 * 请求时间
	 */
	private String channelId;
	/**
	 * token令牌
	 */
	private String token;
	/**
	 * 签名
	 */
	private String sign;
	/**
	 * 微信openId
	 */
	private String openId;
	/**
	 * 设备Id
	 */
	private String deviceId;
	/**
	 * 业务机构
	 */
	private String busiOrg;
	/**
	 * 账务机构
	 */
	private String acctOrg;
	/**
	 * 请求data
	 */
	private T reqData;

	public void setReqDataString(String reqData) {
		this.reqData = (T) reqData;
	}
}
