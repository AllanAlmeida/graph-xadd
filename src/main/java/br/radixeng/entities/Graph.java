package br.radixeng.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "graph")
public class Graph implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8023088477220190632L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "graph_id")
	private long id;
	
	@OneToMany(mappedBy = "graph", targetEntity = Route.class, fetch = FetchType.LAZY)
	private List<Route> routes;

	public Graph(){
		//default construtor
	}
	
	public Graph(List<Route> listaRotas) {
		this.routes = listaRotas;
	}

	public List<Route> getRotas() {
		return routes;
	}

	public void setListaRotas(List<Route> listaRotas) {
		this.routes = listaRotas;
	}
	
}
