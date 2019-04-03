import java.util.Scanner;

import javax.swing.JFrame;

public class Graphics {
	
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
	public Graphics() {
		JFrame jf= new JFrame();
		jf.setSize(1600, 1600);
		jf.setResizable(false);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
	}
	
}
