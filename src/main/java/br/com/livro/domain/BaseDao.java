package br.com.livro.domain;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;



public class BaseDao {
	public BaseDao() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	protected Connection getConnection() throws SQLException {

		String url = "jdbc:mysql://localhost/livro";
		Connection con = DriverManager.getConnection(url,"livro","livro123");
		return con;

	}
	
	public static void main(String[] args) throws SQLException {
		BaseDao db = new BaseDao();
		Connection con = db.getConnection();
		System.out.print(con);
	}
}
