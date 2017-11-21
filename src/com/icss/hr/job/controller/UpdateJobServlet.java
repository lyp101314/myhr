package com.icss.hr.job.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.hr.job.pojo.Job;
import com.icss.hr.job.service.JobService;

/**
 * 根据id修改职务
 */
@WebServlet("/UpdateJobServlet")
public class UpdateJobServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//设置请求编码
		request.setCharacterEncoding("utf-8");
		//设置响应编码
		response.setContentType("text/html;charset=utf-8");
				
		//响应输出流
		PrintWriter out = response.getWriter();
				
		//获得请求参数
		String jobId = request.getParameter("jobId");
		String jobName = request.getParameter("jobName");
		String jobMinSal = request.getParameter("jobMinsal");
		String jobMaxSal = request.getParameter("jobMaxSal");
		
		Job job = new Job(Integer.parseInt(jobId),jobName,Integer.parseInt(jobMinSal),Integer.parseInt(jobMaxSal));
		
		//调用业务对象
		JobService service = new JobService();
		
		try {
			service.updateJob(job);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
