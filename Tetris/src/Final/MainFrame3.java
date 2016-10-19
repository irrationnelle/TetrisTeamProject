package Final;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class MainFrame3 extends JFrame{

	private JTextField idText;
	private JTextField userField;
	private JTextField scoreField;
	private JTextField speedField;
    private JButton idButton;
	private BufferedImage img = null;
	private Board board;
	private String userName;
	private ScorePanel scorePanel;

	private UserInput idInput = null;
	// 프레임 생성 및 초기화
	public MainFrame3() {
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();
		int x = screenSize.width / 6 / 1 - this.getWidth() / 2;
		int y = screenSize.height / 300 / 1 - this.getHeight() / 2;
		setLocation(x, y);
		

		add(new MyPanel());

		// 프레임 위에 붙일 페널 생성
		MyPanel p = new MyPanel();
		JPanel panelMain = new JPanel();
		JPanel panelBar = new JPanel();
		JPanel panelUnclear = new JPanel();
//		JPanel panelGame = new JPanel();
		
		JPanel panelNext = new JPanel();
		JPanel panelItem = new JPanel();

//		// Bar패널 설정
		panelBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelBar.setBackground(Color.darkGray);
		panelBar.setSize(800, 40);
		panelMain.add(panelBar);
		panelBar.setFocusable(false);

		JButton startBtn = new JButton("Start");
		startBtn.setBackground(Color.WHITE);
		startBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				idInput = new UserInput();
			}
		});
		startBtn.setFocusable(false);
		
		panelBar.add(startBtn);
		
		JButton scoreBtn = new JButton("Score");
		scoreBtn.setBackground(Color.WHITE);
		scoreBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ScoreFrame();
			}
		});
		panelBar.add(scoreBtn);
		scoreBtn.setFocusable(false);
		
		JButton optionBtn = new JButton("Option");
		optionBtn.setBackground(Color.WHITE);
		optionBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Option();
			}
		});
		panelBar.add(optionBtn);
		optionBtn.setFocusable(false);
		
		
		
		// Unclear패널 설정
		panelUnclear.setLayout(null);
		panelUnclear.setBounds(30, 70, 500, 100);
		panelUnclear.setSize(720, 800);
		panelUnclear.setBackground(new Color(0, 0, 0, 50));
		panelUnclear.setFocusable(false);
		// -------------------Unclear페널에 붙을 각종 레이블--------------------------//
		// Player 레이블
		JLabel lable2 = new JLabel("PLAYER");
		lable2.setBounds(30, 200, 50, 10);
		lable2.setForeground(Color.white);
		lable2.setFocusable(false);
		panelUnclear.add(lable2);
		// Mode 레이블
		JLabel lable3 = new JLabel("SPEED");
		lable3.setBounds(35, 300, 50, 10);
		lable3.setForeground(Color.white);
		lable3.setFocusable(false);
		panelUnclear.add(lable3);
		// Speed 레이블
		JLabel lable4 = new JLabel("MODE");
		lable4.setBounds(30, 400, 50, 10);
		lable4.setForeground(Color.white);
		lable4.setFocusable(false);
		panelUnclear.add(lable4);
		// Score 레이블
		JLabel lable5 = new JLabel("SCORE");
		lable5.setBounds(640, 50, 50, 10);
		lable5.setForeground(Color.white);
		lable5.setFocusable(false);
		panelUnclear.add(lable5);

		// Level 레이블
		JLabel lable7 = new JLabel("LEVEL");
		lable7.setBounds(105, 750, 100, 10);
		lable7.setForeground(Color.white);
		lable7.setFocusable(false);
		panelUnclear.add(lable7);

		// ------------------Unclear패널에 붙을 각종 텍스트-----------------------------//
		// Speed 텍스트
		speedField = new JTextField();
		speedField.setBounds(17, 330, 70, 40);
		speedField.setBackground(Color.white);
		panelUnclear.add(speedField);
		speedField.setText("400");
		speedField.setFocusable(false);
		// Mode 텍스트
		JTextField Field2 = new JTextField();
		Field2.setBounds(17, 430, 70, 40);
		Field2.setBackground(Color.white);
		panelUnclear.add(Field2);
		Field2.setFocusable(false);
		// Player 텍스트
		userField = new JTextField();
		userField.setBounds(17, 230, 70, 40);
		userField.setBackground(Color.white);
		panelUnclear.add(userField);
		userField.setFocusable(false);

		// Score 텍스트
		scoreField = new JTextField("0");
		scoreField.setBounds(625, 80, 70, 40);
		scoreField.setBackground(Color.white);
		panelUnclear.add(scoreField);
		scoreField.setFocusable(false);
		// Level 텍스트
		JTextField Field5 = new JTextField();
		Field5.setBounds(160, 750, 450, 10);
		Field5.setBackground(Color.white);
		panelUnclear.add(Field5);
		Field5.setFocusable(false);

		// --------------------------------------------------------------------------//
