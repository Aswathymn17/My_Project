package com.fujitsu.frame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.fujitsu.BusinessLogic.DataComapreLogic;
import com.fujitsu.DB.DatabaseConnection;
import com.fujitsu.DB.GetTableData;
import com.fujitsu.Model.OptionSTRModel;
import com.fujitsu.Model.Option_RGST_GRPModel;
import com.fujitsu.constant.Constant;
import com.fujitsu.excel.CreateExcelFile;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;

public class ButtonScreen {

	private JFrame frame;
	JLabel lblNewLabel_1 = new JLabel();
	private JTextField textField;
	private JTextField textField_1;
	Connection connection1=null;
	Connection connection2=null;
	

	  String serverName1=null;
	  String serverName2=null;
	 


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ButtonScreen window = new ButtonScreen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ButtonScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		JButton	btnNewButton_1 = new JButton("OPTION_STR");
		JButton	btnNewButton_1_1 = new JButton("OPTION_RGST_GRP");
		frame = new JFrame();
		frame.setBounds(100, 100, 666, 388);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Enter Store Name1");
		lblNewLabel.setFont(new Font("MS UI Gothic", Font.BOLD, 14));
		lblNewLabel.setBounds(21, 52, 175, 29);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblEnterStoreName = new JLabel("Enter Store Name2");
		lblEnterStoreName.setFont(new Font("MS UI Gothic", Font.BOLD, 14));
		lblEnterStoreName.setBounds(21, 105, 175, 29);
		frame.getContentPane().add(lblEnterStoreName);

		textField = new JTextField();
		textField.setBounds(214, 58, 219, 23);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(214, 111, 219, 23);
		frame.getContentPane().add(textField_1);

