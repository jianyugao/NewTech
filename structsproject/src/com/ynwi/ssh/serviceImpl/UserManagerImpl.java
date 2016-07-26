package com.ynwi.ssh.serviceImpl;


import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ynwi.ssh.beans.User;
import com.ynwi.ssh.dao.BaseDao;
import com.ynwi.ssh.daoImpl.HibernateSessionFactory;
import com.ynwi.ssh.daoImpl.UserDao;
import com.ynwi.ssh.forms.UserForm;
import com.ynwi.ssh.service.UserManager;

public class UserManagerImpl implements UserManager {
	private BaseDao dao;
	private Session session;
	public UserManagerImpl() {
		// TODO Auto-generated constructor stub
		dao = new UserDao();
	}
	@Override
	public void regUser(UserForm user) {
		session = HibernateSessionFactory.currentSession();  
		dao.setSession(session);
		Transaction ts = session.beginTransaction();  
		User u = new User();
		u.setGender(user.getGender());
		u.setPassword(user.getPassword());
		u.setUsername(user.getUsername());
		dao.saveObject(u);
		ts.commit();  
        // 关闭Session  
        HibernateSessionFactory.closeSession();  
	}

}
