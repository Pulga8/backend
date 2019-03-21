package com.coop.model.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coop.model.Rubro;

@Repository
public interface RubroRepository extends JpaRepository<Rubro, Long> {

}
