package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;

public final class adminpage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");


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

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>admin Page</title>\n");
      out.write("        <style>\n");
      out.write("                        body{\n");
      out.write("                \n");
      out.write("                background-image: url(\"images/juice4.jpg\");              \n");
      out.write("                background-repeat: no-repeat;\n");
      out.write("                background-size:cover;\n");
      out.write("            \n");
      out.write("            }\n");
      out.write("            #t1{\n");
      out.write("                margin-left:auto; margin-right:auto; \n");
      out.write("                font-size: 20px;\n");
      out.write("                width: 30%;\n");
      out.write("                border-bottom: 1px solid #ddd;\n");
      out.write("                color:white;\n");
      out.write("                font-weight: bold;\n");
      out.write("                background-color: rgba(0, 0, 0, 0.71);\n");
      out.write("            }\n");
      out.write("            #t2{\n");
      out.write("                 margin-left:auto; margin-right:auto;\n");
      out.write("                font-size: 30px;\n");
      out.write("                width: 30%;\n");
      out.write("                border-bottom: 1px solid #ddd;\n");
      out.write("                color:red;\n");
      out.write("                font-weight: bold;\n");
      out.write("                background-color: rgba(0, 0, 0, 0.81);\n");
      out.write("            }\n");
      out.write("           \n");
      out.write("             td {\n");
      out.write("                 padding: 8px;\n");
      out.write("                 text-align: left;\n");
      out.write("                 border-bottom: 1px solid #ddd;\n");
      out.write("                }\n");
      out.write("            tr:hover {background-color:gray;}\n");
      out.write("            h1{\n");
      out.write("                text-align: center;\n");
      out.write("                color: white;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("       <form action=\"./addproduct\" method=\"POST\">\n");
      out.write("           <table id=\"t1\">\n");
      out.write("                <tr>\n");
      out.write("                  <td>Product code:</td>\n");
      out.write("                  <td><input type=\"text\" name=\"pcode\"></td>\n");
      out.write("                </tr>  \n");
      out.write("                <tr>\n");
      out.write("                  <td>Product Name:</td>\n");
      out.write("                  <td><input type=\"text\" name=\"pname\"></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Price Of Product</td>\n");
      out.write("                  <td>Rs:<input type=\"text\" name=\"price\"></td>\n");
      out.write("                </tr>   \n");
      out.write("                <tr>\n");
      out.write("                    <td>\n");
      out.write("                  <input type=\"submit\" name=\"submit\" value=\"Submit\">\n");
      out.write("                  <input type=\"reset\" value=\"Clear\">\n");
      out.write("                    </td>\n");
      out.write("                </tr>  \n");
      out.write("             </table>\n");
      out.write("           <table id=\"t2\">\n");
      out.write("<tr>\n");
      out.write("<td>Product code</td>\n");
      out.write("<td>Qty</td>\n");
      out.write("<td>Require Date</td>\n");
      out.write("\n");
      out.write("</tr>\n");
      out.write("\n");

try{
connection = DriverManager.getConnection(connectionUrl+database, userid, password);
statement=connection.createStatement();
String sql ="select * from orders";
resultSet = statement.executeQuery(sql);

while(resultSet.next()){

      out.write("\n");
      out.write("\n");
      out.write("<tr>\n");
      out.write("<td>");
      out.print(resultSet.getString("pcode") );
      out.write("</td>\n");
      out.write("<td>");
      out.print(resultSet.getInt("qty") );
      out.write("</td>\n");
      out.write("<td>");
      out.print(resultSet.getDate("date"));
      out.write("</td>\n");
      out.write("\n");
      out.write("\n");
      out.write("</tr>\n");

}
connection.close();
} catch (Exception e) {
e.printStackTrace();
}

      out.write("\n");
      out.write("    </table>\n");
      out.write("           \n");
      out.write("        </form>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
