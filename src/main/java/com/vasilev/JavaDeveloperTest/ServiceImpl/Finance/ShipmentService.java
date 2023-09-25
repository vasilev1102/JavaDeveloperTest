package com.vasilev.JavaDeveloperTest.ServiceImpl.Finance;

import com.vasilev.JavaDeveloperTest.Entity.Customer;
import com.vasilev.JavaDeveloperTest.Entity.Product;
import com.vasilev.JavaDeveloperTest.Entity.Shipment;
import com.vasilev.JavaDeveloperTest.Repository.Finance.CustomerRepository;
import com.vasilev.JavaDeveloperTest.Repository.Finance.ProductRepository;
import com.vasilev.JavaDeveloperTest.Repository.Finance.ShipmentRepository;
import com.vasilev.JavaDeveloperTest.ServiceImpl.ReadWriteService;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;

@Service
public class ShipmentService extends ReadWriteService<Long, Shipment> {

    private final ShipmentRepository shipmentRepository;
    private final ProductRepository productRepository;
    private final CustomerRepository customerRepository;

    public ShipmentService(ShipmentRepository shipmentRepository, ProductRepository productRepository, CustomerRepository customerRepository) {
        super(shipmentRepository);
        this.shipmentRepository = shipmentRepository;
        this.productRepository = productRepository;
        this.customerRepository = customerRepository;
    }

    public List<Shipment> findByCustomersAndProductsAndDate(List<String> names, List<Integer> productsCode,
                                                            OffsetDateTime offsetDateTime){
        List<Product> products = productRepository.getAllByCode(productsCode);
        List<Customer> customers = customerRepository.getAllByName(names);
       return shipmentRepository.findByCustomersAndProductsAndDate(customers,products,offsetDateTime);
    }


}
