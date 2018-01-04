package View;

import javax.swing.JFrame;

public class GUI {
	public static void main(String[] args){
		//Initialize the main frame
		frameScan scan = new frameScan();
		JFrame showScan = scan.getFrame();
		showScan.setVisible(true);
	}
}
