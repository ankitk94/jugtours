package com.okta.developer.jugtours.storage;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.okta.developer.jugtours.model.Deals;

public class DealsStorage {
    private Map<Long, Deals> deals;
    private Long lastDealId = Long.valueOf(0);
    public DealsStorage() {
        deals = new HashMap<>();
        Deals deal = new Deals();
        deal.id = (long) 1;
        deal.endTime = java.time.LocalDate.now();
        deal.startTime = java.time.LocalDate.now();
        deals.put((long) 1, deal);
    }

    public Deals addDeal(Deals deal) {
        lastDealId += 1;
        deal.id = lastDealId;
        deals.put(lastDealId, deal);
        return deal;
    }

    public Deals updateDeal(Long dealId, Deals deal) {
        deals.put(dealId, deal);
        return deal;
    }

    public Collection<Deals> getAllDeals() {
        return deals.values();
    }
}
