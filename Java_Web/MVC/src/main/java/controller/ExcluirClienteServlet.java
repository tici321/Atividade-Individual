package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ClienteDAO;

@WebServlet("/excluir")
public class ExcluirClienteServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int idCliente = Integer.parseInt(req.getParameter("id"));
//		Cliente clienteExcluido = new Cliente();
//		clienteExcluido.setId(idCliente);

		ClienteDAO cdao = new ClienteDAO();

		cdao.deleteByIdCliente(idCliente);

		resp.sendRedirect("home");
	}

}