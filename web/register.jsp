
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>REG</title>
    </head>
    <body>
    <h1>Registation Form</h1>
        
        
        <div id="t1">   
         <form action="./Register" method="POST">
             <table>
                <tr>
                  <td>First Name:</td>
                  <td><input type="text" name="fname"></td>
                </tr>  
                <tr>
                  <td>Middle Name:</td>
                  <td><input type="text" name="mname"></td>
                </tr>
                <tr>
                    <td>Last Name:</td>
                  <td><input type="text" name="lname"></td>
                </tr>   
                    
                <tr>
                  <td>Address:</td>
                  <td><input type="text" name="address" ></td>
                </tr> 
                <tr>
                    <td>Date Of Birth:</td>
                    <td><input type="date" id="date" name="bdate"> </td>
                </tr>
                <tr>
                    <td>
                        Gender:
                    </td>
                    <td><input type="radio" name="gender" value="male" >Male<br><input type="radio" name="gender" value="female" >Female</td>
                </tr>
                <tr>
                    <td>Tel:</td>
                    <td><input type="tel" name="tel"></td>
                </tr>
                <tr>
                    <td>Username</td>
                    <td><input type="text" name="uname"></td>
                </tr>
                <tr>
                    <td>password</td>
                    <td><input type="text" name="pass"></td>
                </tr>
                 <tr>
                    <td>Email</td>
                    <td><input type="text" name="email"></td>
                </tr>
                <tr>
                    <td>
                  <input type="submit" name="submit" value="Submit">
                  <input type="reset" value="Clear">
                    </td>
                </tr>  
             </table>
        </form>
        </div>    
    </body>
</html>
