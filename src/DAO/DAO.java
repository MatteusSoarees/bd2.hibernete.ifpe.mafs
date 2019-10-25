package DAO;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;




public class DAO<T> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private final Class<T> classe;
	private EntityManager em;

	public DAO(EntityManager manager, Class<T> classe) {
		this.em = manager;
		this.classe = classe;
	}

	public T adiciona(T t) {
		em.getTransaction().begin();
		try{
			em.persist(t);
			em.getTransaction().commit();
			return t;
		}catch(RuntimeException e){
			em.getTransaction().rollback();
			throw e;
		}
	}

	public void removeTime(int Id) {
		em.getTransaction().begin();
		try{
			em.remove(em.merge(Id));
			em.getTransaction().commit();
		}catch(RuntimeException e){
			em.getTransaction().rollback();
			throw e;
		}
	}
	public void removeAposta(int Codigo) {
		em.getTransaction().begin();
		try{
			em.remove(em.merge(Codigo));
			em.getTransaction().commit();
		}catch(RuntimeException e){
			em.getTransaction().rollback();
			throw e;
		}
	}

	public T atualiza(T t) {
		em.getTransaction().begin();
		try{
	
			em.flush();
			T merge = em.merge(t);
			em.getTransaction().commit();
			return merge;
		}catch(RuntimeException e){
			em.getTransaction().rollback();
			throw e;
		}
	}

	public List<T> listaTodos() {
		CriteriaQuery<T> query = em.getCriteriaBuilder().createQuery(classe);
		query.select(query.from(classe));

		List<T> lista = em.createQuery(query).getResultList();

		return lista;
	}

	public T buscaPorCodigo(int Codigo) {
		T instancia = em.find(classe, Codigo);
		return instancia;
	}
	public T buscaPorId(int Id) {
		T instancia = em.find(classe, Id);
		return instancia;
	}

	public List<T> listaTodosPaginada(int firstResult, int maxResults) {
		CriteriaQuery<T> query = em.getCriteriaBuilder().createQuery(classe);
		query.select(query.from(classe));

		List<T> lista = em.createQuery(query).setFirstResult(firstResult)
				.setMaxResults(maxResults).getResultList();

		return lista;
	}
	
	public void close(){
		this.em.close();
	}


}
