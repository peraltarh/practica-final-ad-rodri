package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import clienteWeb.WebController;

/**
 * Servlet implementation class Req1
 */
@WebServlet("/Req1")
public class Req1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Req1() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String desc = request.getParameter("descripcion");
		String mat = request.getParameterValues("matPrima")[0];
		String un = request.getParameterValues("unidad")[0];
		String cost = request.getParameter("costo");
		String res = WebController.getInstancia().altaPedidoSemi(desc, mat, un, cost);
		request.setAttribute("respuesta", res);
		
		RequestDispatcher dispacher = request.getRequestDispatcher("index.jsp");
		dispacher.forward(request, response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
