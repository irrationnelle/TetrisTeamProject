package team_project;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class BoardByHS extends JFrame implements BoardInterface {
	public final int WIDTH = 10;
	public final int HEIGHT = 22;
	public final int SQUARE_SIZE = 25;
	private Block block = new Block();
	private BlockGUIbyHS b = new BlockGUIbyHS();
	
	public BoardByHS() {
		block.setShape(Tetrominoes.NoShape);
		
		add(b);
		
		setTitle("Tetris");
		setSize(26*12+26, 26*23+50);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	@Override
	public void clearBoard() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isGameOver() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isWall() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCollideAt() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void stackUpBlock() {
		// TODO Auto-generated method stub

	}

	@Override
	public Tetrominoes shapeAt(int currentX, int currentY) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void main(String[] args) {
		BoardByHS b = new BoardByHS();
	}
}
