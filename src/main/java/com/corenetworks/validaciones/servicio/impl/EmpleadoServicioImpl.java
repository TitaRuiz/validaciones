package com.corenetworks.validaciones.servicio.impl;

import com.corenetworks.validaciones.dto.ResumenDTO;
import com.corenetworks.validaciones.modelo.Empleado;
import com.corenetworks.validaciones.repositorio.IEmpleadoRepo;
import com.corenetworks.validaciones.repositorio.IGenericoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoServicioImpl extends CRUDImpl<Empleado,Integer> implements IEmpleadoServicio {
    @Autowired
    private IEmpleadoRepo repo;
    @Override
    protected IGenericoRepo<Empleado, Integer> getRepo() {
        return repo;
    }


    @Override
    public List<Object[]> obtenerResumenes() {
        return repo.obtenerResumenes();
    }
}
