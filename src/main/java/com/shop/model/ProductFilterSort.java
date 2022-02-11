package com.shop.model;

import com.shop.constants.Constants;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductFilterSort {
    private Constants.FILTER_TYPE filterType;
    private String value;
    private Constants.SORT_TYPE sortType;
}
