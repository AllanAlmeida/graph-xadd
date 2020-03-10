package br.radixeng.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class RouteDTO {

	private String route;
	
	private Integer stops;

	private List<RouteDTO> routes;
	
	public RouteDTO(){
		//Default constructor
	}
	
	public List<RouteDTO> getRoutes() {
		return routes;
	}

	public void setRoutes(List<RouteDTO> routes) {
		this.routes = routes;
	}

	public RouteDTO(String route, Integer stops) {
		this.route = route;
		this.stops = stops;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public Integer getStops() {
		return stops;
	}

	public void setStops(Integer stops) {
		this.stops = stops;
	}
}
