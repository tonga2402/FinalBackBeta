package com.IntegradorBeta.Beta.service;

import com.IntegradorBeta.Beta.exceptions.BadRequestException;

import java.util.List;

public interface AppService <T,E> {

    E agregar ( T t ) throws BadRequestException;
    E buscarPorId ( Integer id ) throws IllegalAccessException;
    E modificar ( T t );
    String eliminar ( Integer id ) throws IllegalAccessException;
    List<E> listar();

}
