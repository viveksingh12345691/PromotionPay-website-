

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Registration extends HttpServlet {

    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String n1=request.getParameter("name");
        String n2=request.getParameter("email");
        String n3=request.getParameter("message");
       
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jack","root","123456");
            System.out.print("connected");
            PreparedStatement ps=con.prepareStatement("insert into contact values(?,?,?)");
            ps.setString(1,n1);
            ps.setString(2,n2);
            ps.setString(3,n3);
            ps.executeUpdate();
            out.print("Message send");
            
                   RequestDispatcher rd=request.getRequestDispatcher("index.html");  
        rd.include(request, response);
                
            
             
        
        }
        catch(ClassNotFoundException | SQLException ex){ 
          out.println(" please provide Proper detail ");
         RequestDispatcher rd=request.getRequestDispatcher("Contact.html");  
        rd.forward(request, response);
                
           
        }
	}
}
      
   

 