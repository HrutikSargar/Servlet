package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.xdevapi.PreparableStatement;
@WebServlet("/saveEmployeeData")
public class AddEmployeeServlet extends HttpServlet {
	
	private static Connection connection=null;
	@Override
	public void init() throws ServletException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/advancejavaservlet","root","hrutik");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		addData(req, resp);
	}
	private void addData(HttpServletRequest req, HttpServletResponse resp) {
		String empName=req.getParameter("empName");
		String empDesignation=req.getParameter("empDesignation");
		String empType=req.getParameter("empType");
		double empSalary=Double.parseDouble(req.getParameter("empSalary"));
		String empDepartment=req.getParameter("Department");
		String empImage=req.getParameter("empImage");
		
		String insertData="insert into employee values(?,?,?,?,?,?,?)";
		
		try {
			PrintWriter pw=resp.getWriter();
			
			PreparedStatement pstmt=connection.prepareStatement(insertData);
			pstmt.setInt(1, 0);
			pstmt.setString(2, empName);
			pstmt.setString(3, empDesignation);
			pstmt.setString(4,empType);
			pstmt.setDouble(5, empSalary);
			pstmt.setString(6, empDepartment);
			pstmt.setString(7, empImage);
			int count=pstmt.executeUpdate();
			
			if(count>0) {
				pw.print("<html><head><link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN\" crossorigin=\"anonymous\">\r\n"
						+ "</head><body>");
				
				pw.print("<h3>"+count+"  Data Inserted Successfully</h3>");
				pw.print("<form action='seeData'>");
				
				pw.print("<a  href='AddEmployee.html'>Add Another Employee</a>");
				pw.print("<br><br>");
				pw.print("<button class=\"btn btn-primary\"  value='DisplayData'>Display Data</button>");
				
				pw.print("</form>");
				//pw.print(count+" Data Inserted Successfully");
				pw.print("</body></html>");
			}else {
				pw.print(" Something went wrong");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
