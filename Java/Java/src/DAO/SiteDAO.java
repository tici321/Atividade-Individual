package DAO;


	import java.sql.Connection;

	import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Conexao.ConnectionFactory;
import modelo.Agencia;

	//C
	public class SiteDAO {
		public void save(Site site) {
			String sql="INSERT INTO Sitea(NomeSite, EnderecoSite)" + 
		"VALUES (?,?)";
			
			Connection conn=null;
			PreparedStatement pstm=null;
			
			try {
				conn=ConnectionFactory.creatConnectiontoMySQL();
				
				pstm=(PreparedStatement) conn.prepareStatement(sql);
				pstm.setString(1, site.getNome());
				pstm.setString(2, site.getEndereco());
				
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
		public void update(Site site) {
			String sql="UPDATE site SET NomeSite =?, EnderecoSite=?"+
		"WHERE IdSite=?";
			
			Connection conn=null;
			PreparedStatement pstm=null;
			try {
				conn=ConnectionFactory.creatConnectiontoMySQL();
				pstm=(PreparedStatement) conn.prepareStatement(sql);
				
				pstm.setString(1, site.getNome());
				pstm.setString(2, site.getEndereco());
				
				pstm.setInt(3, site.getId());
				
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
		public void deleteByIdSite(int IdSite) {
			String sql="DELETE FROM agencia WHERE IdSite=?";
			Connection conn=null;
			PreparedStatement pstm=null;
			try {
				conn= ConnectionFactory.creatConnectiontoMySQL();
				pstm= (PreparedStatement) conn.prepareStatement(sql);
				
				pstm.setInt(1, IdASite);
				
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
	public List<Site> getSite(){
		String sql="SELECT * FROM site";
		List<Site> sites = new ArrayList<Site>();
		Connection conn=null;
		PreparedStatement pstm = null;
		
		ResultSet rset=null;
		
		try {
			conn=ConnectionFactory.creatConnectiontoMySQL();
			
			pstm=(PreparedStatement) conn.prepareStatement(sql);
			
			rset=pstm.executeQuery();
			
			while(rset.next()) {
				Site site=new Site();
				
				site.setId(rset.getInt("IdSite"));
				site.setNome(rset.getString("NomeSite"));
				site.setEndereco(rset.getString("EnderecoSite"));
			
				sites.add(site);
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
		
		return sites;
		
		
		}
	}
	
