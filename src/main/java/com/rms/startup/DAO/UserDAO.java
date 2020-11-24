package com.rms.startup.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.rms.startup.Bean.UserBean;
import com.rms.startup.DAO.Entities.UserEntity;

@Repository
public class UserDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;

	Configuration cnf = new Configuration().configure().addAnnotatedClass(UserEntity.class);
	SessionFactory sf = cnf.buildSessionFactory();
	public List<UserBean> getAllUser() {
		
		Session session = sf.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from UserEntity");
		List<UserEntity> lst = query.list();
		List<UserBean> returnLst = new ArrayList<UserBean>();
		for(UserEntity list : lst)
			returnLst.add(list.convertToBean());
		session.getTransaction().commit();
		session.close();
		return returnLst;
		//return jdbcTemplate.query("select * from User;", new BeanPropertyRowMapper<UserBean>(UserBean.class));
	}

	public void addUser(UserBean bean) {
		//jdbcTemplate.update("insert into User(MobileNumber,password,UserType) values(?,?,?)", bean.getMobileNumber(),
			//	bean.getPassword(), bean.getUserType());
		UserEntity u = new UserEntity(bean);
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(u);
		session.getTransaction().commit();
		session.close();
	}

	public void deleteUser(String mobileNumber) {
		jdbcTemplate.update("delete from user where MobileNumber=?", mobileNumber);
	}

	public UserBean getUser(String mobileNumber) {
		Session session = sf.openSession();
		session.beginTransaction();
		UserEntity user = session.get(UserEntity.class, mobileNumber);
		session.getTransaction().commit();
		session.close();
		return user.convertToBean();
	}

	public void updateUser(String mobileNumber, UserBean bean) {
		jdbcTemplate.update("update User set MobileNumber=?,password=?,UserType=? where MobileNumber=?",
				bean.getMobileNumber(), bean.getPassword(), bean.getUserType(), mobileNumber);
	}

}
