
package authentication;
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static org.apache.tomcat.jni.User.username;


public class authentication extends HttpServlet {


    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          PrintWriter out = response.getWriter();
         try{
          Class.forName("com.mysql.jdbc.Driver");
          Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/juice_bar","root","");
             String   uname1 = request.getParameter("uname"); 
             String   pass1  = request.getParameter("pass"); 

             
            String q = "select * from user_reg where username='"+uname1+"' and password='"+pass1+"'";
             Statement st; 
              st = con.createStatement();
                
             ResultSet row=st.executeQuery(q);
             while(row.next()){
                 
             
               if("admin".equals(row.getString("role")))
               {
                  response.sendRedirect("adminpage.jsp");
               }
               else if("customer".equals(row.getString("role")))
               {
                   response.sendRedirect("userpage.jsp");
               }else 
               {
                  out.println("Invalid password or username.");
               }
         }
               
      st.close();
    }
    catch (ClassNotFoundException | SQLException e)
    {
      System.err.println("Got an exception! ");
      System.err.println(e.getMessage());
    }
       
    }

}
