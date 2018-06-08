/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iesvdc.acceso.zapateria.gestionzapateria;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author matinal
 */
@Entity
@Table(name = "producto_idioma")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "ProductoIdioma.findAll", query = "SELECT p FROM ProductoIdioma p")
  , @NamedQuery(name = "ProductoIdioma.findByCodIdioma", query = "SELECT p FROM ProductoIdioma p WHERE p.codIdioma = :codIdioma")
  , @NamedQuery(name = "ProductoIdioma.findByNombre", query = "SELECT p FROM ProductoIdioma p WHERE p.nombre = :nombre")
  , @NamedQuery(name = "ProductoIdioma.findByDescripcion", query = "SELECT p FROM ProductoIdioma p WHERE p.descripcion = :descripcion")
  , @NamedQuery(name = "ProductoIdioma.findByIdProducto", query = "SELECT p FROM ProductoIdioma p WHERE p.idProducto = :idProducto")})
public class ProductoIdioma implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 3)
  @Column(name = "cod_idioma", nullable = false, length = 3)
  private String codIdioma;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 35)
  @Column(nullable = false, length = 35)
  private String nombre;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 255)
  @Column(nullable = false, length = 255)
  private String descripcion;
  @Basic(optional = false)
  @NotNull
  @Column(name = "id_producto", nullable = false)
  private int idProducto;

  public ProductoIdioma() {
  }

  public ProductoIdioma( String codIdioma ) {
    this.codIdioma = codIdioma;
  }

  public ProductoIdioma( String codIdioma, String nombre, String descripcion, int idProducto ) {
    this.codIdioma = codIdioma;
    this.nombre = nombre;
    this.descripcion = descripcion;
    this.idProducto = idProducto;
  }

  public String getCodIdioma() {
    return codIdioma;
  }

  public void setCodIdioma( String codIdioma ) {
    this.codIdioma = codIdioma;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre( String nombre ) {
    this.nombre = nombre;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion( String descripcion ) {
    this.descripcion = descripcion;
  }

  public int getIdProducto() {
    return idProducto;
  }

  public void setIdProducto( int idProducto ) {
    this.idProducto = idProducto;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (codIdioma != null ? codIdioma.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals( Object object ) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof ProductoIdioma)) {
      return false;
    }
    ProductoIdioma other = (ProductoIdioma) object;
    if ((this.codIdioma == null && other.codIdioma != null) || (this.codIdioma != null && !this.codIdioma.equals(other.codIdioma))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "com.iesvdc.acceso.zapateria.gestionzapateria.ProductoIdioma[ codIdioma=" + codIdioma + " ]";
  }
  
}
