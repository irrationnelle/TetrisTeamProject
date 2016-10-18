package team_project;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
CREATE TABLE SCOREBOARD (
NO INT PRIMARY KEY AUTO_INCREMENT,
NAME VARCHAR(12),
SCORE INT,
);
*/

public class db {
	private final String db_url = "jdbc:mysql://127.0.0.1:3306/java";
	private final String db_id = "root";
	private final String db_pw = "sds902";
	
	private Connection con = null;
	
	public db() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver 연결 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	void Connection(){
		try {
			con = DriverManager.getConnection(db_url, db_id, db_pw);
			System.out.println("db 연결 성공");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	void closeConnect(){
		try {
			con.close();
			System.out.println("데이터베이스 연결 종료");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<ScoreVObyHS> selectScoreList() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ScoreVObyHS> ScoreList = new ArrayList<>();
		try {
			String sql = "SELECT NAME, SCORE FROM SCOREBOARD ORDER BY SCORE DESC";
			// 정렬은 SQL문을 통해 DB에서 미리 정렬하여 가지고 온다.
			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				ScoreVObyHS resultScore = new ScoreVObyHS();
				resultScore.setName(rs.getString(1));
				resultScore.setScore(rs.getInt(2));
				ScoreList.add(resultScore);
			}
		} catch (SQLException e) {
			System.out.println("Dao update 에러");
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return ScoreList;
	}
}
