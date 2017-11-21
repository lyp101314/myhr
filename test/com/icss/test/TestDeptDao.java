package com.icss.test;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.icss.hr.dept.dao.DeptDao;
import com.icss.hr.dept.pojo.Dept;

/**
 * 测试部门数据访问功能 
 * @author DLETC
 */
public class TestDeptDao {
	
	private DeptDao dao = new DeptDao();
	
	//插入测试
	@Test    //+注解,可运行测试
	public void testInsert() throws SQLException {
		
		Dept dept = new Dept("开发部","大连");
		dao.insert(dept);
	}
	
	//修改测试
	@Test
	public void testUPdate () throws SQLException {
		Dept dept = new Dept(1,"财政部","北京");
		dao.update(dept);
	}
	
	//删除测试
	@Test
	public void testDelete () throws SQLException {
	
		dao.delete(3);
	}
	
	//查询单条测试
	@Test
	public void testqueryById () throws SQLException {
		Dept dept = new Dept();
		dept =dao.queryById(2);
		System.out.println(dept);
		
	}
	
	//查询所有记录
	@Test
	public void testquery () throws SQLException {
		List<Dept> list= dao.query();
		for (Dept dept : list) {
			System.out.println(dept);
		}
		
	}
	
}
