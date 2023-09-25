package com.vasilev.JavaDeveloperTest.Controller;

import com.vasilev.JavaDeveloperTest.DTO.ShipmentDto;
import com.vasilev.JavaDeveloperTest.Mapper.Finance.ShipmentMapper;
import com.vasilev.JavaDeveloperTest.ServiceImpl.Finance.ShipmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;
import java.util.List;

@RestController
@RequestMapping("/analisys")
public class AnalysisController {

    private final ShipmentService shipmentService;
    private final ShipmentMapper shipmentMapper;

    public AnalysisController(ShipmentService shipmentService, ShipmentMapper shipmentMapper) {
        this.shipmentService = shipmentService;
        this.shipmentMapper = shipmentMapper;
    }


    @GetMapping("/getAllByCustomersAndProductsAndDate")
    public ResponseEntity<List<ShipmentDto>> getAllByCustomersAndProductsAndDate(@RequestParam List<String> names,
                                                                 @RequestParam List<Integer> productsCode,
                                                                 @RequestParam OffsetDateTime offsetDateTime){
        List<ShipmentDto> shipmentDtos = shipmentMapper.toDto(shipmentService.
                findByCustomersAndProductsAndDate(names,productsCode,offsetDateTime));
        return new ResponseEntity<>(shipmentDtos, HttpStatus.OK);
    }














}
