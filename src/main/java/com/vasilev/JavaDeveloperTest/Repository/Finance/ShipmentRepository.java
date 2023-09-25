package com.vasilev.JavaDeveloperTest.Repository.Finance;

import com.vasilev.JavaDeveloperTest.Entity.Customer;
import com.vasilev.JavaDeveloperTest.Entity.Product;
import com.vasilev.JavaDeveloperTest.Entity.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.List;

@Repository
public interface ShipmentRepository extends JpaRepository<Shipment,Long> {
    /**
     * - выгрузка фактов по дням, согласно фильтрации по списку наименований сетей и списку продуктов
     */
    List<Shipment> findByCustomersAndProductsAndDate(List<Customer> customers, List<Product> products, OffsetDateTime dateTime);



}
