package com.vasilev.JavaDeveloperTest.Repository.Finance;

import com.vasilev.JavaDeveloperTest.Entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepository extends JpaRepository<Price,Long> {
}
