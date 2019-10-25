package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;


import modelo.Time;

public class TimeDAO {

	private DAO<Time> dao;
	private EntityManager manager;
	
	public TimeDAO(EntityManager manager){
		this.manager = manager;
		dao = new DAO<Time>(manager, Time.class);
	}

	public Time adiciona(Time t) {
		return dao.adiciona(t);
	}

	public void remove(int Id) {
		dao.removeTime(Id);
	}

	public Time atualiza(Time t) {
		return dao.atualiza(t);
	}

	public List<Time> listaTodos() {
		return dao.listaTodos();
	}

	public Time buscaPorId(int Id) {
		return dao.buscaPorId(Id);
	}

	public void close() {
		this.dao.close();
	}

	public void removePorId(int Id) {
		manager.getTransaction().begin();
		try{
			String hql = "Delete From Time T Where T.Id = :Id";
			Query query = manager.createQuery(hql);
			query.setParameter("Id", Id);
			query.executeUpdate();
			manager.getTransaction().commit();
		}catch(RuntimeException e){
			manager.getTransaction().rollback();
			throw e;
		}
	}

}

