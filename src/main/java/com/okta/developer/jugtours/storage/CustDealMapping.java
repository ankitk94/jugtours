package com.okta.developer.jugtours.storage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.okta.developer.jugtours.model.Deals;

public class CustDealMapping {
    private Map<Long, List<Long>> dealIdToCustomerIds;
    public CustDealMapping() {
        dealIdToCustomerIds = new HashMap<>();
    }

    public void addDealForCustomer(Long dealId, Long customerId) throws Exception {
        List<Long> customerIds = null;
        if (!dealIdToCustomerIds.containsKey(dealId)) {
            customerIds = new ArrayList<>();
        }
        else {
            customerIds = dealIdToCustomerIds.get(dealId);
        }
        // check for already existing customer
        if (alreadyExists(customerId, customerIds)) {
            throw new Exception("Customer already got the deal");
        }
        customerIds.add(customerId);
    }

    private Boolean alreadyExists(Long customerId, List<Long> customerIds) {
        return customerIds.contains(customerId);
    }
}
