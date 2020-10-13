
import com.tesis.controllers.TesisUserCampusJpaController;
import com.tesis.controllers.TesisUserJpaController;
import com.tesis.model.entity.TesisCampus;
import com.tesis.model.entity.TesisUser;
import com.tesis.model.entity.TesisUserCampus;
import com.tesis.utils.EncriptUtility;
import com.tesis.utils.FindCampus;
import java.util.Date;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author luis.chavez
 */
public class tesis_user_test {

    @Test
    public void init() {

        TesisUserJpaController userImpl = new TesisUserJpaController();
        TesisUserCampusJpaController userCampusImpl = new TesisUserCampusJpaController();
        TesisUser user = new TesisUser();
        user.setUserName("luis.chavez");
        String password = EncriptUtility.getStringMessageDigest("admin", EncriptUtility.MD5);
        user.setUserPass(password);
        user.setUserDescription("administrador de sistema");
        user.setCreatedBy("system");
        user.setCreatedDate(new Date());
        user.setUpdateBy("system");
        user.setUpdateDate(new Date());

        userImpl.create(user);
        TesisCampus tesis_campus = FindCampus.getCampus("1");
        TesisUser user_return = userImpl.findTesisUserByUserName("luis.chavez");

        TesisUserCampus usercampus = new TesisUserCampus();
        usercampus.setFkTesisCampus(tesis_campus);
        usercampus.setFkTesisUser(user_return);
        usercampus.setCreatedBy("system");
        usercampus.setCreatedDate(new Date());
        userCampusImpl.create(usercampus);
    }
}
