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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author matinal
 */
@Entity
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p")
  , @NamedQuery(name = "Producto.findByIdProducto", query = "SELECT p FROM Producto p WHERE p.idProducto = :idProducto")
  , @NamedQuery(name = "Producto.findByRutaImagen", query = "SELECT p FROM Producto p WHERE p.rutaImagen = :rutaImagen")
  , @NamedQuery(name = "Producto.findByCategoria", query = "SELECT p FROM Producto p WHERE p.categoria = :categoria")})
public class Producto implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id_producto", nullable = false)
  private Integer idProducto;
  @Size(max = 255)
  @Column(name = "ruta_imagen", length = 255)
  private String rutaImagen;
  @Basic(optional = false)
  @NotNull
  @Column(nullable = false)
  private int categoria;

  public Producto() {
  }

  public Producto( Integer idProducto ) {
    this.idProducto = idProducto;
  }

  public Producto( Integer idProducto, int categoria ) {
    this.idProducto = idProducto;
    this.categoria = categoria;
  }

  public Integer getIdProducto() {
    return idProducto;
  }

  public void setIdProducto( Integer idProducto ) {
    this.idProducto = idProducto;
  }

  public String getRutaImagen() {
    return rutaImagen;
  }

  public void setRutaImagen( String rutaImagen ) {
    this.rutaImagen = rutaImagen;
  }

  public int getCategoria() {
    return categoria;
  }

  public void setCategoria( int categoria ) {
    this.categoria = categoria;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (idProducto != null ? idProducto.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals( Object object ) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Producto)) {
      return false;
    }
    Producto other = (Producto) object;
    if ((this.idProducto == null && other.idProducto != null) || (this.idProducto != null && !this.idProducto.equals(other.idProducto))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "com.iesvdc.acceso.zapateria.gestionzapateria.Producto[ idProducto=" + idProducto + " ]";
  }
  
}
