package Controller;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Employee;

@WebServlet(urlPatterns = {"/seeData","/ascName","/descName","/ascSalary","/descSalary"})
public class DisplayEmployeeData extends HttpServlet {
	private static Connection connection=null;
	static ArrayList<Employee> data=null;
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
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//getdata(req,resp);
		String path=req.getServletPath();
		
		switch (path) {
		case "/seeData": 
			getdata();
			traverseArrayList(req, resp);
			break;
		case "/ascName":
			Collections.sort(data,new NameComparatorClass());
			//getdata();
			traverseArrayList(req, resp);
			break;
		case "/descName":
			Collections.sort(data,new NameComparatorClass());
			Collections.reverse(data);
			traverseArrayList(req, resp);
			break;
		case "/ascSalary":
			Collections.sort(data);
			traverseArrayList(req, resp);
			break;
		case "/descSalary":
			Collections.sort(data,new SalaryComparatorClass());
			Collections.reverse(data);
			traverseArrayList(req, resp);
		}
	}
	
	private void traverseArrayList(HttpServletRequest req, HttpServletResponse resp) {
		PrintWriter pw;
		try {
			pw = resp.getWriter();
//			Employee e2=new Employee();
			pw.print("<!DOCTYPE html>\r\n"
					+ "<html>\r\n"
					+ "<head>\r\n"
					+ "<meta charset=\"ISO-8859-1\">\r\n"
					+ "<title>Employee Portal</title>\r\n"
					+ "<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN\" crossorigin=\"anonymous\">\r\n"
					+ "</head>\r\n"
					+ "\r\n"
					+ "<body>");
			pw.print("<a href='ascName'>ascending by Name</a> <br>");
			pw.print("<a href='descName'>Descending by Name</a> <br>");
			pw.print("<a href=ascSalary>Ascending byy salary</a> <br>");
			pw.print("<a href=descSalary>Descending by salary</a> <br>");
			
			for(Employee e:data) {
				pw.print("<center><div class=\"card align-items-center\" style=\"width: 18rem;\">\r\n"
						+ "  <img src="+e.getEmpImage()+" class=\"card-img-top\" alt=\"...\">\r\n"
						+ "  <div class=\"card-body\">\r\n"
						+"<h5 class=\\\"card-title\\\" >"+e.getEmpId()+"</h5>"
						+ "    <h5 class=\"card-title\" >"+e.getEmpName()+"</h5>\r\n"
						+ "    <p class=\"card-text\">"+e.getEmpDesignation()+"</p>\r\n"
						+ "    <p class=\"card-text\">"+e.getEmpSalary()+"</p>\r\n"
						+ "    <a href=\"updateDetails?emp_id="+e.getEmpId()+"\" class=\"btn btn-primary\">Update Details</a><br>\r\n"
						
						+"<button class=\"btn btn-primary\"><a style='color:white;''href='deleteRecord?emp_id="+e.getEmpId()+"' >Delete Employee</a></button>"
					
						+ "  </div>\r\n"
						+ "</div></center>");
			}
			pw.print("</body></html>");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

	private void getdata() {
		
		String display="select * from employee";
		data=new ArrayList<Employee>();
		
		try {
		
			PreparedStatement pstmt=connection.prepareStatement(display);
			ResultSet rs=pstmt.executeQuery();
			
			Employee e1;
			while(rs.next()){
				e1=new Employee();
				e1.setEmpId(rs.getInt(1));
				e1.setEmpName(rs.getString(2));
				e1.setEmpDesignation(rs.getString(3));
				e1.setEmpType(rs.getString(4));
				e1.setEmpSalary(rs.getDouble(5));
				e1.setEmpDept(rs.getString(5));
				e1.setEmpImage(rs.getString(7));
				
				data.add(e1);
			}
			
			//disData(req,resp);
			
			
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
