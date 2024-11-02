package arg.com.art.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import arg.com.art.domain.Clients;

public class ClientDAO {
	private EntityManagerFactory emf;
	private EntityManager em;
	
	private final String HQL_SELECT = "SELECT c FROM Clients c";
	private final String HQL_SELECT_BY_ID = "SELECT c FROM Clients c WHERE c.id = :idClient";
	private final String HQL_DELETE = "DELETE FROM Clients WHERE id = :idClient";
	
	public ClientDAO() {
		emf = Persistence.createEntityManagerFactory("HibernatePU");
		em = emf.createEntityManager();
	}
	
	public void listAll() {
		Query query = this.em.createQuery(HQL_SELECT);
		List<Clients> clients = query.getResultList();
		clients.forEach(System.out::println);
	}
	
	public Clients getById(int id) {
		return em.find(Clients.class, id);
	}
	
	public void insert(Clients client) {
		try {
			em.getTransaction().begin();
			em.persist(client);
			em.getTransaction().commit();	
		}catch(Exception ex) {
			ex.printStackTrace(System.out);
		}
	}
	
	public boolean update(Clients client, int id) {
		try {
			Clients findClient = getById(id);
			if(findClient != null) {				
				findClient.setEmail(client.getEmail());
				findClient.setPhone(client.getPhone());
				findClient.setName(client.getName());
				findClient.setLastName(client.getLastName());
				em.getTransaction().begin();
				em.merge(findClient);
				em.getTransaction().commit();
				return true;
			}
		}catch(Exception ex) {
			ex.printStackTrace(System.out);
		}
		return false;
	}
	
	public boolean deleteById(int id) {
		try {
			Clients findClient = getById(id);
			if(findClient != null) {				
				em.getTransaction().begin();
				em.remove(findClient);
				em.getTransaction().commit();
				return true;
			}
		}catch(Exception ex) {
			ex.printStackTrace(System.out);
		}
		return false;
	}
	

}
