package teste.crud;

import javax.persistence.EntityManager;


import DAO.TimeDAO;
import DAO.MyManagerFactory;
import modelo.Time;

public class AtualizaTime {

	public static void main(String[] args){
		EntityManager manager = MyManagerFactory.getInstance().getEntityManager();
		TimeDAO dao = new TimeDAO(manager);
		try{
			Time time = new Time ();
			time.setNome("Barcelona");
			time.setId(3);
			time.setValor(2.10);
			dao.atualiza(time);
			
		}finally{
			manager.close();
			MyManagerFactory.getInstance().close();
		}
	}
}
