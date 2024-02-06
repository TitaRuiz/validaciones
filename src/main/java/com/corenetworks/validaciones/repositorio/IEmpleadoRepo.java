package com.corenetworks.validaciones.repositorio;

import com.corenetworks.validaciones.dto.ResumenDTO;
import com.corenetworks.validaciones.modelo.Empleado;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IEmpleadoRepo extends IGenericoRepo<Empleado, Integer>{
    @Query(value = "Select count(id_empleado) as contador, avg(sueldo) as sueldo_promedio from empleados;",nativeQuery = true)
    public List<Object[]> obtenerResumenes();
}
