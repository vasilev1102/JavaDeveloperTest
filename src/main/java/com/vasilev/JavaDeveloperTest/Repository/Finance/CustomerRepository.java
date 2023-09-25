package com.vasilev.JavaDeveloperTest.Repository.Finance;

import com.vasilev.JavaDeveloperTest.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

    List<Customer> getAllByName(List<String> names);
}
