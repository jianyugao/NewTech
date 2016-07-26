package com.ynwi.ssh.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;

public interface BaseDao {
	public Session getSession();
	public void setSession(Session session);
	public void saveObject(Object obj) throws HibernateException; 
}
