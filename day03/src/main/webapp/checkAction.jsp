<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 
 
 <%
 
 request.setCharacterEncoding("utf-8");
 
 String[] hobbys  = request.getParameterValues("hobby"); 
 for( String hobby : hobbys){
	 out.println( hobby);
 } 
 %>