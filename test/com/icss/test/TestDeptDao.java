package com.icss.test;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.icss.hr.dept.dao.DeptDao;
import com.icss.hr.dept.pojo.Dept;

/**
 * ���Բ������ݷ��ʹ��� 
 * @author DLETC
 */
public class TestDeptDao {
	
	private DeptDao dao = new DeptDao();
	
	//�������
	@Test    //+ע��,�����в���
	public void testInsert() throws SQLException {
		
		Dept dept = new Dept("������","����");
		dao.insert(dept);
	}
	
	//�޸Ĳ���
	@Test
	public void testUPdate () throws SQLException {
		Dept dept = new Dept(1,"������","����");
		dao.update(dept);
	}
	
	//ɾ������
	@Test
	public void testDelete () throws SQLException {
	
		dao.delete(3);
	}
	
	//��ѯ��������
	@Test
	public void testqueryById () throws SQLException {
		Dept dept = new Dept();
		dept =dao.queryById(2);
		System.out.println(dept);
		
	}
	
	//��ѯ���м�¼
	@Test
	public void testquery () throws SQLException {
		List<Dept> list= dao.query();
		for (Dept dept : list) {
			System.out.println(dept);
		}
		
	}
	
}
