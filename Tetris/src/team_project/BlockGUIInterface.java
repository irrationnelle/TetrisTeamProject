package team_project;

public interface BlockGUIInterface {
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
	
	/*
	 * GUI 구현은 자체적으로도 가능하겠지만,
	 * Block 클래스에서 값을 가져오는 형식으로 구현할 것.
	 * 가령, Block의 형태를 정하는 GUI는 Block 클래스에서 x,y 좌표값을 가져오고
	 * Rotation 구현을 위한 boolean값이나 Rotation 후 변형된 x,y 좌표값 또한 Block 클래스에서 가져온다.
	 * 따라서 Block 클래스에 상수 형태로 값을 지정하고 해당 값을 가져오는 방식으로 구현해야 함.
	 */
}
