package teste.crud;

import javax.persistence.EntityManager;

import DAO.TimeDAO;
import DAO.MyManagerFactory;

public class RemoverTime {

	public static void main(String[] args){
		EntityManager manager = MyManagerFactory.getInstance().getEntityManager();
		TimeDAO dao = new TimeDAO(manager);
		try{
			int Id = 1; 
			dao.removePorId(Id);
		}finally{
			manager.close();
			MyManagerFactory.getInstance().close();
		}
	}

}
