/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.proyecto.pruebasu;

import edu.co.sena.proyecto.Manager;
import edu.co.sena.proyecto.entity.Cuenta;
import edu.co.sena.proyecto.entity.CuentaPK;
import edu.co.sena.proyecto.entity.PruebasCapaNegocio;
import edu.co.sena.proyecto.entity.Usuario;
import java.io.UnsupportedEncodingException;
import org.apache.commons.codec.binary.Base64;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.apache.commons.codec.Decoder;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.StringDecoder;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.net.BCodec;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author PeterD
 */
public class TestUsuario {

    EntityManager em = Manager.getEntityManager();
    CuentaPK cPk;
    Cuenta c;
    Usuario u;

    public TestUsuario() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {

        Manager.closeEntityManager();
        Manager.closeEntityManagerFactory();
    }
//.........................................................................

    @Test
    public void usuarioInsert() {
        cPk = new CuentaPK("98111051089", "TI");

        c = em.find(Cuenta.class, cPk);
        String contrasena="12332141";
        
        u = new Usuario();
        u.setCuenta(c);
        u.setContrasena(PruebasCapaNegocio.ENCRIPTAR(contrasena));
        u.setCorreoElectronico("asdasd@troncoCabro.com");
        u.setEstado(true);
        u.setRoll("admind");
        Manager.beginTransaction();
        em.persist(u);
        Manager.commitTransaction();
    }

    @Test
    public void usuarioFindByPk() throws DecoderException, UnsupportedEncodingException {
        u = em.find(Usuario.class, "asdasd@troncoCabro.com");

        System.out.println("...............................................");
        System.out.println("Contrasena : " + PruebasCapaNegocio.DESENCRIPTAR(u.getContrasena()));
        System.out.println("Correo Electronico : " + u.getCorreoElectronico());
        System.out.println("Roll : " + u.getRoll());
        System.out.println("Usuario - No. Documento : " + u.getCuenta().getCuentaPK().getNumeroDocumento());
        System.out.println("Usuario - Tip. Documento :" + u.getCuenta().getCuentaPK().getTipoDocumento());
        System.out.println("Estado : " + u.getEstado());
        System.out.println("...............................................");
    }

    @Test
    public void usuarioUpdate() {
        u = em.find(Usuario.class, "asdasd@troncoCabro.com");
        u.setContrasena("1232141120102");
        u.setCorreoElectronico("asdasd@troncoCabro.com");
        u.setEstado(false);
        u.setRoll("admindU");

        em.persist(u);

    }

    @Test
    public void usuarioRemove() {
        u = em.find(Usuario.class, "asdasd@troncoCabro.com");
        em.remove(u);
    }

    @Test
    public void usuarioFindAll() {
        Query query = em.createNamedQuery("usuario.findALl", Usuario.class);
        List<Usuario> list = query.getResultList();
        for (Usuario u : list) {
            System.out.println("...............................................");
            System.out.println("Contrasena : " + u.getContrasena());
            System.out.println("Correo Electronico : " + u.getCorreoElectronico());
            System.out.println("Roll : " + u.getRoll());
            System.out.println("Usuario - No. Documento : " + u.getCuenta().getCuentaPK().getNumeroDocumento());
            System.out.println("Usuario - Tip. Documento :" + u.getCuenta().getCuentaPK().getTipoDocumento());
            System.out.println("Estado : " + u.getEstado());
            System.out.println("...............................................");
        }
    }

    @Test
    public void usuarioFindByCorreoElectronico() {
        Query query = em.createNamedQuery("usuario.findByCorreoElectronico", Usuario.class);
        query.setParameter("correo", "%@%");
        List<Usuario> list = query.getResultList();
        for (Usuario u : list) {
            System.out.println("...............................................");
            System.out.println("Contrasena : " + u.getContrasena());
            System.out.println("Correo Electronico : " + u.getCorreoElectronico());
            System.out.println("Roll : " + u.getRoll());
            System.out.println("Usuario - No. Documento : " + u.getCuenta().getCuentaPK().getNumeroDocumento());
            System.out.println("Usuario - Tip. Documento :" + u.getCuenta().getCuentaPK().getTipoDocumento());
            System.out.println("Estado : " + u.getEstado());
            System.out.println("...............................................");
        }
    }

