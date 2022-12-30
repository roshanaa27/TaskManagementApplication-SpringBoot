package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Maintask {
@Id 
@GeneratedValue(strategy=GenerationType.AUTO)

private int id;
private int taskId;
private String taskHolderName;
private String taskDate;
private String taskName;
private String taskStatus;

Maintask() {}

Maintask(int taskId,String taskHolderName, String taskDate, String taskName, String taskStatus)
{
	this.setTaskId(taskId);
	this.setTaskHolderName(taskHolderName);
	this.setTaskDate(taskDate);
	this.setTaskName(taskName);
	this.setTaskStatus(taskStatus);
}
public int getTaskId()
{
	return taskId;
}
public void setTaskId(int taskId)
{
	this.taskId=taskId;
}
public String getTaskHolderName()
{
	return taskHolderName;
}
public void setTaskHolderName(String taskHolderName)
{
	this.taskHolderName=taskHolderName;
}
public String getTaskDate()
{
	return taskDate;
}
public void setTaskDate(String taskDate)
{
	this.taskDate=taskDate;
}
public String getTaskName()
{
	return taskName;
}
public void setTaskName(String taskName)
{
	this.taskName=taskName;
}
public String getTaskStatus()
{
	return taskStatus;
}
public void setTaskStatus(String taskStatus)
{
	this.taskStatus=taskStatus;
}
}
