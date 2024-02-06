package com.corenetworks.validaciones.servicio.impl;

import com.corenetworks.validaciones.repositorio.IGenericoRepo;

import java.util.List;

public abstract class CRUDImpl<T,ID> implements ICRUD<T,ID> {

    protected abstract IGenericoRepo<T,ID> getRepo();
    @Override
    public T crear(T t) {
        return getRepo().save(t);
    }

    @Override
    public T modificar(T t) {
        return getRepo().save(t);
    }

    @Override
    public void eliminar(ID id) {
        getRepo().deleteById(id);
    }

    @Override
    public T consultarUno(ID id) {
        return getRepo().findById(id).orElse(null);
    }

    @Override
    public List<T> consultarTodos(T t) {
        return getRepo().findAll();
    }
}
