package com.example.pricingservice.domin.price;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface PriceRepository extends JpaRepository<Price,Long> {

}
