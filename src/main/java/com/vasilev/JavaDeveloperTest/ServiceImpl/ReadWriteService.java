package com.vasilev.JavaDeveloperTest.ServiceImpl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public abstract class ReadWriteService<K,T> extends ReadOnlyService<K,T> {

    private final JpaRepository<T,K> jpaRepository;

    protected ReadWriteService(JpaRepository<T, K> jpaRepository) {
        super(jpaRepository);
        this.jpaRepository = jpaRepository;
    }
    @Transactional
    public void persist(T entity){

        jpaRepository.save(entity);
    }

    @Transactional
    public void persistAll (List<T> entities){

        jpaRepository.saveAll(entities);
    }

    @Transactional
    public void delete (T entity){

        jpaRepository.delete(entity);
    }
    @Transactional
    public void deleteById (K key){

        jpaRepository.deleteById(key);
    }

    @Transactional
    public void deleteAll (){

        jpaRepository.deleteAll();
    }


}
