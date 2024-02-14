package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Employee;

@WebServlet("/update")
public class updatedata extends HttpServlet{
	private static Connection connection=null;
	@Override
	public void init() throws ServletException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/advancejavaservlet","root","hrutik");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int empId=Integer.parseInt(req.getParameter("empId"));
		String empName=req.getParameter("empName");
		String empDesignation=req.getParameter("empDesignation");
		String empType=req.getParameter("empType");
		double empSalary=Double.parseDouble(req.getParameter("empSalary"));
		String empDepartment=req.getParameter("Department");
		String empImage=req.getParameter("empImage");
		
		
		PrintWriter pw=resp.getWriter();
		
		ArrayList<Employee> data2=DisplayEmployeeData.data;
		
		String query="update Employee set emp_name=?,emp_designation=?,emp_type=?,emp_salary=?, emp_dept=?,emp_image=? where emp_id=?";
		
		try {
			PreparedStatement pstmt=connection.prepareStatement(query);
			
			
			for(Employee e: data2) {
				if(e.getEmpId()==(empId)) {
					
//					pstmt.setInt(1, 0);
//					pstmt.setString(2, e.getEmpName());
//					pstmt.setString(3, e.getEmpDesignation());
//					pstmt.setString(4,e.getEmpType());
//					pstmt.setDouble(5, e.getEmpSalary());
//					pstmt.setString(6, e.getEmpDept());
//					pstmt.setString(7, e.getEmpImage());
					pstmt.setString(1, empName);
					pstmt.setString(2, empDesignation);
					pstmt.setString(3, empType);
					pstmt.setDouble(4, empSalary);
					pstmt.setString(5, empDepartment);
					pstmt.setString(6,empImage);
					pstmt.setInt(7, empId);
					e.setEmpName(empName);
					e.setEmpDept(empDepartment);
					e.setEmpDesignation(empDesignation);
					e.setEmpImage(empImage);
					e.setEmpSalary(empSalary);
					e.setEmpType(empType);
					
					int count=pstmt.executeUpdate();
					
					pw.print("<html><body>");
					pw.print("<h4>data Updated Successfully</h4>");
					pw.print("</body></html>");
					break;
					
				}else {
					pw.print("<h4>something went wrong </h4>");
				}
		}
		}
		catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		}
		//pw.print("<a href="">")
	}
