/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitocode.exception;

/**
 *
 * @author cmunoz
 */
public class ModeloNotFoundException extends RuntimeException {

    public ModeloNotFoundException(String mensaje) {
        super(mensaje);
    }

}
