package br.com.qintess.livraria.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import br.com.qintess.livraria.dao.ClienteDao;
import br.com.qintess.livraria.modelo.Cliente;

@SuppressWarnings("serial")
@Named
@ViewScoped
public class ClienteBean implements Serializable {
	
	private Cliente cliente = new Cliente();

	@Inject
	private ClienteDao dao;// CDI faz new AutorDao() e injeta

	private Integer clienteId;

	public Integer getClienteId() {
		return clienteId;
	}

	public void setAutorId(Integer clienteId) {
		this.clienteId = clienteId;
	}

	public void carregarClientePelaId() {
		this.cliente = this.dao.buscaPorId(clienteId);
	}

	@Transactional
	public String gravar() {
		System.out.println("Gravando cliente " + this.cliente.getNome());

		if (this.cliente.getId() == null) {
			this.dao.adiciona(this.cliente);
		} else {
			this.dao.atualiza(this.cliente);
		}

		this.cliente = new Cliente();

		return "cliente?faces-redirect=true";
	}

	@Transactional
	public void remover(Cliente cliente) {
		System.out.println("Removendo cliente " + cliente.getNome());
		this.dao.remove(cliente);
	}

	public List<Cliente> getClientes() {
		return this.dao.listaTodos();
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
