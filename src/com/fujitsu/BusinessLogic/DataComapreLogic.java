package com.fujitsu.BusinessLogic;

import java.util.ArrayList;
import java.util.List;

import com.fujitsu.Model.OptionSTRModel;
import com.fujitsu.Model.Option_RGST_GRPModel;

public class DataComapreLogic {

	public List<OptionSTRModel> joinedListForOptionSTR(List<OptionSTRModel> tableData1, List<OptionSTRModel> tableData2) {
		// TODO Auto-generated method stub
		
		 List<OptionSTRModel> joinedList = new ArrayList<>();
		 OptionSTRModel joinedOptionSTRModel=new OptionSTRModel();

	       for (OptionSTRModel item1 : tableData1) {
	           for (OptionSTRModel item2 : tableData2) {
	               if (item1.getOPT_ID() == item2.getOPT_ID()) {
	            	   
	            	   if(item1.getOPT_VALUE1().equals(item2.getOPT_VALUE1()))
	            	   {
	            		   joinedOptionSTRModel.setResult("○"); 
	            	   }
	            	   else if(!item1.getOPT_VALUE1().equals(item2.getOPT_VALUE1()))
	            	   {
	            		   joinedOptionSTRModel.setResult("×"); 
	            	   }
	            	   OptionSTRModel joinedItem = new OptionSTRModel(item1.getOPT_ID(), item1.getOPT_VALUE1(), item2.getOPT_VALUE1(),joinedOptionSTRModel.getResult());
	                   joinedList.add(joinedItem);
	               }
	           }
	       }

	       return joinedList;
		
	}

	public List<Option_RGST_GRPModel> joinedListForOption_RGST_GRP(List<Option_RGST_GRPModel> tableData1,
			List<Option_RGST_GRPModel> tableData2,int RGST_GRP_ID1) {
		 List<Option_RGST_GRPModel> joinedList = new ArrayList<>();
		 Option_RGST_GRPModel option_RGST_GRPModel=new Option_RGST_GRPModel();

	       for (Option_RGST_GRPModel item1 : tableData1) {
	           for (Option_RGST_GRPModel item2 : tableData2) {
	               if (item1.getOPT_ID() == item2.getOPT_ID() && item1.getRGST_GRP_ID()==RGST_GRP_ID1) {
	            	   
	            	   if(item1.getOPT_VALUE1().trim().equals(item2.getOPT_VALUE1().trim()))
	            	   {
	            		   option_RGST_GRPModel.setResult("○"); 
	            	   }
	            	   else if(!item1.getOPT_VALUE1().equals(item2.getOPT_VALUE1()))
	            	   {
	            		   option_RGST_GRPModel.setResult("×"); 
	            	   }
	            	   option_RGST_GRPModel = new Option_RGST_GRPModel(item1.getOPT_ID(),item1.getRGST_GRP_ID(), item1.getOPT_VALUE1(), item2.getOPT_VALUE1(),option_RGST_GRPModel.getResult());
	                   joinedList.add(option_RGST_GRPModel);
	               }
	           }
	       }

	       return joinedList;
	}
	
	

}
