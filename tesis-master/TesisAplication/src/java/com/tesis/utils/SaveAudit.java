/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tesis.utils;

import com.tesis.controllers.TesisAuditJpaController;
import com.tesis.model.entity.TesisAudit;
import java.util.Date;

/**
 * 
 * @author luis.chavez
 */
public abstract class SaveAudit {
    
    public static void logRegister(String module, String desc) {
        Date date = new Date();
        TesisAuditJpaController auditImpl = new TesisAuditJpaController();
        TesisAudit audit = new TesisAudit();
        
        audit.setModule(module);
        audit.setDescription(desc);
        audit.setVisitDate(date);
        auditImpl.create(audit);
        
    }
}
