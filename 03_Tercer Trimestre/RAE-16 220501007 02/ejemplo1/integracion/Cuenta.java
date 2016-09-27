/**
 * Cuenta
 * 
 * Version 1.0
 * 24-Agosto-2016
 * 
 * EntryIndex
 */
package edu.co.sena.entryindex.integracion;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Esta clase contiene el mapeo de la base de datos de la tabla CUENTA
 * @author Usuario
 */
@Entity
@Table(name = "CUENTA")
@NamedQueries({
    @NamedQuery(name = "Cuenta.findAll", query = "SELECT c FROM Cuenta c"),
    @NamedQuery(name = "Cuenta.findByPK", query = "SELECT c FROM Cuenta c where c.cuentaPK.numeroDocumento=:numeroDocumento and c.cuentaPK.tipoDocumentoTipoDocumento=:tipoDocumento"),
    @NamedQuery(name = "Cuenta.updatePK", query = "UPDATE Cuenta c set c.cuentaPK.numeroDocumento=:nuevoNum,c.cuentaPK.tipoDocumentoTipoDocumento=:tipDoc where c.cuentaPK.numeroDocumento=:numDoc and c.cuentaPK.tipoDocumentoTipoDocumento=:tipoDoc"),
    @NamedQuery(name = "Cuenta.findByNumeroDocumento", query = "SELECT c FROM Cuenta c WHERE c.cuentaPK.numeroDocumento LIKE :numeroDocumento"),
    @NamedQuery(name = "Cuenta.findByTipoDocumentoTipoDocumento", query = "SELECT c FROM Cuenta c WHERE c.cuentaPK.tipoDocumentoTipoDocumento = :tipoDocumentoTipoDocumento"),
    @NamedQuery(name = "Cuenta.findByPrimerNombre", query = "SELECT c FROM Cuenta c WHERE c.primerNombre LIKE :primerNombre"),
    @NamedQuery(name = "Cuenta.findBySegundoNombre", query = "SELECT c FROM Cuenta c WHERE c.segundoNombre LIKE :segundoNombre"),
    @NamedQuery(name = "Cuenta.findByPrimerApellido", query = "SELECT c FROM Cuenta c WHERE c.primerApellido LIKE :primerApellido"),
    @NamedQuery(name = "Cuenta.findBySegundoApellido", query = "SELECT c FROM Cuenta c WHERE c.segundoApellido LIKE :segundoApellido"),
    @NamedQuery(name = "Cuenta.findByCargo", query = "SELECT c FROM Cuenta c WHERE c.cargoCargo.cargo like :cargo"),
    @NamedQuery(name = "Cuenta.findByFechaFinalizacion", query = "SELECT c FROM Cuenta c WHERE c.fechaFinalizacion BETWEEN :fechaIni AND :fechaFin"),
    @NamedQuery(name = "Cuenta.findByEstado", query = "SELECT c FROM Cuenta c WHERE c.estado = :estado")})
