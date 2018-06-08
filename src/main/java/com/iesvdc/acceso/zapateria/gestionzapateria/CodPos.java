/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iesvdc.acceso.zapateria.gestionzapateria;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author matinal
 */
@Entity
@Table(name = "cod_pos")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "CodPos.findAll", query = "SELECT c FROM CodPos c")
  , @NamedQuery(name = "CodPos.findByCp", query = "SELECT c FROM CodPos c WHERE c.cp = :cp")
  , @NamedQuery(name = "CodPos.findByLocalidad", query = "SELECT c FROM CodPos c WHERE c.localidad = :localidad")})
public class CodPos implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(nullable = false)
  private Integer cp;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 120)
  @Column(nullable = false, length = 120)
  private String localidad;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "cp")
  private Collection<ClienteDireccion> clienteDireccionCollection;

  public CodPos() {
  }

  public CodPos( Integer cp ) {
    this.cp = cp;
  }

  public CodPos( Integer cp, String localidad ) {
    this.cp = cp;
    this.localidad = localidad;
  }

  public Integer getCp() {
    return cp;
  }

  public void setCp( Integer cp ) {
    this.cp = cp;
  }

  public String getLocalidad() {
    return localidad;
  }

  public void setLocalidad( String localidad ) {
    this.localidad = localidad;
  }

  @XmlTransient
  public Collection<ClienteDireccion> getClienteDireccionCollection() {
    return clienteDireccionCollection;
  }

  public void setClienteDireccionCollection( Collection<ClienteDireccion> clienteDireccionCollection ) {
    this.clienteDireccionCollection = clienteDireccionCollection;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (cp != null ? cp.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals( Object object ) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof CodPos)) {
      return false;
    }
    CodPos other = (CodPos) object;
    if ((this.cp == null && other.cp != null) || (this.cp != null && !this.cp.equals(other.cp))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "com.iesvdc.acceso.zapateria.gestionzapateria.CodPos[ cp=" + cp + " ]";
  }
  
}
