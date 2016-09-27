/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.proyecto.pruebasu;

import edu.co.sena.proyecto.Manager;
import edu.co.sena.proyecto.entity.Equipo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author PeterD
 */
public class TestEquipo {

    EntityManager em = Manager.getEntityManager();

    public TestEquipo() {
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
//...........................................................................

    @Test
    public void testEquipoInsert() {
        Equipo equi = new Equipo("016230203");
        equi.setDescripcion("descripcion equipo 1");
        equi.setEstado(true);

        Manager.beginTransaction();
        em.persist(equi);
        Manager.commitTransaction();
    }

    @Test
    public void testEquipoUpdate() {

        Equipo equi = em.find(Equipo.class, "016230203");

        equi.setDescripcion("descripcion update ");
        equi.setEstado(false);

        Manager.beginTransaction();
        em.merge(equi);
        Manager.commitTransaction();

    }

    @Test
    public void testEquipoDelete() {
        Equipo equi = em.find(Equipo.class, "01230203");

        Manager.beginTransaction();
        em.remove(equi);
        Manager.commitTransaction();
    }

    @Test
    public void testFindByAll() {
        Manager.beginTransaction();
        Query query = em.createNamedQuery("equipo.FindByAll");
        Manager.commitTransaction();

        List<Equipo> equipos = query.getResultList();
        for (Equipo equipo : equipos) {
            System.out.println(".............................................");
            System.out.println(equipo.getIdEquipo());
            System.out.println(equipo.getDescripcion());
            System.out.println(equipo.getEstado());
            System.out.println(".............................................");
        }
    }

    @Test
    public void testFindByIdEquipo() {

        Query query = em.createNamedQuery("equipo.FindByIdEquipo");
        query.setParameter("idEquipo", "%" + "012" + "%");

        List<Equipo> equipos = query.getResultList();
        for (Equipo equipo : equipos) {
            System.out.println(".............................................");
            System.out.println(equipo.getIdEquipo());
            System.out.println(equipo.getDescripcion());
            System.out.println(equipo.getEstado());
            System.out.println(".............................................");
        }
    }

    @Test
    public void testFindByDescripcion() {

        Query query = em.createNamedQuery("equipo.FindByDescripcion");
        query.setParameter("descripcion", "%" + "1" + "%");

        List<Equipo> equipos = query.getResultList();
        for (Equipo equipo : equipos) {
            System.out.println(".............................................");
            System.out.println(equipo.getIdEquipo());
            System.out.println(equipo.getDescripcion());
            System.out.println(equipo.getEstado());
            System.out.println(".............................................");
        }
    }

    @Test
    public void testFindByEstado() {

        Query query = em.createNamedQuery("equipo.FindByEstado");
        query.setParameter("estado", true);

        List<Equipo> equipos = query.getResultList();
        for (Equipo equipo : equipos) {
            System.out.println(".............................................");
            System.out.println(equipo.getIdEquipo());
            System.out.println(equipo.getDescripcion());
            System.out.println(equipo.getEstado());
            System.out.println(".............................................");
        }
    }

    @Test
    public void testUpdateIdEquipo() {
        Manager.beginTransaction();
        Query query = em.createNamedQuery("equipo.updateIdEquipo");
        query.setParameter("nuevoId", "dsadas");
        query.setParameter("viejaId", "01230203").executeUpdate();
        Manager.commitTransaction();

    }
    
   @Test
   public void testCount(){
   em.getTransaction().begin();
   Query query = em.createNamedQuery("equipo.Count", Equipo.class);
   em.getTransaction().commit();
       System.out.println(query.getResultList());
   }
}
