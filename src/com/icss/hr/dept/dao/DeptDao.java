package com.icss.hr.dept.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.icss.hr.common.DbUtil;
import com.icss.hr.dept.pojo.Dept;


/**
 * ����Dao 
 * @author DLETC
 * 
 */
public class DeptDao {
	/**
	 * �������� 
	 * @param  dept
	 * @throws SQLException 
	 */
	public void insert(Dept dept) throws SQLException {
		//������ݿ�����
		 Connection conn = DbUtil.getConnection();
		
		String sql = "insert into dept values (dept_seq.nextval,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, dept.getDeptName());
		pstmt.setString(2, dept.getDeptLoc());
		
		//ִ��sql���
		pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
	}
	
	
	/**
	 * �޸����� 
	 * @param dept
	 * @throws SQLException 
	 */
	public void update(Dept dept) throws SQLException {
		//������ݿ�����
		Connection conn = DbUtil.getConnection();
		
		String sql = "update dept set dept_name = ?,dept_loc = ? where dept_id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, dept.getDeptName());
		pstmt.setString(2, dept.getDeptLoc());
		pstmt.setInt(3, dept.getDeptId());
		
		//ִ��sql���
		pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
		
		
	}
	
	/**
	 * ɾ������ 
	 * @param  deptId
	 * @throws SQLException 
	 */
	
	public void delete(int deptId) throws SQLException {
		//������ݿ�����
		Connection conn = DbUtil.getConnection();
		
		String sql = "delete from dept where dept_id = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, deptId);
		
		//ִ��sql���
		pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
	}
	/**
	 * ����id��ѯ���ص������� 
	 * @param deptId
	 * @return
	 * @throws SQLException 
	 */
	
	public Dept queryById(int deptId) throws SQLException {
		//������ݿ�����
		Connection conn = DbUtil.getConnection();
				
		String sql = "select * from dept where dept_id = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
			
		pstmt.setInt(1, deptId);
				
		//ִ��sql���
		ResultSet rs = pstmt.executeQuery();
		
		Dept dept = null;
		
		if(rs.next()) {

			dept = new Dept(rs.getInt(1),rs.getString(2),rs.getString(3));
	
		}
		rs.close();
		pstmt.close();
		conn.close();
		
		return dept;
	}
	/**
	 *  ��ѯ�������� 
	 *  @param 
	 * @throws SQLException 
	 */
	public List<Dept> query() throws SQLException {
		// ������ݿ�����
		Connection conn = DbUtil.getConnection();

		ArrayList<Dept> list = new ArrayList<Dept>();

		String sql = "select * from dept ";
		PreparedStatement pstmt = conn.prepareStatement(sql);

		ResultSet rs = null;
		// ִ��sql���
		rs = pstmt.executeQuery();

		while (rs.next()) {
			Dept dept = new Dept();
			dept.setDeptId(rs.getInt(1));
			dept.setDeptName(rs.getString(2));
			dept.setDeptLoc(rs.getString(3));

			list.add(dept);
		}
		rs.close();
		pstmt.close();
		conn.close();
		
		
		return list;
	}
}
