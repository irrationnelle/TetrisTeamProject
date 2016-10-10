package team_project;

public interface BlockInterface {
	/*
	 * Tetrominoes라 불리우는 블록 형태 정보는
	 * x,y축을 가진 값을 정보로 하기 때문에 int[][]대신 Point 클래스를 사용하여 Point[][]로 나타내도 됨.
	 * 블록 형태 정보는 절대로 변하지 않는 값이기 때문에 상수값을 가지기 때문에, 인터페이스 상에서 구현해도 되지만
	 * 블록형태 정보는 상수 클래스인 Enum을 이용하여 구현하는 것을 추천.
	 * 블록 형태로는 각각 I,O,T,J,L,S,Z 모양이 있으며 구현 예시는 아래와 같음.
	 * 예시이므로 실제 구현 시에는 적절한  x,y 초기값을 가져야 함.
	 * int[][] IBlock = new int[][] { {0,0}, {0,0}, {0,0}, {0,0} };
	 * 위와 같은 형태로 int[][] IBlock, OBlock, TBlock, ..., ZBlock으로 총 7개의 블록 형태 정보가 필요.
	 */
	
	public void dropDown();	// UML상 5번 시나리오. 블록의 현재 위치의 y값을 바꿔서 스스로 떨어짐.
	public void setMoveDirection(UserInterface directionInput);	// UML상 2번 시나리오. User클래스로부터 방향 입력을 받아온다.
	public void setRotation(UserInterface rotationInput);	// UML상 4번 시나리오. User클래스로부터 회전 입력을 받아온다.
	public int[][] getBlock();	// UML상 6번 시나리오. Board클래스에 블록 정보를 보낸다. 
	
	
}
