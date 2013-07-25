package no.tm.bryllupsliste;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Server;
//import org.eclipse.jetty.servlet.ServletContextHandler;
//import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.webapp.WebAppContext;

public class BryllupServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();

		writer.append("<html><body>").append("<h1>Bryllupsliste!</h1>")
				.append("</body></html>");
	}

	public static void main(String[] args) throws Exception {
		String portString = System.getenv("PORT");
		String nyPortString = portString == null ? "5000" : portString;
		Server server = new Server(Integer.valueOf(nyPortString));
//		ServletContextHandler context = new ServletContextHandler(
//				ServletContextHandler.SESSIONS);
//		context.setContextPath("/");
//		server.setHandler(context);
//		context.addServlet(new ServletHolder(new BryllupServlet()), "/*");
//		server.start();
//		server.join();
//		
		server.setHandler(new WebAppContext("src/main/webapp", "/"));
		server.start();
	}
	


}