    @Test
    public void usuarioFindByContrasena() {
        Query query = em.createNamedQuery("usuario.findByContrasena", Usuario.class);
        query.setParameter("contrasena", "%4%");
        List<Usuario> list = query.getResultList();
        for (Usuario u : list) {
            System.out.println("...............................................");
            System.out.println("Contrasena : " + u.getContrasena());
            System.out.println("Correo Electronico : " + u.getCorreoElectronico());
            System.out.println("Roll : " + u.getRoll());
            System.out.println("Usuario - No. Documento : " + u.getCuenta().getCuentaPK().getNumeroDocumento());
            System.out.println("Usuario - Tip. Documento :" + u.getCuenta().getCuentaPK().getTipoDocumento());
            System.out.println("Estado : " + u.getEstado());
            System.out.println("...............................................");
        }
    }

    @Test
    public void usuarioFindByROll() {
        Query query = em.createNamedQuery("usuario.findByRoll", Usuario.class);
        query.setParameter("roll", "%c%");
        List<Usuario> list = query.getResultList();
        for (Usuario u : list) {
            System.out.println("...............................................");
            System.out.println("Contrasena : " + u.getContrasena());
            System.out.println("Correo Electronico : " + u.getCorreoElectronico());
            System.out.println("Roll : " + u.getRoll());
            System.out.println("Usuario - No. Documento : " + u.getCuenta().getCuentaPK().getNumeroDocumento());
            System.out.println("Usuario - Tip. Documento :" + u.getCuenta().getCuentaPK().getTipoDocumento());
            System.out.println("Estado : " + u.getEstado());
            System.out.println("...............................................");
        }
    }

    @Test
    public void usuarioFindByEstado() {
        Query query = em.createNamedQuery("usuario.findByEstado", Usuario.class);
        query.setParameter("estado", true);
        List<Usuario> list = query.getResultList();
        for (Usuario u : list) {
            System.out.println("...............................................");
            System.out.println("Contrasena : " + u.getContrasena());
            System.out.println("Correo Electronico : " + u.getCorreoElectronico());
            System.out.println("Roll : " + u.getRoll());
            System.out.println("Usuario - No. Documento : " + u.getCuenta().getCuentaPK().getNumeroDocumento());
            System.out.println("Usuario - Tip. Documento :" + u.getCuenta().getCuentaPK().getTipoDocumento());
            System.out.println("Estado : " + u.getEstado());
            System.out.println("...............................................");
        }
    }

    @Test
    public void usuarioByTipoDocumento() {
        Query query = em.createNamedQuery("usuario.findByTipoDocumento", Usuario.class);
        query.setParameter("tipoDocumento", "%c%");
        List<Usuario> list = query.getResultList();
        for (Usuario u : list) {
            System.out.println("...............................................");
            System.out.println("Contrasena : " + u.getContrasena());
            System.out.println("Correo Electronico : " + u.getCorreoElectronico());
            System.out.println("Roll : " + u.getRoll());
            System.out.println("Usuario - No. Documento : " + u.getCuenta().getCuentaPK().getNumeroDocumento());
            System.out.println("Usuario - Tip. Documento :" + u.getCuenta().getCuentaPK().getTipoDocumento());
            System.out.println("Estado : " + u.getEstado());
            System.out.println("...............................................");
        }
    }

    @Test
    public void usuarioFindByNumeroDocumento() {
        Query query = em.createNamedQuery("usuario.findByNumeroDocumento", Usuario.class);
        query.setParameter("numeroDocumento", "%1%");
        List<Usuario> list = query.getResultList();
        for (Usuario u : list) {
            System.out.println("...............................................");
            System.out.println("Contrasena : " + u.getContrasena());
            System.out.println("Correo Electronico : " + u.getCorreoElectronico());
            System.out.println("Roll : " + u.getRoll());
            System.out.println("Usuario - No. Documento : " + u.getCuenta().getCuentaPK().getNumeroDocumento());
            System.out.println("Usuario - Tip. Documento :" + u.getCuenta().getCuentaPK().getTipoDocumento());
            System.out.println("Estado : " + u.getEstado());
            System.out.println("...............................................");
        }
    }
    @Test
    public void testCount(){
    em.getTransaction().begin();
    Query query = em.createNamedQuery("usuario.Count", Usuario.class);
    em.getTransaction().commit();
        System.out.println(query.getResultList());
    }

}
