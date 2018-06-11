/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iesvdc.acceso.zapateria.gestionzapateria.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iesvdc.acceso.zapateria.gestionzapateria.entities.ClienteDireccion;

/**
 *
 * @author Juangu <jgutierrez at iesvirgendelcarmen.coms>
 */
@Repository
public interface RepositorioDireccion extends JpaRepository<ClienteDireccion, Long> {
	
	//Los repositorios permiten busquedas de entities por atributos y condiciones.
	//Quitar las @NamedQueries de las Entities y ponerlas en los repositorios creo que cumple mejor con el patrón de diseño Repository.
	//DOCUMENTACION: https://docs.spring.io/spring-data/data-commons/docs/1.6.1.RELEASE/reference/html/repositories.html	
	Optional<ClienteDireccion> findByNombre(String nombre);
	Optional<ClienteDireccion> findByIdDireccion(Integer idDireccion);
	Optional<ClienteDireccion> findByNombreVia(String nombre);
}
