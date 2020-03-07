package br.radixeng.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.radixeng.entities.Graph;
import br.radixeng.service.GraphServiceImpl;

/**
 *
 */
@RestController
public class GraphController {
    
	@Autowired
	private GraphServiceImpl graphService;
	
	public GraphController(GraphServiceImpl graphService) {
	       this.graphService = graphService;
	}
		
	@RequestMapping(value = "/graph", method = RequestMethod.GET)
    public ResponseEntity<List<Graph>> listAllGraphs() {
        List<Graph> graphs = graphService.findAllGraphs();
        return new ResponseEntity<List<Graph>>(graphs, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/graph/{id}", method = RequestMethod.GET)
    public ResponseEntity<Graph> getGraphById(@PathVariable long id){
		Graph graph = this.graphService.findById(id);
		return new ResponseEntity<Graph>(graph, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/graph", method =  RequestMethod.POST)
    public ResponseEntity<Graph> saveGraph(@Valid @RequestBody Graph graph){
        graphService.saveGraph(graph);
        return new ResponseEntity<Graph>(graph, HttpStatus.OK);
    }
}
