package com.vasilev.JavaDeveloperTest.ServiceImpl.Finance;

import com.vasilev.JavaDeveloperTest.Entity.Product;
import com.vasilev.JavaDeveloperTest.Repository.Finance.ProductRepository;
import com.vasilev.JavaDeveloperTest.ServiceImpl.ReadWriteService;
import org.springframework.stereotype.Service;

@Service
public class ProductService extends ReadWriteService<Long, Product> {

    private final ProductRepository productRepository;

    protected ProductService(ProductRepository productRepository) {
        super(productRepository);
        this.productRepository = productRepository;
    }
}
