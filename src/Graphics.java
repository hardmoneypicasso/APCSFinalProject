import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.geom.Line2D;

import javax.sound.sampled.Line;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Graphics {

	private final static int height= 1600;
	private final static int width= 1600;
	private final static int size= 160;
	private final static int rows= 10;
	private static JFrame jf= new JFrame();
	private static JPanel panel= new JPanel();
	private static Color commie= Color.RED;
	private static Color cappie= Color.BLUE;
	private static Color indy= Color.GREEN;
	private static Color back= Color.BLACK;
	private static int[][] arr= new int[rows][rows];
	
	//--------------------------------
	//--------------------------------
	public static void createFrame() {
		jf.setSize(width, height);
		jf.setVisible(true);
		jf.setResizable(true);
		jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
		jf.setLayout(new GridLayout(0,1));
		jf.add(panel);
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
		panel.setLayout(new GridLayout(rows, rows));
		for(int i= 0; i< rows; i++) {
			for(int j= 0; j< rows; j++) {
				JButton button;
				if(arr[i][j]== 1) {
					temp= commie;
					button= new ComsTeam(Country.communist);
					button.addActionListener((ActionEvent e) -> comButtonPressed(button));
				}else if(arr[i][j]== -1) {
					temp= cappie;
					button= new StateButton(Country.capitalist);
					button.addActionListener((ActionEvent e) -> capButtonPressed(button));
				}else {
					temp= indy;
					button= new StateButton(Country.independent);
					button.addActionListener((ActionEvent e) -> indButtonPressed(button));
				}
				button.setBackground(temp);
				panel.add(button);
			}
		}
	}

	private static void comButtonPressed(JButton button) {
		((ComsTeam) button).pressed();
	}
	
	private static void capButtonPressed(JButton button) {
		((CapsTeam) button).pressed();
	}
	
	private static void indButtonPressed(JButton button) {
		((OtherTeam) button).pressed();
	}
}