package com.mmocek.msscinventoryfailover.controllers;

import com.mmocek.commons.model.BeerInventoryDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.UUID;

@Slf4j
@RestController
public class InventoryController {

    @GetMapping("inventory-failover")
    public Flux<BeerInventoryDto> listBeersById() {
        BeerInventoryDto beerInventoryDto = BeerInventoryDto.builder()
                                                            .quantityOnHand(999)
                                                            .beerId(new UUID(0, 0))
                                                            .build();
        return Flux.just(beerInventoryDto);
    }

}
