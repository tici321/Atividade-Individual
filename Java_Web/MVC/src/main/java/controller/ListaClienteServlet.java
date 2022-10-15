package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cliente;
import model.ClienteDAO;

@WebServlet("/home")
public class ListaClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Cliente> banco = new ArrayList<Cliente>();
		ClienteDAO cdao = new ClienteDAO();		
		banco = cdao.getCliente();		
		req.setAttribute("listaCliente", banco);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("salvarcliente.jsp");
		dispatcher.forward(req, resp);
		
		
	}

}
