/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitocode.service.impl;

import com.mitocode.repo.IGenericRepo;
import com.mitocode.service.IGenericCRUDService;
import java.util.List;

/**
 *
 * @author cmunoz
 */
public abstract class GenericCRUDServiceImpl<T, V> implements IGenericCRUDService<T, V>{
    
    protected abstract IGenericRepo<T, V> getRepo();

    @Override
    public T registrar(T obj) {
        return getRepo().save(obj);
    }

    @Override
    public T modificar(T obj) {
        return getRepo().save(obj);
    }

    @Override
    public List<T> listar() {
        return getRepo().findAll();
    }

    @Override
    public T listarPorId(V id) {
        return getRepo().findById(id).orElse(null);
    }

    @Override
    public void eliminar(V id) {
        getRepo().deleteById(id);
    }
    
}
