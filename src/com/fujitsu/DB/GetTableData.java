package com.fujitsu.DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fujitsu.Model.OptionSTRModel;
import com.fujitsu.Model.Option_RGST_GRPModel;

public class GetTableData {

	public static List<OptionSTRModel> retrieveOPTION_STR_Data(String serverName,String userName,String pass) throws SQLException {
		// get data from table store it in to arryalist
		
		String query="SELECT [OPT_ID],[OPT_VALUE] as [OPT_VALUE1] FROM [GlobalSTORE1].[dbo].[OPTIONS_STR]";
		List<OptionSTRModel> tableData = new ArrayList<>();
		OptionSTRModel optionSTRModel = null;
		// get coonection from DatabaseConnection class
	  Connection connection = DatabaseConnection.getConnection(serverName,userName,pass);
		Statement statement = connection.createStatement();
		// To execute query
		ResultSet resultSet = statement.executeQuery(query);

		while (resultSet.next()) {

			
			int OPT_ID = resultSet.getInt("OPT_ID");
			String OPT_VALUE = resultSet.getString("OPT_VALUE1");
	        optionSTRModel = new OptionSTRModel(OPT_ID, OPT_VALUE,null,null);

			tableData.add(optionSTRModel);
		}

		resultSet.close();
		statement.close();
		connection.close();
		return tableData;
	}

	public static List<Option_RGST_GRPModel> retrieveOPTION_RGST_GRP_Data(String serverName,String userName,String pass) throws SQLException {
		
		String query="SELECT RGST_GRP_ID,OPT_ID ,OPT_VALUE as OPT_VALUE1  FROM [GlobalSTORE1].[dbo].OPTIONS_RGST_GRP ";
		List<Option_RGST_GRPModel> tableData = new ArrayList<>();
		Option_RGST_GRPModel model = null;

		Connection connection = DatabaseConnection.getConnection(serverName,userName,pass);
		Statement statement = connection.createStatement();

		ResultSet resultSet = statement.executeQuery(query);

		while (resultSet.next()) {


			int RGST_GRP_ID = resultSet.getInt("RGST_GRP_ID");

			int OPT_ID = resultSet.getInt("OPT_ID");

			String OPT_VALUE1 = resultSet.getString("OPT_VALUE1");
			
			model = new Option_RGST_GRPModel(OPT_ID, RGST_GRP_ID, OPT_VALUE1, null, null);

			tableData.add(model);
		}

		resultSet.close();
		statement.close();
		connection.close();

		return tableData;
	}

}
