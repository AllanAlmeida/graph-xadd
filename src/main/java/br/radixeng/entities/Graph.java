package br.radixeng.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Graph {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String source;
	
	private String target;
	
	private Integer distance;
	
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
}
