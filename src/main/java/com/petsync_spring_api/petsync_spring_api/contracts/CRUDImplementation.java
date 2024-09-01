package com.petsync_spring_api.petsync_spring_api.contracts;

import java.util.List;

public interface CRUDImplementation<T, CODE> {

    T insert(T entity);

    T update(T entity);

    Integer deleteByCode(CODE code);

    T selectByCode(CODE code);

    List<T> selectAll();
}
