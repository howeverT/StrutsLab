package com.connect;

import java.sql.*;

public class ConnectionManager {

 //����Sql Server���ݿ�
	private static final String DRIVER_CLASS = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String DATABASE_URL = "jdbc:sqlserver://localhost:1433;DatabaseName=structlab";
	private static final String DATABASE_USRE = "sa";
	private static final String DATABASE_PASSWORD = "htw970508";
	
/*	
   //����mysql���ݿ�
	private static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/example?characterEncoding=utf-8";
	private static final String DATABASE_USRE = "root";
	private static final String DATABASE_PASSWORD = "root";
*/			
	/**
	 * ��������
	 * 
	 * @return Connection
	 */
	public static Connection getConnection() {
		Connection dbConnection = null;
		try {
			Class.forName(DRIVER_CLASS);
			dbConnection = DriverManager.getConnection(DATABASE_URL,
					DATABASE_USRE, DATABASE_PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return dbConnection;
	}

	/**
	 * �ر�����
	 * 
	 * @param dbConnection
	 *            Connection
	 */
	public static void closeConnection(Connection dbConnection) {
		try {
			if (dbConnection != null && (!dbConnection.isClosed())) {
				dbConnection.close();
			}
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		}

	}

	/**
	 * �رս����
	 */
	public static void closeResultSet(ResultSet res) {
		try {
			if (res != null) {
				res.close();
				res = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 *�ر����
	 */

	public static void closeStatement(PreparedStatement pStatement) {
		try {
			if (pStatement != null) {
				pStatement.close();
				pStatement = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}