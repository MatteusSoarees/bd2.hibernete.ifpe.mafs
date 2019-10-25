package teste.crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;



import DAO.ApostaDAO;

import modelo.Aposta;

public class ListarTodasAposta {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate_jpa21");
		EntityManager em = emf.createEntityManager();

		try {
			ApostaDAO dao = new ApostaDAO(em);
			List<Aposta> aposta = dao.listaTodos();
			for (int i = 0; i < aposta.size(); i++) {
				System.out.println("Nome : "  + aposta.get(i).getNome() + " Codigo: " + aposta.get(i).getCodigo() + "Data: " + aposta.get(i).getData() + "Hora: " + aposta.get(i).getHora() + "Valor Total: " + aposta.get(i).getValorTotal());
			} 

		}catch (Exception e) {
			e.printStackTrace();
		} 
		finally {
			em.close();
			emf.close();
		}
	}
}

