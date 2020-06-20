/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitocode.service.impl;

import com.mitocode.model.Producto;
import com.mitocode.repo.IGenericRepo;
import com.mitocode.repo.IProductoRepo;
import com.mitocode.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author cmunoz
 */
@Service
public class ProductoServiceImpl extends GenericCRUDServiceImpl<Producto, Integer> implements IProductoService{
    
    @Autowired
    private IProductoRepo iProductoRepo;

    @Override
    protected IGenericRepo<Producto, Integer> getRepo() {
        return this.iProductoRepo;
    }
    
}
