/**
 * RegistroEquipoPK
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
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Esta clase contiene las llaves primarias de la tabla REGISTRO_EQUIPO
 * @author Dxracso
 */
@Embeddable
public class RegistroEquipoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "REGISTRO_NUMERO_REGISTRO_ENTRADA")
    private int registroNumeroRegistroEntrada;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "EQUIPO_ID_EQUIPO")
    private String equipoIdEquipo;

    public RegistroEquipoPK() {
        /**
         * Esto es un costructor generico
         */
    }
    /**
     * Este constructor inicializa las llaves primarias 
     * @param registroNumeroRegistroEntrada numero de registro que tiene el 
     * usuario al momento de ingresar
     * @param equipoIdEquipo numero de identificacion del equipo del usuario
     */
    public RegistroEquipoPK(int registroNumeroRegistroEntrada, String equipoIdEquipo) {
        this.registroNumeroRegistroEntrada = registroNumeroRegistroEntrada;
        this.equipoIdEquipo = equipoIdEquipo;
    }
    /**
     * Obtiene el numero del registro de entrada de la cuenta
     * @return dato primitivo entero numero de registro de entrada 
     */
    public int getRegistroNumeroRegistroEntrada() {
        return registroNumeroRegistroEntrada;
    }
    /**
     * Permite añadir el numero de registro de la entrada 
     * @param registroNumeroRegistroEntrada dato primitivo entero numero 
     * de registro de la entrada
     */
    public void setRegistroNumeroRegistroEntrada(int registroNumeroRegistroEntrada) {
        this.registroNumeroRegistroEntrada = registroNumeroRegistroEntrada;
    }
    /**
     * Obtiene el numero de identificacion de equipo
     * @return objeto String numero de identificacion del equipo
     */
    public String getEquipoIdEquipo() {
        return equipoIdEquipo;
    }
    /**
     * Permite añadir el numero de identificacion del equipo
     * @param equipoIdEquipo objeto String numero de identificacion del equipo
     */
    public void setEquipoIdEquipo(String equipoIdEquipo) {
        this.equipoIdEquipo = equipoIdEquipo;
    }
    @Override
    /**
     * Este metodo obtiene el id unico de memoria de la clase
     * @return retorna dato primitivo entero
     */
    public int hashCode() {
        int hash = 0;
        hash += registroNumeroRegistroEntrada;
        hash += (equipoIdEquipo != null ? equipoIdEquipo.hashCode() : 0);
        return hash;
    }
    /**
     * Este metodo compara entre los cuentas 
     * @param object 
     * @return retorna dato primitivo boolean
     */
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof RegistroEquipoPK)) {
            return false;
        }
        RegistroEquipoPK other = (RegistroEquipoPK) object;
        if (this.registroNumeroRegistroEntrada != other.registroNumeroRegistroEntrada) {
            return false;
        }
        if (!this.equipoIdEquipo.equals(other.equipoIdEquipo)) {
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
        return "edu.co.sena.entryindex.integracion.RegistroEquipoPK[ registroNumeroRegistroEntrada=" + registroNumeroRegistroEntrada + ", equipoIdEquipo=" + equipoIdEquipo + " ]";
    }
}
