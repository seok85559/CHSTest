package com.employee.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.employee.dto.EmployeeDTO;
import com.employee.service.EmployeeService;

import batch.SelectStudentLowScore;
import batch.TestCronTrigger;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {

	private EmployeeService employeeService;

	public MainController(EmployeeService employeeService) {
		this.employeeService = employeeService;
		TestCronTrigger trigger = new TestCronTrigger("0 0 12 1 1 ? *", SelectStudentLowScore.class);
		trigger.triggerJob();
	}

	@RequestMapping("/")
	public String index() {
		return "login";
	}

	@PostMapping("/login")
	public String login(String eno, String name, HttpSession session, HttpServletResponse response) throws IOException {
		System.out.println("login");
		EmployeeDTO employee = employeeService.login(eno, name);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		if (employee == null) {
			pw.write("<script>alert('로그인 실패\\n아이디 비밀번호 확인하세요');location.href='/';</script>");
			return null;
		}
		session.setAttribute("employee", employee);

		return "redirect:/employee_main";
	}

	@RequestMapping("/main")
	public ModelAndView main(ModelAndView view) {
		List<EmployeeDTO> employeeList = employeeService.selectAllEmployee();

		view.addObject("employeeList", employeeList);
		view.setViewName("main");

		return view;
	}

	@RequestMapping("/employee/delete/{eno}")
	public String deleteEmployee(@PathVariable("eno") String eno) {
		employeeService.deleteEmployee(eno);
		return "redirect:/employee_main";
	}

}
