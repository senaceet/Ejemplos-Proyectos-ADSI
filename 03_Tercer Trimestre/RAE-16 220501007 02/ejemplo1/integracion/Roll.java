/**
 * Roll
 * 
 * Version 1.0
 * 24-Agosto-2016
 * 
 * EntryIndex
 */
package edu.co.sena.entryindex.integracion;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Esta clase contiene el mapeo de la base de datos de la tabla ROLL
 * @author Usuario
 */
@Entity
@Table(name = "ROLL")
@NamedQueries({
    @NamedQuery(name = "Roll.findAll", query = "SELECT r FROM Roll r"),
    @NamedQuery(name = "Roll.findByRoll", query = "SELECT r FROM Roll r WHERE r.roll = :roll"),
    @NamedQuery(name = "Roll.findByDescripcion", query = "SELECT r FROM Roll r WHERE r.descripcion = :descripcion"),
    @NamedQuery(name = "Roll.findByEstado", query = "SELECT r FROM Roll r WHERE r.estado = :estado")})
public class Roll implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ROLL")
    private String roll;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTADO")
    private boolean estado;
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "rollRoll", fetch = FetchType.EAGER)
    private Collection<Usuario> usuarioCollection;

    public Roll() {
        /**
         * Esto es un costructor generico
         */
    }
    /**
     * Este constructor recibe el parametro roll a travez de un String
     * @param roll 
     */
    public Roll(String roll) {
        this.roll = roll;
    }
    /**
     * Este constructor recibe por medio de los parametros roll y 
     * descripcion un String y estado un boolean
     * @param roll
     * @param descripcion
     * @param estado 
     */
    public Roll(String roll, String descripcion, boolean estado) {
        this.roll = roll;
        this.descripcion = descripcion;
        this.estado = estado;
    }
    /**
     * Este metodo retorna un objeto String
     * @return objeto String
     */
    public String getRoll() {
        return roll;
    }
    /**
     * Este metodo recibe por medio del parametro roll un objeto String
     * @param roll objeto String
     */
    public void setRoll(String roll) {
        this.roll = roll;
    }
    /**
     * Este metodo retorna un objeto String
     * @return objeto String
     */
    public String getDescripcion() {
        return descripcion;
    }
    /**
     * Este metodo recibe por medio del parametro descripcion un objeto String
     * @param descripcion 
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    /**
     * Este metodo retorna un dato primitivo boolean
     * @return dato primitivo boolean
     */
    public boolean getEstado() {
        return estado;
    }
    /**
     * Este metodo recibe por medio de estado un objeto boolean
     * @param estado 
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    /**
     * Este metodo retorna una coleccion {@code Collection} de Usuario 
     * @return retorna una coleccion de Usuario
     */
    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }
    /**
     * Este metodo recibe por medio del parametro coleccion una objeto tipo
     * coleccion
     * @param usuarioCollection 
     */
    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }
    /**
     * Este metodo obtiene el id unico de memoria de la clase
     * @return retorna dato primitivo entero
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roll != null ? roll.hashCode() : 0);
        return hash;
    }
    /**
     * Este metodo compara entre los cargos 
     * @param object 
     * @return retorna dato primitivo boolean
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Roll)) {
            return false;
        }
        Roll other = (Roll) object;
        if (!this.roll.equals(other.roll)) {
            return false;
        }
        return true;
    }
    /**
     * Este metodo contiene los valores de las variables de los get y set
     * @return  
     */
    @Override
    public String toString() {
        return  roll ;
    }
}
