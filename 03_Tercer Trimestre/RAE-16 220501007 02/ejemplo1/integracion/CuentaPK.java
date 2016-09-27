/**
 * CuentaPK 
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
 * Esta clase contiene las llaves primarias de la tabla CUENTA
 * @author Dxracso
 */
@Embeddable
public class CuentaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "NUMERO_DOCUMENTO")
    private String numeroDocumento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "TIPO_DOCUMENTO_TIPO_DOCUMENTO")
    private String tipoDocumentoTipoDocumento;

    public CuentaPK() {
        /**
         * Esto es un costructor generico
         */
    }
    /**
     * Este constructor que inicializa las llaves primarias
     * @param numeroDocumento objeto String numero de documento del usuario
     * @param tipoDocumentoTipoDocumento objeto String tipo de documento 
     * que puede tener el usuario
     */
    public CuentaPK(String numeroDocumento, String tipoDocumentoTipoDocumento) {
        this.numeroDocumento = numeroDocumento;
        this.tipoDocumentoTipoDocumento = tipoDocumentoTipoDocumento;
    }
    /**
     * Obtiene numero de documento del usuario
     * @return objeto String nombero de documento del usuario
     */
    public String getNumeroDocumento() {
        return numeroDocumento;
    }
    /**
     * Permite añadir el numero de documento del usuario
     * @param numeroDocumento objeto String numero de documento del usuario
     */
    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }
    /**
     * Obtiene el tipo de documento del usuario
     * @return objeto String tipo de documento del usuario
     */
    public String getTipoDocumentoTipoDocumento() {
        return tipoDocumentoTipoDocumento;
    }
    /**
     * Permite añadir el tipo de documento que puede tener el usuario
     * @param tipoDocumentoTipoDocumento objeto String tipo de documento 
     * del usuario 
     */
    public void setTipoDocumentoTipoDocumento(String tipoDocumentoTipoDocumento) {
        this.tipoDocumentoTipoDocumento = tipoDocumentoTipoDocumento;
    }
    /**
     * Este metodo obtiene el id unico de memoria de la clase
     * @return retorna dato primitivo entero
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroDocumento != null ? numeroDocumento.hashCode() : 0);
        hash += (tipoDocumentoTipoDocumento != null ? tipoDocumentoTipoDocumento.hashCode() : 0);
        return hash;
    }
    /**
     * Este metodo compara entre los cuentas 
     * @param object 
     * @return retorna dato primitivo boolean
     */
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof CuentaPK)) {
            return false;
        }
        CuentaPK other = (CuentaPK) object;
        if (!this.numeroDocumento.equals(other.numeroDocumento)) {
            return false;
        }
        if (!this.tipoDocumentoTipoDocumento.equals(other.tipoDocumentoTipoDocumento)) {
            return false;
        }
        return true;
    }
    /**
     *  Este metodo contiene los valores de las variables de los get y set
     * @return 
     */
    @Override
    public String toString() {
        return "numeroDocumento=" + numeroDocumento + ", tipoDocumentoTipoDocumento=" + tipoDocumentoTipoDocumento;
    }
}