//		new UserInput();
		
		// Game패널 설정
		board = new Board(this);
		board.setLayout(null);
		board.setBounds(135, 90, 400, 50);
		board.setSize(500, 700);
		board.setBackground(Color.gray);
		board.setFocusable(true);
		panelMain.add(board);
		panelMain.setFocusable(false);

		
		// 각 패널들을 전체 Main패널에 붙이기
		add(panelBar);
		add(board);
		add(panelNext);
		add(panelUnclear);
		add(panelMain);
		add(p);


		panelBar.setFocusable(false);
		panelNext.setFocusable(false);
		panelUnclear.setFocusable(false);
		p.setFocusable(false);
//		board.start();
		board.setFocusable(true);
		
		
		setTitle("Tetris");
		setSize(800, 950);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setFocusable(true);
		setVisible(true);
		
		idInput = new UserInput();
//		idInput.setVisible(true);
	}
	
	public JTextField getScoreBoard() {
		return scoreField;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public JTextField getUserField() {
		return userField;
	}
	
	public JTextField getSpeedField() {
		return speedField;
	}

	class MyPanel extends JPanel {
		public void paint(Graphics g) {
			g.drawImage(img, 0, 0, 800, 1100, null, null);
		}

		public Dimension getPreferredSize() {
			if (img == null) {
				return new Dimension(800, 900);
			} else {
				return new Dimension(img.getWidth(null), (img.getHeight(null)));
			}

		}

	}

	// ID입력하는 프레임
	class UserInput extends JDialog {

		Button idButton;
		BufferedImage img = null;
		JTextField idText;

		public UserInput() {

			Toolkit tk = Toolkit.getDefaultToolkit();
			Dimension screenSize = tk.getScreenSize();
			int x = screenSize.width / 3 / 1 - this.getWidth() / 2;
			int y = screenSize.height / 3 / 1 - this.getHeight() / 2;

//			add(new MyPanel());

			MyPanel p = new MyPanel();
			JPanel panelMain1 = new JPanel();
			JPanel panelUnclear1 = new JPanel();

			panelUnclear1.setLayout(null);
			panelUnclear1.setBounds(30, 40, 30, 100);
			panelUnclear1.setSize(240, 40);
			panelUnclear1.setBackground(new Color(0, 0, 0, 0));
			panelUnclear1.setFocusable(false);

			JLabel idLabel = new JLabel("ID");
			idLabel.setBounds(10, 10, 50, 20);
			idLabel.setFont(new Font("바탕", Font.BOLD, 20));
			idLabel.setFocusable(false);
			panelUnclear1.add(idLabel);
			panelUnclear1.setFocusable(false);

			idText = new JTextField();
			idText.setBounds(40, 10, 130, 20);
			idText.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
//					userName = idText.getText();
					setUserName(idText.getText());
					userField.setText(userName);
					userField.setFocusable(false);
					dispose();
					scoreField.setText("0");
					scoreField.setFocusable(false);
					board.start();
					board.setFocusable(true);
					board.requestFocus();
					
				}
			});
			panelUnclear1.add(idText);
			panelUnclear1.setFocusable(false);
			JButton idButton = new JButton("입력");
			idButton.setFocusable(false);
			idButton.setBounds(180, 10, 60, 20);
			idButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					userName = idText.getText();
					userField.setText(userName);
					userField.setFocusable(false);
					dispose();
					scoreField.setText("0");
					scoreField.setFocusable(false);
					board.start();
					board.setFocusable(true);
					board.requestFocus();
				}
			});
			panelUnclear1.add(idButton);
			panelUnclear1.setFocusable(false);

			add(panelUnclear1); 
