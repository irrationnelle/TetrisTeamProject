package team_project;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.RenderingHints.Key;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class BlockGUIbyHS extends JPanel implements KeyListener{
	Block block = null;
	int[][] drawPiece;
	int lineX;
	int lineY;
	User u;
	
	public BlockGUIbyHS() {
		block = new Block();
		drawPiece = new int[4][2];
		u = new User();
		
		block.RandomShape();
		drawPiece = block.getCurrentBlock();
		
		addKeyListener(this);
		
		setFocusable(true);
	}
	
	public void drawPiece(Graphics g) {
		for (int i = 0; i < 4; i++) {
			// 테트로미노스 그리기
			lineX = drawPiece[i][0] * 25;
			lineY = drawPiece[i][1] * 25;
			
			g.setColor(block.getPieceColor());
			g.fillRect(lineX, lineY, 25, 25);
			
			// 윤곽선 그리기
			g.setColor(Color.WHITE);
			g.drawLine(lineX + 25, lineY, lineX + 25, lineY + 25);
			g.drawLine(lineX, lineY + 25, lineX + 25, lineY + 25);
			g.drawLine(lineX, lineY, lineX + 25, lineY);
			g.drawLine(lineX, lineY, lineX, lineY + 25);
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		
		g.fillRect(0, 0, 26*12, 26*23);
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 23; j++) {
				g.setColor(Color.WHITE);
				g.fillRect(26*i, 26*j, 25, 25);
			}
		}
		
		drawPiece(g);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		switch(e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			block.setMoveDirection(u);
			break;
		case KeyEvent.VK_RIGHT:
			block.setMoveDirection(u);
			break;
		case KeyEvent.VK_UP:
//			block.setRotation(u);
			block = block.rotation();
			break;
		case KeyEvent.VK_DOWN:
			block.dropDown();
			break;
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
