package com.dao;
import com.connect.*;
import com.entity.*;
import com.common.HibernateSessionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;
import com.entity.Users;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;




public class PlaneDao {
	public PlaneDao(){
		
	}
	//用户登陆与数据库比较
	public static boolean userLogin(Users user) {
		/*
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
		return status;*/
		Session session;
		try{
			//得到Session对象
			session=HibernateSessionFactory.getSession();
			//HQL语句, Users是持久化类,name和password是持久化Users类的属性
			String hql="from Users where name=? and pwd=?";
			//创建Query对象
			Query query=session.createQuery(hql);
			//设置参数,?的序号从0开始
			query.setParameter(0, user.getName());
			query.setParameter(1, user.getPwd());
			//执行查询,得到查询结果的list集合
			List list=query.list();
			if(list.size()>0){
				return true;
			}else{
				return false;
			}
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}finally{
			HibernateSessionFactory.closeSession();
		}
	}
	//注册判断是否同名
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
				status=true;//找到同名
			}else{
				status=false;//没有找到
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
	//用户注册信息插入到数据库当中
	public static boolean userRegister(Users user){
		/*Connection dbConnection = null;
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
			System.out.println("插入失败");
			return false;
		} finally {
			//ConnectionManager.closeResultSet(res);
			ConnectionManager.closeStatement(pStatement);
			ConnectionManager.closeConnection(dbConnection);
		}
		return status;*/
		int num=0;
		//得到session
		Session session=null;
		Transaction transaction=null;
		try{
			session=HibernateSessionFactory.getSession();
			transaction=session.beginTransaction();
			num=Integer.parseInt(session.save(user).toString());
			transaction.commit(); //写入数据库，
		}catch (Exception e) {
			e.printStackTrace();
			num=0;
		}finally{//关闭session
			HibernateSessionFactory.closeSession();//调用HibernateSessionFactory的静态方法关闭Session
		}
		return true;
	}
	//插入数据
	public static boolean insertData(Plane plane) {
		/*Connection dbConnection = null;
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
		return status;*/
		Session session;
		int num=0; //受影响的行数
		try{
			//获得Sesion对象
			session=HibernateSessionFactory.getSession();
			//开始事物
			Transaction trans=session.beginTransaction();
			//保存数据,返回受影响的行数
			num=Integer.parseInt(session.save(plane).toString());
			//提交事物,才是真正写入数据库表中
			trans.commit();
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			HibernateSessionFactory.closeSession();
		}
		return true;
	}
	//查询订票信息
	public static List<Plane> queryTicket(String p,String n,String d){
		/*Connection dbConnection = null;
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
		}*/
		//得到session
		Session session=null;
		try{
			session=HibernateSessionFactory.getSession();
			//hql语句,Plane代表是entity里的实体类
			//获取所有数据
			String queryString="from Plane where utage=? and uname like '%"+n+"%'"+" and date like '%"+d+"%'";
			//创建查询
			Query query=session.createQuery(queryString);
			//设置参数,?的序号从0开始
			query.setParameter(0, p);
			//执行查询获得的结果,list中的每一个元素代表一个Plane的对象
			List list=query.list();//list集合包含Plane表里所有数据
			if(list.size()>0)
				return list;
			else{
				return null;
				}
			}catch (Exception e) {
				e.printStackTrace();
				return null;
			}finally{//关闭session
				HibernateSessionFactory.closeSession();//调用HibernateSessionFactory的静态方法关闭Session
			}
	}
		//根据id来删除数据方法
		public boolean deletePlaneById(int id){
			Session session=null;
			try{
				session=HibernateSessionFactory.getSession();
				//根据id获取要删除的用户
				Plane plane=(Plane)session.get(Plane.class, id);
				//删除plane数据
				Transaction trans=session.beginTransaction();
				session.delete(plane);//删除数据
				trans.commit();
				return true;
				
			}catch (Exception e) {
				e.printStackTrace();
				return false;
			}finally{//关闭session
				HibernateSessionFactory.closeSession();//调用HibernateSessionFactory的静态方法关闭Session
			}
			//delete方法， user对象处于临时状态，在数据库中没有对应的记录，因为已经删除了
		}
		//根据id来查询数据方法
		public Plane queryTicketById(int id){
			Session session=null;
			try{
				session=HibernateSessionFactory.getSession();
				//根据id获取要修改的用户数据
				Plane p=(Plane)session.get(Plane.class, id);
				return p;
				
			}catch (Exception e) {
				e.printStackTrace();
				return null;
			}finally{//关闭session
				HibernateSessionFactory.closeSession();//调用HibernateSessionFactory的静态方法关闭Session
			}	
		}
		//根据id来更新数据方法
		public boolean updatePlane(Plane newPlane){
			Session session=null;
			try{
				session=HibernateSessionFactory.getSession();
				//保存oldUser数据回数据库
				Transaction trans=session.beginTransaction();
				//调用保存更新方法
				session.saveOrUpdate(newPlane);
				trans.commit();
				return true;
				
			}catch (Exception e) {
				e.printStackTrace();
				return false;
			}finally{//关闭session
				HibernateSessionFactory.closeSession();//调用HibernateSessionFactory的静态方法关闭Session
			}	
		}
		//查询每页需要显示的数据(每次最多5条记录)
		public List<Plane> queryByPage(int pageNo,int pageSize,String p,String n,String d){
			//得到session
			Session session=null;
			try{
				session=HibernateSessionFactory.getSession();
				String queryString="from Plane where utage=? and uname like '%"+n+"%'"+" and date like '%"+d+"%'";
				//创建查询
				Query query=session.createQuery(queryString);
				//设置参数,?的序号从0开始
				query.setParameter(0, p);
				//每次获取第一条数据的索引
				query.setFirstResult((pageNo-1)*pageSize); //设置这一页显示的第一条记录的索引
				//这一页显示的记录个数
				query.setMaxResults(pageSize); 

				//每次最多5条记录
				List<Plane> list=query.list();
				return list;
			}catch (Exception e) {
				e.printStackTrace();
				return null;
			}finally{//关闭session
				HibernateSessionFactory.closeSession();//调用HibernateSessionFactory的静态方法关闭Session
			}	
		}
		//修改密码
		public boolean changePassword(Users user,String oldPwd,String newPwd){
			boolean flag=true;
			//得到session
			Session session=null;
			Transaction transaction=null;
			try{
				session=HibernateSessionFactory.getSession();
				//hql语句,Users是实体类,name和pwd代表实体类的属性
				String queryString="from Users where name=? and pwd=?";
				//创建查询
				Query queryObject=session.createQuery(queryString);
				queryObject.setParameter(0, user.getName());
				queryObject.setParameter(1, oldPwd);
				//执行查询获得的结果,list中的每一个元素代表一个Users的对象
				List<Users> list=queryObject.list();
				if(list.size()==0){
					flag=false;//旧密码错误
				}else{
					user=list.get(0); //找到要修改密码的用户对象
					user.setPwd(newPwd);
					transaction=session.beginTransaction();
					session.update(user);//在缓存中保存数据，受影响行数
					transaction.commit();//写入数据库表
				}
				return flag;
			}catch (Exception e) {
				e.printStackTrace();
				return false;
			}finally{//关闭session
				HibernateSessionFactory.closeSession();//调用HibernateSessionFactory的静态方法关闭Session
			}
		}
}
