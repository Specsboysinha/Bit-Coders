package com.bitcoders.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bitcoders.entity.ClientEntity;

@Repository
public interface ClientDetailsRepository extends JpaRepository<ClientEntity, Long>, JpaSpecificationExecutor<ClientEntity>{

	@Query(value = "SELECT * FROM {h-schema}clients"  + " WHERE name ILIKE CONCAT('%', :name, '%')", nativeQuery = true)
	ClientEntity findByName(@Param("name") String name);


}
