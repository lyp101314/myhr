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
 * ����id�޸�ְ��
 */
@WebServlet("/UpdateJobServlet")
public class UpdateJobServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//�����������
		request.setCharacterEncoding("utf-8");
		//������Ӧ����
		response.setContentType("text/html;charset=utf-8");
				
		//��Ӧ�����
		PrintWriter out = response.getWriter();
				
		//����������
		String jobId = request.getParameter("jobId");
		String jobName = request.getParameter("jobName");
		String jobMinSal = request.getParameter("jobMinsal");
		String jobMaxSal = request.getParameter("jobMaxSal");
		
		Job job = new Job(Integer.parseInt(jobId),jobName,Integer.parseInt(jobMinSal),Integer.parseInt(jobMaxSal));
		
		//����ҵ�����
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
