package teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ORMTeste {

	public static void main(String[] args) {
		try{
			
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate_jpa21");
			EntityManager em = emf.createEntityManager();
			
			try{
				
				em.getTransaction().begin();

				String sql = "select version()";

				String result = (String) em.createNativeQuery(sql).getSingleResult();
				System.out.println(result);

				em.getTransaction().commit();
				
			}finally{
				em.close();
				emf.close();
			}
			
		}catch(Throwable e){
			e.printStackTrace();
		}

	}

}
