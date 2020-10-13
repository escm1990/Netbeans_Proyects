/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.tesis.controllers.TesisCampusJpaController;
import com.tesis.model.entity.TesisCampus;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Luis Chávez
 */
public class tesis_campus_test {
    
    public tesis_campus_test() {
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void insertCampus() {
     
         TesisCampus campus = new TesisCampus();
         TesisCampusJpaController controller = new TesisCampusJpaController();      
         campus.setCampusName("Facultad Multidisciplinaria de Occidente");
         campus.setCreatedBy("Luis Chávez");
         campus.setCreatedDate(new Date());
         controller.create(campus);
         
         
     }
}