public class Cuenta implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CuentaPK cuentaPK;
    @Lob
    @Column(name = "FOTO")
    private byte[] foto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "PRIMER_NOMBRE")
    private String primerNombre;
    @Size(max = 45)
    @Column(name = "SEGUNDO_NOMBRE")
    private String segundoNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "PRIMER_APELLIDO")
    private String primerApellido;
    @Size(max = 45)
    @Column(name = "SEGUNDO_APELLIDO")
    private String segundoApellido;
    @Column(name = "FECHA_FINALIZACION")
    @Temporal(TemporalType.DATE)
    private Date fechaFinalizacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTADO")
    private boolean estado = true;
    @JoinTable(name = "PROPIETARIO", joinColumns = {
        @JoinColumn(name = "CUENTA_NUMERO_DOCUMENTO", referencedColumnName = "NUMERO_DOCUMENTO"),
        @JoinColumn(name = "CUENTA_TIPO_DOCUMENTO_TIPO_DOCUMENTO", referencedColumnName = "TIPO_DOCUMENTO_TIPO_DOCUMENTO")}, inverseJoinColumns = {
        @JoinColumn(name = "EQUIPO_ID_EQUIPO", referencedColumnName = "ID_EQUIPO")})
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Equipo> equipoCollection;
    @JoinColumn(name = "CARGO_CARGO", referencedColumnName = "CARGO")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Cargo cargoCargo;
    @JoinColumn(name = "TIPO_DOCUMENTO_TIPO_DOCUMENTO", referencedColumnName = "TIPO_DOCUMENTO", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private TipoDocumento tipoDocumento;
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "cuenta", fetch = FetchType.EAGER)
    private Collection<Usuario> usuarioCollection;
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "cuenta", fetch = FetchType.EAGER)
    private Collection<Registro> registroCollection;

    public Cuenta() {
        /**
         * Esto es un costructor generico
         */
    }
    /**
     * Inicializa la cuenta
     * @param cuentaPK 
     */
    public Cuenta(CuentaPK cuentaPK) {
        this.cuentaPK = cuentaPK;
    }
    /**
     * Este constructor que inicializa las variables
     * @param cuentaPK llaves primarias de la cuenta numero de documento 
     * y tipo documento
     * @param primerNombre objeto String primer nombre del usuario 
     * @param primerApellido objeto String primer apellido del usuario
     * @param estado objeto primitivo boolean si el usuario esta activo o 
     * inactivo
     */
    public Cuenta(CuentaPK cuentaPK, String primerNombre, String primerApellido, boolean estado) {
        this.cuentaPK = cuentaPK;
        this.primerNombre = primerNombre;
        this.primerApellido = primerApellido;
        this.estado = estado;
    }
    /**
     * Este constructor inicializa la cuentaPK con las variables
     * @param numeroDocumento objeto String numero de documento del usuario
     * @param tipoDocumentoTipoDocumento objeto String tipo de documento 
     * que puede tener el usuario
     */
    public Cuenta(String numeroDocumento, String tipoDocumentoTipoDocumento) {
        this.cuentaPK = new CuentaPK(numeroDocumento, tipoDocumentoTipoDocumento);
    }
    /**
     * Este metodo obtiene las llaves primarias de Cuenta
     * @return retorna los datos de la clase CuentaPK
     */
    public CuentaPK getCuentaPK() {
        return cuentaPK;
    }
    /**
     * Este metodo permite añadir las llaves primarias de Cuenta
     * @param cuentaPK objeto String tipo documento y numero documento
     */
    public void setCuentaPK(CuentaPK cuentaPK) {
        this.cuentaPK = cuentaPK;
    }
    /**
     * Obtiene la foto de la cuenta
     * @return dato primitivo byte foto para reconocer al usuario
     */
    public byte[] getFoto() {
        return foto;
    }
    /**
     * Permite añadir la foto que va a tener la cuenta
     * @param foto dato primitico byte foto para reconocer el usuario
     */
    public void setFoto(byte[] foto) {
        this.foto = foto;
    }
    /**
     * Obtiene el primer nombre de la cuenta
     * @return objeto String nombre que tiene el usuario
     */
    public String getPrimerNombre() {
        return primerNombre;
    }
    /**
     * Permite añadir el primer nombre de la cuenta
     * @param primerNombre objeto tipo String nombre que tiene el usuario
     */
    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }
    /**
     * Obtiene el segundo nombre de la cuenta
     * @return retorna objeto tipo String nombre que tiene el usuario
     */
    public String getSegundoNombre() {
        return segundoNombre;
    }
    /**
     * Permite añadir el segundo nombre de la cuenta
     * @param segundoNombre objeto String nombre que tiene el usuario
     */
    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }
    /**
     * Obtiene el primer apellido de la cuenta
     * @return objeto String apellido que tiene el usuario
     */
    public String getPrimerApellido() {
        return primerApellido;
    }
    /**
     * Permite añadir el primer apellido de la cuenta
     * @param primerApellido objeto String apellido que tiene el usuario
     */
    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }
    /**
     * Obtiene el segundo apellido de la cuenta
     * @return objeto String apellido que tiene el usuario
     */
    public String getSegundoApellido() {
        return segundoApellido;
    }
    /**
     * Permite añadir el segundo apellido a la cuenta
     * @param segundoApellido objeto String apellido que tiene el usuario
     */
    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }
    /**
     * Obtiene la fecha de finalizacion de la cuenta.
     * @return dato primitivo Date fecha de finalizacion del usuario
     */
    public Date getFechaFinalizacion() {
        return fechaFinalizacion;
    }
    /**
     * Permite anadir a la cuenta una fecha de finalizacion.
     * @param fechaFinalizacion dato primitivo Date fecha de finalizacion 
     * del usuario
     */
    public void setFechaFinalizacion(Date fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }
    /**
     * Obtiene el estado actual de la cuenta 
     * @return dato primitivo boolean estado activo o inactivo
     */
    public boolean getEstado() {
        return estado;
    }
    /**
     * Permite cambiar el estado de la cuenta a otro estado 
     * @param estado dato primitivo boolean el estado activo o inactivo
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    /**
     * Obtiene la coleccion {@code Collection} de equipos de la base de datos 
     * @return retorna una coleccion de equipos
     */
    public Collection<Equipo> getEquipoCollection() {
        return equipoCollection;
    }
    /**
     * Permite añadir los equipos a la coleccion
     * @param equipoCollection 
     */
    public void setEquipoCollection(Collection<Equipo> equipoCollection) {
        this.equipoCollection = equipoCollection;
    }
    /**
     * Obtiene el cargo que tiene la cuenta
     * @return objeto String cargo que tiene el usuario
     */
    public Cargo getCargoCargo() {
        return cargoCargo;
    }
    /**
     * Permite anadir el cargo a la cuenta.
     * @param cargoCargo objeto String cargo que puede tener el usuario
     */
    public void setCargoCargo(Cargo cargoCargo) {
        this.cargoCargo = cargoCargo;
    }
    /**
     * Obtiene el tipo de documento que tiene la cuenta
     * @return objeto String tipo de documento del usuario
     */
    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }
    /**
     * Permite anadir el tipo de documento a la cuenta
     * @param tipoDocumento objeto String tipo de documento del usuario
     */
    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }
    /**
     * Obtiene la coleccion {@code Collection} de Usuarios de la base de datos
     * @return retorna coleccion de Usuario
     */
    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }
    /**
     * Perminte añadir Usuarios a la coleccion 
     * @param usuarioCollection 
     */
    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }
    /**
     * Obtiene la coleccion {@code Collection}  de Registro de la base de datos 
     * @return retorna una coleccion de Registros 
     */
    public Collection<Registro> getRegistroCollection() {
        return registroCollection;
    }
    /**
     * Permite añadir registros a la coleccion
     * @param registroCollection 
     */
    public void setRegistroCollection(Collection<Registro> registroCollection) {
        this.registroCollection = registroCollection;
    }
    /**
     * Este metodo obtiene el id unico de memoria de la clase
     * @return retorna dato primitivo entero
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cuentaPK != null ? cuentaPK.hashCode() : 0);
        return hash;
    }
    /**
     * Este metodo compara entre los cuentas 
     * @param object 
     * @return retorna dato primitivo boolean
     */
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Cuenta)) {
            return false;
        }
        Cuenta other = (Cuenta) object;
        if (!this.cuentaPK.equals(other.cuentaPK)) {
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
        return "Tipo De Documento [" + cuentaPK.getTipoDocumentoTipoDocumento()
                + "]" + ", Numero De Documento [" + cuentaPK.getNumeroDocumento()
                + "]," + " Primer Nombre [" + primerNombre + "], Segundo Nombre "
                + "[" + segundoNombre + "], Primer Apellido [" + primerApellido
                + "], " + "Cargo [" + cargoCargo.getCargo() + "],"
                + " Fecha De Finalizacion" + " [" + fechaFinalizacion + "]";
    }
}
