/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iesvdc.acceso.zapateria.gestionzapateria.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iesvdc.acceso.zapateria.gestionzapateria.entities.Cliente;
import com.iesvdc.acceso.zapateria.gestionzapateria.entities.ClienteDireccion;
import com.iesvdc.acceso.zapateria.gestionzapateria.entities.CodPos;
import com.iesvdc.acceso.zapateria.gestionzapateria.repositories.RepositorioClientes;
import com.iesvdc.acceso.zapateria.gestionzapateria.repositories.RepositorioCodPos;
import com.iesvdc.acceso.zapateria.gestionzapateria.repositories.RepositorioDireccion;

/**
 *
 * @author profesor
 */

@RestController
@RequestMapping("/rest")
public class Controlador {
    
    // RepositorioClientes repositorioCliente;
    
    @Autowired
    RepositorioClientes repoClient;
    
    @Autowired
    RepositorioCodPos repoCodPos;
    
    @Autowired
    RepositorioDireccion repoDirec;

   // Get All Clientes
    @GetMapping("/clientes")
    public List<Cliente> getAllAlumnos() {
        return repoClient.findAll();
    }
    
    
    // Get All Clientes
    @GetMapping("/codpos")
    public List<CodPos> getAllCodPos() {
        return repoCodPos.findAll();
    }
    
    
    // Get All Clientes
    @GetMapping("/direcciones")
    public List<ClienteDireccion> getAllDirecciones() {
        return repoDirec.findAll();
    }
    
   /*
    // Get All Notes
    @GetMapping("/cliente/{id}")
    public List<ClienteDireccion> getDireccions(Long id) {
        return repoClient.();
    }
   */

    
}
