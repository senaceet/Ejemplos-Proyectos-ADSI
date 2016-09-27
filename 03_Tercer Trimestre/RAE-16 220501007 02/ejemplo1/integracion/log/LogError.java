/**
 *
 * oahernandez31@misena.edu.co
 *
 * Version
 * 1 de Junio de 2016 17:05
 *
 * EntryIndex
 */
package edu.co.sena.entryindex.integracion.log;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Dxracso
 */
@Entity
@Table(name = "log_error")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LogError.findAll", query = "SELECT l FROM LogError l"),
    @NamedQuery(name = "LogError.findById", query = "SELECT l FROM LogError l WHERE l.id = :id"),
    @NamedQuery(name = "LogError.findByNivel", query = "SELECT l FROM LogError l WHERE l.nivel = :nivel"),
    @NamedQuery(name = "LogError.findByLogName", query = "SELECT l FROM LogError l WHERE l.logName like :logName"),
    @NamedQuery(name = "LogError.findByMensaje", query = "SELECT l FROM LogError l WHERE l.mensaje like :mensaje"),
    @NamedQuery(name = "LogError.findByUsuario", query = "SELECT l FROM LogError l WHERE l.usuario like :usuario"),
    @NamedQuery(name = "LogError.findByFecha", query = "SELECT l FROM LogError l WHERE l.fecha BETWEEN :fechaInicial and :fechaFinal")})
public class LogError implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Size(max = 15)
    @Column(name = "NIVEL")
    private String nivel;
    @Size(max = 256)
    @Column(name = "LOG_NAME")
    private String logName;
    @Size(max = 1000)
    @Column(name = "MENSAJE")
    private String mensaje;
    @Size(max = 100)
    @Column(name = "USUARIO")
    private String usuario;
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    public LogError() {
        /**
         * Esto es un costructor generico
         */
    }

    /**
     * Este constructor recibe por medio de los parametros nivel, logName, 
     * mensaje, usuario un String y fecha un Date
     * @param nivel
     * @param logName
     * @param mensaje
     * @param usuario
     * @param fecha
     */
    public LogError(String nivel, String logName, String mensaje, String usuario, Date fecha) {
        this.nivel = nivel;
        this.logName = logName;
        this.mensaje = mensaje;
        this.usuario = usuario;
        this.fecha = fecha;
    }

    /**
     * Este metodo retorna un objeto primitivo Long
     * @return objeto Long
     */
    public Long getId() {
        return id;
    }

    /**
     * Este metodo recibe por medio del parametro id un objeto primitivo Long
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Este metodo retorna un objeto String
     * @return objeto String
     */
    public String getNivel() {
        return nivel;
    }

    /**
     * Este metodo recibe por medio del parametro nivel un objeto String
     * @param nivel
     */
    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    /**
     * Este metodo retorna un objeto String
     * @return objeto Satring
     */
    public String getLogName() {
        return logName;
    }

    /**
     * Este metodo recibe por medio del parametro logName un objeto String
     * @param logName
     */
    public void setLogName(String logName) {
        this.logName = logName;
    }

    /**
     * Este metodo retorna un objeto String
     * @return
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * Este metodo recibe por medio del parametro mensaje un objeto String
     * @param mensaje
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    /**
     * Este metodo reetorna un objeto String
     * @return
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Este metodo recibe por medio del parametro usuario un objeto String
     * @param usuario
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * Este metodo retorna un objeto tipo Date
     * @return
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * Este metodo recibe por medio del parametro fecha un objeto tipo Date
     * @param fecha
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * Este metodo obtiene el id unico de memoria de la clase
     * @return retorna dato primitivo entero
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
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
        if (!(object instanceof LogError)) {
            return false;
        }
        LogError other = (LogError) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
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
        return id.toString();
    }

}
