package com.pb.achilespcl.bddstore.web.rest.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProductRequest {

    private String name;
    private String description;
    private double price;
}
