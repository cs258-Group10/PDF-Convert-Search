package sep;

import java.awt.EventQueue;
import java.io.*;
import java.sql.*;
import java.util.Scanner;

import javax.swing.*;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import javax.imageio.ImageIO;
import javax.swing.table.TableModel;

public class Patents_Data_Manager {
	
	JFrame frame;
	public static String answer;
	public static dconnection conn = new dconnection();
	public static Connection connection = conn.getDBConnection();
	public static String query=" ";
	public static ResultSet rs;
	private JTextField textField;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_13;
	private JTable table;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_6;
	private JTextField textField_9;
	private JTable table_1;
	/**
	 * @wbp.nonvisual location=462,269
	 */
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Patents_Data_Manager window = new Patents_Data_Manager();
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
	public Patents_Data_Manager() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setExtendedState(Frame.MAXIMIZED_BOTH);
		frame.setBounds(100, 100, 1366, 768);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 1350, 729);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Search", null, panel, null);
		panel.setLayout(null);
		
		
		
		JCheckBox NewCheckBox = new JCheckBox("APP_NO");
		NewCheckBox.setBounds(18, 63, 125, 23);
		panel.add(NewCheckBox);
		
		textField = new JTextField();
		textField.setBounds(149, 63, 137, 23);
		panel.add(textField);
		textField.setColumns(10);
		
		JCheckBox checkBox = new JCheckBox("APP_DATE");
		checkBox.setBounds(18, 93, 125, 23);
		panel.add(checkBox);
		
		JCheckBox chckbxPrioritydate = new JCheckBox("PUB_DATE");
		chckbxPrioritydate.setBounds(18, 144, 125, 23);
		panel.add(chckbxPrioritydate);
		
		
		
		textField_3 = new JTextField();
		textField_3.setBounds(149, 195, 137, 23);
		textField_3.setColumns(10);
		panel.add(textField_3);
		
		JCheckBox checkBox_2 = new JCheckBox("TITLE_OF_INVENTION");
		checkBox_2.setBounds(18, 195, 125, 23);
		panel.add(checkBox_2);
		
		
		
		textField_4 = new JTextField();
		textField_4.setBounds(149, 225, 137, 23);
		textField_4.setColumns(10);
		panel.add(textField_4);
		
		JCheckBox checkBox_3 = new JCheckBox("INT_CLASSIFICATION");
		checkBox_3.setBounds(18, 225, 125, 23);
		panel.add(checkBox_3);
		
		
		
		textField_5 = new JTextField();
		textField_5.setBounds(149, 255, 137, 23);
		textField_5.setColumns(10);
		panel.add(textField_5);
		
		JCheckBox checkBox_4 = new JCheckBox("PRIORITY_DOC_NO");
		checkBox_4.setBounds(18, 255, 125, 23);
		panel.add(checkBox_4);
		
		JCheckBox checkBox_5 = new JCheckBox("PRIORITY_DATE");
		checkBox_5.setBounds(18, 285, 125, 23);
		panel.add(checkBox_5);
		
		
		
		textField_7 = new JTextField();
		textField_7.setBounds(149, 336, 137, 23);
		textField_7.setColumns(10);
		panel.add(textField_7);
		
		JCheckBox checkBox_6 = new JCheckBox("NAME_OF_PRIORITY_COUNTRY");
		checkBox_6.setBounds(18, 336, 125, 23);
		panel.add(checkBox_6);
		
		
		
		textField_8 = new JTextField();
		textField_8.setBounds(149, 366, 137, 23);
		textField_8.setColumns(10);
		panel.add(textField_8);
		
		JCheckBox checkBox_7 = new JCheckBox("INT_APP_NO");
		checkBox_7.setBounds(18, 366, 125, 23);
		panel.add(checkBox_7);
		
		JCheckBox checkBox_8 = new JCheckBox("IAN_FILING_DATE");
		checkBox_8.setBounds(18, 396, 125, 23);
		panel.add(checkBox_8);
		
		
		
		textField_10 = new JTextField();
		textField_10.setBounds(149, 447, 137, 23);
		textField_10.setColumns(10);
		panel.add(textField_10);
		
		JCheckBox checkBox_9 = new JCheckBox("INT_PUB_NO");
		checkBox_9.setBounds(18, 447, 125, 23);
		panel.add(checkBox_9);
		
		
		
		textField_11 = new JTextField();
		textField_11.setBounds(149, 477, 137, 23);
		textField_11.setColumns(10);
		panel.add(textField_11);
		
		JCheckBox checkBox_10 = new JCheckBox("PAT_OF_ADD_TO_APP_NO");
		checkBox_10.setBounds(18, 477, 125, 23);
		panel.add(checkBox_10);
		
		JCheckBox checkBox_11 = new JCheckBox("POATAN_FILING_DATE");
		checkBox_11.setBounds(18, 507, 125, 23);
		panel.add(checkBox_11);
		
		
		
		textField_13 = new JTextField();
		textField_13.setBounds(149, 558, 137, 23);
		textField_13.setColumns(10);
		panel.add(textField_13);
		
		JCheckBox checkBox_12 = new JCheckBox("DIV_TO_APP_NO");
		checkBox_12.setBounds(18, 558, 125, 23);
		panel.add(checkBox_12);
		
		JCheckBox checkBox_13 = new JCheckBox("DTAN_FILING_DATE");
		checkBox_13.setBounds(18, 588, 125, 23);
		panel.add(checkBox_13);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		scrollPane.setBounds(296, 63, 1021, 613);
		panel.add(scrollPane);
		
		DefaultTableModel model,model_1;
		model = new DefaultTableModel()
		{
		    /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column)
		    {
		      return false;//This causes all cells to be not editable
		    }
		  };
		  
		 model_1 = new DefaultTableModel()
			{
			    /**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				public boolean isCellEditable(int row, int column)
			    {
			      return false;//This causes all cells to be not editable
			    }
			  };
		
		model.addColumn("Applicaiton Number");
		model.addColumn("Application Date");
		model.addColumn("Publication Date");
		model.addColumn("Title of Invention");
		model.addColumn("Int. Classification");
		model.addColumn("Priority Doc. No.");
		model.addColumn("Priority Date");
		model.addColumn("Name of Priority Country");
		model.addColumn("Int. App. No.");
		model.addColumn("IAN Filing Date");
		model.addColumn("Int. Pub. No.");
		model.addColumn("Pat. of ADD. to APP. No.");
		model.addColumn("POATAN Filing Date");
		model.addColumn("Div. to App. No.");
		model.addColumn("DTAN Filing Date");
		model.addColumn("Abstract");
		model.addColumn("Applicant");
		model.addColumn("Inventor");
		
		table = new JTable(model);
		table.setCellSelectionEnabled(true);
		
		table.setGridColor(new Color(0, 128, 0));
		scrollPane.setViewportView(table);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(184, 93, 102, 20);
		panel.add(dateChooser);
		
		JLabel lblFrom = new JLabel("From");
		lblFrom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFrom.setBounds(149, 94, 42, 20);
		panel.add(lblFrom);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(184, 117, 102, 20);
		panel.add(dateChooser_1);
		
		JLabel lblTo = new JLabel("To");
		lblTo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTo.setBounds(149, 117, 42, 20);
		panel.add(lblTo);
		
		JLabel label = new JLabel("From");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(149, 145, 42, 20);
		panel.add(label);
		
		JDateChooser dateChooser_2 = new JDateChooser();
		dateChooser_2.setBounds(184, 144, 102, 20);
		panel.add(dateChooser_2);
		
		JDateChooser dateChooser_3 = new JDateChooser();
		dateChooser_3.setBounds(184, 168, 102, 20);
		panel.add(dateChooser_3);
		
		JLabel label_1 = new JLabel("To");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_1.setBounds(149, 168, 42, 20);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("From");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_2.setBounds(149, 286, 42, 20);
		panel.add(label_2);
		
		JDateChooser dateChooser_4 = new JDateChooser();
		dateChooser_4.setBounds(184, 285, 102, 20);
		panel.add(dateChooser_4);
		
		JDateChooser dateChooser_5 = new JDateChooser();
		dateChooser_5.setBounds(184, 309, 102, 20);
		panel.add(dateChooser_5);
		
		JLabel label_3 = new JLabel("To");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_3.setBounds(149, 309, 42, 20);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("From");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_4.setBounds(149, 397, 42, 20);
		panel.add(label_4);
		
		JDateChooser dateChooser_6 = new JDateChooser();
		dateChooser_6.setBounds(184, 396, 102, 20);
		panel.add(dateChooser_6);
		
		JDateChooser dateChooser_7 = new JDateChooser();
		dateChooser_7.setBounds(184, 420, 102, 20);
		panel.add(dateChooser_7);
		
		JLabel label_5 = new JLabel("To");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_5.setBounds(149, 420, 42, 20);
		panel.add(label_5);
		
		JLabel label_6 = new JLabel("From");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_6.setBounds(149, 508, 42, 20);
		panel.add(label_6);
		
		JDateChooser dateChooser_8 = new JDateChooser();
		dateChooser_8.setBounds(184, 507, 102, 20);
		panel.add(dateChooser_8);
		
		JDateChooser dateChooser_9 = new JDateChooser();
		dateChooser_9.setBounds(184, 531, 102, 20);
		panel.add(dateChooser_9);
		
		JLabel label_7 = new JLabel("To");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_7.setBounds(149, 531, 42, 20);
		panel.add(label_7);
		
		JLabel label_8 = new JLabel("From");
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_8.setBounds(149, 589, 42, 20);
		panel.add(label_8);
		
		JDateChooser dateChooser_10 = new JDateChooser();
		dateChooser_10.setBounds(184, 588, 102, 20);
		panel.add(dateChooser_10);
		
		JDateChooser dateChooser_11 = new JDateChooser();
		dateChooser_11.setBounds(184, 612, 102, 20);
		panel.add(dateChooser_11);
		
		JLabel label_9 = new JLabel("To");
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_9.setBounds(149, 612, 42, 20);
		panel.add(label_9);
		
		
		
		
		JButton btnSearch = new JButton("Search");
		
		btnSearch.setBounds(18, 653, 125, 23);
		panel.add(btnSearch);
		
		JButton btnNewButton_1 = new JButton("Export Results");
		
		btnNewButton_1.setBounds(159, 653, 127, 23);
		panel.add(btnNewButton_1);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel label_10 = new JLabel("");
		label_10.setVisible(false);
		label_10.setPreferredSize(new Dimension(50, 50));
		label_10.setBounds(447, 193, 204, 196);
		panel_1.add(label_10);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				JFileChooser chooser = new JFileChooser();
				chooser.showOpenDialog(null);
				File f = chooser.getSelectedFile();
				
				label_10.setVisible(true);
				
				String path = f.getAbsolutePath();
				try {
					File file = new File(path);
					FileReader fileReader = new FileReader(file);
					BufferedReader bufferedReader = new BufferedReader(fileReader);
					String line;
					int success=0,failure=0;
					while ((line = bufferedReader.readLine()) != null) {
					
					
					try{
						Statement statement = connection.createStatement();
						String fquery = "insert into patents_data(app_no,app_date,pub_date,title_of_invention,int_classification,priority_doc_no,priority_date,name_of_priority_country,int_app_no,ian_filing_date,int_pub_no,pat_of_add_to_app_no,poatan_filing_date,div_to_app_no,dtan_filing_date,applicants,inventor,abstract) values("+line+")";
						ResultSet x=statement.executeQuery(fquery);
						statement.close();
						
						if(x.equals(null))
							failure++;
						else
							success++;
					}
					catch(SQLException e)
					{
						failure++;
						e.printStackTrace();
					}
				
					}
					
					label_10.setVisible(false);
					
					JOptionPane.showMessageDialog(null, success+" enteries successfully inserted!\n"+failure+" failures!");
					
					fileReader.close();
			} catch (IOException e) {
					e.printStackTrace();
					frame.dispose();
				}
			}			
		});
		btnNewButton.setBounds(502, 130, 89, 23);
		panel_1.add(btnNewButton);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_2, null);
		panel_2.setLayout(null);
		
		JButton btnGranted = new JButton("granted");
		btnGranted.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				JFileChooser chooser = new JFileChooser();
				chooser.showOpenDialog(null);
				File f = chooser.getSelectedFile();
				
				String path = f.getAbsolutePath();
				try {
					File file = new File(path);
					FileReader fileReader = new FileReader(file);
					BufferedReader bufferedReader = new BufferedReader(fileReader);
					String line;
					int success=0,failure=0;
					while ((line = bufferedReader.readLine()) != null) {
					
					
					try{
						Statement statement = connection.createStatement();
						String fquery = "insert into patents_granted(patent_no,app_no,app_date,priority_date,title,pub_date,office) values("+line+")";
						ResultSet x=statement.executeQuery(fquery);
						statement.close();
						
						if(x.equals(null))
							failure++;
						else
							success++;
					}
					catch(SQLException e1)
					{
						failure++;
						e1.printStackTrace();
					}
				
					}
				
					JOptionPane.showMessageDialog(null, success+" enteries successfully inserted!\n"+failure+" failures!");
					
					fileReader.close();
			} catch (IOException e2) {
					e2.printStackTrace();
					frame.dispose();
				}
			}
		});
		btnGranted.setBounds(286, 74, 89, 23);
		panel_2.add(btnGranted);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		tabbedPane.addTab("New tab", null, panel_4, null);
		
		JCheckBox chckbxPatentno = new JCheckBox("PATENT_NO");
		chckbxPatentno.setBounds(18, 63, 125, 23);
		panel_4.add(chckbxPatentno);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(149, 63, 137, 23);
		panel_4.add(textField_1);
		
		JCheckBox checkBox_15 = new JCheckBox("APP_DATE");
		checkBox_15.setBounds(18, 93, 125, 23);
		panel_4.add(checkBox_15);
		
		JCheckBox chckbxPrioritydate_1 = new JCheckBox("PRIORITY_DATE");
		chckbxPrioritydate_1.setBounds(18, 144, 125, 23);
		panel_4.add(chckbxPrioritydate_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(149, 195, 137, 23);
		panel_4.add(textField_2);
		
		JCheckBox chckbxAppno = new JCheckBox("APP_NO");
		chckbxAppno.setBounds(18, 195, 125, 23);
		panel_4.add(chckbxAppno);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(149, 225, 137, 23);
		panel_4.add(textField_6);
		
		JCheckBox chckbxTitleAndPatentee = new JCheckBox("TITLE AND PATENTEE");
		chckbxTitleAndPatentee.setBounds(18, 225, 125, 23);
		panel_4.add(chckbxTitleAndPatentee);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(149, 255, 137, 23);
		panel_4.add(textField_9);
		
		JCheckBox chckbxOffice = new JCheckBox("OFFICE");
		chckbxOffice.setBounds(18, 255, 125, 23);
		panel_4.add(chckbxOffice);
		
		JCheckBox chckbxPubdate = new JCheckBox("PUB_DATE");
		chckbxPubdate.setBounds(18, 285, 125, 23);
		panel_4.add(chckbxPubdate);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBorder(null);
		scrollPane_1.setBounds(296, 63, 1021, 613);
		panel_4.add(scrollPane_1);
		
		model_1.addColumn("Patent Number");
		model_1.addColumn("Application Number");
		model_1.addColumn("Application Date");
		model_1.addColumn("Priority Date");
		model_1.addColumn("Title and Patentee");
		model_1.addColumn("Publication Date");
		model_1.addColumn("Office");
		
		table_1 = new JTable(model_1);
		table_1.setGridColor(new Color(0, 128, 0));
		table_1.setCellSelectionEnabled(true);
		scrollPane_1.setViewportView(table_1);
		
		JDateChooser dateChooser_12 = new JDateChooser();
		dateChooser_12.setBounds(184, 93, 102, 20);
		panel_4.add(dateChooser_12);
		
		JLabel label_11 = new JLabel("From");
		label_11.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_11.setBounds(149, 94, 42, 20);
		panel_4.add(label_11);
		
		JDateChooser dateChooser_13 = new JDateChooser();
		dateChooser_13.setBounds(184, 117, 102, 20);
		panel_4.add(dateChooser_13);
		
		JLabel label_12 = new JLabel("To");
		label_12.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_12.setBounds(149, 117, 42, 20);
		panel_4.add(label_12);
		
		JLabel label_13 = new JLabel("From");
		label_13.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_13.setBounds(149, 145, 42, 20);
		panel_4.add(label_13);
		
		JDateChooser dateChooser_14 = new JDateChooser();
		dateChooser_14.setBounds(184, 144, 102, 20);
		panel_4.add(dateChooser_14);
		
		JDateChooser dateChooser_15 = new JDateChooser();
		dateChooser_15.setBounds(184, 168, 102, 20);
		panel_4.add(dateChooser_15);
		
		JLabel label_14 = new JLabel("To");
		label_14.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_14.setBounds(149, 168, 42, 20);
		panel_4.add(label_14);
		
		JLabel label_15 = new JLabel("From");
		label_15.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_15.setBounds(149, 286, 42, 20);
		panel_4.add(label_15);
		
		JDateChooser dateChooser_16 = new JDateChooser();
		dateChooser_16.setBounds(184, 285, 102, 20);
		panel_4.add(dateChooser_16);
		
		JDateChooser dateChooser_17 = new JDateChooser();
		dateChooser_17.setBounds(184, 309, 102, 20);
		panel_4.add(dateChooser_17);
		
		JLabel label_16 = new JLabel("To");
		label_16.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_16.setBounds(149, 309, 42, 20);
		panel_4.add(label_16);
		
		JButton button = new JButton("Search");
		JButton button_1 = new JButton("Export Results");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				Integer check=0;
				query = " ";
				
				if(chckbxPatentno.isSelected())
				{
					check++;
					
					if(check == 1)
					{
						query+="where patent_no like '%"+textField_1.getText()+"%'";
					}
				}
				
				if(checkBox_15.isSelected())
				{
					check++;
					
					java.sql.Date from_date = new java.sql.Date(dateChooser_12.getDate().getTime());
					java.sql.Date to_date = new java.sql.Date(dateChooser_13.getDate().getTime());
					
					if(check == 1)
					{
						query+="where APP_DATE between to_date('"+ from_date +"','yyyy-mm-dd') and to_date('"+ to_date +"','yyyy-mm-dd')";
					}
					
					else if(check>1)
					{
						query+=" and APP_DATE between to_date('"+ from_date +"','yyyy-mm-dd') and to_date('"+ to_date +"','yyyy-mm-dd')";
					}
				}
				
				if(chckbxPrioritydate_1.isSelected())
				{
					check++;
					
					java.sql.Date from_date = new java.sql.Date(dateChooser_14.getDate().getTime());
					java.sql.Date to_date = new java.sql.Date(dateChooser_15.getDate().getTime());
					
					
					if(check == 1)
					{
						query+="where PRIORITY_DATE between to_date('"+ from_date +"','yyyy-mm-dd') and to_date('"+ to_date +"','yyyy-mm-dd')";
					}
					
					else if(check>1)
					{
						query+=" and PRIORITY_DATE between to_date('"+ from_date +"','yyyy-mm-dd') and to_date('"+ to_date +"','yyyy-mm-dd')";
					}
				}
				
				if(chckbxAppno.isSelected())
				{
					check++;
					
					if(check == 1)
					{
						query+="where APP_NO like '%"+textField_2.getText()+"%'";
					}
					
					else if(check>1)
					{
						query+=" and APP_NO like '%"+textField_2.getText()+"%'";
					}
				}
				
				if(chckbxTitleAndPatentee.isSelected())
				{
					check++;
					
					if(check == 1)
					{
						query+="where title_and_patentee like '%"+textField_6.getText()+"%'";
					}
					
					else if(check>1)
					{
						query+=" and title_and_patentee like '%"+textField_6.getText()+"%'";
					}
				}
				
				if(chckbxOffice.isSelected())
				{
					check++;
					
					if(check == 1)
					{
						query+="where office like '%"+textField_9.getText()+"%'";
					}
					
					else if(check>1)
					{
						query+=" and office like '%"+textField_9.getText()+"%'";
					}
				}
				
				if(chckbxPubdate.isSelected())
				{
					check++;
					
					java.sql.Date from_date = new java.sql.Date(dateChooser_16.getDate().getTime());
					java.sql.Date to_date = new java.sql.Date(dateChooser_17.getDate().getTime());
					
					
					if(check == 1)
					{
						query+="where PUB_DATE between to_date('"+ from_date +"','yyyy-mm-dd') and to_date('"+ to_date +"','yyyy-mm-dd')";
					}
					
					else if(check>1)
					{
						query+=" and PUB_DATE between to_date('"+ from_date +"','yyyy-mm-dd') and to_date('"+ to_date +"','yyyy-mm-dd')";
					}
				}
				
				try{
					Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
					String fquery = "select patent_no,app_no,app_date,priority_date,title_and_patentee,pub_date,office from patents_granted";
					rs = statement.executeQuery(fquery+query);					
					
					model_1.setRowCount(0);
					int count=0;
					
					while(rs.next())
					{
						model_1.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)});
						count++;
					}
					JOptionPane.showMessageDialog(null, count+" results found!");
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
				button_1.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						JFileChooser chooser = new JFileChooser();
						chooser.showSaveDialog(null);
						File f = chooser.getSelectedFile();
						String path = f.getAbsolutePath();
						try {
							File file = new File(path);
							FileWriter filewriter = new FileWriter(file);
							try {
								rs.beforeFirst();

							while(rs.next())
							{
								for(int i=1 ; i<8 ;i++)
								{
									filewriter.write("\""+rs.getString(i)+"\"");
									if(i<7)
										filewriter.write(",");
								}
								filewriter.write("\n");
							}
							}
							catch (SQLException e) {
								e.printStackTrace();
							}
							
							filewriter.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		button.setBounds(18, 653, 125, 23);
		panel_4.add(button);
		
		button_1.setBounds(159, 653, 127, 23);
		panel_4.add(button_1);
		
		btnSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				Integer check=0;
				query = " ";
				
				if(NewCheckBox.isSelected())
				{
					check++;
					
					if(check == 1)
					{
						query+="where app_no like '%"+textField.getText()+"%'";
					}
				}
				
				if(checkBox.isSelected())
				{
					check++;
					
					java.sql.Date from_date = new java.sql.Date(dateChooser.getDate().getTime());
					java.sql.Date to_date = new java.sql.Date(dateChooser_1.getDate().getTime());
					
					if(check == 1)
					{
						query+="where APP_DATE between to_date('"+ from_date +"','yyyy-mm-dd') and to_date('"+ to_date +"','yyyy-mm-dd')";
					}
					
					else if(check>1)
					{
						query+=" and APP_DATE between to_date('"+ from_date +"','yyyy-mm-dd') and to_date('"+ to_date +"','yyyy-mm-dd')";
					}
				}
				
				if(chckbxPrioritydate.isSelected())
				{
					check++;
					
					java.sql.Date from_date = new java.sql.Date(dateChooser_2.getDate().getTime());
					java.sql.Date to_date = new java.sql.Date(dateChooser_3.getDate().getTime());
					
					
					if(check == 1)
					{
						query+="where PUB_DATE between to_date('"+ from_date +"','yyyy-mm-dd') and to_date('"+ to_date +"','yyyy-mm-dd')";
					}
					
					else if(check>1)
					{
						query+=" and PUB_DATE between to_date('"+ from_date +"','yyyy-mm-dd') and to_date('"+ to_date +"','yyyy-mm-dd')";
					}
				}
				
				if(checkBox_2.isSelected())
				{
					check++;
					
					if(check == 1)
					{
						query+="where TITLE_OF_INVENTION like '%"+textField_3.getText()+"%'";
					}
					
					else if(check>1)
					{
						query+=" and TITLE_OF_INVENTION like '%"+textField_3.getText()+"%'";
					}
				}
				
				if(checkBox_3.isSelected())
				{
					check++;
					
					if(check == 1)
					{
						query+="where INT_CLASSIFICATION like '%"+textField_4.getText()+"%'";
					}
					
					else if(check>1)
					{
						query+=" and INT_CLASSIFICATION like '%"+textField_4.getText()+"%'";
					}
				}
				
				if(checkBox_4.isSelected())
				{
					check++;
					
					if(check == 1)
					{
						query+="where PRIORITY_DOC_NO like '%"+textField_5.getText()+"%'";
					}
					
					else if(check>1)
					{
						query+=" and PRIORITY_DOC_NO like '%"+textField_5.getText()+"%'";
					}
				}
				
				if(checkBox_5.isSelected())
				{
					check++;
					
					java.sql.Date from_date = new java.sql.Date(dateChooser_4.getDate().getTime());
					java.sql.Date to_date = new java.sql.Date(dateChooser_5.getDate().getTime());
					
					
					if(check == 1)
					{
						query+="where PRIORITY_DATE between to_date('"+ from_date +"','yyyy-mm-dd') and to_date('"+ to_date +"','yyyy-mm-dd')";
					}
					
					else if(check>1)
					{
						query+=" and PRIORITY_DATE between to_date('"+ from_date +"','yyyy-mm-dd') and to_date('"+ to_date +"','yyyy-mm-dd')";
					}
				}
				
				if(checkBox_6.isSelected())
				{
					check++;
					
					if(check == 1)
					{
						query+="where NAME_OF_PRIORITY_COUNTRY like '%"+textField_7.getText()+"%'";
					}
					
					else if(check>1)
					{
						query+=" and NAME_OF_PRIORITY_COUNTRY like '%"+textField_7.getText()+"%'";
					}
				}
				
				if(checkBox_7.isSelected())
				{
					check++;
					
					if(check == 1)
					{
						query+="where INT_APP_NO like '%"+textField_8.getText()+"%'";
					}
					
					else if(check>1)
					{
						query+=" and INT_APP_NO like '%"+textField_8.getText()+"%'";
					}
				}
				
				if(checkBox_8.isSelected())
				{
					check++;
					
					java.sql.Date from_date = new java.sql.Date(dateChooser_6.getDate().getTime());
					java.sql.Date to_date = new java.sql.Date(dateChooser_7.getDate().getTime());
					
					
					if(check == 1)
					{
						query+="where IAN_FILING_DATE between to_date('"+ from_date +"','yyyy-mm-dd') and to_date('"+ to_date +"','yyyy-mm-dd')";
					}
					
					else if(check>1)
					{
						query+=" and IAN_FILING_DATE between to_date('"+ from_date +"','yyyy-mm-dd') and to_date('"+ to_date +"','yyyy-mm-dd')";
					}
				}
				
				if(checkBox_9.isSelected())
				{
					check++;
					
					if(check == 1)
					{
						query+="where INT_PUB_NO like '%"+textField_10.getText()+"%'";
					}
					
					else if(check>1)
					{
						query+=" and INT_PUB_NO like '%"+textField_10.getText()+"%'";
					}
				}
				
				if(checkBox_10.isSelected())
				{
					check++;
					
					if(check == 1)
					{
						query+="where PAT_OF_ADD_TO_APP_NO like '%"+textField_11.getText()+"%'";
					}
					
					else if(check>1)
					{
						query+=" and PAT_OF_ADD_TO_APP_NO like '%"+textField_11.getText()+"%'";
					}
				}
				
				if(checkBox_11.isSelected())
				{
					check++;
					
					java.sql.Date from_date = new java.sql.Date(dateChooser_8.getDate().getTime());
					java.sql.Date to_date = new java.sql.Date(dateChooser_9.getDate().getTime());
					
					
					if(check == 1)
					{
						query+="where POATAN_FILING_DATE between to_date('"+ from_date +"','yyyy-mm-dd') and to_date('"+ to_date +"','yyyy-mm-dd')";
					}
					
					else if(check>1)
					{
						query+=" and POATAN_FILING_DATE between to_date('"+ from_date +"','yyyy-mm-dd') and to_date('"+ to_date +"','yyyy-mm-dd')";
					}
				}
				
				if(checkBox_12.isSelected())
				{
					check++;
					
					if(check == 1)
					{
						query+="where DIV_TO_APP_NO like '%"+textField_13.getText()+"%'";
					}
					
					else if(check>1)
					{
						query+=" and DIV_TO_APP_NO like '%"+textField_13.getText()+"%'";
					}
				}
				
				if(checkBox_13.isSelected())
				{
					check++;
					
					java.sql.Date from_date = new java.sql.Date(dateChooser_10.getDate().getTime());
					java.sql.Date to_date = new java.sql.Date(dateChooser_11.getDate().getTime());
					
					
					if(check == 1)
					{
						query+="where DTAN_FILING_DATE between to_date('"+ from_date +"','yyyy-mm-dd') and to_date('"+ to_date +"','yyyy-mm-dd')";
					}
					
					else if(check>1)
					{
						query+=" and DTAN_FILING_DATE between to_date('"+ from_date +"','yyyy-mm-dd') and to_date('"+ to_date +"','yyyy-mm-dd')";
					}
				}
				
				try{
					Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
					String fquery = "select app_no,app_date,pub_date,title_of_invention,COALESCE(int_classification,'NA'),COALESCE(priority_doc_no,'NA'),COALESCE(cast(priority_date as char(10)),'NA'),COALESCE(name_of_priority_country,'NA'),COALESCE(int_app_no,'NA'),COALESCE(cast(ian_filing_date as char(10)),'NA'),COALESCE(int_pub_no,'NA'),COALESCE(pat_of_add_to_app_no,'NA'),COALESCE(cast(poatan_filing_date as char(10)),'NA'),COALESCE(div_to_app_no,'NA'),COALESCE(cast(dtan_filing_date as char(10)),'NA'),abstract,applicants,inventor from patents_data";
					rs = statement.executeQuery(fquery+query);					
					
					model.setRowCount(0);
					
					int count=0;
					
					while(rs.next())
					{
						model.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14),rs.getString(15),rs.getString(16),rs.getString(17),rs.getString(18)});
						count++;
					}
					
					JOptionPane.showMessageDialog(null, count+" results found!");
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
				btnNewButton_1.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						JFileChooser chooser = new JFileChooser();
						chooser.showSaveDialog(null);
						File f = chooser.getSelectedFile();
						String path = f.getAbsolutePath();
						try {
							File file = new File(path);
							FileWriter filewriter = new FileWriter(file);
							try {
								rs.beforeFirst();

							while(rs.next())
							{
								for(int i=1 ; i<17 ;i++)
								{
									filewriter.write("\""+rs.getString(i)+"\"");
									if(i<16)
										filewriter.write(",");
								}
								filewriter.write("\n");
							}
							}
							catch (SQLException e) {
								e.printStackTrace();
							}
							
							filewriter.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		
		
	}
}
