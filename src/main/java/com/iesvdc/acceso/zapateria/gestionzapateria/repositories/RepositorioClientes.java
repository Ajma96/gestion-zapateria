/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iesvdc.acceso.zapateria.gestionzapateria.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iesvdc.acceso.zapateria.gestionzapateria.entities.Cliente;

/**
 *
 * @author profesor
 */
@Repository
public interface RepositorioClientes extends JpaRepository<Cliente, Long> {
    
	//Los repositorios permiten busquedas de entities por atributos y condiciones.
	//Quitar las @NamedQueries de las Entities y ponerlas en los repositorios creo que cumple mejor con el patrón de diseño Repository.
	//DOCUMENTACION: https://docs.spring.io/spring-data/data-commons/docs/1.6.1.RELEASE/reference/html/repositories.html
	Optional<Cliente> findByNombre(String nombre);
	Optional<Cliente> findByApellidos(String apellidos);
	Optional<Cliente> findByDni(int dni);

}
