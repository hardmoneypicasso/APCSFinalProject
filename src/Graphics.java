import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.geom.Line2D;

import javax.sound.sampled.Line;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Graphics {

	private final static int height= 1600;
	private final static int width= 1600;
	private final static int rows= 10;
	private static JFrame jf= new JFrame();
	private static Container frame= new Container();
	private static Color commie= Color.RED;
	private static Color cappie= Color.BLUE;
	private static Color indy= Color.GREEN;
	private static Color back= Color.BLACK;
	private static int[][] arr= new int[rows][rows];
	
	//--------------------------------
	//--------------------------------
	public static void createFrame() {
		jf.setSize(height, width);
		jf.setVisible(true);
		jf.setResizable(false);
		jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
	}
	
	//--------------------------------
	//--------------------------------
	public static void createContainer() {
		frame= jf.getContentPane();
		frame.setLayout(new GridLayout(rows, rows, 2, 2));
	}
	
	//--------------------------------
	//--------------------------------
	public static void createGrid() {
		double random;
		for(int i= 0; i< rows; i++) {
			for(int j= 0; j< rows; j++) {
				if(i<2 && j<2) {
					arr[i][j]= 1;
				}else {
					random= Math.random()*100;
					if(random<= 5) {
						arr[i][j]= 0;
					}else {
						arr[i][j]= -1;
					}
				}
			}
		}
	}
	
	//--------------------------------
	//--------------------------------
	public static int[][] getArray() {
		return arr;
	}
	
	//--------------------------------
	//--------------------------------
	public static int getArraySpot(int i, int j){
		return arr[i][j];
	}
	
	//--------------------------------
	//--------------------------------
	public static void fillGrid() {
		Color temp;
		for(int i= 0; i< rows; i++) {
			for(int j= 0; j< rows; j++) {
				JPanel panel= new JPanel();
				if(arr[i][j]== 1) {
					temp= commie;
				}else if(arr[i][j]== -1) {
					temp= cappie;
				}else {
					temp= indy;
				}
				panel.setBackground(temp);
				frame.add(panel);
			}
		}
	}
}