package br.radixeng.service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.radixeng.dto.RouteDTO;
import br.radixeng.entities.Graph;
import br.radixeng.entities.Route;
import br.radixeng.enums.Values;

@Service
@SuppressWarnings({ "unchecked", "rawtypes" })
public class RouteServiceImpl implements IRouteService{

	@Autowired
	GraphServiceImpl graphService;
	
	@Autowired
	RouteServiceImpl routeService;
	
	private List<RouteDTO> routeStops = new ArrayList<>();
	
	private List<RouteDTO> routeBuilded = new ArrayList<>();
	
	@Override
	public RouteServiceImpl findAllRoutes(Long graphId, String town1, String town2) {
		
		Graph returnedGraph = graphService.findById(graphId);
		
		if(returnedGraph!=null) {
		
			for(Route route : returnedGraph.getData()) {
				routeService.addEdge(route.getSource(), route.getTarget());
			}
			
			LinkedList<String> visited = new LinkedList();
			visited.add(town1);
	 		
			routeService.depthFirst(routeService, visited, town2, routeStops);
			
		} else {
			routeStops = new ArrayList<>();
			RouteDTO route = new RouteDTO();
			route.setStops(-1);
			route.setRoute(Values.GRAPH_NOT_FOUND.getCode());
			routeStops.add(route);
		}
		
		return this;
	}
	

	public void resetRouteStops() {
		this.routeStops.clear();
	}
	
	public void resetRouteBuilded() {
		this.routeBuilded.clear();
	}
	
	public List<RouteDTO> getRouteStops() {
		return routeStops;
	}

	public void setRouteStops(List<RouteDTO> routeStops) {
		this.routeStops = routeStops;
	}

	public List<RouteDTO> getRouteBuilded() {
		return routeBuilded;
	}

	public void setRouteBuilded(List<RouteDTO> routeBuilded) {
		this.routeBuilded = routeBuilded;
	}

	public RouteServiceImpl getRouteService() {
		return routeService;
	}


	public void setRouteService(RouteServiceImpl routeService) {
		this.routeService = routeService;
	}


	public RouteServiceImpl removeRoutesBy(Integer maxStops){
		
		List<RouteDTO> returnedRoutes = new ArrayList<>();
		
		if(!routeStops.isEmpty()) {
			
			for (RouteDTO route : this.routeStops) {
				
				if(maxStops==null) {
					returnedRoutes.add(route);
					continue;
				}
				
				if(maxStops > 0 && route.getStops() <= maxStops) {
				
					returnedRoutes.add(route);
				}
				
			}
			
			routeBuilded.addAll(returnedRoutes);
			
		} else {
			routeBuilded = new ArrayList<>();
		}
		
		return this;
	}
	
	public List<RouteDTO> buildRoute(){
		
		return routeBuilded;
	}
}
