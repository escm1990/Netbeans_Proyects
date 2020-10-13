/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.tesis.controllers.TesisCampusJpaController;
import com.tesis.controllers.TesisMastersJpaController;
import com.tesis.model.entity.TesisCampus;
import com.tesis.model.entity.TesisMasters;
import com.tesis.utils.JpaUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Luis Chávez
 */
public class tesis_maestria_test {

    public tesis_maestria_test() {
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

    @Test
    public void prueba() {
        TesisMasters maestria = new TesisMasters();
        TesisMastersJpaController controller = new TesisMastersJpaController();
        TesisCampus campus;
        TesisCampusJpaController campusController = new TesisCampusJpaController();
        campus = campusController.findTesisCampus(1);

        maestria.setMaestriaName("Maestria en Gestion Ambiental");
        maestria.setMaestriaDescripcion("Disponible en Facultad Multidisciplinaria de Occidente");
        maestria.setFkTesisCampus(campus);
        maestria.setCreatedBy("Luis Chávez");
        maestria.setCreatedDate(new Date());
        controller.create(maestria);
        
        List<TesisMasters> maestrias = new ArrayList<>();
        maestrias = controller.findTesisMastersEntities();
        for(TesisMasters master: maestrias) {
            System.out.println(master.getCodTesisMasters() + " " + master.getMaestriaName());
        }

    }

}
