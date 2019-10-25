package teste.crud;

import java.util.Arrays;

import javax.persistence.EntityManager;

import DAO.ApostaDAO;
import DAO.MyManagerFactory;
import modelo.Aposta;
import modelo.Time;

public class AtualizaAposta {

	public static void main(String[] args){
		EntityManager manager = MyManagerFactory.getInstance().getEntityManager();
		ApostaDAO dao = new ApostaDAO(manager);
		try{
			Aposta aposta = new Aposta();
			aposta.setNome("Marcos vilela");
			aposta.setCodigo(2);
			aposta.setData("15/02/2019");
			aposta.setHora("10:20");
			aposta.setValorTotal(3000);
			
			Time time = new Time ();
			time.setNome("Barcelona");
			time.setId(3);
			time.setValor(2.50);
			
			aposta.setTimes(Arrays.asList(time));
			
			dao.atualiza(aposta);
		}finally{
			manager.close();
			MyManagerFactory.getInstance().close();
		}
	}
}
