package com.corenetworks.validaciones.controlador;

import com.corenetworks.validaciones.dto.EmpleadoDTO;
import com.corenetworks.validaciones.excepciones.ExcepcionPersonalizadaNoEncontrado;
import com.corenetworks.validaciones.modelo.Empleado;
import com.corenetworks.validaciones.servicio.impl.IEmpleadoServicio;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/empleados")
public class EmpleadoControlador {

    @Autowired
    private IEmpleadoServicio servicio;
    @PostMapping
    public ResponseEntity<EmpleadoDTO>  crearEmpleado(@Valid @RequestBody EmpleadoDTO e){
        Empleado e1 = e.castEmpleado();
        e1 = servicio.crear(e1);
        return new ResponseEntity<>(e.castEmpleadoADto(e1), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<EmpleadoDTO>  modificarEmpleado(@Valid @RequestBody EmpleadoDTO e){

        Empleado e1 = servicio.consultarUno(e.getIdEmpleado());
        if(e1 == null){
            throw new ExcepcionPersonalizadaNoEncontrado("EMPLEADO NO ENCONTRADO " + e.getIdEmpleado());
        }
        e1 = servicio.modificar(e.castEmpleado());
        return new ResponseEntity<>(e.castEmpleadoADto(e1), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<EmpleadoDTO> consultarUno(@PathVariable(name="id") Integer id){
        Empleado e1 = servicio.consultarUno(id);
        if(e1 == null){
            throw new ExcepcionPersonalizadaNoEncontrado("EMPLEADO NO ENCONTRADO " + id);
        }
        return new ResponseEntity<>((new EmpleadoDTO()).castEmpleadoADto(e1),HttpStatus.OK);
    }



}
