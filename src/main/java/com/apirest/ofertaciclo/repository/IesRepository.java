package com.apirest.ofertaciclo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.apirest.ofertaciclo.model.Ies;

@Repository
public interface IesRepository extends JpaRepository<Ies, Long> {

	Ies findByIdies(@Param("idies") long idies);
	
	@Query(value = "select i from Ies i")
	Page<Ies> getIesPageable(final Pageable pageable);
	
}
