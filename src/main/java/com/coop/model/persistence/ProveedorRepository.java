package com.coop.model.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coop.model.Proveedor;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Long> {

}
