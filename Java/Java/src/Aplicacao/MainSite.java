package Aplicacao;

import DAO.SiteDAO;
import modelo.Site;

public class MainSite {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Site site=new Site();
		site.setNome("Leticia");
		site.setEndereco("Rua Yoshimara Minamoto, 1633, São Paulo - Brasil");
		
		SiteDAO SiteDao=new SiteDAO();
		//siteDao.save(site);
		
		//att
		
		Site a1=new Site();
		s1.setNome("Go Travel");
		s1.setId(1);
		s1.setEndereco("Rua Yoshimara Minamoto, 1633, São Paulo - Brasil");
		
		//siteDao.update(a1);
		
		//delete
		siteDao.deleteByIdSite(2);
		
		
		for(Site s:siteDao.getSite()) {
			System.out.println("Site: " +s.getNome());
		}
	}

}
