package br.radixeng.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.radixeng.entities.Graph;
import br.radixeng.repository.GraphRepository;

@Service
public class GraphServiceImpl implements IGraphService{
	 
	@Autowired
	private GraphRepository graphRepository;

	@Override
	public Graph findById(Long id) {
		return graphRepository.findOne(id);
	}
	
	@Override
	public List<Graph> findAllGraphs() {
		return graphRepository.findAll();
	}
	
	@Override
	public void saveGraph(Graph graph) {
		graphRepository.save(graph);
	}
}
