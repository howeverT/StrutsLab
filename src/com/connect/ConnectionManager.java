package com.connect;

import java.sql.*;

public class ConnectionManager {

 //连接Sql Server数据库
	private static final String DRIVER_CLASS = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String DATABASE_URL = "jdbc:sqlserver://localhost:1433;DatabaseName=structlab";
	private static final String DATABASE_USRE = "sa";
	private static final String DATABASE_PASSWORD = "htw970508";
	
/*	
   //连接mysql数据库
	private static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/example?characterEncoding=utf-8";
	private static final String DATABASE_USRE = "root";
	private static final String DATABASE_PASSWORD = "root";
*/			
	/**
	 * 返回连接
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
	 * 关闭连接
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
	 * 关闭结果集
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
	 *关闭语句
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