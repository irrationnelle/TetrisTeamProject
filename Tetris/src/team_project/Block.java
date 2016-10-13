package team_project;

import java.util.Random;

public class Block implements BlockInterface {
	private Tetrominoes pieceShape;	//enum���� ����� ��Ʈ���� �ǽ�
	private int[][] currentBlock;	//���� Ŭ�������� ����� ��Ʈ���� �ǽ��� �޾ƿ´�.
	private User user1 = new User();
	
	public Block() {
		currentBlock = new int[4][2];
	}
	
	public void setShape(Tetrominoes shape) {
		for(int i= 0; i<4; i++) {
			for(int j = 0; j<2; ++j) {
				currentBlock[i][j] = shape.coords[i][j];
			}
		}
		//���� �ǽ��� �Ӽ� ������ ������ �ִ� Tetrominoes ��ȯ. e.g. ���� �ǽ��� ������ TShape.
		pieceShape = shape;
	}
	
	//  
	void RandomShape() {
		Random r = new Random();
		int x = Math.abs(r.nextInt()) % 6 + 1;	// enum���� ����� ��Ʈ���� �ǽ� �� �ϳ��� ������ ����
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
    
    public 
		
	@Override
	public void dropDown() {
		// TODO Auto-generated method stub
		new Thread() {
			@Override public void run() {
				while (true) {
					try {
						Thread.sleep(1000);
						for(int i=0; i<currentBlock.length; i++) {
							currentBlock[rotation][i][1] += 1;
							down = currentBlock[rotation][i][1]; 
						}
//						repaint();
					} catch ( InterruptedException e ) {}
				}
			}

		}.start();
		

	}

	@Override
	public void setMoveDirection(UserInterface directionInput) {
		// TODO Auto-generated method stub
		if(user1.leftInput == 37) {
			left++;
		} else if(user1.rightInput == 39) {
			right++;
		}
	}

	@Override
	public void setRotation(UserInterface rotationInput) {
		for (int i = 0; i < 4; i++) {
			int temp = currentBlock[i][0];
			currentBlock[i][0] = -1 * currentBlock[i][1];
			currentBlock[i][1] = temp;
		}
	}

	@Override
	public int[][] getBlock() {
		// TODO Auto-generated method stub
		return null;
	}

}
