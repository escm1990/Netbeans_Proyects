
import com.tesis.controllers.TesisCampusJpaController;
import com.tesis.controllers.TesisSystemImageJpaController;
import com.tesis.model.entity.TesisCampus;
import com.tesis.model.entity.TesisSystemImage;
import java.util.Date;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Luis Chávez
 */
public class tesis_system_image_test {
    
     @Test
     public void insertCampus() {
     
         TesisSystemImage image = new TesisSystemImage();
         TesisSystemImageJpaController controller = new TesisSystemImageJpaController();
         image.setImageUri("/algo");
         image.setImageDescription("adas");
         image.setImageExtesion("jpg");
         controller.create(image);
       
         
         
     }
}
