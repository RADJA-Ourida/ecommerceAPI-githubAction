package com.example.ecommerce2.exception;

public class ProductNotFound extends RuntimeException{
    public ProductNotFound(String msg){
        super(msg);
    }
}