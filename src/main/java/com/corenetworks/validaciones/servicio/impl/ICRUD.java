package com.corenetworks.validaciones.servicio.impl;

import java.util.List;

public interface ICRUD<T,ID>{
    T crear(T t);
    T modificar(T t);

    void eliminar(ID id);
    T consultarUno(ID id);

    List<T> consultarTodos(T t);

}
