package com.example.task.Controller;

import com.example.task.Api.ApiResponce;
import com.example.task.Model.Task;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/task")
public class TaskController {

    ArrayList<Task> tasks=new ArrayList<>();

    @GetMapping("/get")
    public ArrayList<Task> getTasks() {
        return tasks;
    }


    @PostMapping("/add")
    public ApiResponce addTask(@RequestBody Task task){
        tasks.add(task);
        return new ApiResponce ("task added");
    }

    @PutMapping("/update/{index}")
    public ApiResponce updateTask(@PathVariable int index,@RequestBody Task task){
        tasks.set(index,task);
        return new ApiResponce ("task updated");
    }

    @DeleteMapping("/delete/{index}")
    public ApiResponce deleteTask(@PathVariable int index){
        tasks.remove(index);
        return new ApiResponce ("task deleted");
    }


    @PutMapping("/change/{index}")
    public ApiResponce change(@PathVariable int index){
        if(tasks.get(index).getStatus().equalsIgnoreCase("not done")){
            tasks.get(index).setStatus("done");
            return new ApiResponce("task change");
        }
        return new ApiResponce("not change");
    }
    @GetMapping("/search/{title}")
      public ApiResponce search(@PathVariable String title){
        ArrayList<Task> searches = new ArrayList<>();
        for( Task task : tasks){
            if(task.getTitle().equalsIgnoreCase(title)){
                searches.add(task);
                return searches;
            }
        }return new ApiResponce (" not found");
          
        
      }

}
