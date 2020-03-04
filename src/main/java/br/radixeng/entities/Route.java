package br.radixeng.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "route")
public class Route implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4095658960187068323L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String source;
	
	private String target;
	
	private Integer distance;
	
	@ManyToOne
	@JoinColumn (name="graph_id")
	private Graph graph;
	
	public Route(){
		//default construtor
	}
	
	public Route(String source, String target, Integer distance, Graph graph){
		this.source = source;
		this.target = target;
		this.distance = distance;
		this.graph = graph;
	}
	
	public String getSource() {
		return source;
	}
	
	public void setSource(String source) {
		this.source = source;
	}
	
	public String getTarget() {
		return target;
	}
	
	public void setTarget(String target) {
		this.target = target;
	}
	
	public Integer getDistance() {
		return distance;
	}
	
	public void setDistance(Integer distance) {
		this.distance = distance;
	}

	public Graph getGraph() {
		return graph;
	}

	public void setGraph(Graph graph) {
		this.graph = graph;
	}
}
