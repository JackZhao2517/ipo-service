package com.smc.sba.repository;

import com.smc.sba.entity.IPODetailEntity;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


public interface IpoRepository extends JpaRepository<IPODetailEntity, Integer> {

	@Query(name = "findIPOByExchange", nativeQuery = true,
			value = "SELECT * from ipodetails  where stockexchange = :stockexchange")
	IPODetailEntity findIPOByExchange(String stockexchange);

	@Query(name = "findIPOByExchange", nativeQuery = true,
			value = "SELECT * from ipodetails  where companyname = :companyname")
	IPODetailEntity findIPOByCompanyName(String companyname);
	
	@Transactional
	@Modifying()
	@Query(name = "deleteIPOByName", nativeQuery = true, value = "delete from ipodetails where companyname = :companyname")
	void deleteIPOByName(String companyname);
}

