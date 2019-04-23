import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.geom.Line2D;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
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
					button.addActionListener((ActionEvent e) -> {
						try {
							comButtonPressed(button);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					});
				}else if(arr[i][j]== -1) {
					temp= cappie;
					button= new StateButton(Country.capitalist);
					button.addActionListener((ActionEvent e) -> {
						try {
							capButtonPressed(button);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					});
				}else {
					temp= indy;
					button= new StateButton(Country.independent);
					button.addActionListener((ActionEvent e) -> {
						try {
							indButtonPressed(button);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					});
				}
				button.setBackground(temp);
				panel.add(button);
			}
		}
		OtherTeam.setInitial();
	}

	private static void comButtonPressed(JButton button) throws IOException {
		((ComsTeam) button).pressed();
		turnCount(button);
		((ComsTeam) button).victoryState();
	}
	
	private static void capButtonPressed(JButton button) throws IOException {
		((CapsTeam) button).pressed();
		turnCount(button);
		((ComsTeam) button).victoryState();
	}
	
	private static void indButtonPressed(JButton button) throws IOException {
		((StateButton) button).pressed(button);
		turnCount(button);
		((ComsTeam) button).victoryState();
	}
	
//------------------------------------------------------------------------------------------------------------------	
	static int turnCount= 0;
	
	public static int turnCount(JButton button) {
		turnCount++;
		return turnCount;
	}
	
	private static Image image;
	
	public static void War() throws IOException {
		jf.remove(panel);
		image= (ImageIO.read(new File("War.png")));
	}
	
	public static void Peace() throws IOException {
		jf.remove(panel);
		image= (ImageIO.read(new File("Peace.png")));
	}
	
	public static void Loss() throws IOException {
		jf.remove(panel);
		image= (ImageIO.read(new File("Loss.png")));
	}
	
	
	
}