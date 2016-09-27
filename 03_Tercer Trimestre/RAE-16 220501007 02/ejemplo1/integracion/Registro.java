/**
 * Registro 
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
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Esta clase contiene el mapeo de la base de datos de la tabla REGISTRO
 * @author Usuario
 */
@Entity
@Table(name = "REGISTRO")
@NamedQueries({
    @NamedQuery(name = "Registro.findAll", query = "SELECT r FROM Registro r"),
    @NamedQuery(name = "Registro.findByTipoDocumento", query = "SELECT r FROM Registro r WHERE r.cuenta.tipoDocumento.tipoDocumento = :tipoDocumento"),
    @NamedQuery(name = "Registro.findByNumeroDocumento", query = "SELECT r FROM Registro r WHERE r.cuenta.cuentaPK.numeroDocumento = :numeroDocumento"),
    @NamedQuery(name = "Registro.findByNumeroRegistro", query = "SELECT r FROM Registro r WHERE r.numeroRegistro = :numeroRegistro"),
    @NamedQuery(name = "Registro.findByFechaEntrada", query = "SELECT r FROM Registro r WHERE r.fechaEntrada BETWEEN :fechaInicial and :fechaFinal"),
    @NamedQuery(name = "Registro.findByFechaSalida", query = "SELECT r FROM Registro r WHERE r.fechaSalida BETWEEN :fechaInicial and :fechaFinal"),
    @NamedQuery(name = "Registro.findByVisitaLike", query = "SELECT r FROM Registro r WHERE r.visita LIKE :visita"),
    @NamedQuery(name = "Registro.findByRollVisita", query = "SELECT r FROM Registro r WHERE r.rollVisita = :rollVisita"),
    @NamedQuery(name = "Registro.findCuentaPK", query = "SELECT r FROM Registro r WHERE r.cuenta.cuentaPK.numeroDocumento = :numeroDocumento and r.cuenta.cuentaPK.tipoDocumentoTipoDocumento = :tipoDocumento ORDER BY r.numeroRegistro DESC" )})
public class Registro implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "registro", fetch = FetchType.EAGER)
    private Collection<RegistroEquipo> registroEquipoCollection;
    @OneToMany(mappedBy = "registroNumeroRegistroSalida", fetch = FetchType.EAGER)
    private Collection<RegistroEquipo> registroEquipoCollectionSalida;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "NUMERO_REGISTRO")
    private Integer numeroRegistro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_ENTRADA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEntrada;
    @Column(name = "FECHA_SALIDA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaSalida;
    @Size(max = 200)
    @Column(name = "VISITA")
    private String visita;
    @Size(max = 20)
    @Column(name = "ROLL_VISITA")
    private String rollVisita;
    @JoinColumns({
        @JoinColumn(name = "CUENTA_NUMERO_DOCUMENTO", referencedColumnName = "NUMERO_DOCUMENTO"),
        @JoinColumn(name = "CUENTA_TIPO_DOCUMENTO_TIPO_DOCUMENTO", referencedColumnName = "TIPO_DOCUMENTO_TIPO_DOCUMENTO")})
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Cuenta cuenta;

    public Registro() {
        /**
         * Esto es un costructor generico
         */
    }
    /**
     * Este constructor obtiene el parametro Integer numero de registro
     * @param numeroRegistro 
     */
    
    public Registro(Integer numeroRegistro) {
        this.numeroRegistro = numeroRegistro;
    }
    /**
     * Este constructor inicializa las variables
     * @param numeroRegistro objeto Integer numero de resgistro con 
     * el que ingresa el usuario
     * @param fechaEntrada objeto Date fecha de caundo el usuario 
     * ingresa a las instalaciones
     */
    public Registro(Integer numeroRegistro, Date fechaEntrada) {
        this.numeroRegistro = numeroRegistro;
        this.fechaEntrada = fechaEntrada;
    }
    /**
     * Obtiene el numero de registro de ingreso del usuario
     * @return objeto Integer numero de resgistro 
     */
    public Integer getNumeroRegistro() {
        return numeroRegistro;
    }
    /**
     * Permite añadir el numero de registro de ingreso del usuario
     * @param numeroRegistro objeto Integer numero de registro
     */
    public void setNumeroRegistro(Integer numeroRegistro) {
        this.numeroRegistro = numeroRegistro;
    }
    /**
     * Obtiene la fecha en la que ingreso el usuario
     * @return objeto Date fecha de ingreso
     */
    public Date getFechaEntrada() {
        return fechaEntrada;
    }
    /**
     * Permite añadir la fecha de entrada del usuario
     * @param fechaEntrada objeto Date fecha de entrada
     */
    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }
    /**
     * Obtiene la fecha en la que salio el usuario
     * @return objeto Date fecha salida
     */
    public Date getFechaSalida() {
        return fechaSalida;
    }
    /**
     * Permite añadir la fecha de salida del usuario
     * @param fechaSalida objeto Date fecha de salida
     */
    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }
    /**
     * Obtiene el motivo de visita cuando el usuario ingresa como visitante
     * @return objeto String motivo de la visita
     */
    public String getVisita() {
        return visita;
    }
    /**
     * Permite agregar el motivo de la visita cuando el usuario
     * ingresa como visitante
     * @param visita objeto String motivo de la visita
     */
    public void setVisita(String visita) {
        this.visita = visita;
    }
    /**
     * Obtiene el roll del usuario cuando ingresa como visitante
     * @return objeto String roll que tiene el usuario visitante
     */
    public String getRollVisita() {
        return rollVisita;
    }
    /**
     * Permite añadir el roll del usuario cuando es visitante
     * @param rollVisita objeto String roll que tiene el usuario visitante
     */
    public void setRollVisita(String rollVisita) {
        this.rollVisita = rollVisita;
    }
    /**
     * Obtiene la cuenta para el registro del usuario
     * @return retorna una Cuenta
     */
    public Cuenta getCuenta() {
        return cuenta;
    }
    /**
     * Permite añadir el registro a la Cuenta
     * @param cuenta 
     */
    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }
    /**
     * Este metodo obtiene el id unico de memoria de la clase
     * @return retorna dato primitivo entero
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroRegistro != null ? numeroRegistro.hashCode() : 0);
        return hash;
    }
    /**
     * Este metodo compara entre los equipos 
     * @param object 
     * @return retorna dato primitivo boolean
     */
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Registro)) {
            return false;
        }
        Registro other = (Registro) object;
        if (!this.numeroRegistro.equals(other.numeroRegistro)) {
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
        return "edu.co.sena.entryindex.integracion.Registro[ numeroRegistro=" + numeroRegistro + " ]";
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
     * Este metodo retorna una coleccion {@code Collection} de RegistroEquipo 
     * @return retorna una coleccion de RegistroEquipo 
     */
    @XmlTransient
    public Collection<RegistroEquipo> getRegistroEquipoCollectionSalida() {
        return registroEquipoCollectionSalida;
    }
    /**
     * Este metodo recibe por medio del parametro coleccion una objeto tipo
     * coleccion
     * @param registroEquipoCollectionSalida 
     */
    public void setRegistroEquipoCollectionSalida(Collection<RegistroEquipo> registroEquipoCollectionSalida) {
        this.registroEquipoCollectionSalida = registroEquipoCollectionSalida;
    }
}
