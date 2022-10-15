package controller;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cliente;
import model.ClienteDAO;


@WebServlet("/Inserir")
public class InserirClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String nome=request.getParameter("nome");
		String email=request.getParameter("email");
		String usuario=request.getParameter("usuario");
		String senha=request.getParameter("senha");
		String endereco=request.getParameter("endereco");
		
		Cliente cliente= new Cliente();
		cliente.setNome(nome);
		cliente.setEmail(email);
		cliente.setUsuario(usuario);
		cliente.setSenha(senha);
		cliente.setEndereco(endereco);
		RequestDispatcher rd= request.getRequestDispatcher("salvarcliente.jsp");
		rd.forward(request, response);
		
		ClienteDAO cdao = new ClienteDAO();		
		cdao.save(cliente);
		
		// Redirecionando o usuario para a pagina inicial da aplicação.
				response.sendRedirect("home");


		PrintWriter out=response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html lang='pt-br'>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Dados do cliente</title>");
		out.println("<!/head>");
		out.println("<body>");
		
		out.println("<h1> Dados do cliente</h1>");

		out.println("<p>");

		out.println("Nome: "+nome+"<br>");
		out.println("Email: " +email+"<br>");
		out.println("Usuario: "+ usuario +"<br>");
	
		out.println("Endereco: "+endereco);
		out.println("</p>");

		
		out.println("</body");

		out.println("</html>");


		
		
	}



		
		

		
		
	}

