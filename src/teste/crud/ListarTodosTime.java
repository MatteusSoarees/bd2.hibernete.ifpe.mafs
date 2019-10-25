package teste.crud;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import DAO.TimeDAO;
import modelo.Time;

public class ListarTodosTime {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate_jpa21");
		EntityManager em = emf.createEntityManager();

		try {
			TimeDAO dao = new TimeDAO(em);
			List<Time> time = dao.listaTodos();
			for (int i = 0; i < time.size(); i++) {
				System.out.println("Nome : "  + time.get(i).getNome() + " Id: " + time.get(i).getId() + "Valor: " + time.get(i).getValor());
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
