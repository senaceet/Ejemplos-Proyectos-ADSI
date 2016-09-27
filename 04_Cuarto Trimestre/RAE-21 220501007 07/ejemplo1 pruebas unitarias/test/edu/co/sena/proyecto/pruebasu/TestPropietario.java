/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.proyecto.pruebasu;

import edu.co.sena.proyecto.Manager;
import edu.co.sena.proyecto.entity.Cuenta;
import edu.co.sena.proyecto.entity.CuentaPK;
import edu.co.sena.proyecto.entity.Equipo;
import java.util.Collection;
import java.util.List;
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
public class TestPropietario {

    EntityManager em = Manager.getEntityManager();

    public TestPropietario() {
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
    public void insert() {

        Cuenta c1 = em.find(Cuenta.class, new CuentaPK("1030684230", "CC"));
        Equipo e1 = em.find(Equipo.class, "1234567");
        Collection<Equipo> equipos = c1.getCollectionEquipo();
        equipos.add(e1);
        c1.setCollectionEquipo(equipos);

        Manager.beginTransaction();
        em.merge(c1);
        Manager.commitTransaction();

    }

    @Test
    public void find() {
        Cuenta c1 = em.find(Cuenta.class, new CuentaPK("1030621348", "CC"));
        Equipo e1 = em.find(Equipo.class, "102233");
        for (Equipo col : c1.getCollectionEquipo()) {
            if (col.getIdEquipo().equals(e1.getIdEquipo())) {
                System.out.println("........................................");
                System.out.println("CUENTA :");
                System.out.println("Cargo : " + c1.getCargo());
                System.out.println("Primer Apellido : " + c1.getPrimerApellido());
                System.out.println("Primer Nombre : " + c1.getPrimerNombre());
                System.out.println("Segundo Apellido : " + c1.getSegundoApellido());
                System.out.println("Estado : " + c1.getEstado());
                System.out.println("Fecha Finalizacion : " + c1.getFechaFinalizacion().toString());
                if (c1.getImagen() != null) {
                    System.out.println("Imagen : " + c1.getImagen().length);
                } else {
                    System.out.println("Esta Vacia");
                }
                System.out.println("Numero Documento : " + c1.getCuentaPK().getNumeroDocumento());
                System.out.println("Tipo Documento : " + c1.getCuentaPK().getTipoDocumento());
                System.out.println(".........................................");
                System.out.println("EQUIPO :");
                System.out.println(".........................................");
                System.out.println("Id Equipo : " + col.getIdEquipo());
                System.out.println("Descripcion : " + col.getDescripcion());
                if (c1.getEstado() == true) {
                    System.out.println("Estado : Activo");
                } else {
                    System.out.println("Estado : Activo");
                }
                System.out.println(".........................................");
            }

        }

    }

    @Test
    public void update() {

        Equipo equi = new Equipo("888555");
        equi.setDescripcion("descripcion equipo ne");
        equi.setEstado(true);

        Manager.beginTransaction();
        em.persist(equi);
        Manager.commitTransaction();
//        

        Cuenta c1 = em.find(Cuenta.class, new CuentaPK("98111051089", "TI"));
        Equipo eViejo = em.find(Equipo.class, "01230203");
        Equipo eNuevo = em.find(Equipo.class, "888555");

        Collection<Equipo> eTemp = c1.getCollectionEquipo();

        for (Equipo col : c1.getCollectionEquipo()) {
            if (col.getIdEquipo().equals(eViejo.getIdEquipo())) {
                System.out.println("encontro");
                eTemp.remove(col);
                eTemp.add(eNuevo);
                break;
            }
        }
        c1.setCollectionEquipo(eTemp);

        Manager.beginTransaction();
        em.merge(c1);
        Manager.commitTransaction();

    }

    @Test
    public void borrar() {
        Cuenta c1 = em.find(Cuenta.class, new CuentaPK("1030621348", "CC"));
        Equipo eborrar = em.find(Equipo.class, "102233");

        for (Equipo col : c1.getCollectionEquipo()) {
            if (col.getIdEquipo().equals(eborrar.getIdEquipo())) {
                c1.getCollectionEquipo().remove(col);
                break;
            }
        }
        Manager.beginTransaction();
        em.merge(c1);
        Manager.commitTransaction();
    }

}
