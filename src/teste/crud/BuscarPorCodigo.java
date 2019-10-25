package teste.crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import DAO.ApostaDAO;
import modelo.Aposta;

public class BuscarPorCodigo {
		public static void main(String[] args) {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate_jpa21");
			EntityManager em = emf.createEntityManager();

			try {
				ApostaDAO dao = new ApostaDAO(em);
				int Codigo = 1;
				Aposta aposta = dao.buscaPorCodigo(Codigo);
				System.out.println("Nome: " + aposta.getNome() + "Cpf: " + aposta.getCodigo());
				

			}catch (Exception e) {
				e.printStackTrace();
			} finally {
				em.close();
				emf.close();
			}

		}

	}

