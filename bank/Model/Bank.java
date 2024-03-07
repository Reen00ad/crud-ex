package com.example.bank.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Bank {

    private String id,username;
    private int balance;
}
