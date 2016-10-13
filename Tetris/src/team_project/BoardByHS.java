package team_project;

public class BoardByHS implements BoardInterface {
	Block block = new Block();
	
	public BoardByHS() {
		// TODO Auto-generated constructor stub
		block.setShape(Tetrominoes.NoShape);
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

}
