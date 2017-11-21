package com.icss.hr.dept.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.hr.dept.service.DeptService;

/**
 * ɾ�����ſ�����
 */
@WebServlet("/DelDeptServlet")
public class DelDeptServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ò���ID
		String deptId = request.getParameter("deptId");
		
		//����ҵ�����
		DeptService service = new  DeptService();
		
		try {
			service.deleteDept(Integer.parseInt(deptId));
			//�ض��򵽲�ѯҳ��
			response.sendRedirect("QueryDeptServlet");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
