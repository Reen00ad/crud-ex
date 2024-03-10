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

    @PostMapping("/deposite/{index}/{amount}")
    public ApiResponce deposite(@PathVariable int index,@PathVariable int amount){
       int deposite=banks.get(index).getBalance()+amount;
       banks.get(index).setBalance(deposite);
         return new ApiResponce("deposite done");

        }
     @PostMapping("/withdraw/{index}/{amount}")
    public  ApiResponce withdraw(@PathVariable int index,@PathVariable int amount){
       if(banks.get(index).getBalance()<amount){
            return new ApiResponce ("invalid operation");
           }
         int withdraw=banks.get(index).getBalance()-amount;
         banks.get(index).setBalance(withdraw);
       return new ApiResponce("withdraw done");
    }
    }



