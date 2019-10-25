package teste;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import modelo.Aposta;
import modelo.Time;

public class QueryTeste {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate_jpa21");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			
			tx.begin();
			
			consultarAposta(em);
			
			consultarTime(em);
			
			tx.commit();
			
		} catch (Throwable e) {
			e.printStackTrace();
			tx.rollback();
			
		}finally{
			em.close();
			emf.close();
		}

	}

	private static void consultarTime(EntityManager em) {
		TypedQuery<Time> qp = em.createQuery("Select * from Time * join T.Aposta A where A.Nome like '%Aposta%'", Time.class);
		List<Time> rp = qp.getResultList();
		
		Iterator<Time> ip = rp.iterator();
		
		while(ip.hasNext()){
			System.out.println(ip.next().toString());
		}
		
	}

	private static void consultarAposta(EntityManager em) {
		TypedQuery<Aposta> qc = em.createQuery("from Aposta A where A.Nome like :Silva", Aposta.class);
		qc.setParameter("Silva", "%Silva%");
		List<Aposta> rc = qc.getResultList();
		
		Iterator<Aposta> ic = rc.iterator();
		
		while(ic.hasNext()){
			System.out.println(ic.next().toString());
		}
		
		qc = em.createQuery("from Aposta A where A.Codigo = :Codigo", Aposta.class);
		qc.setParameter("Codigo", "1");
		Aposta aposta = qc.getSingleResult();
		
		
	}

}
