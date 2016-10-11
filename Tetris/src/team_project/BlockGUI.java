package team_project;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.RenderingHints.Key;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class BlockGUI extends JPanel implements BlockGUIInterface{
	// commit push Test
	enum Tetro{
		Z_Shape(0),
		S_Shape(1),
		I_Shape(2),
		T_Shape(3),
		O_Shape(4),
		L_Shape(5),
		J_Shape(6);
		
		private int num;
		Tetro(int num) {
			this.num = num;
		}
		public int getNum() {
			return num;
		}
	}
	
	int BLockSize = 10; // ��� ũ���Ӵ�

	// ������ (40, 40)
	int x = 20;
	int y = 20;

	// ���������� ���� �簢�� ��ǥ�� ���� ����
	int linex;
	int liney;
	
	int tetrominoes[][][] =
			{
				{ { -1,  0 }, { -1,  1 }, {  0, -1 }, { 0,  0 } }, // Z-Shape
				{ { -1, -1 }, { -1,  0 }, {  0,  0 }, { 0,  1 } }, // S-Shape
				{ {  0, -1 }, {  0,  0 }, {  0,  1 }, { 0,  2 } }, // I-Shape
				{ { -1,  0 }, {  0,  0 }, {  1,  0 }, { 0,  1 } }, // T-Shape
				{ { -1, -1 }, { -1,  0 }, {  0, -1 }, { 0,  0 } }, // O-Shape
				{ { -1, -2 }, { -1, -1 }, { -1,  0 }, { 0,  0 } }, // L-Shape
				{ { -1,  0 }, {  0,  0 }, {  0, -1 }, { 0, -2 } }  // J-Shape
			};
	
	BlockGUI(){
	       setFocusable(true);
	       addKeyListener(new MykeyListener());
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
			x = 20;
			
			g.setColor(new Color(128, 128, 128));
			g.fillRect(0, 0, 600, 300);

			for (int i = 0; i < 4; i++) {
				
				// ��Ʈ�ι̳뽺 �׸���
				linex = tetrominoes[Tetro.Z_Shape.getNum()][i][0] * BLockSize;
				liney = tetrominoes[Tetro.Z_Shape.getNum()][i][1] * BLockSize;
				
				g.setColor(Color.RED);
				g.fillRect(x + linex, y + liney, BLockSize, BLockSize);
				
				// ������ �׸���
				g.setColor(Color.BLACK);
				g.drawLine(x + linex + BLockSize, y + liney, x + linex + BLockSize, y + liney + BLockSize);
				g.drawLine(x + linex, y + liney + BLockSize, x + linex + BLockSize, y + liney + BLockSize);
				g.setColor(Color.WHITE);
				g.drawLine(x + linex, y + liney, x + linex + BLockSize, y + liney);
				g.drawLine(x + linex, y + liney, x + linex, y + liney + BLockSize);

			}
			

			x += 5*BLockSize;
			for (int i = 0; i < 4; i++) {
				
				// ��Ʈ�ι̳뽺 �׸���
				linex = tetrominoes[Tetro.S_Shape.getNum()][i][0] * BLockSize;
				liney = tetrominoes[Tetro.S_Shape.getNum()][i][1] * BLockSize;
				
				g.setColor(new Color(255, 127, 0));
				g.fillRect(x + linex, y + liney, BLockSize, BLockSize);
				
				// ������ �׸���
				g.setColor(Color.BLACK);
				g.drawLine(x + linex + BLockSize, y + liney, x + linex + BLockSize, y + liney + BLockSize);
				g.drawLine(x + linex, y + liney + BLockSize, x + linex + BLockSize, y + liney + BLockSize);
				g.setColor(Color.WHITE);
				g.drawLine(x + linex, y + liney, x + linex + BLockSize, y + liney);
				g.drawLine(x + linex, y + liney, x + linex, y + liney + BLockSize);

			}
			x += 5*BLockSize;
			for (int i = 0; i < 4; i++) {
				
				// ��Ʈ�ι̳뽺 �׸���
				linex = tetrominoes[Tetro.I_Shape.getNum()][i][0] * BLockSize;
				liney = tetrominoes[Tetro.I_Shape.getNum()][i][1] * BLockSize;
				
				g.setColor(Color.YELLOW);
				g.fillRect(x + linex, y + liney, BLockSize, BLockSize);
				
				// ������ �׸���
				g.setColor(Color.BLACK);
				g.drawLine(x + linex + BLockSize, y + liney, x + linex + BLockSize, y + liney + BLockSize);
				g.drawLine(x + linex, y + liney + BLockSize, x + linex + BLockSize, y + liney + BLockSize);
				g.setColor(Color.WHITE);
				g.drawLine(x + linex, y + liney, x + linex + BLockSize, y + liney);
				g.drawLine(x + linex, y + liney, x + linex, y + liney + BLockSize);

			}
			x += 5*BLockSize;
			for (int i = 0; i < 4; i++) {
				
				// ��Ʈ�ι̳뽺 �׸���
				linex = tetrominoes[Tetro.T_Shape.getNum()][i][0] * BLockSize;
				liney = tetrominoes[Tetro.T_Shape.getNum()][i][1] * BLockSize;
				
				g.setColor(Color.GREEN);
				g.fillRect(x + linex, y + liney, BLockSize, BLockSize);
				
				// ������ �׸���
				g.setColor(Color.BLACK);
				g.drawLine(x + linex + BLockSize, y + liney, x + linex + BLockSize, y + liney + BLockSize);
				g.drawLine(x + linex, y + liney + BLockSize, x + linex + BLockSize, y + liney + BLockSize);
				g.setColor(Color.WHITE);
				g.drawLine(x + linex, y + liney, x + linex + BLockSize, y + liney);
				g.drawLine(x + linex, y + liney, x + linex, y + liney + BLockSize);

			}
			x += 5*BLockSize;
			for (int i = 0; i < 4; i++) {
				
				// ��Ʈ�ι̳뽺 �׸���
				linex = tetrominoes[Tetro.O_Shape.getNum()][i][0] * BLockSize;
				liney = tetrominoes[Tetro.O_Shape.getNum()][i][1] * BLockSize;
				
				g.setColor(Color.BLUE);
				g.fillRect(x + linex, y + liney, BLockSize, BLockSize);
				
				// ������ �׸���
				g.setColor(Color.BLACK);
				g.drawLine(x + linex + BLockSize, y + liney, x + linex + BLockSize, y + liney + BLockSize);
				g.drawLine(x + linex, y + liney + BLockSize, x + linex + BLockSize, y + liney + BLockSize);
				g.setColor(Color.WHITE);
				g.drawLine(x + linex, y + liney, x + linex + BLockSize, y + liney);
				g.drawLine(x + linex, y + liney, x + linex, y + liney + BLockSize);

			}
			x += 5*BLockSize;
			for (int i = 0; i < 4; i++) {
				
				// ��Ʈ�ι̳뽺 �׸���
				linex = tetrominoes[Tetro.L_Shape.getNum()][i][0] * BLockSize;
				liney = tetrominoes[Tetro.L_Shape.getNum()][i][1] * BLockSize;
				
				g.setColor(new Color(8, 11, 84));
				g.fillRect(x + linex, y + liney, BLockSize, BLockSize);
				
				// ������ �׸���
				g.setColor(Color.BLACK);
				g.drawLine(x + linex + BLockSize, y + liney, x + linex + BLockSize, y + liney + BLockSize);
				g.drawLine(x + linex, y + liney + BLockSize, x + linex + BLockSize, y + liney + BLockSize);
				g.setColor(Color.WHITE);
				g.drawLine(x + linex, y + liney, x + linex + BLockSize, y + liney);
				g.drawLine(x + linex, y + liney, x + linex, y + liney + BLockSize);

			}
			x += 5*BLockSize;
			for (int i = 0; i < 4; i++) {
				
				// ��Ʈ�ι̳뽺 �׸���
				linex = tetrominoes[Tetro.J_Shape.getNum()][i][0] * BLockSize;
				liney = tetrominoes[Tetro.J_Shape.getNum()][i][1] * BLockSize;
				
				g.setColor(new Color(128, 0, 255));
				g.fillRect(x + linex, y + liney, BLockSize, BLockSize);
				
				// ������ �׸���
				g.setColor(Color.BLACK);
				g.drawLine(x + linex + BLockSize, y + liney, x + linex + BLockSize, y + liney + BLockSize);
				g.drawLine(x + linex, y + liney + BLockSize, x + linex + BLockSize, y + liney + BLockSize);
				g.setColor(Color.WHITE);
				g.drawLine(x + linex, y + liney, x + linex + BLockSize, y + liney);
				g.drawLine(x + linex, y + liney, x + linex, y + liney + BLockSize);

			}
	}
	
	

	public void dropDown() {
		// TODO Auto-generated method stub
		if(y < 200)
				y += BLockSize;
	}	// 1�� ������


	public void setMoveDirection(UserInterface directionInput) {
		// TODO Auto-generated method stub
		
		System.out.println(directionInput.getKeyPressed());
		/*
		 if(directionInput.getKeyPressed() == KeyEvent.VK_UP){
		 
		 }
		 else if(directionInput.getKeyPressed() == KeyEvent.VK_UP){
		 
		 }
		 */
	} // �Է¹��� Ű�� ���� �̵� üũ(���ϰ� Ȯ��)

	public void setRotation(UserInterface rotationInput) {
		// TODO Auto-generated method stub
		for(int i = 0 ; i < 7; i++){
			for(int j = 0 ; j < 4; j++){
				int temp = tetrominoes[i][j][0];
				tetrominoes[i][j][0] = -1 * tetrominoes[i][j][1];
				tetrominoes[i][j][1] = temp;
			}
		}
	} // ����� ��� ȸ����Ŵ

	public int[][] getBlock() {
		// TODO Auto-generated method stub
		int[][] xy = tetrominoes[0];	// ������ ��Ʈ�γ�̽� ��� ����
		if(x > 0|y > 0)	// ���� �����ؾ���
			return xy;
		else
			return null;
	}
	
	public static void main(String[] args) {
		JFrame j = new JFrame();
		
		j.add(new BlockGUI());
		
		j.setSize(600, 300);
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j.setVisible(true);
	}
	//Test�� Key �Է�
	class MykeyListener implements KeyListener{
		
		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			
			if(e.getKeyCode() == KeyEvent.VK_UP){
				UserInterface u = new UserInterface() {
					
					@Override
					public void showGameOver(TetrisManagerInterface tm) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void setBlock(BoardInterface currentBlock) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public UserInterface getKeyPressed() {
						// TODO Auto-generated method stub
						return null;
					}
				};
				setRotation(u.getKeyPressed());
				
			}
			else if(e.getKeyCode() == KeyEvent.VK_DOWN){
				dropDown();
				System.out.println("���");
			}
			else if(e.getKeyCode() == KeyEvent.VK_R){
				y = 20;	// reset
			}
			repaint();
		}
		
		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

	}
}