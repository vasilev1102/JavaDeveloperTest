package com.vasilev.JavaDeveloperTest.ServiceImpl;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public abstract class ReadOnlyService<K,T> {

    private final JpaRepository<T,K> jpaRepository;

    protected ReadOnlyService(JpaRepository<T, K> jpaRepository) {
        this.jpaRepository = jpaRepository;
    }


    public T getByKey(K key) {

        return (T) jpaRepository.findById(key);
    }

    public boolean isExist(K key){
        return jpaRepository.existsById(key);
    }

    public List<T> getAll() {

        return jpaRepository.findAll();
    }

}
