package com.mappings.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mappings.jpa.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{

}
