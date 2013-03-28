<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>    
<!doctype html>
<html>
<head>
<meta charset="UTF-8" />
<title>Demo</title>
</head>
<body>
<s:form action="login" method="post">  
        <s:textfield name="username" label="username"></s:textfield>  
        <s:password name="password" label="password"></s:password>  
        <s:submit label="submit"></s:submit>  
    </s:form>  
</body>
</html>