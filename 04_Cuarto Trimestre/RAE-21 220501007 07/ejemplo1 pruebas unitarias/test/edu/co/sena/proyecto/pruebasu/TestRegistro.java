/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.proyecto.pruebasu;

import edu.co.sena.proyecto.Manager;
import edu.co.sena.proyecto.entity.Cuenta;
import edu.co.sena.proyecto.entity.CuentaPK;
import edu.co.sena.proyecto.entity.Registro;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Dxracso
 */
public class TestRegistro {

    EntityManager em = Manager.getEntityManager();

    public TestRegistro() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        System.out.println("*****************************************");
        System.out.println("");

    }

    @After
    public void tearDown() {
        Manager.closeEntityManager();
        Manager.closeEntityManagerFactory();
    }

    @Test
    public void testInsert() {

        Calendar calendar1 = GregorianCalendar.getInstance();
        calendar1.set(2017, Calendar.AUGUST, 15, 13, 50, 50);

        Calendar calendar2 = GregorianCalendar.getInstance();
        calendar2.set(2017, Calendar.AUGUST, 15, 17, 40, 50);

        Cuenta c1 = em.find(Cuenta.class, new CuentaPK("1030621348", "CC"));

        Registro registro1 = new Registro(new Timestamp(calendar1.getTimeInMillis()), c1);
        registro1.setFechaSalida(new Timestamp(calendar2.getTimeInMillis()));

        Manager.beginTransaction();
        em.persist(registro1);
        Manager.commitTransaction();
    }

    @Test
    public void testUpdate() {
        Registro rTemp1 = em.find(Registro.class, 1);
        rTemp1.setRolVisita("visitante");
        rTemp1.setVisita("tuabuela");
        Calendar calendar1 = GregorianCalendar.getInstance();
        calendar1.set(2017, Calendar.AUGUST, 15, 14, 50, 50);
        rTemp1.setFechaSalida(new Timestamp(calendar1.getTimeInMillis()));

        Manager.beginTransaction();
        em.merge(rTemp1);
        Manager.commitTransaction();

    }

    @Test
    public void testBorrar() {
        Registro rTemp1 = em.find(Registro.class, 1);

        Manager.beginTransaction();
        em.remove(rTemp1);
        Manager.commitTransaction();
    }

    @Test
    public void testFindByAll() {
        Manager.beginTransaction();
        Query query = em.createNamedQuery("registro.FindByAll");
        Manager.commitTransaction();
        List<Registro> registros = query.getResultList();

        for (Registro registro : registros) {
            System.out.println(".................................................");
            System.out.println("Roll Visita : " + registro.getRolVisita());
            System.out.println("Visita : " + registro.getVisita());
            System.out.println("Fe. Entrada : " + registro.getFechaEntrada());
            System.out.println("Fe. Salida : " + registro.getFechaSalida());
            System.out.println("No. Registro : " + registro.getNumeroRegistro());
            System.out.println("Registro - No. Documento : " + registro.getCuenta().getCuentaPK().getNumeroDocumento());
            System.out.println("Registro - Tip. Documento : " + registro.getCuenta().getCuentaPK().getTipoDocumento());
            System.out.println(".................................................");
        }
    }

    @Test
    public void testFindByNumeroRegistro() {
        Manager.beginTransaction();
        Query query = em.createNamedQuery("registro.FindByNumeroRegistro");
        query.setParameter("numeroRegistro", 2);
        Manager.commitTransaction();
        Registro r1 = (Registro) query.getSingleResult();
        System.out.println(".................................................");
        System.out.println("Roll Visita : " + r1.getRolVisita());
        System.out.println("Visita : " + r1.getVisita());
        System.out.println("Fe. Entrada : " + r1.getFechaEntrada());
        System.out.println("Fe. Salida : " + r1.getFechaSalida());
        System.out.println("No. Registro : " + r1.getNumeroRegistro());
        System.out.println("Registro - No. Documento : " + r1.getCuenta().getCuentaPK().getNumeroDocumento());
        System.out.println("Registro - Tip. Documento : " + r1.getCuenta().getCuentaPK().getTipoDocumento());
        System.out.println(".................................................");
    }

    @Test
    public void testFindByFechaEntrada() {
        Calendar c1 = GregorianCalendar.getInstance();
        c1.set(2015, Calendar.AUGUST, 15, 13, 50, 50);
        Calendar c2 = GregorianCalendar.getInstance();
        c2.set(2019, Calendar.AUGUST, 15, 13, 50, 50);

        Manager.beginTransaction();
        Query query = em.createNamedQuery("registro.FindByFechaEntrada");
        query.setParameter("fechaInicial", new Timestamp(c1.getTimeInMillis()));
        query.setParameter("fechaFinal", new Timestamp(c2.getTimeInMillis()));

        Manager.commitTransaction();

        List<Registro> registros = query.getResultList();
        for (Registro r1 : registros) {
            System.out.println(".................................................");
            System.out.println("Roll Visita : " + r1.getRolVisita());
            System.out.println("Visita : " + r1.getVisita());
            System.out.println("Fe. Entrada : " + r1.getFechaEntrada());
            System.out.println("Fe. Salida : " + r1.getFechaSalida());
            System.out.println("No. Registro : " + r1.getNumeroRegistro());
            System.out.println("Registro - No. Documento : " + r1.getCuenta().getCuentaPK().getNumeroDocumento());
            System.out.println("Registro - Tip. Documento : " + r1.getCuenta().getCuentaPK().getTipoDocumento());
            System.out.println(".................................................");
        }

    }

    @Test
    public void testFindByFechaSalida() {
        Calendar c1 = GregorianCalendar.getInstance();
        c1.set(2015, Calendar.AUGUST, 15, 13, 50, 50);
        Calendar c2 = GregorianCalendar.getInstance();
        c2.set(2019, Calendar.AUGUST, 15, 13, 50, 50);

        Manager.beginTransaction();
        Query query = em.createNamedQuery("registro.FindByFechaSalida");
        query.setParameter("fechaInicial", new Timestamp(c1.getTimeInMillis()));
        query.setParameter("fechaFinal", new Timestamp(c2.getTimeInMillis()));
        Manager.commitTransaction();

        List<Registro> registros = query.getResultList();
        for (Registro r1 : registros) {
            System.out.println(".................................................");
            System.out.println("Roll Visita : " + r1.getRolVisita());
            System.out.println("Visita : " + r1.getVisita());
            System.out.println("Fe. Entrada : " + r1.getFechaEntrada());
            System.out.println("Fe. Salida : " + r1.getFechaSalida());
            System.out.println("No. Registro : " + r1.getNumeroRegistro());
            System.out.println("Registro - No. Documento : " + r1.getCuenta().getCuentaPK().getNumeroDocumento());
            System.out.println("Registro - Tip. Documento : " + r1.getCuenta().getCuentaPK().getTipoDocumento());
            System.out.println(".................................................");
        }
    }

    @Test
    public void testFindByCuenta() {
        CuentaPK cpk = new CuentaPK("98", "T");
        Manager.beginTransaction();
        Query query = em.createNamedQuery("registro.FindByCuenta");
        query.setParameter("tipoDocumento", "%" + cpk.getTipoDocumento() + "%");
        query.setParameter("numeroDocumento", "%" + cpk.getNumeroDocumento() + "%");

        Manager.commitTransaction();

        List<Registro> registros = query.getResultList();
        for (Registro r1 : registros) {
            System.out.println(".................................................");
            System.out.println("Roll Visita : " + r1.getRolVisita());
            System.out.println("Visita : " + r1.getVisita());
            System.out.println("Fe. Entrada : " + r1.getFechaEntrada());
            System.out.println("Fe. Salida : " + r1.getFechaSalida());
            System.out.println("No. Registro : " + r1.getNumeroRegistro());
            System.out.println("Registro - No. Documento : " + r1.getCuenta().getCuentaPK().getNumeroDocumento());
            System.out.println("Registro - Tip. Documento : " + r1.getCuenta().getCuentaPK().getTipoDocumento());
            System.out.println(".................................................");
        }
    }

    @Test
    public void testFindByVisita() {
        Manager.beginTransaction();
        Query query = em.createNamedQuery("registro.FindByVisita");
        query.setParameter("visita", "%" + "p" + "%");
        Manager.commitTransaction();

        List<Registro> registros = query.getResultList();
        for (Registro r1 : registros) {
            System.out.println(".................................................");
            System.out.println("Roll Visita : " + r1.getRolVisita());
            System.out.println("Visita : " + r1.getVisita());
            System.out.println("Fe. Entrada : " + r1.getFechaEntrada());
            System.out.println("Fe. Salida : " + r1.getFechaSalida());
            System.out.println("No. Registro : " + r1.getNumeroRegistro());
            System.out.println("Registro - No. Documento : " + r1.getCuenta().getCuentaPK().getNumeroDocumento());
            System.out.println("Registro - Tip. Documento : " + r1.getCuenta().getCuentaPK().getTipoDocumento());
            System.out.println(".................................................");
        }
    }

    @Test
    public void testFindByRolVisita() {
        Manager.beginTransaction();
        Query query = em.createNamedQuery("registro.FindByRolVisita");
        query.setParameter("rolVisita", "%" + "v" + "%");
        Manager.commitTransaction();

        List<Registro> registros = query.getResultList();
        for (Registro r1 : registros) {
            System.out.println(".................................................");
            System.out.println("Roll Visita : " + r1.getRolVisita());
            System.out.println("Visita : " + r1.getVisita());
            System.out.println("Fe. Entrada : " + r1.getFechaEntrada());
            System.out.println("Fe. Salida : " + r1.getFechaSalida());
            System.out.println("No. Registro : " + r1.getNumeroRegistro());
            System.out.println("Registro - No. Documento : " + r1.getCuenta().getCuentaPK().getNumeroDocumento());
            System.out.println("Registro - Tip. Documento : " + r1.getCuenta().getCuentaPK().getTipoDocumento());
            System.out.println(".................................................");
        }
    }
    
    @Test
    public void testCount(){
    em.getTransaction().begin();
    Query query = em.createNamedQuery("registro.Count", Registro.class);
    em.getTransaction().commit();
        System.out.println(query.getResultList());
    }
}
