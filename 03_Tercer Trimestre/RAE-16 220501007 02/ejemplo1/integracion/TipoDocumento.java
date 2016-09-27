/**
 * TipoDocumento
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
 * Esta clase contiene el mapeo de la base de datos de la tabla TIPO_DOCUMENTO
 * @author Usuario
 */
@Entity
@Table(name = "TIPO_DOCUMENTO")
@NamedQueries({
    @NamedQuery(name = "TipoDocumento.findAll", query = "SELECT t FROM TipoDocumento t"),
    @NamedQuery(name = "TipoDocumento.findByTipoDocumento", query = "SELECT t FROM TipoDocumento t WHERE t.tipoDocumento = :tipoDocumento"),
    @NamedQuery(name = "TipoDocumento.findByDescripcion", query = "SELECT t FROM TipoDocumento t WHERE t.descripcion LIKE :descripcion"),
    @NamedQuery(name = "TipoDocumento.findByEstado", query = "SELECT t FROM TipoDocumento t WHERE t.estado = :estado"),
    @NamedQuery(name = "TipoDocumento.updatePk", query = "UPDATE TipoDocumento t SET t.tipoDocumento = :tipoDocNue where t.tipoDocumento = :tipoDocVie")})
public class TipoDocumento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "TIPO_DOCUMENTO")
    private String tipoDocumento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTADO")
    private boolean estado;
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "tipoDocumento", fetch = FetchType.EAGER)
    private Collection<Cuenta> cuentaCollection;

    public TipoDocumento() {
        /**
         * Esto es un costructor generico
         */
    }
    /**
     * Este constructor recibe el parametro tipoDocumento a travez de un String
     * @param tipoDocumento 
     */
    public TipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }
    /**
     * Este constructor recibe por medio de los parametros tipoDocumento y 
     * descripcion un String y estado un boolean
     * @param tipoDocumento
     * @param descripcion
     * @param estado 
     */
    public TipoDocumento(String tipoDocumento, String descripcion, boolean estado) {
        this.tipoDocumento = tipoDocumento;
        this.descripcion = descripcion;
        this.estado = estado;
    }
    /**
     * Este metodo retorna objeto String
     * @return objeto String
     */
    public String getTipoDocumento() {
        return tipoDocumento;
    }
    /**
     * Este metodo recibe por medio del parametro tipoDocumento un objeto String
     * @param tipoDocumento objeto String
     */
    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
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
     * Este metodo retorna una coleccion {@code Collection} de cuenta 
     * @return retorna una coleccion de cuentas 
     */
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
     * Este metodo obtiene el id unico de memoria de la clase
     * @return retorna dato primitivo entero
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoDocumento != null ? tipoDocumento.hashCode() : 0);
        return hash;
    }
    /**
     * Este metodo compara entre los cargos 
     * @param object 
     * @return retorna dato primitivo boolean
     */
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof TipoDocumento)) {
            return false;
        }
        TipoDocumento other = (TipoDocumento) object;
        if (!this.tipoDocumento.equals(other.tipoDocumento)) {
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
        return tipoDocumento;
    }
}
