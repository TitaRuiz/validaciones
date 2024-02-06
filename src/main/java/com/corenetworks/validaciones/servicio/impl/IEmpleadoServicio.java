package com.corenetworks.validaciones.servicio.impl;

import com.corenetworks.validaciones.dto.ResumenDTO;
import com.corenetworks.validaciones.modelo.Empleado;

import java.util.List;

public interface IEmpleadoServicio extends ICRUD<Empleado,Integer> {
    public List<Object[]> obtenerResumenes();
}
