package br.com.qintess.livraria.dao;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.qintess.livraria.modelo.Cliente;

@SuppressWarnings("serial")
@Stateless //EJB
public class ClienteDao implements Serializable {

	@PersistenceContext
	EntityManager em;

	private DAO<Cliente> dao;
	
	@PostConstruct
	void init() {
		this.dao = new DAO<Cliente>(this.em, Cliente.class);
	}
	
	public void adiciona(Cliente t) {
		dao.adiciona(t);
	}

	public void remove(Cliente t) {
		dao.remove(t);
	}

	public void atualiza(Cliente t) {
		dao.atualiza(t);
	}

	public List<Cliente> listaTodos() {
		return dao.listaTodos();
	}

	public Cliente buscaPorId(Integer id) {
		return dao.buscaPorId(id);
	}
}
