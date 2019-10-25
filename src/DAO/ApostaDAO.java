package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import modelo.Aposta;

public class ApostaDAO {
	
	private DAO<Aposta> dao;
	private EntityManager manager;
	
	public ApostaDAO(EntityManager manager){
		this.manager = manager;
		dao = new DAO<Aposta>(manager, Aposta.class);
	}

	public Aposta adiciona(Aposta t) {
		return dao.adiciona(t);
	}

	public void remove(int Codigo) {
		dao.removeAposta(Codigo);
	}

	public Aposta atualiza(Aposta t) {
		return dao.atualiza(t);
	}

	public List<Aposta> listaTodos() {
		return dao.listaTodos();
	}

	public Aposta buscaPorCodigo(int Codigo) {
		return dao.buscaPorCodigo(Codigo);
	}

	public void close() {
		this.dao.close();
	}
	public void removePorCodigo(int codigo) {
		manager.getTransaction().begin();
		try{
			String hql = "Delete From Aposta A Where A.Codigo = :Codigo";
			Query query = manager.createQuery(hql);
			query.setParameter("Codigo", codigo);
			query.executeUpdate();
			manager.getTransaction().commit();
		}catch(RuntimeException e){
			manager.getTransaction().rollback();
			throw e;
		}
	}

}
