package com.vasilev.JavaDeveloperTest.Repository.Finance;


import com.vasilev.JavaDeveloperTest.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    List<Product> getAllByCode(List<Integer> codes);

}