package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSplitPane;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JTable;

import Model.UserFile;
import javax.swing.SwingConstants;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import java.util.Date;
import java.util.Properties;
import java.util.Calendar;


public class frame1 {

	private JFrame frame;
	private JTable tableFiles;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame1 window = new frame1();
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
	public frame1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//Create main frame
		frame = new JFrame("FileFinder");
		//set frame size
		frame.setBounds(100, 100, 500, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//main Buttons
		JButton btnScan = new JButton("Scan");
		btnScan.setBounds(0, 0, 115, 29);
		frame.getContentPane().add(btnScan);
		
		JButton btnOptn = new JButton("Options");
		btnOptn.setBounds(121, 0, 115, 29);
		frame.getContentPane().add(btnOptn);
		
		JButton btnHist = new JButton("History");
		btnHist.setBounds(241, 0, 115, 29);
		frame.getContentPane().add(btnHist);
		
		JButton btnAbout = new JButton("About");
		btnAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAbout.setBounds(361, 0, 116, 29);
		frame.getContentPane().add(btnAbout);
		
		//dropDown boxes, set type and driver + DatePicker
		
		//Labels
		JLabel lblType_1 = new JLabel("Type");
		lblType_1.setBounds(60, 30, 100, 20);
		frame.getContentPane().add(lblType_1);
		
		JLabel lblDir = new JLabel("Directories");
		lblDir.setBounds(60, 66, 100, 20);
		frame.getContentPane().add(lblDir);
		
		JLabel lblDate = new JLabel("Set date");
		lblDate.setBounds(60, 102, 100, 20);
		frame.getContentPane().add(lblDate);
		
		//Types 
		String[] typeStrings = {"All", "Books", "Images", "Software", "Others"};
		JComboBox cbType = new JComboBox(typeStrings);
		cbType.setSelectedIndex(0);
		//cbType.addActionListener(this);
		cbType.setBounds(160, 30, 115, 26);
		frame.getContentPane().add(cbType);
		
		//Directory
		String[] directories = {"All", "C", "D", "Specify"};
		JComboBox cbDir = new JComboBox(directories);
		cbDir.setBounds(160, 66, 115, 26);
		cbDir.setSelectedIndex(0);
		frame.getContentPane().add(cbDir);
		
		//Date picker
		UtilDateModel model = new UtilDateModel();
		//Set and show initial date
		model.setDate(2015, 8, 24);
		model.setSelected(true);
		//Need this...
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, null);
		datePicker.setBounds(160, 102, 115, 26);
		frame.getContentPane().add(datePicker);
		
		//Table showing files found
		String[] columnNames = {"Name", "Location", "Type", "Size", "Last Date Modified"};
		Object[][] files = {}; 
		tableFiles = new JTable(files, columnNames);
		tableFiles.setBounds(15, 144, 350, 410);
		frame.getContentPane().add(tableFiles);
		tableFiles.setFillsViewportHeight(true);
		
		
		
		//Create scrollpane
		//Insert table to scrollpane
		JScrollPane scrollPane1 = new JScrollPane(tableFiles);
		scrollPane1.setBounds(15, 144, 350, 410);
		frame.getContentPane().add(scrollPane1);
		//frame.getContentPane().add(scrollPane1);
		
		//Remove files buttons
		JButton btnRemoveAll = new JButton("Remove all");
		btnRemoveAll.setBounds(380, 230, 100, 65);
		frame.getContentPane().add(btnRemoveAll);
		
		JButton btnRemoveSelected = new JButton("Remove selected files");
		btnRemoveSelected.setBounds(380, 311, 100, 65);
		frame.getContentPane().add(btnRemoveSelected);
		
		
	}
}
