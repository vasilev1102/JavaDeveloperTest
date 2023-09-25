package com.vasilev.JavaDeveloperTest.ServiceImpl.Finance;


import com.vasilev.JavaDeveloperTest.Entity.Price;
import com.vasilev.JavaDeveloperTest.Repository.Finance.PriceRepository;
import com.vasilev.JavaDeveloperTest.ServiceImpl.ReadWriteService;
import org.springframework.stereotype.Service;

@Service
public class PriceService extends ReadWriteService<Long, Price>{

    private final PriceRepository priceRepository;

    protected PriceService(PriceRepository priceRepository) {
        super(priceRepository);
        this.priceRepository = priceRepository;
    }
}