//			add(panelMain);
			add(p);
			
			setTitle("Tetris");
			setLocation(x, y);
			setSize(300, 150);
			
			setResizable(false);
			setModal(true);
			setVisible(true);

		}

		class MyPanel extends JPanel {
			public void paint(Graphics g) {
				g.drawImage(img, 0, 0, 300, 200, null, null);
			}

			public Dimension getPreferredSize() {
				if (img == null) {
					return new Dimension(300, 200);
				} else {
					return new Dimension(img.getWidth(null), (img.getHeight(null)));
				}

			}

		}

	}
	
	// Score 보여주는 프레임
	public class ScoreFrame extends JFrame {
		
		ScorePanel scorePanel;
		
		public ScoreFrame() {
			scorePanel = new ScorePanel();
			JButton resetBtn = new JButton("Reset");
			
			Toolkit tk = Toolkit.getDefaultToolkit();
			Dimension screenSize = tk.getScreenSize();
			int x = screenSize.width / 3 / 1 - this.getWidth() / 2;
			int y = screenSize.height / 3 / 1 - this.getHeight() / 2;
			
			resetBtn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					board.resetScoreBoard();
					dispose();
				}
			});
			
			add(scorePanel);
			add(resetBtn, BorderLayout.SOUTH);
			
			setTitle("Score Board");
			setLocation(x, y);
			setSize(500, 500);
			
