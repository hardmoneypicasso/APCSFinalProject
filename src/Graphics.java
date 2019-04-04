import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Graphics {
	
	//private instance data
	private static JFrame jf= new JFrame();
	private static int width= 1600;
	private static int height= 1600;
	private final static Color COMMIE= new Color(255, 0, 0);
	private final static Color BOURGOIS= new Color(51, 153, 255);
	private final static Color INDY= new Color(0, 255, 0);
private static JPanel pane= new JPanel();

	//-------------------------------
	//Graphics() constructor
	//
	//Pre-condition: none
	//post-condition: creates JFrame where the game will occur, and be edited further
	//
	//@param n/a	@return n/a
	//
	//BY: PETER WHITE
	//-------------------------------
	public static void setFrame() {
		jf.setSize(width, height);
		jf.setResizable(false);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.add(pane);
	}
	

	
	public static void setRed() {
		pane.setBackground(COMMIE);
	}
	
	public static void setBlue() {
		pane.setBackground(BOURGOIS);
	}
	
	public static void setGreen() {
		pane.setBackground(INDY);
	}
	
	
	
	
}
