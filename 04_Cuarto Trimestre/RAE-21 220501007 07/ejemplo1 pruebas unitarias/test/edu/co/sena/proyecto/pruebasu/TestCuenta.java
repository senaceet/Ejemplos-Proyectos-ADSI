/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.proyecto.pruebasu;

import edu.co.sena.proyecto.Manager;
import edu.co.sena.proyecto.entity.Cuenta;
import edu.co.sena.proyecto.entity.CuentaPK;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import org.eclipse.persistence.internal.jpa.parsing.TemporalLiteralNode;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author PeterD
 */
public class TestCuenta {

    EntityManager em = Manager.getEntityManager();
    Cuenta c;
    CuentaPK cPk;

    public TestCuenta() {
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
//..........................................................................

    @Test
    public void cuentaInsert() {
        Calendar calendar = GregorianCalendar.getInstance();
        //los meses se manejan de 0 - 11  enero=0   
        calendar.set(2012, 12, 12);

        cPk = new CuentaPK();
        cPk.setNumeroDocumento("98111051089");
        cPk.setTipoDocumento("TI");

        c = new Cuenta();
        c.setCuentaPK(cPk);
        c.setImagen(null);
        c.setPrimerNombre("Peter");
        c.setSegundoNombre(null);
        c.setPrimerApellido("Gomez");
        c.setSegundoApellido(null);
        c.setCargo("aprendiz");
        c.setFechaFinalizacion(calendar.getTime());
        c.setEstado(true);

        Manager.beginTransaction();

        em.persist(c);

        Manager.commitTransaction();

    }

    @Test
    public void cuentaFindByPk() {
        cPk = new CuentaPK("98111051089", "TI");
        c = em.find(Cuenta.class, cPk);
        System.out.println(".................................................");
        System.out.println("Cargo : " + c.getCargo());
        System.out.println("No. Documento : " + c.getCuentaPK().getNumeroDocumento());
        System.out.println("Tipo Documento : " + c.getCuentaPK().getTipoDocumento());
        if (c.getEstado() == true) {
            System.out.println("Estado : Activo");
        } else {
            System.out.println("Estado : In Activo");
        }
        System.out.println("Fecha Finalizacion : " + c.getFechaFinalizacion());
        if (c.getImagen() != null) {
            System.out.println("Imagen : " + c.getImagen().length);
        } else {
            System.out.println("No Hay Imagen");
        }
        System.out.println("Primer Apellido : " + c.getPrimerApellido());
        System.out.println("Primer Nombre : " + c.getPrimerNombre());
        System.out.println("Segundo Apellido : " + c.getSegundoApellido());
        System.out.println("Segundo Nombre : " + c.getSegundoNombre());
        System.out.println(".................................................");
    }

    @Test
    public void cuentaUpdate() {

        Calendar calendar = GregorianCalendar.getInstance();
        //los meses se manejan de 0 - 11  enero=0   
        calendar.set(2011, 8, 1);

        cPk = new CuentaPK("98111051089", "T.I");
        c = em.find(Cuenta.class, cPk);

        c.setCuentaPK(cPk);
        c.setImagen(null);
        c.setPrimerNombre("PeterU");
        c.setSegundoNombre(null);
        c.setPrimerApellido("GomezU");
        c.setSegundoApellido(null);
        c.setCargo("aprendizU");
        c.setFechaFinalizacion(calendar.getTime());
        c.setEstado(false);

        Manager.beginTransaction();
        em.merge(c);
        Manager.commitTransaction();
    }

    @Test
    public void cuentaRemove() {

        cPk = new CuentaPK("98111051089", "T.I");
        c = em.find(Cuenta.class, cPk);
        Manager.beginTransaction();

        em.remove(c);
        Manager.commitTransaction();
    }

    @Test
    public void testFindALLQuery() {

        Query query = em.createNamedQuery("cuenta.findAll", Cuenta.class);

        List<Cuenta> lis = query.getResultList();
        for (Cuenta c : lis) {
            System.out.println(".................................................");
            System.out.println("Cargo : " + c.getCargo());
            System.out.println("No. Documento : " + c.getCuentaPK().getNumeroDocumento());
            System.out.println("Tipo Documento : " + c.getCuentaPK().getTipoDocumento());
            if (c.getEstado() == true) {
                System.out.println("Estado : Activo");
            } else {
                System.out.println("Estado : In Activo");
            }
            System.out.println("Fecha Finalizacion : " + c.getFechaFinalizacion());
            if (c.getImagen() != null) {
                System.out.println("Imagen : " + c.getImagen().length);
            } else {
                System.out.println("No Hay Imagen");
            }
            System.out.println("Primer Apellido : " + c.getPrimerApellido());
            System.out.println("Primer Nombre : " + c.getPrimerNombre());
            System.out.println("Segundo Apellido : " + c.getSegundoApellido());
            System.out.println("Segundo Nombre : " + c.getSegundoNombre());
            System.out.println(".................................................");
        }

    }

    @Test
    public void testFindByTipoDocumentoQuery() {

        Query query = em.createNamedQuery("cuenta.findByTipoDocumento", Cuenta.class);
        query.setParameter("tipoDocumento", "%i%");
        List<Cuenta> lis = query.getResultList();
        for (Cuenta c : lis) {
            System.out.println(".................................................");
            System.out.println("Cargo : " + c.getCargo());
            System.out.println("No. Documento : " + c.getCuentaPK().getNumeroDocumento());
            System.out.println("Tipo Documento : " + c.getCuentaPK().getTipoDocumento());
            if (c.getEstado() == true) {
                System.out.println("Estado : Activo");
            } else {
                System.out.println("Estado : In Activo");
            }
            System.out.println("Fecha Finalizacion : " + c.getFechaFinalizacion());
            if (c.getImagen() != null) {
                System.out.println("Imagen : " + c.getImagen().length);
            } else {
                System.out.println("No Hay Imagen");
            }
            System.out.println("Primer Apellido : " + c.getPrimerApellido());
            System.out.println("Primer Nombre : " + c.getPrimerNombre());
            System.out.println("Segundo Apellido : " + c.getSegundoApellido());
            System.out.println("Segundo Nombre : " + c.getSegundoNombre());
            System.out.println(".................................................");
        }

    }

    @Test
    public void testFindByNumeroDocumentoQuery() {

        Query query = em.createNamedQuery("cuenta.findByNumeroDocumento", Cuenta.class);
        query.setParameter("numeroDocumento", "%9%");
        List<Cuenta> lis = query.getResultList();
        for (Cuenta c : lis) {
            System.out.println(".................................................");
            System.out.println("Cargo : " + c.getCargo());
            System.out.println("No. Documento : " + c.getCuentaPK().getNumeroDocumento());
            System.out.println("Tipo Documento : " + c.getCuentaPK().getTipoDocumento());
            if (c.getEstado() == true) {
                System.out.println("Estado : Activo");
            } else {
                System.out.println("Estado : In Activo");
            }
            System.out.println("Fecha Finalizacion : " + c.getFechaFinalizacion());
            if (c.getImagen() != null) {
                System.out.println("Imagen : " + c.getImagen().length);
            } else {
                System.out.println("No Hay Imagen");
            }
            System.out.println("Primer Apellido : " + c.getPrimerApellido());
            System.out.println("Primer Nombre : " + c.getPrimerNombre());
            System.out.println("Segundo Apellido : " + c.getSegundoApellido());
            System.out.println("Segundo Nombre : " + c.getSegundoNombre());
            System.out.println(".................................................");
        }

    }

    @Test
    public void testFindByPrimerNombreQuery() {

        Query query = em.createNamedQuery("cuenta.findByPrimerNombre", Cuenta.class);
        query.setParameter("nombre", "%e%");
        List<Cuenta> lis = query.getResultList();
        for (Cuenta c : lis) {
            System.out.println(".................................................");
            System.out.println("Cargo : " + c.getCargo());
            System.out.println("No. Documento : " + c.getCuentaPK().getNumeroDocumento());
            System.out.println("Tipo Documento : " + c.getCuentaPK().getTipoDocumento());
            if (c.getEstado() == true) {
                System.out.println("Estado : Activo");
            } else {
                System.out.println("Estado : In Activo");
            }
            System.out.println("Fecha Finalizacion : " + c.getFechaFinalizacion());
            if (c.getImagen() != null) {
                System.out.println("Imagen : " + c.getImagen().length);
            } else {
                System.out.println("No Hay Imagen");
            }
            System.out.println("Primer Apellido : " + c.getPrimerApellido());
            System.out.println("Primer Nombre : " + c.getPrimerNombre());
            System.out.println("Segundo Apellido : " + c.getSegundoApellido());
            System.out.println("Segundo Nombre : " + c.getSegundoNombre());
            System.out.println(".................................................");
        }

    }

    @Test
    public void testFindBySegundoNombreQuery() {

        Query query = em.createNamedQuery("cuenta.findBySegundoNombre", Cuenta.class);
        query.setParameter("nombreSeg", "%e%");
        List<Cuenta> lis = query.getResultList();
        for (Cuenta c : lis) {
            System.out.println(".................................................");
            System.out.println("Cargo : " + c.getCargo());
            System.out.println("No. Documento : " + c.getCuentaPK().getNumeroDocumento());
            System.out.println("Tipo Documento : " + c.getCuentaPK().getTipoDocumento());
            if (c.getEstado() == true) {
                System.out.println("Estado : Activo");
            } else {
                System.out.println("Estado : In Activo");
            }
            System.out.println("Fecha Finalizacion : " + c.getFechaFinalizacion());
            if (c.getImagen() != null) {
                System.out.println("Imagen : " + c.getImagen().length);
            } else {
                System.out.println("No Hay Imagen");
            }
            System.out.println("Primer Apellido : " + c.getPrimerApellido());
            System.out.println("Primer Nombre : " + c.getPrimerNombre());
            System.out.println("Segundo Apellido : " + c.getSegundoApellido());
            System.out.println("Segundo Nombre : " + c.getSegundoNombre());
            System.out.println(".................................................");
        }

    }

    @Test
    public void testFindByPrimerApellidoQuery() {

        Query query = em.createNamedQuery("cuenta.findByPrimerApellido", Cuenta.class);
        query.setParameter("apellido", "%e%");
        List<Cuenta> lis = query.getResultList();
        for (Cuenta c : lis) {
            System.out.println(".................................................");
            System.out.println("Cargo : " + c.getCargo());
            System.out.println("No. Documento : " + c.getCuentaPK().getNumeroDocumento());
            System.out.println("Tipo Documento : " + c.getCuentaPK().getTipoDocumento());
            if (c.getEstado() == true) {
                System.out.println("Estado : Activo");
            } else {
                System.out.println("Estado : In Activo");
            }
            System.out.println("Fecha Finalizacion : " + c.getFechaFinalizacion());
            if (c.getImagen() != null) {
                System.out.println("Imagen : " + c.getImagen().length);
            } else {
                System.out.println("No Hay Imagen");
            }
            System.out.println("Primer Apellido : " + c.getPrimerApellido());
            System.out.println("Primer Nombre : " + c.getPrimerNombre());
            System.out.println("Segundo Apellido : " + c.getSegundoApellido());
            System.out.println("Segundo Nombre : " + c.getSegundoNombre());
            System.out.println(".................................................");
        }

    }

    @Test
    public void testFindBySegundoApellidoQuery() {

        Query query = em.createNamedQuery("cuenta.findBySegundoApellido", Cuenta.class);
        query.setParameter("apellidoSeg", "%e%");
        List<Cuenta> lis = query.getResultList();
        for (Cuenta c : lis) {
            System.out.println(".................................................");
            System.out.println("Cargo : " + c.getCargo());
            System.out.println("No. Documento : " + c.getCuentaPK().getNumeroDocumento());
            System.out.println("Tipo Documento : " + c.getCuentaPK().getTipoDocumento());
            if (c.getEstado() == true) {
                System.out.println("Estado : Activo");
            } else {
                System.out.println("Estado : In Activo");
            }
            System.out.println("Fecha Finalizacion : " + c.getFechaFinalizacion());
            if (c.getImagen() != null) {
                System.out.println("Imagen : " + c.getImagen().length);
            } else {
                System.out.println("No Hay Imagen");
            }
            System.out.println("Primer Apellido : " + c.getPrimerApellido());
            System.out.println("Primer Nombre : " + c.getPrimerNombre());
            System.out.println("Segundo Apellido : " + c.getSegundoApellido());
            System.out.println("Segundo Nombre : " + c.getSegundoNombre());
            System.out.println(".................................................");
        }

    }

    @Test
    public void testFindByCargoQuery() {

        Query query = em.createNamedQuery("cuenta.findByCargo", Cuenta.class);
        query.setParameter("cargo", "%a%");
        List<Cuenta> lis = query.getResultList();
        for (Cuenta c : lis) {
            System.out.println(".................................................");
            System.out.println("Cargo : " + c.getCargo());
            System.out.println("No. Documento : " + c.getCuentaPK().getNumeroDocumento());
            System.out.println("Tipo Documento : " + c.getCuentaPK().getTipoDocumento());
            if (c.getEstado() == true) {
                System.out.println("Estado : Activo");
            } else {
                System.out.println("Estado : In Activo");
            }
            System.out.println("Fecha Finalizacion : " + c.getFechaFinalizacion());
            if (c.getImagen() != null) {
                System.out.println("Imagen : " + c.getImagen().length);
            } else {
                System.out.println("No Hay Imagen");
            }
            System.out.println("Primer Apellido : " + c.getPrimerApellido());
            System.out.println("Primer Nombre : " + c.getPrimerNombre());
            System.out.println("Segundo Apellido : " + c.getSegundoApellido());
            System.out.println("Segundo Nombre : " + c.getSegundoNombre());
            System.out.println(".................................................");
        }

    }

    @Test
    public void testFindByFechaFinalizacionQuery() {
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.set(2012, Calendar.JANUARY, 12, 12, 05, 00);
        Calendar calendar2 = GregorianCalendar.getInstance();
        calendar2.set(2019, Calendar.DECEMBER, 10, 10, 10, 11);

        Query query = em.createNamedQuery("cuenta.findByFechaFina", Cuenta.class);
        query.setParameter("fechaInicio", new Timestamp(calendar.getTimeInMillis()));
        query.setParameter("fechaFinalizacion", new Timestamp(calendar2.getTimeInMillis()));
        List<Cuenta> lis = query.getResultList();
        for (Cuenta c : lis) {
            System.out.println(".................................................");
            System.out.println("Cargo : " + c.getCargo());
            System.out.println("No. Documento : " + c.getCuentaPK().getNumeroDocumento());
            System.out.println("Tipo Documento : " + c.getCuentaPK().getTipoDocumento());
            if (c.getEstado() == true) {
                System.out.println("Estado : Activo");
            } else {
                System.out.println("Estado : In Activo");
            }
            System.out.println("Fecha Finalizacion : " + c.getFechaFinalizacion());
            if (c.getImagen() != null) {
                System.out.println("Imagen : " + c.getImagen().length);
            } else {
                System.out.println("No Hay Imagen");
            }
            System.out.println("Primer Apellido : " + c.getPrimerApellido());
            System.out.println("Primer Nombre : " + c.getPrimerNombre());
            System.out.println("Segundo Apellido : " + c.getSegundoApellido());
            System.out.println("Segundo Nombre : " + c.getSegundoNombre());
            System.out.println(".................................................");
        }

    }

    @Test
    public void testFindByEstado() {

        Query query = em.createNamedQuery("cuenta.findByEstado", Cuenta.class);
        query.setParameter("estado", true);
        List<Cuenta> lis = query.getResultList();
        for (Cuenta c : lis) {
            System.out.println(".................................................");
            System.out.println("Cargo : " + c.getCargo());
            System.out.println("No. Documento : " + c.getCuentaPK().getNumeroDocumento());
            System.out.println("Tipo Documento : " + c.getCuentaPK().getTipoDocumento());
            if (c.getEstado() == true) {
                System.out.println("Estado : Activo");
            } else {
                System.out.println("Estado : In Activo");
            }
            System.out.println("Fecha Finalizacion : " + c.getFechaFinalizacion());
            if (c.getImagen() != null) {
                System.out.println("Imagen : " + c.getImagen().length);
            } else {
                System.out.println("No Hay Imagen");
            }
            System.out.println("Primer Apellido : " + c.getPrimerApellido());
            System.out.println("Primer Nombre : " + c.getPrimerNombre());
            System.out.println("Segundo Apellido : " + c.getSegundoApellido());
            System.out.println("Segundo Nombre : " + c.getSegundoNombre());
            System.out.println(".................................................");
        }

    }

    @Test
    public void testUpdateQueryTipoDocumento() {
        em.getTransaction().begin();
        Query query = em.createNamedQuery("cuenta.updateTipoDocumento", Cuenta.class);
        query.setParameter("nuevoTipoDocumento", "C.C");
        query.setParameter("nuevoNumeroDocumento", "1215455");
        query.setParameter("tipoDocumento", "TI");
        query.setParameter("viejoNumeroDocumento", "4154554");
        query.executeUpdate();
        em.getTransaction().commit();
    }

    @Test
    public void testUpdateQueryNumeroDocumento() {
        em.getTransaction().begin();
        Query query = em.createNamedQuery("cuenta.updateNumeroDocumento", Cuenta.class);
        query.setParameter("nuevoNumeroDocumento", "4154554");
        query.setParameter("numeroDocumento", "98111051089").executeUpdate();
        em.getTransaction().commit();
    }
    @Test
    public void testCount(){
    em.getTransaction().begin();
    Query query = em.createNamedQuery("cuenta.Count",Cuenta.class);
    em.getTransaction().commit();
        System.out.println(query.getResultList());
    }

}
