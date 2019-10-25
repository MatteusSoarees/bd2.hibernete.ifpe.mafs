package teste.crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import DAO.TimeDAO;
import modelo.Time;

public class BuscarPorId {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate_jpa21");
		EntityManager em = emf.createEntityManager();

		try {
			TimeDAO dao = new TimeDAO(em);
			int Id = 1;
			Time time = dao.buscaPorId(Id);
			System.out.println("Nome: " + time.getNome() + "Id: " + time.getId());
			

		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
			emf.close();
		}

	}

}

