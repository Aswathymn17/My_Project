package com.fujitsu.Model;

public class OptionSTRModel {
	
	private int OPT_ID;
	private String OPT_VALUE1;
	private String OPT_VALUE2;
	private String result;
	
	
	public OptionSTRModel() {
		
	}


	public OptionSTRModel(int oPT_ID, String oPT_VALUE1, String oPT_VALUE2, String result) {
		
		OPT_ID = oPT_ID;
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
		return "JoinedOptionSTRModel [OPT_ID=" + OPT_ID + ", OPT_VALUE1=" + OPT_VALUE1 + ", OPT_VALUE2=" + OPT_VALUE2
				+ ", result=" + result + "]";
	}
	
	
	

}
