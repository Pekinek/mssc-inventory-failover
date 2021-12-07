package com.mmocek.msscinventoryfailover.controllers;

import com.mmocek.commons.model.BeerInventoryDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.UUID;

@Slf4j
@RestController
public class InventoryController {

    @GetMapping("api/v1/beer/{beerId}/inventory")
    public Flux<BeerInventoryDto> listBeersById(@PathVariable UUID beerId) {
        log.debug("Finding Inventory for beerId: " + beerId);
        return getFailoverInventory();
    }

    @GetMapping("api/v1/beerUpc/{beerUpc}/inventory")
    public Flux<BeerInventoryDto> listBeersByUpc(@PathVariable String beerUpc) {
        log.debug("Finding Inventory for beerUpc: " + beerUpc);
        return getFailoverInventory();
    }

    private Flux<BeerInventoryDto> getFailoverInventory() {
        BeerInventoryDto beerInventoryDto = BeerInventoryDto.builder()
                                                            .quantityOnHand(999)
                                                            .beerId(new UUID(0, 0))
                                                            .build();
        return Flux.just(beerInventoryDto);
    }
}
