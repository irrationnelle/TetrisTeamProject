package team_project;

import java.awt.Shape;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;

// UML�� 2�� �ó�����. BlockŬ������ �Է��� key���� ������. keyPressed(KeyEvent e)�̿��� �� 
public class User implements UserInterface {
	int curX = 0; // ����� X��ǥ
	int curY = 0; // ����� Y��ǥ
	Shape curPiece; // ����� ����
    
	public int getLeft(){
		return curX -= 1;
	}
	public int getRight(){
		return curX += 1;
	}
	/**
	 * rotation ���ó��
	 */
	final Shape rotation() {
		return curPiece;

	}

	/**
	 * Ű �Է� ó��
	 */
	public void keyPressed(KeyEvent e) {
//		int Keycode = e.getKeyCode();
//
//		switch (Keycode) {
//		case KeyEvent.VK_LEFT:
//			getLeft();
//			break;
//		case KeyEvent.VK_RIGHT:
//			getRight();
//			break;
//		case KeyEvent.VK_DOWN:
//			dropDown();
//			break;
//		case KeyEvent.VK_UP:
//			MoveDirection(((User) curPiece).rotation(), curX, curY);
//			break;
//		}
	}

	// UML�� 1��, 7�� �ó�����. Board Ŭ�����κ��� ��ϰ��� �޾ƿ´�.
	public void setBlock(Board b) {
	}

	// UML�� 13�� �ó�����. �� �޼ҵ尡 ȣ��Ǹ� '�ش� ����'�� ��Ʈ������ ����ȴ�.
	public void showGameOver(TetrisManagerInterface tm) {
//		JOptionPane.showMessageDialog(null, "������ ����Ǿ����ϴ�.", "��������", JOptionPane.ERROR_MESSAGE);
	}
	@Override
	public UserInterface getKeyPressed() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setBlock(BoardInterface currentBlock) {
		// TODO Auto-generated method stub
		
	}

}
