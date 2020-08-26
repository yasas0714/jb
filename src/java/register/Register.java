
package register;



import java.io.IOException;
import java.io.PrintWriter;

import java.sql.DriverManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.xml.bind.DatatypeConverter.parseDate;

public class Register extends HttpServlet {

 
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            String fname= request.getParameter("fname");
            String mname= request.getParameter("mname");
            String lname= request.getParameter("lname");
            String gender= request.getParameter("gender");
            String uname= request.getParameter("uname");
            String pass= request.getParameter("pass");
            String address= request.getParameter("address");
            String tel= request.getParameter("tel");
            String email= request.getParameter("email");
            String customer= "customer";
            String bdate1=request.getParameter("bdate");
            
            Calendar calendar = Calendar.getInstance();
            String startDate="12-31-2014";
            SimpleDateFormat sdf1 = new SimpleDateFormat("MM-dd-yyyy");
            java.util.Date date = sdf1.parse(bdate1);
            java.sql.Date bdate2 = new java.sql.Date(date.getTime());
            
            System.out.println(bdate2);
            PrintWriter out=response.getWriter();
            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/juice_bar","root","");
                Statement st = con.createStatement();
                
                st.executeUpdate("insert into user_reg(fname,mname,lname,username,user_address,password,tel,role,bdate,gender,email) values('"+fname+"','"+mname+"','"+lname+"','"+uname+"','"+address+"','"+pass+"','"+tel+"','"+customer+"','"+bdate2+"','"+gender+"','"+email+"')");
                out.println("success");
            }catch(ClassNotFoundException | SQLException e){
                
                out.println(e);
            }
            
            
        }catch(ParseException ex){
            
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null,ex);
        }
      
      
    }
}
