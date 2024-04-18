package com.fujitsu.Model;

public class Option_RGST_GRPModel {
	
	private int OPT_ID;
	private int RGST_GRP_ID;
	private String OPT_VALUE1;
	private String OPT_VALUE2;
	private String result;
	
	
	public Option_RGST_GRPModel() {
		
	}


	public Option_RGST_GRPModel(int oPT_ID, int rGST_GRP_ID, String oPT_VALUE1, String oPT_VALUE2, String result) {
		
		OPT_ID = oPT_ID;
		RGST_GRP_ID = rGST_GRP_ID;
		OPT_VALUE1 = oPT_VALUE1;
		OPT_VALUE2 = oPT_VALUE2;
		this.result = result;
	}


	public int getOPT_ID() {
		return OPT_ID;
	}


	public void setOPT_ID(int oPT_ID) {
		OPT_ID = oPT_ID;
	}


	public int getRGST_GRP_ID() {
		return RGST_GRP_ID;
	}


	public void setRGST_GRP_ID(int rGST_GRP_ID) {
		RGST_GRP_ID = rGST_GRP_ID;
	}


	public String getOPT_VALUE1() {
		return OPT_VALUE1;
	}


	public void setOPT_VALUE1(String oPT_VALUE1) {
		OPT_VALUE1 = oPT_VALUE1;
	}


	public String getOPT_VALUE2() {
		return OPT_VALUE2;
	}


	public void setOPT_VALUE2(String oPT_VALUE2) {
		OPT_VALUE2 = oPT_VALUE2;
	}


	public String getResult() {
		return result;
	}


	public void setResult(String result) {
		this.result = result;
	}


	@Override
	public String toString() {
		return "Option_RGST_GRPModel [OPT_ID=" + OPT_ID + ", RGST_GRP_ID=" + RGST_GRP_ID + ", OPT_VALUE1=" + OPT_VALUE1
				+ ", OPT_VALUE2=" + OPT_VALUE2 + ", result=" + result + "]";
	}
	
	

}
