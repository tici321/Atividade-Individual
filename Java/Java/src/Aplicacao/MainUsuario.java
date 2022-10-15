package Aplicacao;

import DAO.UsuarioDAO;
import modelo.Usuario;

public class MainUsuario {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Usuario usuario=new Usuario();
		
		usuario.setNome("Pedro");
		usuario.setEndereco("Rua Oliveira");
		usuario.setUsuario("pedrinho");
		usuario.setSenha("321");
		usuario.setEmail("pedrooliveira");
		
		UsuarioDAO usuarioDao=new UsuarioDAO();
		//usuarioDao.save(usuario);
		
		//att
		
		Usuario u1=new Usuario();
		u1.setNome("Laura");
		u1.setId(2);
		u1.setEndereco("Rua Sousa");
		u1.setUsuario("lala");
		u1.setSenha("321");
		u1.setEmail("laurinhasousa");
		
		usuarioDao.update(u1);
		
		//delete
		//usuarioDao.deleteByIdUsuario(2);
		
		
		for(Usuario u:usuarioDao.getUsuario()) {
			System.out.println("Usuario: " +u.getNome());
		}
	}

}
