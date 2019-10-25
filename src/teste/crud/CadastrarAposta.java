package teste.crud;


import javax.persistence.EntityManager;

import DAO.ApostaDAO;
import DAO.MyManagerFactory;
import modelo.Aposta;

public class CadastrarAposta {
	
	public static void main(String[] args){
		EntityManager manager = MyManagerFactory.getInstance().getEntityManager();
		ApostaDAO dao = new ApostaDAO(manager);
		try{
			Aposta aposta = new Aposta();
			aposta.setNome("Mateus Augusto");
			aposta.setCodigo(1);
			aposta.setData("10/05/2014");
			aposta.setHora("9:15");
			aposta.setValorTotal(1500);
			
			dao.adiciona(aposta);
		}finally{
			manager.close();
			MyManagerFactory.getInstance().close();
		}
	}

}
