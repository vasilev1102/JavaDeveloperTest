package com.vasilev.JavaDeveloperTest.Mapper;

import java.util.List;

public interface DtoMapper<E,D> {

    E toEntity (D dto);

    List<E> toEntity (List<D> dto);
}
