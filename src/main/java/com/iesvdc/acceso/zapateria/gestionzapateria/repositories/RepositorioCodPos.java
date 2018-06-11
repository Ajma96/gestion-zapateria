/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iesvdc.acceso.zapateria.gestionzapateria.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iesvdc.acceso.zapateria.gestionzapateria.entities.CodPos;

/**
 *
 * @author Juangu <jgutierrez at iesvirgendelcarmen.coms>
 */
@Repository
public interface RepositorioCodPos extends JpaRepository<CodPos, Long> {
    
	Optional<CodPos> findByCp(Integer cp);
	Optional<CodPos> findByLocalidad (String localidad);
}
