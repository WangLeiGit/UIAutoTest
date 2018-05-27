package com.etyero.dao;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.web.entity.Segments;

public class MyBatisDemo {
	public static void main(String[] args) throws IOException {
	
		String resource = "myBatis.xml";
		// 使用类加载器加载mybatis的配置文件
		InputStream inputStream = MyBatisDemo.class.getClassLoader().getResourceAsStream(resource);
		// 构建sqlSession的工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// 使用MyBatis提供的Resources类加载mybatis的配置文件（它也加载关联的映射文件）
		// Reader reader = Resources.getResourceAsReader(resource);
		// 构建sqlSession的工厂
		// SqlSessionFactory sessionFactory = new
		// SqlSessionFactoryBuilder().build(reader);
		
		// 创建能执行映射文件中sql的sqlSession
		SqlSession session = sessionFactory.openSession();
		/**
		 * 映射sql的标识字符串，
		 * com.etyero.mapping.SmsMapper是SmsMapper.xml文件中mapper标签的namespace属性的值，
		 * getSms是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
		 */
		String statement = "com.etyero.mapper.SegmentsMapper.getSms";// 映射sql的标识字符串
		// 执行查询返回一个唯一user对象的sql
		Segments sms = session.selectOne(statement, "分区测试");
		System.out.println(sms.getName());
	}
}
