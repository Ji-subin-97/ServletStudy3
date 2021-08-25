package com.iu.s1.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.iu.s1.util.DBConnector;

public class MemberDAO {
	
	private DBConnector dbConnector;
	
	public MemberDAO() {
		dbConnector = new DBConnector();
	}
	
	public int memberJoin(MemberDTO memberDTO) {
		
		Connection con = null;
		PreparedStatement st = null;
		int result = 0;
		
		con = dbConnector.getConnect();
		
		String sql = "insert into member (id, pw, name, phone, email) values (?,?,?,?,?)";
		try {
			st = con.prepareStatement(sql);
			st.setString(1, memberDTO.getId());
			st.setString(2, memberDTO.getPw());
			st.setString(3, memberDTO.getName());
			st.setString(4, memberDTO.getPhone());
			st.setString(5, memberDTO.getEmail());
			
			result = st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbConnector.disConnect(st, con);
		}
		
		return result;
	}
}
