package com.icss.hr.emp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.icss.hr.emp.pojo.Emp;
import com.icss.hr.emp.service.EmpService;

/**
 * ���ݵ�¼����ѯ�û�����
 */
@WebServlet("/QueryEmpByLoginNameServlet")
public class QueryEmpByLoginNameServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//��session��Χȡ����¼��
		HttpSession session = request.getSession();
		
		//�����
		PrintWriter out = response.getWriter();
		
		String empLoginName = (String)session.getAttribute("empLoginName");
		
		//����ҵ�����
		EmpService service = new EmpService();
		
		try {
			Emp emp = service.queryEmpByLoginName(empLoginName);
			
			//ת��Ϊjson������Ӧ��ǰ��
			Gson gson = new Gson();
			out.write(gson.toJson(emp));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
