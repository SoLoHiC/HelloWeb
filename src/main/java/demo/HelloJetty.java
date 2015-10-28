package demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author chuck
 * @since 10/28/15
 */
public class HelloJetty extends HttpServlet{

//  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    resp.setContentType("text/html;charset=utf-8");
    resp.setCharacterEncoding("utf-8");
    PrintWriter out = resp.getWriter();
    out.println("<html>hello Jetty!</html>");
  }

}
