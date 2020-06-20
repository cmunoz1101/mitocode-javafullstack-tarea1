/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitocode.service;

import com.mitocode.model.Venta;

/**
 *
 * @author cmunoz
 */
public interface IVentaService extends IGenericCRUDService<Venta, Integer> {

    Venta registrarTransaccional(Venta venta) throws Exception;

}
