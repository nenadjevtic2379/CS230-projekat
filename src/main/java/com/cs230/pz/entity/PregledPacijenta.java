/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cs230.pz.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Korsn
 */
@Entity
@Table(name = "pregled_pacijenta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PregledPacijenta.findAll", query = "SELECT p FROM PregledPacijenta p")
    , @NamedQuery(name = "PregledPacijenta.findByIDPregleda", query = "SELECT p FROM PregledPacijenta p WHERE p.iDPregleda = :iDPregleda")
    , @NamedQuery(name = "PregledPacijenta.findByDatumPregleda", query = "SELECT p FROM PregledPacijenta p WHERE p.datumPregleda = :datumPregleda")
    , @NamedQuery(name = "PregledPacijenta.findBySledeciPregled", query = "SELECT p FROM PregledPacijenta p WHERE p.sledeciPregled = :sledeciPregled")
    , @NamedQuery(name = "PregledPacijenta.findByOpisPregleda", query = "SELECT p FROM PregledPacijenta p WHERE p.opisPregleda = :opisPregleda")
    , @NamedQuery(name = "PregledPacijenta.findByUsersEmail", query = "SELECT p FROM PregledPacijenta p WHERE p.usersEmail = :usersEmail")})
public class PregledPacijenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDPregleda")
    private Integer iDPregleda;
    @Column(name = "datumPregleda")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datumPregleda;
    @Column(name = "sledeciPregled")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sledeciPregled;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "opisPregleda")
    private String opisPregleda;
    @Size(max = 45)
    @Column(name = "users_email")
    private String usersEmail;
    @JoinColumn(name = "patient_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Patient patientID;

    public PregledPacijenta() {
    }

    public PregledPacijenta(Integer iDPregleda) {
        this.iDPregleda = iDPregleda;
    }

    public PregledPacijenta(Integer iDPregleda, String opisPregleda) {
        this.iDPregleda = iDPregleda;
        this.opisPregleda = opisPregleda;
    }

    public Integer getIDPregleda() {
        return iDPregleda;
    }

    public void setIDPregleda(Integer iDPregleda) {
        this.iDPregleda = iDPregleda;
    }

    public Date getDatumPregleda() {
        return datumPregleda;
    }

    public void setDatumPregleda(Date datumPregleda) {
        this.datumPregleda = datumPregleda;
    }

    public Date getSledeciPregled() {
        return sledeciPregled;
    }

    public void setSledeciPregled(Date sledeciPregled) {
        this.sledeciPregled = sledeciPregled;
    }

    public String getOpisPregleda() {
        return opisPregleda;
    }

    public void setOpisPregleda(String opisPregleda) {
        this.opisPregleda = opisPregleda;
    }

    public String getUsersEmail() {
        return usersEmail;
    }

    public void setUsersEmail(String usersEmail) {
        this.usersEmail = usersEmail;
    }

    public Patient getPatientID() {
        return patientID;
    }

    public void setPatientID(Patient patientID) {
        this.patientID = patientID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDPregleda != null ? iDPregleda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PregledPacijenta)) {
            return false;
        }
        PregledPacijenta other = (PregledPacijenta) object;
        if ((this.iDPregleda == null && other.iDPregleda != null) || (this.iDPregleda != null && !this.iDPregleda.equals(other.iDPregleda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cs230.pz.entity.PregledPacijenta[ iDPregleda=" + iDPregleda + " ]";
    }
    
}
