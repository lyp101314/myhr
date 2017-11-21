package com.icss.hr.pic.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.hr.pic.pojo.Pic;
import com.icss.hr.pic.service.PicService;

/**
 * ����ͼƬId����ͼƬ����������
 */
@WebServlet("/GetPicServlet")
public class GetPicServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//�����
		OutputStream out = response.getOutputStream();
		//���ͼƬId
		String picId = request.getParameter("picId");
		
		//����ҵ�����
		PicService	service = new PicService();
		
		try {
			Pic pic = service.queryByIdPic(Integer.parseInt(picId));
		
			//���ͼƬ������
			InputStream is = pic.getPicData();
			//��Ӧ����
			byte[] b = new byte[1024*8];
			int len = is.read(b);
			
			while (len != -1) {
				out.write(b,0,len);
				len = is.read(b);
			}
			
			is.close();
			out.close();
			
		} catch (NumberFormatException | SQLException e) {
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
