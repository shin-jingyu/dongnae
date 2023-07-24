package com.marketdongnae.database;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class JDBCTests {

	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	@Test
	public void test() {
		try (Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/dongnae?useUnicode=true&serverTimezone=Asia/Seoul",
				"dongnae",
				"dongnae")) {
			log.info(conn);
		} catch (Exception e) {
			// TODO: handle exception
			fail(e.getMessage());
		}
	}
	
}
