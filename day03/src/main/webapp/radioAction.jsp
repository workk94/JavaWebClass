<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 
 <%
 
 
  String gender =request.getParameter("gender");
  System.out.println( gender); 
  out.println(" 응답" + gender);
  
  
  //
 %>
 
 
 <%= "응답" + gender %>