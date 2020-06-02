

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import layout.TableLayout;

public class WindowJoc extends JFrame implements ActionListener {

	
	private static final long serialVersionUID = 1L;
	private JButton [][]button;
	private JButton newGame, end;
	private JLabel img;
	private JLabel player;
	private JLabel score;
	private JLabel scoreX;
	private JLabel score0;
	private Panel tableGame;
	private TableLayout tableLayout;
	private GridLayout gridLayout;
	private int number=0;
    private String actualPlayer="X";
	private int x=0;
	private int o=0;
    private String endPlayer;
    private JLabel labelPanel;
	
	public WindowJoc() {
		super();
		this.setSize(665, 550);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(400, 70);
		setupButton();
		this.setMaximumSize(new Dimension(665,550));
	}
	private void setupButton() {
		double [][] dim= {{10,150,	TableLayout.FILL,40,110,40},
				          {30,40,30,TableLayout.FILL,40,60,40,60,20,20,20,TableLayout.FILL,10}};
		tableLayout=new TableLayout(dim);
		this.setLayout(tableLayout);
		gridLayout=new GridLayout(3,3);
		tableGame=new Panel(gridLayout);
		//tableGame.setBackground(Color.blue);
		instantiereObject();
	
		
		
	}
	public void instantiereObject() {
		button=new JButton[3][3];
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				button[i][j]=new JButton("");
				button[i][j].addActionListener(this);
				button[i][j].setFont(new Font("Arial", Font.BOLD, 40));
				button[i][j].setBackground(Color.BLACK);
				button[i][j].setForeground(Color.WHITE);
			}
		}
		
		newGame=new JButton("New Game");
		newGame.setFont(new Font("Arial", Font.BOLD, 13));
		newGame.setBackground(Color.BLACK);
		newGame.setForeground(Color.WHITE);
		newGame.addActionListener(this);
		end=new JButton("Winner");
		end.setFont(new Font("Arial", Font.BOLD, 13));
		end.setBackground(Color.BLACK);
		end.setForeground(Color.WHITE);
		end.addActionListener(this);
		labelPanel=new JLabel("Castigator:  "+actualPlayer);
		labelPanel.setFont(new Font("Arial", Font.BOLD, 17));
		labelPanel.setForeground(Color.BLACK);
		labelPanel.setHorizontalAlignment(SwingConstants.CENTER);
		img=new JLabel();
		player=new JLabel("Actual player:   "+actualPlayer);
		player.setFont(new Font("Arial", Font.BOLD, 20));
		player.setForeground(Color.BLACK);
		score=new JLabel("Score:");
		scoreX=new JLabel("X:  "+x);
		score0=new JLabel("0:  "+o);
		score.setFont(new Font("Arial", Font.BOLD, 20));
		score.setForeground(Color.BLACK);
		scoreX.setFont(new Font("Arial", Font.BOLD, 20));
		scoreX.setForeground(Color.BLACK);
		score0.setFont(new Font("Arial", Font.BOLD, 20));
		score0.setForeground(Color.BLACK);
		this.add(img,"1,0,1,2");
		this.add(player,"2,1");
		this.add(tableGame,"1,3,2,11");
		this.add(newGame,"4,4");
		this.add(end,"4,6");
		this.add(score,"4,8");
		this.add(scoreX,"4,9");
		this.add(score0,"4,10");
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				tableGame.add(button[i][j]);
			}
		}
		
		player.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon icon=new ImageIcon(this.getClass().getResource("img\\p.jpg"));
		img.setIcon(icon);
		img.setHorizontalAlignment(SwingConstants.CENTER);
		
	}
	private void playerChange( String c) {
		if(c.equals("X")) {
			actualPlayer="O";
		}
		if(c.equals("O")) {
			actualPlayer="X";
		}
		player.setText("Actual player:   "+actualPlayer);
	}
	private void scor() {
		if(actualPlayer=="X") {
			x++;
			scoreX.setText("X:  "+x);
		}
		if(actualPlayer=="O") {
			o++;
			score0.setText("0:  "+o);
		}
	}
	private void newGame(){
		reset(0,5);
		actualPlayer="X";
		o=0;
		x=0;
		player.setText("Actual player:   "+actualPlayer);
		scoreX.setText("X:  "+x);
		score0.setText("O:  "+o);
	}
	private void result() {
		if(x>o) {
			labelPanel.setText("WINNER: X    SCOR: "+x+" : "+o);
			windowEnd();
		}else if(o>x){
			labelPanel.setText("WINNER: O    SCOR: "+x+" : "+o);
			windowEnd();
		}else {
			labelPanel.setText("REMIZA     SCOR: "+x+" : "+o);
			windowEnd();
		}
		newGame();
	}
	private void reset(int l,int n) {
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				button[i][j].setText("");
			}
		}
		if(n==0) {
			button[l][0].setBackground(Color.BLACK);
			button[l][0].setForeground(Color.WHITE);
			button[l][1].setBackground(Color.BLACK);
			button[l][1].setForeground(Color.WHITE);
			button[l][2].setBackground(Color.BLACK);
			button[l][2].setForeground(Color.WHITE);
		}else if(n==1) {
			button[0][l].setBackground(Color.BLACK);
			button[0][l].setForeground(Color.WHITE);
			button[1][l].setBackground(Color.BLACK);
			button[1][l].setForeground(Color.WHITE);
			button[2][l].setBackground(Color.BLACK);
			button[2][l].setForeground(Color.WHITE);
		}else if(n==2) {
			button[0][0].setBackground(Color.BLACK);
			button[0][0].setForeground(Color.WHITE);
			button[1][1].setBackground(Color.BLACK);
			button[1][1].setForeground(Color.WHITE);
			button[2][2].setBackground(Color.BLACK);
			button[2][2].setForeground(Color.WHITE);
		}else if(n==3) {
			button[2][0].setBackground(Color.BLACK);
			button[2][0].setForeground(Color.WHITE);
			button[1][1].setBackground(Color.BLACK);
			button[1][1].setForeground(Color.WHITE);
			button[0][2].setBackground(Color.BLACK);
			button[0][2].setForeground(Color.WHITE);
		}
		number=0;
	}
	private void winner(int nr) {
		boolean rem=true;
		if(nr>=5) {
			if((button[0][0].getText()==button[1][1].getText())&&(button[0][0].getText()==button[2][2].getText())&&(button[0][0].getText()!="")) {
				button[0][0].setBackground(Color.WHITE);
				button[0][0].setForeground(Color.BLACK);
				button[1][1].setBackground(Color.WHITE);
				button[1][1].setForeground(Color.BLACK);
				button[2][2].setBackground(Color.WHITE);
				button[2][2].setForeground(Color.BLACK);
				rem=false;
				scor();
				labelPanel.setText("Castigator:  "+actualPlayer);
				windowEnd();
				if(actualPlayer!=endPlayer) {
					playerChange(actualPlayer);
				}
				reset(0,2);
				
			}
			if((button[0][2].getText()==button[1][1].getText())&&(button[0][2].getText()==button[2][0].getText())&&(button[0][2].getText()!="")) {
				button[2][0].setBackground(Color.WHITE);
				button[2][0].setForeground(Color.BLACK);
				button[1][1].setBackground(Color.WHITE);
				button[1][1].setForeground(Color.BLACK);
				button[0][2].setBackground(Color.WHITE);
				button[0][2].setForeground(Color.BLACK);
				rem=false;
				scor();
				labelPanel.setText("Castigator:  "+actualPlayer);
				windowEnd();
				if(actualPlayer!=endPlayer) {
					playerChange(actualPlayer);
				}
				reset(0,3);
				
			}
			for(int i=0;i<3;i++) {
				if((button[i][0].getText()==button[i][1].getText())&&(button[i][0].getText()==button[i][2].getText())&&(button[i][0].getText()!="")) {
					button[i][0].setBackground(Color.WHITE);
					button[i][0].setForeground(Color.BLACK);
					button[i][1].setBackground(Color.WHITE);
					button[i][1].setForeground(Color.BLACK);
					button[i][2].setBackground(Color.WHITE);
					button[i][2].setForeground(Color.BLACK);
					rem=false;
					scor();
					labelPanel.setText("Castigator:  "+actualPlayer);
					windowEnd();
					if(actualPlayer!=endPlayer) {
						playerChange(actualPlayer);
					}
					reset(i,0);
					break;
				}
				if((button[0][i].getText()==button[1][i].getText())&&(button[0][i].getText()==button[2][i].getText())&&(button[0][i].getText()!="")) {
					button[0][i].setBackground(Color.WHITE);
					button[0][i].setForeground(Color.BLACK);
					button[1][i].setBackground(Color.WHITE);
					button[1][i].setForeground(Color.BLACK);
					button[2][i].setBackground(Color.WHITE);
					button[2][i].setForeground(Color.BLACK);
					rem=false;
					scor();
					labelPanel.setText("Castigator:  "+actualPlayer);
					windowEnd();
					if(actualPlayer!=endPlayer) {
						playerChange(actualPlayer);
					}
					reset(i,1);
					break;
				}
				
			}
	    	if((nr==9)&&(rem==true)) {
	    		labelPanel.setText("REMIZA");
	    		windowEnd();
		        reset(0,5);
		}
		}
	}
	private void windowEnd() {
		JOptionPane.showMessageDialog(this, 
		        labelPanel, 
		        "FELICITARI", 
		        JOptionPane.INFORMATION_MESSAGE,
		        new ImageIcon(this.getClass().getResource("img\\xand0.jpg")));
	}
	public void actionPerformed(ActionEvent e) {
		 
	    if(e.getActionCommand().equals("")) {
	    	for(int i=0;i<3;i++) {
				for(int j=0;j<3;j++) {   
					if(e.getSource().equals(button[i][j])) {
						button[i][j].setText(actualPlayer);
						break;
					}
				}
			}
	    	number++;
	    	if(number==1) {
				endPlayer=actualPlayer;
			}
		    winner(number);
			playerChange(actualPlayer);	
	    }
	    if(e.getSource().equals(newGame)) {
	    	newGame();
	    }
	    if(e.getSource().equals(end)) {
	    	result();
	    }
	   
	}
	public static void main(String[] args) {
		WindowJoc window=new WindowJoc();
		window.setVisible(true);
	}
	
}

