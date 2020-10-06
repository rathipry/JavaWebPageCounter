package com.study.mypackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/*
 * This is the implementation class of DAO interface. 
 * Read count from database and update it in database.
 */
public class PageCounterImpl implements PageCounterDAO {

	Statement statement = null;
	PreparedStatement preparedStatment = null;
	ResultSet resultSet = null;
	Connection conn = null;

	@Override
	public int readPageCount() {
		int count = 0;
		String query = "SELECT * FROM tbl_pagecount";
		try {
			conn = DBConnectionUtil.openConnection();
			Statement stat = conn.createStatement();
			ResultSet resultSet = stat.executeQuery(query);
			while (resultSet.next()) {
				count = resultSet.getInt("count");
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return count;
	}

	@Override
	public void savePageCount(int count) {

		try {
			conn = DBConnectionUtil.openConnection();
			String query = "UPDATE tbl_pagecount SET count='" + count + "'";
			preparedStatment = conn.prepareStatement(query);
			preparedStatment.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

}
