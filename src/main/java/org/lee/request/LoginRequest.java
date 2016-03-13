/*
 * Copyright 2015 the SiChuan MiaoQu Technology Co., Ltd.
 *
 * 四川妙趣科技有限公司    http://www.miaoqutech.com
 * 
 * Create Date : 2015年12月14日
 */

package org.lee.request;

public class LoginRequest {
	
	/** 登录名 */
	private String loginName;
	
	/** 密码 */
	private String password;
	
	/** 客户端ID，同于作推送时的标识 */
	private String clientId;
	
	/** 客户端设备标识(0:未知,1:ANDROID,2:IOS) */
	private int deviceType;
	
	/** 是否"记住我" */
	private boolean rememberMe;
	
	/** 用于推送踢掉旧clientId 无需客户端调用设置*/
	private String oldClientId;

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isRememberMe() {
		return rememberMe;
	}

	public void setRememberMe(boolean rememberMe) {
		this.rememberMe = rememberMe;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public int getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(int deviceType) {
		this.deviceType = deviceType;
	}

	public String getOldClientId() {
		return oldClientId;
	}

	public void setOldClientId(String oldClientId) {
		this.oldClientId = oldClientId;
	}
	
}
