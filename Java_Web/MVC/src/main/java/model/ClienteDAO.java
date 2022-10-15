package model;


	


	import java.sql.Connection;

	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.util.ArrayList;
	import java.util.List;


		
		public class ClienteDAO {
			
			Connection conn = null;
			PreparedStatement pstm = null;
		
			//C
			public void save(Cliente cliente) {
				String sql="INSERT INTO Cliente(NomeCliente, EmailCliente , UsuarioCliente, SenhaCliente,EnderecoCliente )" + 
			"VALUES (?,?,?,?,?)";
				
				Connection conn=null;
				PreparedStatement pstm=null;
				
				try {
					conn=Conexao.creatConnectiontoMySQL();
					
					pstm=(PreparedStatement) conn.prepareStatement(sql);
					pstm.setString(1, cliente.getNome());
					pstm.setString(2, cliente.getEmail());
					pstm.setString(3, cliente.getUsuario());
					pstm.setString(4, cliente.getSenha());
					pstm.setString(5, cliente.getEndereco());
				
					
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
			public void update(Cliente cliente) {

				String sql = "UPDATE cliente SET NomeCliente = ?, EmailCliente = ?, UsuarioCliente = ?, SenhaCliente=?, EnderecoCliente=? "
				+ " WHERE IdCliente = ?";

				try {
					// Cria uma conexão com o banco
					conn = Conexao.creatConnectiontoMySQL();

					// Cria um PreparedStatment, classe usada para executar a query
					pstm = conn.prepareStatement(sql);

					// Adiciona o valor do primeiro parâmetro da sql
					pstm.setString(1, cliente.getNome());
					// Adicionar o valor do segundo parâmetro da sql
					pstm.setString(2, cliente.getEmail());
					// Adiciona o valor do terceiro parâmetro da sql
					pstm.setString(3, cliente.getUsuario());
					pstm.setString(4, cliente.getSenha());
					pstm.setString(5, cliente.getEndereco());

					pstm.setInt(6, cliente.getId());
					
					// Executa a sql para inserção dos dados
					pstm.execute();

				} catch (Exception e) {

					e.printStackTrace();
				} finally {

					// Fecha as conexões

					try {
						if (pstm != null) {

							pstm.close();
						}

						if (conn != null) {
							conn.close();
						}

					} catch (Exception e) {

						e.printStackTrace();
					}
				}
			}
			
		//D
			public void deleteByIdCliente(int IdCliente) {
				String sql="DELETE FROM cliente WHERE IdCliente=?";
				Connection conn=null;
				PreparedStatement pstm=null;
				try {
					conn= Conexao.creatConnectiontoMySQL();
					pstm= (PreparedStatement) conn.prepareStatement(sql);
					
					pstm.setInt(1, IdCliente);
					
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
		public List<Cliente> getCliente(){
			String sql="SELECT * FROM cliente";
			List<Cliente> clientes = new ArrayList<Cliente>();
			Connection conn=null;
			PreparedStatement pstm = null;
			
			ResultSet rset=null;
			
			try {
				conn=Conexao.creatConnectiontoMySQL();
				
				pstm=(PreparedStatement) conn.prepareStatement(sql);
				
				rset=pstm.executeQuery();
				
				while(rset.next()) {
					Cliente cliente=new Cliente();
					
					cliente.setId(rset.getInt("IdCliente"));
					cliente.setNome(rset.getString("NomeCliente")); 				

					cliente.setEndereco(rset.getString("EnderecoCliente"));
					cliente.setUsuario(rset.getString("UsuarioCliente"));
					cliente.setSenha(rset.getString("SenhaCliente"));
					cliente.setEmail(rset.getString("EmailCliente"));
				
					clientes.add(cliente);
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
			
			return clientes;
			
			
			}
		
		
		public Cliente getClienteById(int IdCliente) {

			String sql = "SELECT * FROM cliente WHERE IdCliente=?";
			
			Cliente cliente = new Cliente();
		
			ResultSet rset = null;
			

			try {
				conn = Conexao.creatConnectiontoMySQL();
				pstm = conn.prepareStatement(sql);
				pstm.setInt(1, IdCliente);
				
				
				rset = pstm.executeQuery();
				
				
				
				rset.next();
				
				
				cliente.setId(rset.getInt("IdCliente"));
				cliente.setNome(rset.getString("NomeCliente")); 				

				cliente.setEndereco(rset.getString("EnderecoCliente"));
				cliente.setUsuario(rset.getString("UsuarioCliente"));
				cliente.setSenha(rset.getString("SenhaCliente"));
				cliente.setEmail(rset.getString("EmailCliente"));

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (rset != null) {
						rset.close();
					}
					if (pstm != null) {
						pstm.close();
					}
					if (conn != null) {
						conn.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return cliente;
		}
	}


