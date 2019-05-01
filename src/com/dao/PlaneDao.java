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
	//�û���½�����ݿ�Ƚ�
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
			//�õ�Session����
			session=HibernateSessionFactory.getSession();
			//HQL���, Users�ǳ־û���,name��password�ǳ־û�Users�������
			String hql="from Users where name=? and pwd=?";
			//����Query����
			Query query=session.createQuery(hql);
			//���ò���,?����Ŵ�0��ʼ
			query.setParameter(0, user.getName());
			query.setParameter(1, user.getPwd());
			//ִ�в�ѯ,�õ���ѯ�����list����
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
			System.out.println("����ʧ��");
			return false;
		} finally {
			//ConnectionManager.closeResultSet(res);
			ConnectionManager.closeStatement(pStatement);
			ConnectionManager.closeConnection(dbConnection);
		}
		return status;*/
		int num=0;
		//�õ�session
		Session session=null;
		Transaction transaction=null;
		try{
			session=HibernateSessionFactory.getSession();
			transaction=session.beginTransaction();
			num=Integer.parseInt(session.save(user).toString());
			transaction.commit(); //д�����ݿ⣬
		}catch (Exception e) {
			e.printStackTrace();
			num=0;
		}finally{//�ر�session
			HibernateSessionFactory.closeSession();//����HibernateSessionFactory�ľ�̬�����ر�Session
		}
		return true;
	}
	//��������
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
		int num=0; //��Ӱ�������
		try{
			//���Sesion����
			session=HibernateSessionFactory.getSession();
			//��ʼ����
			Transaction trans=session.beginTransaction();
			//��������,������Ӱ�������
			num=Integer.parseInt(session.save(plane).toString());
			//�ύ����,��������д�����ݿ����
			trans.commit();
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			HibernateSessionFactory.closeSession();
		}
		return true;
	}
	//��ѯ��Ʊ��Ϣ
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
		//�õ�session
		Session session=null;
		try{
			session=HibernateSessionFactory.getSession();
			//hql���,Plane������entity���ʵ����
			//��ȡ��������
			String queryString="from Plane where utage=? and uname like '%"+n+"%'"+" and date like '%"+d+"%'";
			//������ѯ
			Query query=session.createQuery(queryString);
			//���ò���,?����Ŵ�0��ʼ
			query.setParameter(0, p);
			//ִ�в�ѯ��õĽ��,list�е�ÿһ��Ԫ�ش���һ��Plane�Ķ���
			List list=query.list();//list���ϰ���Plane������������
			if(list.size()>0)
				return list;
			else{
				return null;
				}
			}catch (Exception e) {
				e.printStackTrace();
				return null;
			}finally{//�ر�session
				HibernateSessionFactory.closeSession();//����HibernateSessionFactory�ľ�̬�����ر�Session
			}
	}
		//����id��ɾ�����ݷ���
		public boolean deletePlaneById(int id){
			Session session=null;
			try{
				session=HibernateSessionFactory.getSession();
				//����id��ȡҪɾ�����û�
				Plane plane=(Plane)session.get(Plane.class, id);
				//ɾ��plane����
				Transaction trans=session.beginTransaction();
				session.delete(plane);//ɾ������
				trans.commit();
				return true;
				
			}catch (Exception e) {
				e.printStackTrace();
				return false;
			}finally{//�ر�session
				HibernateSessionFactory.closeSession();//����HibernateSessionFactory�ľ�̬�����ر�Session
			}
			//delete������ user��������ʱ״̬�������ݿ���û�ж�Ӧ�ļ�¼����Ϊ�Ѿ�ɾ����
		}
		//����id����ѯ���ݷ���
		public Plane queryTicketById(int id){
			Session session=null;
			try{
				session=HibernateSessionFactory.getSession();
				//����id��ȡҪ�޸ĵ��û�����
				Plane p=(Plane)session.get(Plane.class, id);
				return p;
				
			}catch (Exception e) {
				e.printStackTrace();
				return null;
			}finally{//�ر�session
				HibernateSessionFactory.closeSession();//����HibernateSessionFactory�ľ�̬�����ر�Session
			}	
		}
		//����id���������ݷ���
		public boolean updatePlane(Plane newPlane){
			Session session=null;
			try{
				session=HibernateSessionFactory.getSession();
				//����oldUser���ݻ����ݿ�
				Transaction trans=session.beginTransaction();
				//���ñ�����·���
				session.saveOrUpdate(newPlane);
				trans.commit();
				return true;
				
			}catch (Exception e) {
				e.printStackTrace();
				return false;
			}finally{//�ر�session
				HibernateSessionFactory.closeSession();//����HibernateSessionFactory�ľ�̬�����ر�Session
			}	
		}
		//��ѯÿҳ��Ҫ��ʾ������(ÿ�����5����¼)
		public List<Plane> queryByPage(int pageNo,int pageSize,String p,String n,String d){
			//�õ�session
			Session session=null;
			try{
				session=HibernateSessionFactory.getSession();
				String queryString="from Plane where utage=? and uname like '%"+n+"%'"+" and date like '%"+d+"%'";
				//������ѯ
				Query query=session.createQuery(queryString);
				//���ò���,?����Ŵ�0��ʼ
				query.setParameter(0, p);
				//ÿ�λ�ȡ��һ�����ݵ�����
				query.setFirstResult((pageNo-1)*pageSize); //������һҳ��ʾ�ĵ�һ����¼������
				//��һҳ��ʾ�ļ�¼����
				query.setMaxResults(pageSize); 

				//ÿ�����5����¼
				List<Plane> list=query.list();
				return list;
			}catch (Exception e) {
				e.printStackTrace();
				return null;
			}finally{//�ر�session
				HibernateSessionFactory.closeSession();//����HibernateSessionFactory�ľ�̬�����ر�Session
			}	
		}
		//�޸�����
		public boolean changePassword(Users user,String oldPwd,String newPwd){
			boolean flag=true;
			//�õ�session
			Session session=null;
			Transaction transaction=null;
			try{
				session=HibernateSessionFactory.getSession();
				//hql���,Users��ʵ����,name��pwd����ʵ���������
				String queryString="from Users where name=? and pwd=?";
				//������ѯ
				Query queryObject=session.createQuery(queryString);
				queryObject.setParameter(0, user.getName());
				queryObject.setParameter(1, oldPwd);
				//ִ�в�ѯ��õĽ��,list�е�ÿһ��Ԫ�ش���һ��Users�Ķ���
				List<Users> list=queryObject.list();
				if(list.size()==0){
					flag=false;//���������
				}else{
					user=list.get(0); //�ҵ�Ҫ�޸�������û�����
					user.setPwd(newPwd);
					transaction=session.beginTransaction();
					session.update(user);//�ڻ����б������ݣ���Ӱ������
					transaction.commit();//д�����ݿ��
				}
				return flag;
			}catch (Exception e) {
				e.printStackTrace();
				return false;
			}finally{//�ر�session
				HibernateSessionFactory.closeSession();//����HibernateSessionFactory�ľ�̬�����ر�Session
			}
		}
}
