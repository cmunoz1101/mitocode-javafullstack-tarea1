/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitocode.service.impl;

import com.mitocode.model.Persona;
import com.mitocode.repo.IGenericRepo;
import com.mitocode.repo.IPersonaRepo;
import com.mitocode.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author cmunoz
 */
@Service
public class PersonaServiceImpl extends GenericCRUDServiceImpl<Persona, Integer> implements IPersonaService{
    
    @Autowired
    private IPersonaRepo iPersonaRepo;

    @Override
    protected IGenericRepo<Persona, Integer> getRepo() {
        return this.iPersonaRepo;
    }
    
}
