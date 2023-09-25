package com.vasilev.JavaDeveloperTest.Controller;

import com.vasilev.JavaDeveloperTest.DTO.PriceDto;
import com.vasilev.JavaDeveloperTest.Entity.Price;
import com.vasilev.JavaDeveloperTest.Mapper.Finance.PriceMapper;
import com.vasilev.JavaDeveloperTest.ServiceImpl.Finance.CustomerService;
import com.vasilev.JavaDeveloperTest.ServiceImpl.Finance.PriceService;
import com.vasilev.JavaDeveloperTest.ServiceImpl.Finance.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/finance")
public class FinanceController {

    private final PriceService priceService;

    private final CustomerService customerService;

    private final ProductService productServie;
    private final PriceMapper priceMapper;

    public FinanceController(PriceService priceService, CustomerService customerService,
                             ProductService productServie, PriceMapper priceMapper) {
        this.priceService = priceService;
        this.customerService = customerService;
        this.productServie = productServie;
        this.priceMapper = priceMapper;
    }


    @GetMapping("/getAll")
    public ResponseEntity<List<PriceDto>> getAllPrices(){
        List<PriceDto> prices = priceMapper.toDto(priceService.getAll());
        if(!prices.isEmpty()){
            return new ResponseEntity<>(prices, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/{priceId}")
    public ResponseEntity<PriceDto> getPriceById(@PathVariable("priceId") Long priceId){
        if(priceService.isExist(priceId)){
            return new ResponseEntity<>(priceMapper.toDto(priceService.getByKey(priceId)), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping()
    public ResponseEntity<Void> createPrice(@RequestBody PriceDto priceDto){

        Price price = priceMapper.toEntity(priceDto);
        if(productServie.isExist(priceDto.productId) && customerService.isExist(priceDto.customerId)){
            price.setProduct(productServie.getByKey(priceDto.productId));
            price.setCustomer(customerService.getByKey(priceDto.customerId));
            return ResponseEntity.ok().build();
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/{priceId}")
    public ResponseEntity<PriceDto> updatePrice(@PathVariable("priceId") Long priceId, @RequestBody PriceDto priceDto){
        if(priceService.isExist(priceId) && productServie.isExist(priceDto.productId)
                && customerService.isExist(priceDto.customerId)){
            Price price = priceService.getByKey(priceId);
            price.setCustomer(customerService.getByKey(priceDto.customerId));
            price.setProduct(productServie.getByKey(priceDto.productId));
            priceService.persist(price);
            return new ResponseEntity<>(priceMapper.toDto(price),HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{priceId}")
    public ResponseEntity<Void> deletePrice(@PathVariable("priceId") Long priceId){
        if(priceService.isExist(priceId)){
            priceService.deleteById(priceId);
            return ResponseEntity.ok().build();
        } else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }



}
