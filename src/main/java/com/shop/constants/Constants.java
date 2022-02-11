package com.shop.constants;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

public class Constants {

    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public enum CREDENTIAL {
        VALID("gurunathan5029@gmail.com", "Iceman1!", "Hello Gurunathan"),
        INVALID_EMAIL("gurunathan500029@gmail.com", "Iceman1!", "We couldn't find an account created with gurunathan23456@gmail.com"),
        INVALID_PASSWORD("gurunathan5029@gmail.com", "Iceman", "Password is incorrect. Please try again (20014)"),
        BLANK("", "", "");
        @Getter
        private String email;
        @Getter
        private String password;
        @Getter
        private String message;
    }

    //Can be moved to page object class and maintained there
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public enum FILTER_TYPE {
        BRANDS("div.brand-filter label"), PRICE_MIN("//div[contains(@class,'price-filter')]//input[@placeholder='$ min']"), PRICE_MAX("//div[contains(@class,'price-filter')]//input[@placeholder='$ max']"), AVAILABILITY("input.in-stock-filter"), CASHBACK_STORE("div.store-filter label");
        @Getter
        private String path;
    }
    //Can be moved to page object class and maintained there
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public enum SORT_TYPE {
        MOST_RELEVANT("Most Relevant"), PRICE_HIGH_TO_LOW("Price High to Low"), PRICE_LOW_TO_HIGH("Price Low to High"), HIGHEST_CASHBACK("Highest Cashback");
        @Getter
        private String text;
    }

    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public enum OPERATION_TYPE {
        FILTER,
        SORT
    }


}
