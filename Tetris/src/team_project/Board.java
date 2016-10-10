package team_project;

import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class Board extends JFrame implements BoardInterface, ActionListener {
	private static final int Y_COORDINATE_INDEX = 1;
	private static final int X_COORDINATE_INDEX = 0;
	private static final int BOARD_SPATIAL_DIMENSION = 2;
	private static final int TOTAL_NUMBER_OF_BLOCK_COODINATES = 4;
	public static final int boardWidth = 10;
	public static final int boardHeight = 22;
	private Tetrimino[][] tetriminoes = new Tetrimino[boardHeight][boardWidth];

	public Board() {
		setFocusable(true);
		/* 보드 초기화 */
		this.initBoard(boardHeight, boardWidth);
	}

	private void initBoard(int height, int width) {
		for (int row = 0; row < height; row++) {
			for (int col = 0; col < width; col++) {
				this.setTetrimino(row, col, Tetrimino.NoShape);
			}
		}
	}

	private void setTetrimino(int row, int col, Tetrimino tetrimino) {
		this.tetriminoes[row][col] = tetrimino;
	}

	@Override
	public void lineDown() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setBlockPosition(BlockInterface blockPosition) {
		int[][] coordinates = blockPosition.getBlock();
		for (int i = 0; i < TOTAL_NUMBER_OF_BLOCK_COODINATES; i++) {
			// FIXME unknown
			int xCoordinate = coordinates[i][X_COORDINATE_INDEX];
			int yCoordinate = coordinates[i][Y_COORDINATE_INDEX];
			this.tetriminoes[xCoordinate][yCoordinate] = Tetrimino.UNKNOWN;
			// FIXME after solving issue above, replace code with below..
			// this.tetriminoes[xCoordinate][yCoordinate] =
			// blockPosition.getBlockType();
		}
	}

	@Override
	public void setBlockStack(BlockInterface blockPosition) {
		// TODO Auto-generated method stub

	}

	@Override
	public BoardInterface getFullBlock() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setBreakBlock(TetrisManagerInterface tm) {
		// TODO Auto-generated method stub

	}

	@Override
	public BoardInterface getVerticalLimitOver() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

}