//			setResizable(false);
			setVisible(true);
		}
		
		public class ScorePanel extends JPanel {
			String[] Column = { "순위", "사용자", "점수" };
			Object[][] data;
			ScoreDAO d = new ScoreDAO(); // 점수 DB DAO
			
			public ScorePanel() {
				Toolkit tk = Toolkit.getDefaultToolkit();
				Dimension screenSize = tk.getScreenSize();
				int x = screenSize.width / 3 / 1 - this.getWidth() / 2;
				int y = screenSize.height / 3 / 1 - this.getHeight() / 2;
				
				
				d.createConnection();
				List<ScoreVO> l = d.selectScoreList();
				data = new Object[l.size()][];
				
				for (int i = 0; i < d.selectScoreList().size(); i++) {
					data[i] = new Object[3];
					data[i][0] = new Integer(i+1);
					data[i][1] = new String(l.get(i).getName());
					data[i][2] = new Integer(l.get(i).getScore());
				} // 테이블에 들어갈 데이터 입력
				
				
				DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
				dtcr.setHorizontalAlignment(SwingConstants.CENTER);
				// 가운데 정렬용 DefaultTableCellRenderer
				
				JTable b = new JTable(data, Column);
				
				for(int i = 0 ; i < b.getColumnCount() ; i++)
					b.getColumnModel().getColumn(i).setCellRenderer(dtcr);
				// 각 column들을 가운데 정렬함
				
				b.setEnabled(false);
				// 테이블 수정금지
				b.getTableHeader().setReorderingAllowed(false);
				// 테이블 이동 불가
				b.getTableHeader().setResizingAllowed(false);
				// 테이블 크기 조절 불가.
				JScrollPane p = new JScrollPane(b); 
				add(p); // JScrollPane으로 테이블에 스크롤을 넣은후에 패널에 추가
				
				System.out.println("scorePanel Construct");
				
				setTitle("Score Board");
				setLocation(x, y);
				setSize(300, 150);
				
				setResizable(false);
				setVisible(true);
			}
			
		}
	}
	
	public class Option extends JFrame {
		String a1 = "";

		public Option() {

			// 프레임에 붙일 패널생성
			JPanel a = new JPanel();
			JPanel b = new JPanel();
			JPanel d = new JPanel();

			// 패널 설정
			a.setBackground(Color.white);
			b.setBackground(Color.white);

			a.setLayout(null);
			b.setLayout(null);
			d.setLayout(null);

			a.setBounds(0, 0, 500, 350);
			b.setBounds(0, 350, 500, 700);
			// 패널 테두리 생성
			a.setBorder(new EtchedBorder(EtchedBorder.LOWERED));

			// 패널에 붙일 레이블 생성 및 설정
			JLabel ModeLabel = new JLabel("모드설정");
			ModeLabel.setBounds(140, 50, 300, 80);
			ModeLabel.setFont(new Font("맑은고딕", Font.BOLD, 50));
			a.add(ModeLabel);
			JLabel SpeedLabel = new JLabel("속도");
			JLabel Speed1Label = new JLabel("1-999(낮을수록 빠름)");
			SpeedLabel.setBounds(180, 50, 300, 80);
			Speed1Label.setBounds(120, 90, 300, 100);
			SpeedLabel.setFont(new Font("맑은고딕", Font.BOLD, 50));
			Speed1Label.setFont(new Font("맑은고딕", Font.BOLD, 20));
			b.add(SpeedLabel);
			b.add(Speed1Label);

			// 패널에 붙일 텍스트 생성 및 설정
			JTextField speedText = new JTextField();
			speedText.setBounds(180, 160, 100, 30);
			speedText.addKeyListener(new ex());
			speedText.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					speedField.setText(speedText.getText());
					board.setGameSpeed(Integer.parseInt(speedText.getText()));
					dispose();
				}
			});
			speedText.setDocument(new JTextFieldLimit(3));

			b.add(speedText);

			// 패널에 붙일 버튼 생성 및 설정
			JButton ModeBtn1 = new JButton("Single");
			ModeBtn1.setBounds(80, 150, 150, 150);
			ModeBtn1.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					dispose();

				}
			});
			JButton ModeBtn2 = new JButton("Multi");
			ModeBtn2.setBounds(250, 150, 150, 150);
			ModeBtn2.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					dispose();

				}
			});
			JButton Speedbtn = new JButton("확인");
			Speedbtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					speedField.setText(speedText.getText());
					board.setGameSpeed(Integer.parseInt(speedText.getText()));
					dispose();
				}
			});
			Speedbtn.setBounds(190, 200, 80, 30);

			a.add(ModeBtn1);
			a.add(ModeBtn2);
			b.add(Speedbtn);

			Toolkit tk = Toolkit.getDefaultToolkit();
			Dimension screenSize = tk.getScreenSize();
			int x = screenSize.width / 4 / 1 - this.getWidth() / 2;
			int y = screenSize.height / 7 / 1 - this.getHeight() / 2;

			add(a);
			add(b);
			add(d);

			setLocation(x, y);
			setTitle("Setting");
			setSize(500, 700);
			setResizable(false);
			setVisible(true);

		}

		// Speed텍스트에 숫자만 입력할수있는 메소드
		class ex extends KeyAdapter {
			public void keyReleased(KeyEvent e) {
				JTextField s = (JTextField) e.getSource();
				try {
					if (!s.getText().isEmpty())
						Integer.parseInt(s.getText());
					a1 = s.getText();

				} catch (NumberFormatException nfe) {
					s.setText(a1);
				}
			}
		}

		// speed텍스트에 숫자입력 제한 메소드
		public class JTextFieldLimit extends PlainDocument {
			private int limit;

			public JTextFieldLimit(int limit) {

				super();
				this.limit = limit;
			}

			public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
				if (str == null)
					return;

				if (getLength() + str.length() <= limit)
					super.insertString(offset, str, attr);

			}

		}

	}

	

	public static void main(String[] args) {
		MainFrame3 main = new MainFrame3();
		main.setLocationRelativeTo(null);
        main.setVisible(true);

	}

	
	
}
