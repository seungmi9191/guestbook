package com.javaex.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaex.dao.GuestbookDao;
import com.javaex.vo.GuestVO;

@WebServlet("/Gb")
public class GuestbookController extends HttpServlet {
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println("애는 guestbook의 controller");
	
		String actionName=request.getParameter("a");
		System.out.println("a의 값은: " + actionName);
		
		if("add".equals(actionName)) {
			//add
			String name=request.getParameter("name");
			String password=request.getParameter("password");
			String content=request.getParameter("content");
			//String regDate=request.getParameter("regDate");
			
			GuestVO vo = new GuestVO(name, password, content, null);
			GuestbookDao dao = new GuestbookDao();
			dao.insert(vo);
			
			//add redirect
			response.sendRedirect("/gusetbook/Gb");
			System.out.println("얘는 add의 list");

		} else if("delete".equals(actionName)) {
			//delete
			//int idx=Integer.parseInt(request.getParameter("idx"));
			//System.out.println(idx);
			
			String no = request.getParameter("no");
			String password = request.getParameter("password");
			String pw_input = request.getParameter("pw_input");
			System.out.println(no + password+pw_input);
			
			if (password.equals(pw_input)) {
				GuestbookDao dao = new GuestbookDao();
				dao.list_delete(no);				
			} else {
				System.out.println("패스워드가 맞지 않습니다.");
				RequestDispatcher rd = request.getRequestDispatcher("deleteform.jsp");
				rd.forward(request, response);
			}
			
			
			
			//delete redirect
			response.sendRedirect("/gusetbook/Gb");
			System.out.println("얘는 delete의 list");
			
		} else if("deleteform".equals(actionName)) {
			//deleteform
			RequestDispatcher rd = request.getRequestDispatcher("deleteform.jsp");
			rd.forward(request, response);
			
		} else {
			//list
			GuestbookDao dao = new GuestbookDao();
			List<GuestVO> list = dao.getList();
			
			request.setAttribute("list", list);
			System.out.println(list);
			
			RequestDispatcher rd = request.getRequestDispatcher("list.jsp");
			rd.forward(request, response);
			
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}