package com.okta.developer.jugtours.web;

import com.okta.developer.jugtours.model.DealCreationPayload;
import com.okta.developer.jugtours.model.Deals;
import com.okta.developer.jugtours.storage.CustDealMapping;
import com.okta.developer.jugtours.storage.DealsStorage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Collection;

@RestController
@RequestMapping("/api")
class Controller {

    private final Logger log = LoggerFactory.getLogger(Controller.class);
    private final DealsStorage dealsStorage;
    private final CustDealMapping custDealMapping;

    public Controller() {
        dealsStorage = new DealsStorage();
        custDealMapping = new CustDealMapping();
    }

    @GetMapping("/deals")
    Collection<Deals> groups() {
        return dealsStorage.getAllDeals();
    }

    @PostMapping("/deals/addDeal")
    Deals addDeal(@RequestBody DealCreationPayload dealCreationPayload) {
        log.info("Request to add deal");
        log.info(dealCreationPayload.toString());
        Deals deal = new Deals();
        deal.startTime = LocalDate.now();
        deal.endTime = dealCreationPayload.endTime;
        deal.isDealOngoing = true;
        deal.price = dealCreationPayload.price;
        deal.remainingItems = dealCreationPayload.numberOfItems;
        deal.totalItems = dealCreationPayload.numberOfItems;
        dealsStorage.addDeal(deal);
        log.info("Deal added successfully");
        return deal;
    }
/*
    @GetMapping("/group/{id}")
    ResponseEntity<?> getGroup(@PathVariable Long id) {
        Optional<Group> group = groupRepository.findById(id);
        return group.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/group")
    ResponseEntity<Group> createGroup(@Valid @RequestBody Group group) throws URISyntaxException {
        log.info("Request to create group: {}", group);
        Group result = groupRepository.save(group);
        return ResponseEntity.created(new URI("/api/group/" + result.getId()))
                .body(result);
    }

    @PutMapping("/group/{id}")
    ResponseEntity<Group> updateGroup(@Valid @RequestBody Group group) {
        log.info("Request to update group: {}", group);
        Group result = groupRepository.save(group);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/group/{id}")
    public ResponseEntity<?> deleteGroup(@PathVariable Long id) {
        log.info("Request to delete group: {}", id);
        groupRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }*/
}