package team_project;

public interface UserInterface {
	public UserInterface getKeyPressed();	// UML상 2번 시나리오. Block클래스에 입력한 key값을 보낸다. keyPressed(KeyEvent e)이용할 것 
	public void setBlock(BoardInterface currentBlock);	// UML상 1번, 7번 시나리오. Board 클래스로부터 블록값을 받아온다.
	public void showGameOver(TetrisManagerInterface tm);	// UML상 13번 시나리오. 이 메소드가 호출되면 '해당 유저'의 테트리스는 종료된다.
}
