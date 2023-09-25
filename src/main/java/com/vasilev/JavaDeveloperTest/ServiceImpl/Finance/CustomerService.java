package com.vasilev.JavaDeveloperTest.ServiceImpl.Finance;

import com.vasilev.JavaDeveloperTest.Entity.Customer;
import com.vasilev.JavaDeveloperTest.Repository.Finance.CustomerRepository;
import com.vasilev.JavaDeveloperTest.ServiceImpl.ReadWriteService;
import org.springframework.stereotype.Service;

@Service
public class CustomerService extends ReadWriteService<Long, Customer> {

    private final CustomerRepository customerRepository;

    protected CustomerService(CustomerRepository customerRepository) {
        super(customerRepository);
        this.customerRepository = customerRepository;
    }
}