		JButton btnNewButton = new JButton("Connect");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (checkConnection1() && checkConnection2()) {
					JOptionPane.showMessageDialog(frame, "Sucesssfully connected to the server");
					serverName1=textField.getText();
					serverName2=textField_1.getText();
					btnNewButton_1.setEnabled(true);
					btnNewButton_1_1.setEnabled(true);
					changeLabelToGreen();
					
				} else {
					JOptionPane.showMessageDialog(frame, "Connection Failed Please check Sever Name");
					btnNewButton_1.setEnabled(false);
					btnNewButton_1_1.setEnabled(false);
					changeLabelToRed();
				}

			}
		});
		btnNewButton.setBounds(506, 84, 98, 36);
		frame.getContentPane().add(btnNewButton);
		btnNewButton_1.setEnabled(false);
		btnNewButton_1_1.setEnabled(false);
		changeLabelToRed();
		
		
		

		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				List<OptionSTRModel> tableData1=null;
				List<OptionSTRModel> tableData2=null;
				List<OptionSTRModel> list=null;
				// TODO Auto-generated method stub
				//	GetTableData s=new GetTableData();

				try {
					if(serverName1!=null &&serverName2!=null)
					{
					tableData1=GetTableData.retrieveOPTION_STR_Data(textField.getText(),Constant.userName1,Constant.pass1);
					tableData2=GetTableData.retrieveOPTION_STR_Data(textField_1.getText(),Constant.userName2,Constant.pass2);
					}
					DataComapreLogic optionSTRComapreLogic=new DataComapreLogic();

					list=optionSTRComapreLogic.joinedListForOptionSTR(tableData1,tableData2);

					CreateExcelFile createExcelFile=new CreateExcelFile();
					createExcelFile.generateExcelFileForOption_STR(list, "ComapareResult");

					JOptionPane.showMessageDialog(frame, "Output Generated Sucessfully");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					 JOptionPane.showMessageDialog(null, "Error creating file!",
						      "Error!", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}catch (IOException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Error creating file,Please check if excel file has already opened!",
						      "Error!", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}



			}
		});
		btnNewButton_1.setBounds(33, 239, 234, 67);
		frame.getContentPane().add(btnNewButton_1);

		
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				serverName1=textField.getText().trim();
				//	serverName2=textField_1.getText().trim();
				System.out.println(textField_1.getText());
				List<Option_RGST_GRPModel> tableData1=null;
				List<Option_RGST_GRPModel> tableData2=null;
				List<Option_RGST_GRPModel> list1=null;
				List<Option_RGST_GRPModel> list5=null;
				List<Option_RGST_GRPModel> list6=null;
				List<Option_RGST_GRPModel> list10=null;
				List<Option_RGST_GRPModel> list11=null;
				// TODO Auto-generated method stub
				//	GetTableData s=new GetTableData();
				//	System.out.println(serverName1);
				//System.out.println(serverName2);
				try {
					if(serverName1!=null &&serverName2!=null)
					{
					tableData1=GetTableData.retrieveOPTION_RGST_GRP_Data(serverName1,Constant.userName1,Constant.pass1);
					tableData2=GetTableData.retrieveOPTION_RGST_GRP_Data(serverName2,Constant.userName2,Constant.pass2);
					}
					DataComapreLogic optionSTRComapreLogic=new DataComapreLogic();

					list1=	optionSTRComapreLogic.joinedListForOption_RGST_GRP(tableData1,tableData2,1);
					list5=	optionSTRComapreLogic.joinedListForOption_RGST_GRP(tableData1,tableData2,5);
					list6=	optionSTRComapreLogic.joinedListForOption_RGST_GRP(tableData1,tableData2,6);
					list10=optionSTRComapreLogic.joinedListForOption_RGST_GRP(tableData1,tableData2,9);
					list11=optionSTRComapreLogic.joinedListForOption_RGST_GRP(tableData1,tableData2,10);

					CreateExcelFile createExcelFile=new CreateExcelFile();
					XSSFWorkbook workbook1 =createExcelFile.generateExcelFileForOPTION_RGST_GRP(list1, "POS");
					
					XSSFWorkbook workbook2 =	createExcelFile.generateExcelFileForOPTION_RGST_GRP(list5, "SS");
					XSSFWorkbook workbook3 =	createExcelFile.generateExcelFileForOPTION_RGST_GRP(list6, "PS");
					XSSFWorkbook workbook4 =	createExcelFile.generateExcelFileForOPTION_RGST_GRP(list10, "FULL_SELF");
					XSSFWorkbook workbook5 =	createExcelFile.generateExcelFileForOPTION_RGST_GRP(list11, "CASHLESS");
					workbook1.close();
					workbook2.close();
					workbook3.close();
					workbook4.close();
					workbook5.close();
					JOptionPane.showMessageDialog(frame, "Output Generated Sucessfully");
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					 JOptionPane.showMessageDialog(null, "Error creating file!",
						      "Error!", JOptionPane.ERROR_MESSAGE);
					e2.printStackTrace();
				}catch (IOException e2) {
					// TODO Auto-generated catch block
					 JOptionPane.showMessageDialog(null, "Error creating file,Please check if excel file has already opened!",
						      "Error!", JOptionPane.ERROR_MESSAGE);
					e2.printStackTrace();
				}


			}



		});
		btnNewButton_1_1.setBounds(370, 239, 234, 67);
		frame.getContentPane().add(btnNewButton_1_1);
	}

	public boolean checkConnection1() {

		boolean isConnection1 = false;
		if (textField.getText().trim().length() > 0 && textField_1.getText().trim().length() > 0) {

			{

				try {

					DriverManager.setLoginTimeout(1);
					connection1 = DatabaseConnection.getConnection(textField.getText(), Constant.userName1, Constant.pass1);
					//connection2 = DatabaseConnection.getConnection(textField_1.getText(), "sa", "aswa17");
					isConnection1 = true;

				} catch (SQLException e1) { // TODO Auto-generated catch block
					isConnection1 = false;
					e1.printStackTrace();
				}
			}
				
		} else {
			isConnection1 = false;

		}
		return isConnection1;
	}
	public boolean checkConnection2() {

		boolean isConnection2 = false;
		if (textField.getText().trim().length() > 0 && textField_1.getText().trim().length() > 0) {

			{

				try {

					DriverManager.setLoginTimeout(1);
					//connection1 = DatabaseConnection.getConnection(textField.getText(), "root", "password");
					connection2 = DatabaseConnection.getConnection(textField_1.getText(), Constant.userName2, Constant.pass2);
					isConnection2 = true;

				} catch (SQLException e1) { // TODO Auto-generated catch block
					isConnection2 = false;
					e1.printStackTrace();
				}
			}
				
		} else {
			isConnection2 = false;

		}
		return isConnection2;
	}
	private void changeLabelToGreen()
	{
		 lblNewLabel_1.setText("Successfully Connected to the server");
			lblNewLabel_1.setForeground(Color.GREEN);
			lblNewLabel_1.setBackground(Color.GREEN);
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setFont(new Font("MS UI Gothic", Font.BOLD, 12));
			lblNewLabel_1.setBounds(132, 168, 370, 29);
			frame.getContentPane().add(lblNewLabel_1);
	}
	private void changeLabelToRed()
	{
		 lblNewLabel_1.setText("Please Connect to the Server");
			lblNewLabel_1.setForeground(Color.RED);
			lblNewLabel_1.setBackground(Color.RED);
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setFont(new Font("MS UI Gothic", Font.BOLD, 12));
			lblNewLabel_1.setBounds(132, 168, 370, 29);
			frame.getContentPane().add(lblNewLabel_1);
	}
}
