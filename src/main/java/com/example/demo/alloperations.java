package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class alloperations {
@Autowired repository ob;
@PostMapping("/addtask")
public String save(@RequestBody Maintask maintask1)
{
	Maintask w= new Maintask();
	int id=maintask1.getTaskId();
	String taskHolderName=maintask1.getTaskHolderName();
	String taskDate=maintask1.getTaskDate();
	String taskName=maintask1.getTaskName();
	String taskStatus=maintask1.getTaskStatus();
	
	w.setTaskId(id);
	w.setTaskHolderName(taskHolderName);
	w.setTaskDate(taskDate);
	w.setTaskName(taskName);
	w.setTaskStatus(taskStatus);
	
	Maintask first = new Maintask(id,taskHolderName,taskDate,taskName,taskStatus);
	ob.save(first);
	return "Task added successfully";
}

@GetMapping("/Maintask")
public List<Maintask> getAllMaintask()
{
	return ob.findAll();
}

@GetMapping("Maintask/{id}")
public List<Maintask> getTaskById(@PathVariable("id") int id)
{
	return ob.findById(id);
}

@GetMapping("Maintask/name/{taskHolderName}")
public List<Maintask> getTaskByName(@PathVariable("taskHolderName") String taskHolderName)
{
	return ob.findByName(taskHolderName);
}

@PutMapping("/updatetask/{id}")
public String update(@RequestBody Maintask x,@PathVariable("id") int id)
{
	int taskId1=x.getTaskId();
	String taskHolderName=x.getTaskHolderName();
	String taskDate=x.getTaskDate();
	String taskName=x.getTaskName();
	String taskStatus=x.getTaskStatus();
	ob.update(taskId1,taskHolderName,taskDate,taskName,taskStatus,id);
	return "Tasks successfully updated";
}

@DeleteMapping("deletetask/{id}")
public String deleteById(@PathVariable("id") int id)
{
	ob.deleteAllByIdInBatch(id);
	return "Items deleted successfully";
}
}
