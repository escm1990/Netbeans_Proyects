/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.tesis.controllers.TesisCampusJpaController;
import com.tesis.controllers.TesisInfrastructureJpaController;
import com.tesis.model.entity.TesisCampus;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import com.tesis.model.entity.TesisInfrastructure;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Luis Chávez
 */
public class tesis_infraestructure_test {
    
    public tesis_infraestructure_test() {
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
    }
   
     @Test
     public void hello() throws Exception {
     
         TesisInfrastructureJpaController controller = new TesisInfrastructureJpaController();
         TesisInfrastructure ent = new TesisInfrastructure();

         TesisCampus campus;
         TesisCampusJpaController campusController = new TesisCampusJpaController();
         campus = campusController.findTesisCampus(1);
         ent.setInfraestructuraName("Edificio de Usos Multiples");
         ent.setCreatedDate(new Date());
         ent.setCreatedBy("Luis Chavez");
         ent.setFkTesisCampus(campus);
         controller.create(ent);
         
         
         List<TesisInfrastructure> list = controller.findTesisInfrastructureEntities();
         
     }
}
