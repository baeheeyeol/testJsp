package Print;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends DAO {

	public void insertMember(String name, String pass) {

		connect();
		String sql = "insert into members values(?,?,4)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, pass);
			int r = pstmt.executeUpdate();
			System.out.println(r + "건 입력됨.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	public List<User> selectAll() {
		List<User> list = new ArrayList<>();
		try {
			connect();
			String sql = "SELECT * FROM Members";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				User us = new User();
				us.setUserId(rs.getString(("Member_id")));
				us.setUserPass(rs.getString(("Member_pwd")));
				list.add(us);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}


}
