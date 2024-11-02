package arg.com.art.presentation;

import arg.com.art.dao.ClientDAO;
import arg.com.art.domain.Clients;

public class App {
	public static void main(String[] args) {
		ClientDAO clientDAO = new ClientDAO();
		Clients client = new Clients();
		client.setName("Santiago");
		client.setLastName("Arteche");
		client.setEmail("san@san.com");
		client.setPhone("34136501110");
		
		
		clientDAO.insert(client);
		clientDAO.update(client, 22);
		clientDAO.deleteById(22);
		clientDAO.listAll();
		System.out.println(clientDAO.getById(22));
	}
}
