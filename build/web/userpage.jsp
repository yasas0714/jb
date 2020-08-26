

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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Page</title>
        <style>
             body{
                background-image: url("images/juice3.jpg");              
                background-repeat: no-repeat;
                background-size:cover;
            }
            #t1{
                 margin-left:auto; margin-right:auto;
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
            #t2{
                 margin-left:auto; margin-right:auto;
                font-size: 30px;
                width: 30%;
                border-bottom: 1px solid #ddd;
                color:red;
                font-weight: bold;
                background-color: rgba(0, 0, 0, 0.81);
            }
             h1{
                text-align: center;
                color: red;
                background-color: white;
            }
        </style>
    </head>
    <body>
       <h1>SELECT YOUR ORDER</h1>
<table id="t1">
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
<td><%String pri=resultSet.getString("price") ;
   double price1=Double.parseDouble(pri);
    double  price2 = price1*0.95;
    out.print(price2);
    %></td>



</tr>
<%
}
connection.close();
} catch (Exception e) {
e.printStackTrace();
}
%>
    </table>
    <br><br>
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
    </body>
</html>
