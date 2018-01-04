package View;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

public class frameHist {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frameHist window = new frameHist();
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
	public frameHist() {
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
		btnScan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frameScan scan = new frameScan();
				JFrame showScan = scan.getFrame();
				showScan.setVisible(true);
				frame.setVisible(false);				
				
			}
		});
		
		
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
		//do nothing
				/*
		btnHist.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frameHist history = new frameHist();
				JFrame showHist = history.getFrame();
				showHist.setVisible(true);
				frame.setVisible(false);
			}
			
		});
		*/
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
							    	
	}
	//Getter
	public JFrame getFrame() {
		return this.frame;
	}

}
