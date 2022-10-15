package DAO;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Conexao.ConnectionFactory;
import modelo.Viagem;

	//C
	public class DestinoDAO {
		public void save(Destino destino) {
			String sql="INSERT INTO Viagem(Internacional, Nacional, Valor,)" + 
		"VALUES (?,?,?,?)";
			
			Connection conn=null;
			PreparedStatement pstm=null;
			
			try {
				conn=ConnectionFactory.creatConnectiontoMySQL();
				
				pstm=(PreparedStatement) conn.prepareStatement(sql);
				pstm.setDouble(3, destino.getValor());
				pstm.setString(4, destino.getNacional());
				pstm.setString(4, destino.getInternacional());
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
		public void update(Destino destino) {
			String sql="UPDATE destino SET  Valor=?,Nacional=?, Internacional=?"+
		"WHERE IdDestino=?";
			
			Connection conn=null;
			PreparedStatement pstm=null;
			try {
				conn=ConnectionFactory.creatConnectiontoMySQL();
				pstm=(PreparedStatement) conn.prepareStatement(sql);
				
				pstm.setDouble(1, destino.getValor());
				pstm.setString(2, destino.getNacional());
				pstm.setString(3, destino.getInternacional());
				pstm.setInt(4, destino.getId());
				pstm.execute();
				
				System.out.println("Salvo com sucesso");
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
		public void deleteByIdDestino(int IdDestino) {
			String sql="DELETE FROM destinos WHERE IdDestino=?";
			Connection conn=null;
			PreparedStatement pstm=null;
			try {
				conn= ConnectionFactory.creatConnectiontoMySQL();
				pstm= (PreparedStatement) conn.prepareStatement(sql);
				
				pstm.setInt(1, IdDestino);
				
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
	public List<Destino> getDestino(){
		String sql="SELECT * FROM destino";
		List<Destino> destinos = new ArrayList<Destino>();
		Connection conn=null;
		PreparedStatement pstm = null;
		
		ResultSet rset=null;
		
		try {
			conn=ConnectionFactory.creatConnectiontoMySQL();
			
			pstm=(PreparedStatement) conn.prepareStatement(sql);
			
			rset=pstm.executeQuery();
			
			while(rset.next()) {
				Destino destino=new Destino();
				
				pstm.setDouble(1, destino.getValor());
				pstm.setString(2, destino.getDestino());
				pstm.execute();
			
				destinos.add(destino);
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
		
		return destinos;
		
		
		}
	}
	
