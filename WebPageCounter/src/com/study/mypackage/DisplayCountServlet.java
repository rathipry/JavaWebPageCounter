package com.study.mypackage;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DisplayCountServlet
 */
@WebServlet("/countpage")
public class DisplayCountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PageCounter pg;
	static int pageCount = 0;
	PageCounterImpl pageCounterImpl = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DisplayCountServlet() {
		super();
		// reading page count from file
		// pg = new PageCounter();
		// pageCount = pg.getPageCount();
		
		
		//reading page count from database
		pageCounterImpl = new PageCounterImpl();
		pageCount = pageCounterImpl.readPageCount();	
	}

	/**
	 * Evwrytime the page is refreshed, 
	 * this method will be called by webserver.
	 * Count will be increased and send the count back to UI.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		++pageCount;
		request.setAttribute("count", pageCount);
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);

	}

	//When server stops, destroy will be called and it will save the count to the database.
	public void destroy() {
		pageCounterImpl.savePageCount(pageCount);
		//this.pg.writeFile(pageCount);
		super.destroy();
	}

}
