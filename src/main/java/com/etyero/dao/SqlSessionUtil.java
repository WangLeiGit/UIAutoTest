package com.etyero.dao;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * mybatis DB操作
 * 
 * @author lijialong
 */
public class SqlSessionUtil {
	private SqlSession sqlSession = null;

	public SqlSessionUtil() {
		try {
			String resource = "myBatis.xml";
			InputStream inputStream = SqlSessionUtil.class.getClassLoader().getResourceAsStream(resource);
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			this.sqlSession = sessionFactory.openSession();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public SqlSession getSession() {
		return this.sqlSession;
	}

	public void commit() {
		this.sqlSession.commit();
	}

	public void closeSession() {
		if (this.sqlSession != null) {
			try {
				this.sqlSession.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
