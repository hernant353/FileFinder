package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSplitPane;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JTable;

import Model.UserFile;
import javax.swing.SwingConstants;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.ArrayList;
import java.util.Calendar;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

import java.util.Scanner;




public class frameScan {

	private JFrame frame;
	private JTable tableFiles;
	List<String> selectedType = new ArrayList<String>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frameScan window = new frameScan();
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
	public frameScan() {
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
		//Scan
		JButton btnScan = new JButton("Scan");
		//do nothing
		/*
		btnScan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				frameScan scan = new frameScan();
				JFrame showScan = scan.getFrame();
				showScan.setVisible(true);
				frame.setVisible(false);				
				
			}
		});
		*/
		
		btnScan.setBounds(0, 0, 115, 29);
		frame.getContentPane().add(btnScan);
		
		//Options
		JButton btnOptn = new JButton("Options");
		btnOptn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frameOptn options = new frameOptn();
				JFrame showOptions = options.getFrame();
				showOptions.setVisible(true);
				frame.setVisible(false);
				
			}
		});
		btnOptn.setBounds(121, 0, 115, 29);
		frame.getContentPane().add(btnOptn);
		
		//History
		JButton btnHist = new JButton("History");
		btnHist.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frameHist history = new frameHist();
				JFrame showHist = history.getFrame();
				showHist.setVisible(true);
				frame.setVisible(false);
			}
			
		});
		btnHist.setBounds(241, 0, 115, 29);
		frame.getContentPane().add(btnHist);
		
		//About
		JButton btnAbout = new JButton("About");
		btnAbout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frameAbout about = new frameAbout();
				JFrame showAbout = about.getFrame();
				showAbout.setVisible(true);
				frame.setVisible(false);
			}
		});
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
		cbType.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if (cbType.getSelectedIndex()==4) {
					selectedType.add( JOptionPane.showInputDialog("Please type file extention to look for: "));
					
					System.out.println(selectedType.get(0));
					//System.out.println(selectedType.get(1));
					
				}
				else {
				int typeIndex = cbType.getSelectedIndex();
				selectedType.add ( typeStrings[typeIndex]);
				//Debug test
				System.out.println(selectedType.get(0));
				}
			}
		});
		
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
		
		
		//fuck
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
	//Getter
			public JFrame getFrame() {
				return this.frame;
			}
			
}
