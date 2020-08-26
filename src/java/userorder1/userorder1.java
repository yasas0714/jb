/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userorder1;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Class.forName;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class userorder1 extends HttpServlet {

   
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      PrintWriter out=response.getWriter();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/juice_bar","root","");
            Statement st=con.createStatement();
            
            String qty1=request.getParameter("qty");
            String odate1=request.getParameter("odate");
            String pcode1=request.getParameter("pcode");
             Calendar calendar = Calendar.getInstance();
            String startDate="12-31-2014";
            SimpleDateFormat sdf1 = new SimpleDateFormat("MM-dd-yyyy");
            java.util.Date date = sdf1.parse(odate1);
            java.sql.Date odate2 = new java.sql.Date(date.getTime());
              st.executeUpdate("insert into orders(pcode,date,qty) values ( '"+pcode1+"','"+odate2+"','"+qty1+"')"); 
            out.print ("success order");
           
        }catch(ClassNotFoundException | SQLException e){
        out.print(e);
        } catch (ParseException ex) {
            Logger.getLogger(userorder1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
