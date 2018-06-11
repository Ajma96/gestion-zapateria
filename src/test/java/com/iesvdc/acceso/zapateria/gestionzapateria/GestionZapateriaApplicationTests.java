package com.iesvdc.acceso.zapateria.gestionzapateria;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.iesvdc.acceso.zapateria.gestionzapateria.entities.Cliente;
import com.iesvdc.acceso.zapateria.gestionzapateria.repositories.RepositorioClientes;
import com.iesvdc.acceso.zapateria.gestionzapateria.repositories.RepositorioDireccion;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GestionZapateriaApplicationTests {

	@Autowired
	RepositorioClientes clientesRepo;
	
	@Autowired
	RepositorioDireccion direccionRepo;
	
	@Test
	@Transactional
	public void assertInsertions() {
		assertEquals(3, clientesRepo.count());
		Cliente cliente = clientesRepo.findByNombre("Pepe").get();
		
		//El resuiltado es el mismo! Pero deja entrever la ventaja fundamentar de los ORM 
		//(no hace falta un repositorio especifico para las tablas resultantes de una relacion entre dos entidades)
		assertEquals("Paseo de la Estación 44", direccionRepo.findByNombre("Mi casa").get().getNombreVia());
		assertEquals("Paseo de la Estación 44", cliente.getClienteDireccionList().get(0).getNombreVia());
	}
}