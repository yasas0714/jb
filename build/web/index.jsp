


<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%

String driver = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/";
String database = "juice_bar";
String userid = "root";
String password = "";
try {
Class.forName(driver);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}
Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>
<!DOCTYPE html>
<html>
    <head>
        <style>
               
            body{
                background-image: url("images/juice1.jpg");              
                background-repeat: no-repeat;
                background-size:cover;
            }

         
            #T{
                font-size: 31px;
                text-align: center;
           
            }
            #a{
                 
                float:right; 
                background-color:rgba(245, 245, 245, 0.7);
                text-align: center;
                border: 2px solid black;
                border-radius: 12px;    
                height: 50%;
                width: 30%;
                
  
            }    
            #t1{
                font-size: 30px;
                width: 50%;
                border-bottom: 1px solid #ddd;
                color:red;
                font-weight: bold;
                background-color: rgba(0, 0, 0, 0.71);
            }
            th {
            background-color: #4CAF50;
                color: white;
                }
             td {
                 padding: 8px;
                 text-align: left;
                 border-bottom: 1px solid #ddd;
                }
            tr:hover {background-color:gray;}
</style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <title>Juice bar</title>
    </head>
    <body>
    <div id="T">
    <h1>JUICE BAR</h1>
    </div>
    <div id="a">
     <%@include file="login.jsp" %>
     <a href="register.jsp"><h3>Sign up</h3></a>
    </div>
    <div id="st">
     <h1>Select your Orders</h1>
    </div>   
     
 <div id="b">
<table  id="t1">
<tr>
<th>Product code</th>
<th>Product name</th>
<th>Price</th>


</tr>

<%
try{
connection = DriverManager.getConnection(connectionUrl+database, userid, password);
statement=connection.createStatement();
String sql ="select * from juice";
resultSet = statement.executeQuery(sql);

while(resultSet.next()){
%>

<tr>
<td><%=resultSet.getString("pcode") %></td>
<td><%=resultSet.getString("pname") %></td>
<td><%=resultSet.getString("price") %></td>



</tr>
<%
}
connection.close();
} catch (Exception e) {
e.printStackTrace();
}
%>
    </table>
    
    <table id="t2">
        <form action="./userorder1" method="post">
        <tr>
         <th>Product code</th>
          <td><input type="text"  name="pcode" required></td>
          </tr>
        <tr>
        <th>Qty</th>
        <td><input type="int"  name="qty" required></td>
        </tr>
        <tr>
        <th>Require Date</th>
          <td><input type="date" id="date" name="odate" required></td>
        </tr>
        <tr>
        <td><input type="submit" name="order" value="ODER" ></td>
        </tr>
 </form>
    </table>
    </div>
    </body>
</html>
