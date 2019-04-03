package com.dao;
import com.connect.*;
import com.entity.*;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;




public class PlaneDao {
	public PlaneDao(){
		
	}
	//�û���½�����ݿ�Ƚ�
	public static boolean userLogin(String name,String password) {

		Connection dbConnection = null;
		PreparedStatement pStatement = null;
		ResultSet res = null;
		boolean status=true;
		try {
			dbConnection = ConnectionManager.getConnection();
			String strSql = "select * from userList where userName='"+name+"' and password='"+password+"'";
			pStatement = dbConnection.prepareStatement(strSql);
			res = pStatement.executeQuery();
			
			if (res.next()&&res!=null) {
				status=true;
			}else{
				status=false;
			}
		} catch (SQLException sqlE) {
			sqlE.printStackTrace();
		} finally {
			ConnectionManager.closeResultSet(res);
			ConnectionManager.closeStatement(pStatement);
			ConnectionManager.closeConnection(dbConnection);
		}
		return status;
	}
	//ע���ж��Ƿ�ͬ��
	public static boolean uregCheck(String name) {

		Connection dbConnection = null;
		PreparedStatement pStatement = null;
		ResultSet res = null;
		boolean status=true;
		try {
			dbConnection = ConnectionManager.getConnection();
			String strSql = "select * from userList where userName='"+name+"'";
			pStatement = dbConnection.prepareStatement(strSql);
			res = pStatement.executeQuery();
			
			if (res.next()&&res!=null) {
				status=true;//�ҵ�ͬ��
			}else{
				status=false;//û���ҵ�
			}
		} catch (SQLException sqlE) {
			sqlE.printStackTrace();
		} finally {
			ConnectionManager.closeResultSet(res);
			ConnectionManager.closeStatement(pStatement);
			ConnectionManager.closeConnection(dbConnection);
		}
		return status;
	}
	//�û�ע����Ϣ���뵽���ݿ⵱��
	public static boolean userRegister(String name,String password){
		Connection dbConnection = null;
		PreparedStatement pStatement = null;
		int res = 0;
		boolean status=true;
		try {
			dbConnection = ConnectionManager.getConnection();
			String strSql = "insert into dbo.userList(userName,password) "+"values(?,?)";
			pStatement = dbConnection.prepareStatement(strSql);
			pStatement.setString(1,name);
			pStatement.setString(2,password);
			res = pStatement.executeUpdate();
			
		} catch (SQLException sqlE) {
			status=false;
			sqlE.printStackTrace();
			System.out.println("����ʧ��");
			return false;
		} finally {
			//ConnectionManager.closeResultSet(res);
			ConnectionManager.closeStatement(pStatement);
			ConnectionManager.closeConnection(dbConnection);
		}
		return status;
	}
	//��������
	public static boolean insertData(String name,String sex,String stcity,String distinction,String date,String identification) {
		Connection dbConnection = null;
		PreparedStatement pStatement = null;
		int res=0;
		boolean status=true;
		try {
			dbConnection = ConnectionManager.getConnection();
			String strSql = "insert into dbo.PlaneList(Name,Sex,startCity,Distinction,Date,Identification) "+"values(?,?,?,?,?,?)";
			pStatement = dbConnection.prepareStatement(strSql);
			pStatement.setString(1,name);
			pStatement.setString(2,sex);
			pStatement.setString(3,stcity);
			pStatement.setString(4,distinction);
			pStatement.setString(5,date);
			pStatement.setString(6,identification);
			res = pStatement.executeUpdate();
		} catch (SQLException sqlE) {
			status=false;
			sqlE.printStackTrace();
			return status;
		} finally {
			ConnectionManager.closeStatement(pStatement);
			ConnectionManager.closeConnection(dbConnection);
		}
		return status;
	}
	//��ѯ��Ʊ��Ϣ
	public static Vector<Plane> queryTicket(String p){
		Connection dbConnection = null;
		PreparedStatement pStatement = null;
		ResultSet res = null;
		Vector<Plane> data=new Vector<Plane>();
		try {
			dbConnection = ConnectionManager.getConnection();
			String strSql = "select * from PlaneList where name='" + p+"'";
			pStatement = dbConnection.prepareStatement(strSql);
			res = pStatement.executeQuery();
			while(res.next()){
				Plane pn=new Plane();
				pn.setUname(res.getString(2));
				pn.setSex(res.getString(3));
				pn.setScity(res.getString(4));
				pn.setDcity(res.getString(5));
				pn.setDate(res.getString(6));
				pn.setIdent(res.getString(7));
				data.add(pn);
			}
			return data;
		} catch (SQLException sqlE) {
			sqlE.printStackTrace();
			return null;
		} finally {
			ConnectionManager.closeResultSet(res);
			ConnectionManager.closeStatement(pStatement);
			ConnectionManager.closeConnection(dbConnection);
		}
	}
}
