package controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cliente;
import model.ClienteDAO;

@WebServlet("/editar")
public class AlterarClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		
		int idCliente = Integer.parseInt(req.getParameter("id"));
	
		
		
		ClienteDAO cdao = new ClienteDAO();
		
		
		Cliente clienteSelecionado = cdao.getClienteById(idCliente);
		
		
		
		req.setAttribute("cliente", clienteSelecionado);
	
		RequestDispatcher rd = req.getRequestDispatcher("/alterarCliente.jsp");

        rd.forward(req, resp);
        
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cliente clienteAlterado = new Cliente();		
		clienteAlterado.setNome(req.getParameter("nome"));
		
		clienteAlterado.setEmail(req.getParameter("email"));
		clienteAlterado.setEndereco(req.getParameter("endereco"));
		clienteAlterado.setUsuario(req.getParameter("usuario"));
		clienteAlterado.setSenha(req.getParameter("senha"));
		clienteAlterado.setId(Integer.parseInt(req.getParameter("id")));
		
		ClienteDAO cd = new ClienteDAO();
		cd.update(clienteAlterado);	
		
		resp.sendRedirect("home");
		
		
	}

}