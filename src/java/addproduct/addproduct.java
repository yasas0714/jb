
package addproduct;

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


public class addproduct extends HttpServlet {

    
    

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String pcode= request.getParameter("pcode");
      String pname= request.getParameter("pname");
      String price= request.getParameter("price");
      PrintWriter out=response.getWriter();
          try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/juice_bar","root","");
                Statement st = con.createStatement();    
                 st.executeUpdate("insert into juice(pcode,pname,price)values('"+pcode+"','"+pname+"','"+price+"')");
                 out.println("success");
          }catch(ClassNotFoundException | SQLException e){
                
                out.println(e);
            }
    }

}
