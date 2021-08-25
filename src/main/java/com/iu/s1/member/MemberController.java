package com.iu.s1.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

public class MemberController {
	
	private MemberDAO memberDAO;
	
	public MemberController() {
		memberDAO = new MemberDAO();
	}
	
	public void start(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("MemberController 실행");
		String uri = request.getRequestURI();
		int index = uri.lastIndexOf("/");
		
		
		String path=uri.substring(index+1);
		
		if(path.equals("memberLogin.do")) {
			System.out.println("로그인 진행");
			String value= request.getParameter("id");
			System.out.println(value);
			String pw = request.getParameter("pw");
			System.out.println(pw);
			
		}else if(path.equals("memberJoin.do")) {
			System.out.println("회원가입 진행");
			String method = request.getMethod();
			
			if(method.equals("POST")) {
				MemberDTO memberDTO = new MemberDTO();
				memberDTO.setId(request.getParameter("id"));
				memberDTO.setPw(request.getParameter("pw"));
				memberDTO.setName(request.getParameter("name"));
				memberDTO.setPhone(request.getParameter("phone"));
				memberDTO.setEmail(request.getParameter("email"));
				int result = memberDAO.memberJoin(memberDTO);
				
				if(result==1) {
					System.out.println("성공");
					try {
						response.sendRedirect("../index.jsp");
					} catch (IOException e) {
						e.printStackTrace();
					}
				}else {
					System.out.println("실패");
				}
			}else {
				RequestDispatcher view = request.getRequestDispatcher("../WEB-INF/views/member/memberJoin.jsp");
				try {
					view.forward(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}else if(path.equals("memberPage.do")) {
			System.out.println("myPage 진행");
		}else {
			System.out.println("그 외 나머지");
		}
		
	}

}
