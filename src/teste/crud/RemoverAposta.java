package teste.crud;

import javax.persistence.EntityManager;

import DAO.ApostaDAO;
import DAO.MyManagerFactory;



public class RemoverAposta {
	
	public static void main(String[] args){
		EntityManager manager = MyManagerFactory.getInstance().getEntityManager();
		ApostaDAO dao = new ApostaDAO(manager);
		
		try{
			int Codigo = 1;
			dao.removePorCodigo(Codigo);
		}finally{
			manager.close();
			MyManagerFactory.getInstance().close();
		}
	}

}
