package com.icss.hr.emp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.hr.dept.pojo.Dept;
import com.icss.hr.emp.pojo.Emp;
import com.icss.hr.emp.service.EmpService;
import com.icss.hr.job.pojo.Job;

/**
 * 修改员工控制器
 */
@WebServlet("/UpdateEmpServlet")
public class UpdateEmpServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		//设置请求编码
		request.setCharacterEncoding("utf-8");
		//设置响应编码
		response.setContentType("text/html;charset=utf-8");
		
		//响应输出流
		PrintWriter out = response.getWriter();
		
		//获得请求参数
		String empId = request.getParameter("empId");
		String empName = request.getParameter("empName");
		String empPhone = request.getParameter("empPhone");
		
		String empSalary =request.getParameter("empSalary");
		String deptId = request.getParameter("deptId");
		String jobId = request.getParameter("jobId");
		String empInfo = request.getParameter("empInfo");
		
		//封装对象
		Dept dept = new Dept();
		dept.setDeptId(Integer.parseInt(deptId));
		
		Job job = new Job();
		job.setJobId(Integer.parseInt(jobId));
		
		Emp emp = new Emp(Integer.parseInt(empId),empName,null,null,null,empPhone,Double.parseDouble(empSalary),
				null,dept,job,null,empInfo);
		
		//调用业务对象
		EmpService service = new EmpService();
		
		try {
			service.updateEmp(emp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
