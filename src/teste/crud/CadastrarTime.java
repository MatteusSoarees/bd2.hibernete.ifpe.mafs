package teste.crud;

import javax.persistence.EntityManager;

import DAO.TimeDAO;
import DAO.MyManagerFactory;
import modelo.Time;

public class CadastrarTime {

	public static void main(String[] args){
		EntityManager manager = MyManagerFactory.getInstance().getEntityManager();
		TimeDAO dao = new TimeDAO(manager);
		try{
			Time time = new Time ();
			time.setId(1);
			time.setNome("Palmeiras");
			time.setValor(4.80);
			
			dao.adiciona(time);
			
		}finally{
			manager.close();
			MyManagerFactory.getInstance().close();
		}
	}

}
