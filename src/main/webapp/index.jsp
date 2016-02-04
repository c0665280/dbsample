<%-- 
    Document   : index
    Created on : 26-Jan-2016, 4:17:32 PM
    Author     : c0662834
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dbsample.DBSample" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%=DBSample.getTable()%>
    </body>
</html>
