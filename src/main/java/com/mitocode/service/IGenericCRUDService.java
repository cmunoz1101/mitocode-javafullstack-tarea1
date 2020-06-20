/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitocode.service;

import java.util.List;

/**
 *
 * @author cmunoz
 */
public interface IGenericCRUDService<T, V> {

    T registrar(T obj);

    T modificar(T obj);

    List<T> listar();

    T listarPorId(V id);

    void eliminar(V id);

}
