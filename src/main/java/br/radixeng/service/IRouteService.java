package br.radixeng.service;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import br.radixeng.dto.RouteDTO;

@SuppressWarnings({ "unchecked", "rawtypes" })
public interface IRouteService {
	
	Map<String, LinkedHashSet<String>> map = new HashMap();
	
	RouteServiceImpl findAllRoutes(Long graphId, String town1, String town2);
	
	RouteServiceImpl removeRoutesBy(Integer maxStops);
	
	default void depthFirst(IRouteService graph, LinkedList<String> visited, String end, List<RouteDTO> routeStops) {
        
    	LinkedList<String> nodes = new LinkedList();
        
    	LinkedHashSet<String> adjacent = map.get(visited.getLast());
        
    	if(adjacent!=null) {
            nodes = new LinkedList<String>(adjacent);
        }
        
    	for (String node : nodes) {
        
    		if (visited.contains(node)) {
                continue;
            }
            
    		if (node.equals(end)) {
                visited.add(node);
                printPath(visited, routeStops);
                visited.removeLast();
                break;
            }
        }
    	
        for (String node : nodes) {
        
        	if (visited.contains(node) || node.equals(end)) {
                continue;
            }
            
        	visited.addLast(node);
            
        	depthFirst(graph, visited, end, routeStops);
            visited.removeLast();
        }
    }

    static void printPath(LinkedList<String> visited, List<RouteDTO> routeStops) {
        
    	int count = -1;
    	
    	StringBuilder nodes = new StringBuilder();
    	
    	for (String node : visited) {
	    	nodes.append(node);
	    	count++;
	    }
    	
    	routeStops.add(new RouteDTO(nodes.toString(), count));
    }
    
    default void addEdge(String node1, String node2) {
	    
		LinkedHashSet<String> adjacent = map.get(node1);
        
		if(adjacent==null) {
            adjacent = new LinkedHashSet();
            map.put(node1, adjacent);
        }
        
		adjacent.add(node2);
    }
    
    static LinkedList<String> adjacentNodes(String last) {
        
    	LinkedHashSet<String> adjacent = map.get(last);
        
    	if(adjacent==null) {
            return new LinkedList();
        }
        
    	return new LinkedList<String>(adjacent);
    }
    
    default void resetMap() {
    	map.clear();
    }
	
}
