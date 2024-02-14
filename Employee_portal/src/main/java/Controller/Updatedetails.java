package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Employee;

@WebServlet("/updateDetails")
public class Updatedetails extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		long empId=Long.parseLong(req.getParameter("emp_id"));
		
		ArrayList<Employee> data1 =DisplayEmployeeData.data;
		
		Employee e1=null;
		for(Employee e: data1) {
			if(e.getEmpId()==empId) {
				e1=e;
				break;
			}
		}
		PrintWriter pw=resp.getWriter();
		
		pw.print("<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "<meta charset=\"ISO-8859-1\">\r\n"
				+ "<title>Employee Portal</title>\r\n"
				+ "<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN\" crossorigin=\"anonymous\">\r\n"
				+ "</head>\r\n"
				+ "\r\n"
				+ "<body>");
		pw.print("<body>");
		pw.print("<div align=\"center\" class=\"rounded\">\r\n"
				+ "<h1 class=\"fw-light\">EMPPLOYEE PORTAL</h1><br>");
		pw.print("<form action=update >");
		pw.print("<label>Enter Employee ID :</label>");
		pw.print("\"<input type=\\\"text\\\" name='empId' value="+e1.getEmpId()+" readonly><br><br>\"");
		pw.print("<label>Enter Employee Name :</label>\r\n"
				+ "<input type=\"text\" name='empName' placeholder=\"Akshay\"value="+e1.getEmpName()+" ><br><br>");
		pw.print("<label>Enter Employee Designation :</label>\r\n"
				+ "<input type=\"text\" name='empDesignation' placeholder=\"Manager\" value="+e1.getEmpDesignation()+"><br><br>");
		pw.print("<label>Select Employee Type :</label>\r\n"
				+ "<input type=\"radio\" name='empType' value=\"Permanent\" placeholder=\"Akshay\">Permenent \r\n"
				+ "<input type=\"radio\" name='empType' value=\"Contract-Based\" >Contract-based<br><br>");
		pw.print("<label>Enter Employee Salary :</label>\r\n"
				+ "<input type=\"text\" name='empSalary' placeholder=\"34999.99\" value="+e1.getEmpSalary()+"><br><br>");
		pw.print("<label>Enter Employee Department : </label>\r\n"
				+ "<select name=\"Department\">\r\n"
				+ "<option name=\"Department\" value=\"Development\">Development</option>\r\n"
				+ "<option name=\"Department\" value=\"Testing\">Testing</option>\r\n"
				+ "<option name=\"Department\" value=\"Performance Engineer\">Performance Engineer</option>\r\n"
				+ "<option name=\"Department\" value=\"Sales\">Sales</option>\r\n"
				+ "</select><br><br>");
		pw.print("<label>Enter Employee Image Link :</label>\r\n"
				+ "<input type=\"text\" name='empImage'value="+e1.getEmpImage().toString()+" ><br>\r\n"
				+ "<br>\r\n"
				+ "<br>");
		pw.print("<input type=submit class=\"btn btn-primary\" value=\"Update Employee\">");
		pw.print("<body></html>");
		
		
		
	}
}
