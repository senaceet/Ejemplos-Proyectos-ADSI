/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.proyecto.pruebasu;

import edu.co.sena.proyecto.Manager;
import edu.co.sena.proyecto.entity.Equipo;
import edu.co.sena.proyecto.entity.Registro;
import java.util.Collection;
import javax.persistence.EntityManager;
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
public class TestRegistroEquipo {

    EntityManager em = Manager.getEntityManager();

    public TestRegistroEquipo() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("*****************************************");
        System.out.println("");
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
    public void insert() {

        Registro r1 = em.find(Registro.class, 1);
        Equipo e1 = em.find(Equipo.class, "01230203");
        Collection<Equipo> equipos = r1.getCollectionEquipo();
        equipos.add(e1);
        r1.setCollectionEquipo(equipos);

        Manager.beginTransaction();
        em.merge(r1);
        Manager.commitTransaction();

    }

    @Test
    public void find() {

        Registro r1 = em.find(Registro.class, 1);
        Equipo e1 = em.find(Equipo.class, "112233");
        for (Equipo col : r1.getCollectionEquipo()) {
            if (col.getIdEquipo().equals(e1.getIdEquipo())) {
                System.out.println("........................................");
                System.out.println("REGISTRO");
                System.out.println("Roll Visita : " + r1.getRolVisita());
                System.out.println("Visita : " + r1.getVisita());
                System.out.println("Fe. Entrada : " + r1.getFechaEntrada().toString());
                System.out.println("Fe. Salida : " + r1.getFechaSalida().toString());
                System.out.println("No. Registro : " + r1.getNumeroRegistro());
                System.out.println("Registro - No. Documento : " + r1.getCuenta().getCuentaPK().getNumeroDocumento());
                System.out.println("Registro - Tip. Documento : " + r1.getCuenta().getCuentaPK().getTipoDocumento());
                System.out.println(".................................................");
                System.out.println("EQUIPO");
                System.out.println(".............................................");
                System.out.println("Id Equipo : " + col.getIdEquipo());
                System.out.println("Descripcion : " + col.getDescripcion());
                System.out.println("Estado : " + col.getEstado());
                System.out.println(".............................................");
            }

        }

    }

    @Test
    public void update() {
        Registro r1 = em.find(Registro.class, 1);
        Equipo eViejo = em.find(Equipo.class, "112233");
        Equipo eNuevo = em.find(Equipo.class, "888555");

        Collection<Equipo> eTemp = r1.getCollectionEquipo();

        for (Equipo col : r1.getCollectionEquipo()) {
            if (col.getIdEquipo().equals(eViejo.getIdEquipo())) {
                System.out.println("encontro");
                eTemp.remove(col);
                eTemp.add(eNuevo);
                break;
            }
        }
        r1.setCollectionEquipo(eTemp);

        Manager.beginTransaction();
        em.merge(r1);
        Manager.commitTransaction();

    }

    @Test
    public void borrar() {
        Registro r1 = em.find(Registro.class, 1);
        Equipo eborrar = em.find(Equipo.class, "888555");

        for (Equipo col : r1.getCollectionEquipo()) {
            if (col.getIdEquipo().equals(eborrar.getIdEquipo())) {
                r1.getCollectionEquipo().remove(col);
                break;
            }
        }
        Manager.beginTransaction();
        em.merge(r1);
        Manager.commitTransaction();
    }

}
