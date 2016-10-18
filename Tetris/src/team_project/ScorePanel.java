package team_project;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class ScorePanel extends JPanel {
	String[] Column = { "순위", "사용자", "점수" };
	Object[][] data;
	db d = new db(); // 점수 DB DAO

	public ScorePanel() {

		d.Connection();
		List<ScoreVObyHS> l = d.selectScoreList();
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

	}
//
	public static void main(String[] args) {
		JFrame f = new JFrame("Score board");
		f.setLayout(new BorderLayout());
		f.add(new ScorePanel(), BorderLayout.CENTER);
		
		f.pack();
		// 사이즈 자동조절

		//f.setSize(600, 200);
		f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
//
}
