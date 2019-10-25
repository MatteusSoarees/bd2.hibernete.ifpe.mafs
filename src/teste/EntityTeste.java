package teste;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.Aposta;
import modelo.Time;


public class EntityTeste {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate_jpa21");
		EntityManager em = emf.createEntityManager();
		
		try {
			
			em.getTransaction().begin();
			
			//testeCliente(em);
			//testeEmpresa(em);
			
			
			em.getTransaction().commit();
			
		} catch (Throwable e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			
		}finally{
			em.close();
			emf.close();
		}
	}
	
	private static void testeAposta(EntityManager em){
		Aposta aposta = new Aposta();
		aposta.setCodigo(1);
		aposta.setNome("Mateus Augusto");
		aposta.setData("12/10/2018");
		aposta.setHora("14:30");
		aposta.setValorTotal(2000);
		
		System.out.println(aposta);
		
		em.persist(aposta);
		
		System.out.println(aposta);
		
	}
	private static void testeTime(EntityManager em){
		Time time = new Time();
		time.setNome("Flamengo");
		time.setValor(3.75);
		time.setId(1);
	
		System.out.println(time);
		
		em.persist(time);
		
		System.out.println(time);
		
	}
}
