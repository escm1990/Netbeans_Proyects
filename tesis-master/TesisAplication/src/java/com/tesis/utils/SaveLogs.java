/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tesis.utils;

import com.tesis.controllers.TesisLogJpaController;
import com.tesis.model.entity.TesisLog;
import java.util.Date;

/**
 * 
 * @author luis.chavez
 */
public abstract class SaveLogs {

    public static void logRegister(String idLog, String desc, String user) {
        Date date = new Date();
        TesisLogJpaController logImpl = new TesisLogJpaController();
        TesisLog log = new TesisLog();

        log.setIdLog(idLog);
        log.setLogDescription(desc);
        log.setCreatedDate(date);
        log.setCreatedBy(user);
        logImpl.create(log);

    }
	
}
