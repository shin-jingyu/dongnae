package com.marketdongnae.database;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class DataSourceTests {

	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	@Test
	public void test() {
		try(Connection conn = dataSource.getConnection()){
			log.info(conn);
		}catch (Exception e) {
			// TODO: handle exception
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testMybatis() {
		try(SqlSession session = sqlSessionFactory.openSession();
			Connection conn = session.getConnection();)
		{
			log.info(session);
			log.info(conn);
			PreparedStatement pstmt = conn.prepareStatement("select * from goods");
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String name = rs.getString("g_name");
				System.out.println("name  : " + name);
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			fail(e.getMessage());
		}
	}
}
