package DAO;


import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Conexao.ConnectionFactory;

import modelo.Cliente;

	//C
	public class UsuarioDAO {
		public void save(Usuario usuario) {
			String sql="INSERT INTO Usuario(NomeUsuario, EnderecoUsuario, UsuarioUsuario, SenhaUsuario, EmailUsuario)" + 
		"VALUES (?,?,?,?,?)";
			
			Connection conn=null;
			PreparedStatement pstm=null;
			
			try {
				conn=ConnectionFactory.creatConnectiontoMySQL();
				
				pstm=(PreparedStatement) conn.prepareStatement(sql);
				pstm.setString(1, usuario.getNome());
				pstm.setString(2, usuario.getEndereco());
				pstm.setString(3, usuario.getUsuario());
				pstm.setString(4, usuario.getSenha());
				pstm.setString(5, usuario.getEmail());
				
				pstm.execute();
				
				System.out.println("Salvo com sucesso");
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				try{
					if(pstm!=null) {
						pstm.close();
				}
					if(conn!=null) {
						conn.close();
					}
			}catch(Exception e) {
				e.printStackTrace();
			}
			}
		}
	
	//U
		public void update(Usuario usuario) {
			String sql="UPDATE usuario SET NomeUsuario =?, EnderecoUsuario=?, ClienteUsuario=?, SenhaUsuario=?, EmailUsuario=?"+
		"WHERE IdUsuario=?";
			
			Connection conn=null;
			PreparedStatement pstm=null;
			try {
				conn=ConnectionFactory.creatConnectiontoMySQL();
				pstm=(PreparedStatement) conn.prepareStatement(sql);
				
				pstm.setString(1, usuario.getNome());
				pstm.setString(2, usuario.getEndereco());
				pstm.setString(3, usuario.getUsuario());
				pstm.setString(4, usuario.getSenha());
				pstm.setString(5, usuario.getEmail());
				
				pstm.setInt(6, usuario.getId());
				
				pstm.execute();
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(pstm!=null) {
						pstm.close();
					}
					if(conn!=null) {
						conn.close();
					}
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		
	//D
		public void deleteByIdUsuario(int IdUsuario) {
			String sql="DELETE FROM usuario WHERE IdUsuario=?";
			Connection conn=null;
			PreparedStatement pstm=null;
			try {
				conn= ConnectionFactory.creatConnectiontoMySQL();
				pstm= (PreparedStatement) conn.prepareStatement(sql);
				
				pstm.setInt(1, IdUsuario);
				
				pstm.execute();
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(pstm!=null) {
						pstm.close();
					}
				 if(conn!=null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		}
		
	//R
	public List<Usuario> getUsuario(){
		String sql="SELECT * FROM usuario";
		List<Usuario> usuario = new ArrayList<Usuario>();
		Connection conn=null;
		PreparedStatement pstm = null;
		
		ResultSet rset=null;
		
		try {
			conn=ConnectionFactory.creatConnectiontoMySQL();
			
			pstm=(PreparedStatement) conn.prepareStatement(sql);
			
			rset=pstm.executeQuery();
			
			while(rset.next()) {
				Usuario usuario=new Usuario();
				
				usuario.setId(rset.getInt("IdUsuario"));
				usuario.setNome(rset.getString("NomeUsuario"));
				usuario.setEndereco(rset.getString("EnderecoUsuario"));
				usuario.setUsuario(rset.getString("UsuarioUsuario"));
				usuario.setSenha(rset.getString("SenhaUsuario"));
				usuario.setEmail(rset.getString("EmailUsuario"));
			
				usuarios.add(usuario);
			}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					
					try {
					if(rset!=null) {
						rset.close();
					}
				 if(pstm!=null) {
					pstm.close();
				}
			if(conn!=null) {
				conn.close();
			}
		}	catch(Exception e) {
			e.printStackTrace();
			}
		}
		
		return usuarios;
		
		
		}
	}
	