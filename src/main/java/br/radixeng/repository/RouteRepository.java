package br.radixeng.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.radixeng.entities.Route;

/**
*
*/
@RepositoryRestResource(collectionResourceRel = "route", path = "route")
public interface RouteRepository extends PagingAndSortingRepository<Route, Long>{}
