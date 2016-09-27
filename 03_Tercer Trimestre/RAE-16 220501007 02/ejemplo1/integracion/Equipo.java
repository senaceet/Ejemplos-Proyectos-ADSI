/**
 * Equipo
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
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Esta clase contiene el mapeo de la base de datos de la tabla EQUIPO
 * @author Dxracso
 */
@Entity
@Table(name = "EQUIPO")
@NamedQueries({
    @NamedQuery(name = "Equipo.findAll", query = "SELECT e FROM Equipo e"),
    @NamedQuery(name = "Equipo.findByIdEquipo", query = "SELECT e FROM Equipo e WHERE e.idEquipo = :idEquipo"),
    @NamedQuery(name = "Equipo.findByIdEquipoLike", query = "SELECT e FROM Equipo e WHERE e.idEquipo like :idEquipo"),
    @NamedQuery(name = "Equipo.findByDescripcion", query = "SELECT e FROM Equipo e WHERE e.descripcion like :descripcion"),
    @NamedQuery(name = "Equipo.findByEstado", query = "SELECT e FROM Equipo e WHERE e.estado = :estado")})
public class Equipo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ID_EQUIPO")
    private String idEquipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTADO")
    private boolean estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "equipo", fetch = FetchType.EAGER)
    private Collection<RegistroEquipo> registroEquipoCollection;
    @ManyToMany(mappedBy = "equipoCollection", fetch = FetchType.EAGER)
    private Collection<Cuenta> cuentaCollection;

    public Equipo() {
        /**
         * Esto es un costructor generico
         */
    }
    /**
     * Este constructor obtiene el parametro String idEquipo
     * @param idEquipo 
     */
    public Equipo(String idEquipo) {
        this.idEquipo = idEquipo;
    }
    /**
     * Este constructor inicializa las variables
     * @param idEquipo objeto String numero de identificacion que 
     * tiene el equipo
     * @param descripcion objeto String descripcion del equipo
     * @param estado objeto primitivo boolean activo o inactivo para el equipo
     */
    public Equipo(String idEquipo, String descripcion, boolean estado) {
        this.idEquipo = idEquipo;
        this.descripcion = descripcion;
        this.estado = estado;
    }
    /**
     * Obtiene el numero de identificacion del equipo
     * @return objeto String numero de identificacion del equipo
     */
    public String getIdEquipo() {
        return idEquipo;
    }
    /**
     * Permite añadir el numero de identificacion del equipo
     * @param idEquipo objeto String numero de identificacion del equipo
     */
    public void setIdEquipo(String idEquipo) {
        this.idEquipo = idEquipo;
    }
    /**
     * Obtiene la descripcion del equipo. 
     * @return objeto String descripcion de como es el equipo
     */
    public String getDescripcion() {
        return descripcion;
    }
    /**
     * Permite anadir la descripcion del equipo.
     * @param descripcion objeto String descripcion de como es el equipo
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    /**
     * Obtiene el estado del equipo que tiene la base de datos
     * @return dato primitivo boolean estado activo o inactivo
     */
    public boolean getEstado() {
        return estado;
    }
    /**
     * Permite cambiar el estado del equipo a otro estado 
     * @param estado dato primitivo boolean estado activo o inactivo
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    /**
     * Este metodo retorna una coleccion {@code Collection} de Cuenta 
     * @return retorna una coleccion de cuentas  
     */
    @XmlTransient
    public Collection<Cuenta> getCuentaCollection() {
        return cuentaCollection;
    }
    /**
     * Este metodo recibe por medio del parametro coleccion una objeto tipo
     * coleccion
     * @param cuentaCollection 
     */
    public void setCuentaCollection(Collection<Cuenta> cuentaCollection) {
        this.cuentaCollection = cuentaCollection;
    }
    /**
     * Este metodo retorna una coleccion {@code Collection} de RegistroEquipo 
     * @return retorna una coleccion de RegistroEquipo
     */
    @XmlTransient
    public Collection<RegistroEquipo> getRegistroEquipoCollection() {
        return registroEquipoCollection;
    }
    /**
     * Este metodo recibe por medio del parametro coleccion una objeto tipo
     * coleccion
     * @param registroEquipoCollection 
     */
    public void setRegistroEquipoCollection(Collection<RegistroEquipo> registroEquipoCollection) {
        this.registroEquipoCollection = registroEquipoCollection;
    }
    /**
     * Este metodo obtiene el id unico de memoria de la clase
     * @return retorna dato primitivo entero
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEquipo != null ? idEquipo.hashCode() : 0);
        return hash;
    }
    /**
     * Este metodo compara entre los equipos 
     * @param object 
     * @return retorna dato primitivo boolean
     */
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Equipo)) {
            return false;
        }
        Equipo other = (Equipo) object;

        if (!(this.getIdEquipo().equals(other.getIdEquipo()))) {
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
        return "edu.co.sena.entryindex.integracion.Equipo[ idEquipo=" + idEquipo + " ]";
    }
}
