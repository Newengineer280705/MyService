package com.Myservlet;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
public class MyServletInterface implements Servlet{
	ServletConfig config;
	@Override
	public void destroy() {
		System.out.println("Servlet is Destroyed");
	}
	@Override
	public ServletConfig getServletConfig() {
		return config;
	}
	@Override
	public String getServletInfo() {
		return "My servlet Version 1.0";
	}
	@Override
	public void init(ServletConfig config) throws ServletException {
		this.config = config;
		System.out.println("Servlet is Intialized");
		System.out.println("Servlet Configuration->"+getServletConfig());
		System.out.println("Servlet Information->"+getServletInfo());
		destroy();
	}
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		pw.println("<html><body>");
		pw.println("<h1>Servlet By Implementing Servlet Interface</h1>");
		String str = getServletInfo();
		pw.print("Servlet Information->"+str);
		pw.println("</body></html>");
	}
}

