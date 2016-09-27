/**
 * Usuario
 * 
 * Version 1.0
 * 24-Agosto-2016
 * 
 * EntryIndex
 */
package edu.co.sena.entryindex.integracion;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Esta clase contiene el mapeo de la base de datos de la tabla USUARIO
 * @author Usuario
 */
@Entity
@Table(name = "USUARIO")
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByCorreoElectronico", query = "SELECT u FROM Usuario u WHERE u.correoElectronico LIKE :correoElectronico"),
    @NamedQuery(name = "Usuario.findByContrasena", query = "SELECT u FROM Usuario u WHERE u.contrasena LIKE :contrasena"),
    @NamedQuery(name = "Usuario.findByRoll", query = "SELECT u FROM Usuario u where u.rollRoll.roll LIKE :roll"),
    @NamedQuery(name = "Usuario.findByEstado", query = "SELECT u FROM Usuario u where u.estado =:estado"),
    @NamedQuery(name = "Usuario.findByTipoDocumento", query = "SELECT u FROM Usuario u where u.cuenta.cuentaPK.tipoDocumentoTipoDocumento LIKE :tipoDocumento"),
    @NamedQuery(name = "Usuario.findByNumeroDocumento", query = "SELECt u FROM Usuario u where u.cuenta.cuentaPK.numeroDocumento LIKE :numeroDocumento"),
    @NamedQuery(name = "Usuario.Count", query = "SELECT COUNT(u) FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByIdCorreoElectronico", query = "SELECT u FROM Usuario u WHERE u.correoElectronico = :correoElectronico"),
    @NamedQuery(name = "Usuario.UpdatePk", query = "UPDATE Usuario u SET u.correoElectronico=:correoElectronicoNuevo WHERE u.correoElectronico=:correoElectronicoAntiguo")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "CORREO_ELECTRONICO")
    private String correoElectronico;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "CONTRASENA")
    private String contrasena;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTADO")
    private boolean estado;
    @JoinColumns({
        @JoinColumn(name = "CUENTA_NUMERO_DOCUMENTO", referencedColumnName = "NUMERO_DOCUMENTO"),
        @JoinColumn(name = "CUENTA_TIPO_DOCUMENTO_TIPO_DOCUMENTO", referencedColumnName = "TIPO_DOCUMENTO_TIPO_DOCUMENTO")})
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Cuenta cuenta;
    @JoinColumn(name = "ROLL_ROLL", referencedColumnName = "ROLL")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Roll rollRoll;

    public Usuario() {
        /**
         * Esto es un costructor generico
         */
    }
    /**
     * Este constructor recibe el parametro correoElectronico a travez de un 
     * String
     * @param correoElectronico 
     */
    public Usuario(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }
    /**
     * Este constructor recibe por medio de los parametros correoElectronico y 
     * contraseña un String y estado un boolean
     * @param correoElectronico
     * @param contrasena
     * @param estado 
     */
    public Usuario(String correoElectronico, String contrasena, boolean estado) {
        this.correoElectronico = correoElectronico;
        this.contrasena = contrasena;
        this.estado = estado;
    }
    /**
     * Este metodo retorna un objeto String
     * @return objeto String
     */
    public String getCorreoElectronico() {
        return correoElectronico;
    }
    /**
     * Este metodo recibe por medio del parametro conrreoElectronico un objeto 
     * String
     * @param correoElectronico 
     */
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }
    /**
     * Este metodo retorna objeto String
     * @return objeto String
     */
    public String getContrasena() {
        return contrasena;
    }
    /**
     * Este metodo recibe por medio del parametro contraseña un objeto String
     * @param contrasena 
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
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
     * Este metodo retorna un objeto Cuenta
     * @return 
     */
    public Cuenta getCuenta() {
        return cuenta;
    }
    /**
     * Este metodo recibe un objeto Cuenta
     * @param cuenta 
     */
    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }
    /**
     * Este metodo retorna un objeto rollroll
     * @return 
     */
    public Roll getRollRoll() {
        return rollRoll;
    }
    /**
     * Este metodo recibe un objeto rollroll
     * @param rollRoll 
     */
    public void setRollRoll(Roll rollRoll) {
        this.rollRoll = rollRoll;
    }
    /**
     * Este metodo obtiene el id unico de memoria de la clase
     * @return retorna dato primitivo entero
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (correoElectronico != null ? correoElectronico.hashCode() : 0);
        return hash;
    }
    /**
     * Este metodo compara entre los cargos 
     * @param object 
     * @return retorna dato primitivo boolean 
     */
    @Override
    public boolean equals(Object object) {

        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if (!this.correoElectronico.equals(other.correoElectronico)) {
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
        return  correoElectronico;
    }
}
