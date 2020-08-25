

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
        <title>admin Page</title>
        <style>
                        body{
                
                background-image: url("images/juice2.jpg");              
                background-repeat: no-repeat;
                background-size:cover;
            
            }
            #t1{
                margin-left:auto; margin-right:auto; 
                font-size: 20px;
                width: 30%;
                border-bottom: 1px solid #ddd;
                color:white;
                font-weight: bold;
                background-color: rgba(0, 0, 0, 0.71);
            }
            #t2{
                 margin-left:auto; margin-right:auto;
                font-size: 30px;
                width: 30%;
                border-bottom: 1px solid #ddd;
                color:red;
                font-weight: bold;
                background-color: rgba(0, 0, 0, 0.81);
            }
           
             td {
                 padding: 8px;
                 text-align: left;
                 border-bottom: 1px solid #ddd;
                }
            tr:hover {background-color:gray;}
            h1{
                text-align: center;
                color: white;
            }
        </style>
    </head>
    <body>
       <form action="./addproduct" method="POST">
           <table id="t1">
                <tr>
                  <td>Product code:</td>
                  <td><input type="text" name="pcode"></td>
                </tr>  
                <tr>
                  <td>Product Name:</td>
                  <td><input type="text" name="pname"></td>
                </tr>
                <tr>
                    <td>Price Of Product</td>
                  <td>Rs:<input type="text" name="price"></td>
                </tr>   
                <tr>
                    <td>
                  <input type="submit" name="submit" value="Submit">
                  <input type="reset" value="Clear">
                    </td>
                </tr>  
             </table>
           <table id="t2">
<tr>
<td>Product code</td>
<td>Qty</td>
<td>Require Date</td>

</tr>

<%
try{
connection = DriverManager.getConnection(connectionUrl+database, userid, password);
statement=connection.createStatement();
String sql ="select * from orders";
resultSet = statement.executeQuery(sql);

while(resultSet.next()){
%>

<tr>
<td><%=resultSet.getString("pcode") %></td>
<td><%=resultSet.getInt("qty") %></td>
<td><%=resultSet.getDate("date")%></td>


</tr>
<%
}
connection.close();
} catch (Exception e) {
e.printStackTrace();
}
%>
    </table>
           
        </form>
    </body>
</html>
