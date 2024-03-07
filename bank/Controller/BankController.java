package com.example.bank.Controller;

import com.example.bank.Api.ApiResponce;
import com.example.bank.Model.Bank;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/bank")
public class BankController {

    ArrayList<Bank> banks=new ArrayList<>();

    @GetMapping("/get")
    public ArrayList<Bank> getBanks (){
        return banks;
    }

    @PostMapping("/add")
    public ApiResponce addBank(@RequestBody Bank bank){
        banks.add(bank);
         return new ApiResponce("account added");
    }

    @PutMapping("/update/{index}")
    public ApiResponce updateBank(@PathVariable int index,@RequestBody Bank bank){
        banks.set(index,bank);
        return new ApiResponce ("account updated");
    }
    @DeleteMapping("/delete/{index}")
    public ApiResponce deleteBank(@PathVariable int index){
        banks.remove(index);
        return new ApiResponce ("account deleted");
    }

    @PostMapping("/deposite/{amount}")
    public ApiResponce deposite(@PathVariable int amount){
        ArrayList<Bank> deposites =new ArrayList<>();
        for(Bank bank:banks){
            bank.setBalance(bank.getBalance() + amount);
            deposites.add(bank);
                }
         return new ApiResponce("deposite done");

        }
     @PostMapping("/withdraw/{amount}")
    public  ApiResponce withdraw(@PathVariable int amount){
       ArrayList<Bank> withdraws=new ArrayList<>();
       for(Bank bank:banks){
           if(bank.getBalance() >= amount){
               bank.setBalance(bank.getBalance() - amount);
               withdraws.add(bank);

           }else if (bank.getBalance() < amount){
            return new ApiResponce ("invalid operation");
           }
       }
       return new ApiResponce("withdraw done");
    }
    }



