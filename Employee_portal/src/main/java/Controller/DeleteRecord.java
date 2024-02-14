package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Employee;

@WebServlet("/deleteRecord")
public class DeleteRecord extends HttpServlet {
	private static Connection connection=null;
	ArrayList<Employee> data=DisplayEmployeeData.data;
	
	@Override
	public void init() throws ServletException {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/advancejavaservlet","root","hrutik");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String deleteQuery="delete from employee where emp_id=?";
		String employeeId=req.getParameter("emp_id");
		PrintWriter pw=resp.getWriter();
		for(Employee e:data) {
			if(e.getEmpId()==Integer.parseInt(employeeId)) {
				try {
					PreparedStatement pstmt=connection.prepareStatement(deleteQuery);
					pstmt.setInt(1, Integer.parseInt(employeeId));
					int count=pstmt.executeUpdate();
					
					if(count>0) {
						pw.print("<html><body>");
						pw.print("<h4>Record deleted Successfully</h4>");
						pw.print("<a href=seeData>Display Employee List</a>");
						pw.print("</body></html>");
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				break;
				
			}
		}
	}

}
