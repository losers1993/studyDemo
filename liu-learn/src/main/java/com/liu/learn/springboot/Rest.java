package com.liu.learn.springboot;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Rest {
	private String NotifyContractRoot;
	private String TYPE;
	private String GROUP_TRANSACTIONID;
	private String CUSTOMER_TRANSACTIONID;
	private String STATUSINFO;
	private String ACCNBR;
	private String ACCEPTTYPE;
	private String ACCEPTMSG; 
	private String STATUSDT;
	private String RESULTMSG;
	public String getNotifyContractRoot() {
		return NotifyContractRoot;
	}
	public void setNotifyContractRoot(String notifyContractRoot) {
		NotifyContractRoot = notifyContractRoot;
	}
	public String getTYPE() {
		return TYPE;
	}
	public void setTYPE(String tYPE) {
		TYPE = tYPE;
	}
	public String getGROUP_TRANSACTIONID() {
		return GROUP_TRANSACTIONID;
	}
	public void setGROUP_TRANSACTIONID(String gROUP_TRANSACTIONID) {
		GROUP_TRANSACTIONID = gROUP_TRANSACTIONID;
	}
	public String getCUSTOMER_TRANSACTIONID() {
		return CUSTOMER_TRANSACTIONID;
	}
	public void setCUSTOMER_TRANSACTIONID(String cUSTOMER_TRANSACTIONID) {
		CUSTOMER_TRANSACTIONID = cUSTOMER_TRANSACTIONID;
	}
	public String getSTATUSINFO() {
		return STATUSINFO;
	}
	public void setSTATUSINFO(String sTATUSINFO) {
		STATUSINFO = sTATUSINFO;
	}
	public String getACCNBR() {
		return ACCNBR;
	}
	public void setACCNBR(String aCCNBR) {
		ACCNBR = aCCNBR;
	}
	public String getACCEPTTYPE() {
		return ACCEPTTYPE;
	}
	public void setACCEPTTYPE(String aCCEPTTYPE) {
		ACCEPTTYPE = aCCEPTTYPE;
	}
	public String getACCEPTMSG() {
		return ACCEPTMSG;
	}
	public void setACCEPTMSG(String aCCEPTMSG) {
		ACCEPTMSG = aCCEPTMSG;
	}
	public String getSTATUSDT() {
		return STATUSDT;
	}
	public void setSTATUSDT(String sTATUSDT) {
		STATUSDT = sTATUSDT;
	}
	public String getRESULTMSG() {
		return RESULTMSG;
	}
	public void setRESULTMSG(String rESULTMSG) {
		RESULTMSG = rESULTMSG;
	}
	
	
}
