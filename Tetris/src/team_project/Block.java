package team_project;

import java.awt.Color;
import java.util.Random;

public class Block implements BlockInterface {
	private Tetrominoes pieceShape;	//enum으로 선언된 테트리스 피스
	private int[][] currentBlock;	//현재 클래스에서 사용할 테트리스 피스를 받아온다.
	private Color pieceColor;
	
	public Block() {
		currentBlock = new int[4][2];
	}
	
	public void setShape(Tetrominoes shape) {
		for(int i= 0; i<4; i++) {
			for(int j = 0; j<2; ++j) {
				currentBlock[i][j] = shape.coords[i][j];
			}
		}
		setPieceColor(shape.color);
		
		//현재 피스의 속성 정보를 가지고 있는 Tetrominoes 반환. e.g. 현재 피스의 정보는 TShape.
		pieceShape = shape;
	}
	
	//  
	void RandomShape() {
		Random r = new Random();
		int x = Math.abs(r.nextInt()) % 6 + 1;	// enum으로 선언된 테트리스 피스 중 하나를 무작위 선택
		Tetrominoes[] values = Tetrominoes.values();
		setShape(values[x]);
	}
	
	public int[][] getCurrentBlock() {
		return currentBlock;
	}
	
	public int minX()
    {
      int m = currentBlock[0][0];
      for (int i=0; i < 4; i++) {
          m = Math.min(m, currentBlock[i][0]);
      }
      return m;
    }


    public int minY() 
    {
      int m = currentBlock[0][1];
      for (int i=0; i < 4; i++) {
          m = Math.min(m, currentBlock[i][1]);
      }
      return m;
    }
    
	public int maxX()
    {
      int m = currentBlock[0][0];
      for (int i=0; i < 4; i++) {
          m = Math.max(m, currentBlock[i][0]);
      }
      return m;
    }


    public int maxY() 
    {
      int m = currentBlock[0][1];
      for (int i=0; i < 4; i++) {
          m = Math.max(m, currentBlock[i][1]);
      }
      return m;
    }
    
	@Override
	public void dropDown() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 4; i++) {
			currentBlock[i][1] += 1;
		}
	}

	@Override
	public void setMoveDirection(UserInterface directionInput) {
		for (int i = 0; i < 4; i++) {
			currentBlock[i][0] += 1;
		}
	}

	@Override
	public void setRotation(UserInterface rotationInput) {
		if(pieceShape != Tetrominoes.OShape) {
			for (int i = 0; i < 4; i++) {
				int temp = currentBlock[i][0];
				currentBlock[i][0] = -1 * currentBlock[i][1];
				currentBlock[i][1] = temp;
			}
		}
	}
	
	public Block rotation() {
		Block block = new Block();
		block.pieceShape = pieceShape;
		if(pieceShape != Tetrominoes.OShape) {
			for (int i = 0; i < 4; i++) {
				int temp = this.currentBlock[i][0];
				block.currentBlock[i][0] = -1 * this.currentBlock[i][1];
				block.currentBlock[i][1] = temp;
			}
		} else if(pieceShape == Tetrominoes.OShape) {
			return this;
		}
		return block;
	}

	@Override
	public int[][] getBlock() {
		// TODO Auto-generated method stub
		return null;
	}

	public Color getPieceColor() {
		return pieceColor;
	}

	public void setPieceColor(Color pieceColor) {
		this.pieceColor = pieceColor;
	}

}
