/**
 * RegistroEquipo
 * 
 * Version 1.0
 * 24-Agosto-2016
 * 
 * EntryIndex
 */
package edu.co.sena.entryindex.integracion;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Esta clase contiene el mapeo de la base de datos de la tabla REGISTRO_EQUIPO
 * @author Dxracso
 */
@Entity
@Table(name = "REGISTRO_EQUIPO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RegistroEquipo.findAll", query = "SELECT r FROM RegistroEquipo r"),
    @NamedQuery(name = "RegistroEquipo.findByRegistroNumeroRegistroEntrada", query = "SELECT r FROM RegistroEquipo r WHERE r.registro.numeroRegistro = :registroNumeroRegistroEntrada"),
    @NamedQuery(name = "RegistroEquipo.findByRegistroNumeroRegistroSalida", query = "SELECT r FROM RegistroEquipo r WHERE r.registroNumeroRegistroSalida.numeroRegistro = :registroNumeroRegistroSalida"),
    @NamedQuery(name = "RegistroEquipo.findByRegistroNumeroRegistroSalidaIsNull", query = "SELECT r FROM RegistroEquipo r WHERE r.registroNumeroRegistroSalida IS NULL"),
    @NamedQuery(name = "RegistroEquipo.findByPK", query = "SELECT r FROM RegistroEquipo r WHERE r.registroEquipoPK.registroNumeroRegistroEntrada = :registroNumeroRegistroEntrada and r.registroEquipoPK.equipoIdEquipo = :equipoIdEquipo"),
    @NamedQuery(name = "RegistroEquipo.findByFechaIngreso", query = "SELECT r FROM RegistroEquipo r WHERE r.registro.fechaEntrada BETWEEN :fechaInicial AND :fechaFinal"),
    @NamedQuery(name = "RegistroEquipo.findByFechaSalida", query = "SELECT r FROM RegistroEquipo r WHERE r.registroNumeroRegistroSalida.fechaSalida BETWEEN :fechaInicial AND :fechaFinal"),
    @NamedQuery(name = "RegistroEquipo.findIdEquipoDESC", query = "SELECT r FROM RegistroEquipo r WHERE r.equipo.idEquipo = :equipoIdEquipo ORDER BY r.registro.numeroRegistro DESC"),
    @NamedQuery(name = "RegistroEquipo.findByEquipoIdEquipo", query = "SELECT r FROM RegistroEquipo r WHERE r.registroEquipoPK.equipoIdEquipo = :equipoIdEquipo"),
    @NamedQuery(name = "RegistroEquipo.findByEquipoIdEquipoLike", query = "SELECT r FROM RegistroEquipo r WHERE r.registroEquipoPK.equipoIdEquipo like :equipoIdEquipo")})
public class RegistroEquipo implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RegistroEquipoPK registroEquipoPK;
    @JoinColumn(name = "EQUIPO_ID_EQUIPO", referencedColumnName = "ID_EQUIPO", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Equipo equipo;
    @JoinColumn(name = "REGISTRO_NUMERO_REGISTRO_ENTRADA", referencedColumnName = "NUMERO_REGISTRO", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Registro registro;
    @JoinColumn(name = "REGISTRO_NUMERO_REGISTRO_SALIDA", referencedColumnName = "NUMERO_REGISTRO")
    @ManyToOne(fetch = FetchType.EAGER)
    private Registro registroNumeroRegistroSalida;

    public RegistroEquipo() {
        /**
         * Esto es un costructor generico
         */
    }
    /**
     * Este constructor obtiene las llaves primarias de registro equipo
     * @param registroEquipoPK registroNumeroRegistroEntrada y 
     * equipoIdEquipo
     */
    public RegistroEquipo(RegistroEquipoPK registroEquipoPK) {
        this.registroEquipoPK = registroEquipoPK;
    }
    /**
     * Este constructor inicializa las llaves primarias  
     * @param registroNumeroRegistroEntrada numero de registro que tiene el 
     * usuario al momento de ingresar
     * @param equipoIdEquipo numero de identificacion del equipo del usuario
     */
    public RegistroEquipo(int registroNumeroRegistroEntrada, String equipoIdEquipo) {
        this.registroEquipoPK = new RegistroEquipoPK(registroNumeroRegistroEntrada, equipoIdEquipo);
    }
    /**
     * Este metodo obtiene las llaves primarias de Registro
     * @return retorna los datos de la clase RegistroEquipoPK
     */
    public RegistroEquipoPK getRegistroEquipoPK() {
        return registroEquipoPK;
    }
    /**
     * Este metodo permite añadir las llaves primarias de Cuenta
     * @param registroEquipoPK objeto String tipo documento y numero documento
     */
    public void setRegistroEquipoPK(RegistroEquipoPK registroEquipoPK) {
        this.registroEquipoPK = registroEquipoPK;
    }
    /**
     * Obtiene los datos de la clase Equipo 
     * @return 
     */
    public Equipo getEquipo() {
        return equipo;
    }
    /**
     * Permite añadir los datos de la clase Equipo a equipo
     * @param equipo 
     */
    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }
    /**
     * Obtiene los datos de la clase Registro 
     * @return 
     */
    public Registro getRegistro() {
        return registro;
    }
    /**
     * Permite añadir los datos de la clase Registro a registro
     * @param registro 
     */
    public void setRegistro(Registro registro) {
        this.registro = registro;
    }
    /**
     * Obtiene el numero de registro de salida de la clase Registro
     * @return objeto String 
     */
    public Registro getRegistroNumeroRegistroSalida() {
        return registroNumeroRegistroSalida;
    }
    /**
     * Permite añadir la fecha de salida del usuario
     * @param registroNumeroRegistroSalida objeto String fecha de salida
     */
    public void setRegistroNumeroRegistroSalida(Registro registroNumeroRegistroSalida) {
        this.registroNumeroRegistroSalida = registroNumeroRegistroSalida;
    }
    /**
     * Este metodo obtiene el id unico de memoria de la clase
     * @return retorna dato primitivo entero
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (registroEquipoPK != null ? registroEquipoPK.hashCode() : 0);
        return hash;
    }
    /**
     * Este metodo compara entre los cuentas 
     * @param object 
     * @return retorna dato primitivo boolean
     */
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof RegistroEquipo)) {
            return false;
        }
        RegistroEquipo other = (RegistroEquipo) object;
        if ((this.registroEquipoPK == null && other.registroEquipoPK != null) || (this.registroEquipoPK != null && !this.registroEquipoPK.equals(other.registroEquipoPK))) {
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
        return "edu.co.sena.entryindex.integracion.RegistroEquipo[ registroEquipoPK=" + registroEquipoPK + " ]";
    }
}
