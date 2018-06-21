/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cs230.pz.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Korsn
 */
@Entity
@Table(name = "patient")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Patient.findAll", query = "SELECT p FROM Patient p")
    , @NamedQuery(name = "Patient.findById", query = "SELECT p FROM Patient p WHERE p.id = :id")
    , @NamedQuery(name = "Patient.findByPatientFirstName", query = "SELECT p FROM Patient p WHERE p.patientFirstName = :patientFirstName")
    , @NamedQuery(name = "Patient.findByBirthDate", query = "SELECT p FROM Patient p WHERE p.birthDate = :birthDate")
    , @NamedQuery(name = "Patient.findByPatientLastName", query = "SELECT p FROM Patient p WHERE p.patientLastName = :patientLastName")
    , @NamedQuery(name = "Patient.findByJmbg", query = "SELECT p FROM Patient p WHERE p.jmbg = :jmbg")})
public class Patient implements Serializable {

    @Size(max = 45)
    @Column(name = "addedBy")
    private String addedBy;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patientID")
    private Collection<PregledPacijenta> pregledPacijentaCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "patientFirstName")
    private String patientFirstName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "birthDate")
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    @Size(max = 45)
    @Column(name = "patientLastName")
    private String patientLastName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "JMBG")
    private String jmbg;

    public Patient() { 
    }

    public Patient(Integer id) {
        this.id = id;
    }

    public Patient(Integer id, String patientFirstName, Date birthDate, String jmbg) {
        this.id = id;
        this.patientFirstName = patientFirstName;
        this.birthDate = birthDate;
        this.jmbg = jmbg;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPatientFirstName() {
        return patientFirstName;
    }

    public void setPatientFirstName(String patientFirstName) {
        this.patientFirstName = patientFirstName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getPatientLastName() {
        return patientLastName;
    }

    public void setPatientLastName(String patientLastName) {
        this.patientLastName = patientLastName;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Patient)) {
            return false;
        }
        Patient other = (Patient) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Ime: " + patientFirstName + " " + patientLastName + " JMBG: " + jmbg;
    }

    @XmlTransient
    public Collection<PregledPacijenta> getPregledPacijentaCollection() {
        return pregledPacijentaCollection;
    }

    public void setPregledPacijentaCollection(Collection<PregledPacijenta> pregledPacijentaCollection) {
        this.pregledPacijentaCollection = pregledPacijentaCollection;
    }

    public String getAddedBy() {
        return addedBy;
    }

    public void setAddedBy(String addedBy) {
        this.addedBy = addedBy;
    }
    
}
