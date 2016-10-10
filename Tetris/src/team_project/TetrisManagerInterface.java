package team_project;

public interface TetrisManagerInterface {
	public void setFullBlockArray(BoardInterface setFullBlock);	// 9번 시나리오.  Board로부터 받아온 값을 토대로 Board 상태를 바꾸기 위한 연산을 한다.
	public TetrisManagerInterface getArrayLineErase();	// 10번 시나리오. Board 상태를 바꾸기 위해 연산한 값을 반환하여 Board로 보낸다.
	public void setVerticalLimitOver(BoardInterface setVerticalLimit);	// 12번 시나리오. Board로부터 받아온 값을 토대로 Board 상태를 바꾸기 위한 연산을 한다.
	public TetrisManagerInterface getGameOver();	// 13번 시나리오. User에게 GameOver가 되었음을 알리는 값을 반환한다.
	
}
