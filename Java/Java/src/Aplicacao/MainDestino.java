package Aplicacao;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import DAO.ViagemDAO;
import modelo.Viagem;

public class MainDestino{

	public static void main(String[] args) throws ParseException  {
		// TODO Auto-generated method stub
		Destino viagem=new Destino();
		
		
		Destino.setValor(5040.59);
		Destino.setDestino("Canadá");
		
		DestinoDAO destinoDao=new DestinoDAO();
		//destinoDao.save(viagem);
		
		//att
		
		Destino v1=new Destino();
		d1.setId(2);
		d1.setValor(5000.50);
		d1.setDestino("EUA");
	
		
		destinoDao.update(v1);
		
		//delete
		//destinoDao.deleteByIdDestino(3);
		
		
		for(Destino d:destinoDao.getDestino()) {
			System.out.println("Destino: " +d.getDestino());
		}
	}

}
