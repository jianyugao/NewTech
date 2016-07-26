package com.ynwi.ssh.daoImpl;

import org.apache.catalina.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.ynwi.ssh.dao.BaseDao;

public class UserDao implements BaseDao{
	private Session session;

	@Override
	public Session getSession() {
		// TODO Auto-generated method stub
		return this.session;
	}

	@Override
	public void setSession(Session session) {
		// TODO Auto-generated method stub
		this.session = session;
	}
	

	@Override
	public void saveObject(Object obj) throws HibernateException {
		// TODO Auto-generated method stub
		this.session.save(obj);
	}
	
}
