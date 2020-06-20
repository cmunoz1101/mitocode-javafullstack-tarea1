/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitocode.service.impl;

import com.mitocode.model.Venta;
import com.mitocode.repo.IGenericRepo;
import com.mitocode.repo.IVentaRepo;
import com.mitocode.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author cmunoz
 */
@Service
public class VentaServiceImpl extends GenericCRUDServiceImpl<Venta, Integer> implements IVentaService {

    @Autowired
    private IVentaRepo iVentaRepo;

    @Override
    protected IGenericRepo<Venta, Integer> getRepo() {
        return this.iVentaRepo;
    }

    @Override
    public Venta registrarTransaccional(Venta venta) throws Exception {
        venta.getDetalleVenta().forEach(det -> det.setVenta(venta));
        return this.iVentaRepo.save(venta);
    }

}
