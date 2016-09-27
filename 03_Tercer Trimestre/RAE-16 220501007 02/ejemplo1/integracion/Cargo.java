/**
 * Cargo 
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
 * Esta clase contiene el mapeo de la base de datos de la tabla CARGO
 * @author Dxracso
 */
@Entity
@Table(name = "CARGO")
@NamedQueries({
    @NamedQuery(name = "Cargo.updateCargoPK", query = "UPDATE Cargo c SET c.cargo = :nuevoCargo where c.cargo = :antiguoCargo"),
    @NamedQuery(name = "Cargo.updateCargo", query = "UPDATE Cargo c SET c.descripcion = :nuevoDescripcion , c.estado = :nuevoEsctado where c.cargo = :antiguoCargo"),
    @NamedQuery(name = "Cargo.findAll", query = "SELECT c FROM Cargo c"),
    @NamedQuery(name = "Cargo.findByCargo", query = "SELECT c FROM Cargo c WHERE c.cargo LIKE :cargo"),
    @NamedQuery(name = "Cargo.findByDescripcion", query = "SELECT c FROM Cargo c WHERE c.descripcion LIKE :descripcion"),
    @NamedQuery(name = "Cargo.findByEstado", query = "SELECT c FROM Cargo c WHERE c.estado = :estado"),
    @NamedQuery(name = "Cargo.findByVisita", query = "SELECT c FROM Cargo c WHERE c.motivoVisitaRequerido = :visitante"),
    @NamedQuery(name = "Cargo.findByMotivoVisitaRequerido", query = "SELECT c FROM Cargo c WHERE c.motivoVisitaRequerido = :motivoVisitaRequerido")})
public class Cargo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CARGO")
    private String cargo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTADO")
    private boolean estado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MOTIVO_VISITA_REQUERIDO")
    private boolean motivoVisitaRequerido;
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "cargoCargo", fetch = FetchType.EAGER)
    private Collection<Cuenta> cuentaCollection;
   
    public Cargo(){
        /**
         * Esto es un costructor generico 
         */
    }
    /**
     * Este constructor obtiene el parametro String cargo
     * @param cargo 
     */
    public Cargo(String cargo) {
        this.cargo = cargo;
    }
    /**
     * Este constructor que inicializa las variables
     * @param cargo objeto String cargo que puede tener el usuario
     * @param descripcion objeto String descripcion del cargo
     * @param estado objeto primitivo boolean activo o inactivo para el usuario
     */
    public Cargo(String cargo, String descripcion, boolean estado) {
        this.cargo = cargo;
        this.descripcion = descripcion;
        this.estado = estado;
    }
    /**
     * Obtiene nombre del cargo 
     * @return objeto String cargo que puede tener el usuario
     */
    public String getCargo() {
        return cargo;
    }
    /**
     * Permite anadir el nombre del cargo.
     * @param cargo objeto String cargo que puede tener el usuario
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    /**
     * Obtiene la descripcion del cargo. 
     * @return objeto String descripcion funcion tiene el cargo
     */
    public String getDescripcion() {
        return descripcion;
    }
    /**
     * Permite anadir la descripcion del cargo.
     * @param descripcion objeto String descripcion que tiene el cargo
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    /**
     * Obtiene el estado del cargo que tiene la base de datos
     * @return dato primitivo boolean estado activo o inactivo
     */
    public boolean getEstado() {
        return estado;
    }
    /**
     * Permite cambiar el estado del cargo a otro estado de cargo 
     * @param estado dato primitivo boolean el estado activo o inactivo
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    /**
     * Obtiene la coleccion {@code Collection} de cuentas de la base de datos 
     * @return retorna una coleccion de cuentas 
     */
    public Collection<Cuenta> getCuentaCollection() {
        return cuentaCollection;
    }
    /**
     * Permite añadir las cuentas a la coleccion
     * @param cuentaCollection 
     */
    public void setCuentaCollection(Collection<Cuenta> cuentaCollection) {
        this.cuentaCollection = cuentaCollection;
    }
    /**
     * Este metodo obtiene el id unico de memoria de la clase
     * @return retorna dato primitivo entero
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cargo != null ? cargo.hashCode() : 0);
        return hash;
    }
    /**
     * Este metodo compara entre los cargos 
     * @param object 
     * @return retorna dato primitivo boolean
     */
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Cargo)) {
            return false;
        }
        Cargo other = (Cargo) object;
        if (!this.cargo.equals(other.cargo)) {
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
        return cargo;
    }
    /**
     * Este metodo retorna un dato primitivo boolean
     * @return 
     */
    public boolean isMotivoVisitaRequerido() {
        return motivoVisitaRequerido;
    }
    /**
     * Este metodo recibe por medio del parametro motivoVisitaRequerido
     * un objeto primitivo boolean
     * @param motivoVisitaRequerido 
     */
    public void setMotivoVisitaRequerido(boolean motivoVisitaRequerido) {
        this.motivoVisitaRequerido = motivoVisitaRequerido;
    }
    
}
