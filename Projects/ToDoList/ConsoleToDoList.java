package ToDoList;

import java.util.*;
import java.util.Scanner;



public class ConsoleToDoList {

    private static final Scanner input = new Scanner(System.in);
    private static List<ToDoList.Task> tasks=new ArrayList<>();

    public static void main(String[] args) {
        startApp();
    }
    private static void startApp(){
        System.out.println("Welcome to your to do planner!!!");
        boolean isExit = false;
        do {
            if(tasks.isEmpty()){
                System.out.println("There is no any tasks in the toDoList!!! add a task");
                ToDoList.Task newTask = addTask();
                if (newTask!= null) tasks.add(newTask);
            } else {
                tasks.forEach(System.out::println);
                String action = selectTaskName();
                if(action.equalsIgnoreCase("Add")){
                    tasks.add(addTask());
                } else if (action.equalsIgnoreCase("Done")) {
                    markTaskCompleted();
                } else if (action.equalsIgnoreCase("Delete")) {
                    removeTask();
                } else if (action.equalsIgnoreCase("Exit")) {
                    isExit = true;
                }
            }
        } while (!isExit);
    }
    private static ToDoList.Task addTask(){
        System.out.println("Add your tasks");
        System.out.println("Enter your task number: ");
        int id = input.nextInt();
        if(tasks.stream().anyMatch(task -> task.id==id)){
            System.out.println("Task already exists. please try again");
            return null;
        }
        System.out.println("Enter your task name: ");
        String name = input.next();
        if(name.isEmpty()){
            System.out.println("task name cannot be empty");
            return null;
        }
        return new ToDoList.Task(name,id);
    }
    private static void markTaskCompleted(){
        System.out.println("Enter the ID of the task to mark Completed: ");
        int id = input.nextInt();
        Optional<ToDoList.Task> getTask = tasks.stream()
                .filter(task -> task.id == id)
                .findFirst();
        if(getTask.isPresent()){
            getTask.get().setCompleted(true);
            System.out.println("✅ Task marked as completed!");
        } else{
            System.out.println("⚠\uFE0F Task not found.");
        }
    }
    private static void removeTask(){
        System.out.println("Enter the ID of the task to delete: ");
        int id = input.nextInt();
        if(tasks.removeIf(task -> task.id==id)){
            System.out.println("\uD83D\uDDD1\uFE0F Task deleted!");
        } else {
            System.out.println("⚠️ Task not found.");
        }
    }
    private static String selectTaskName(){
        System.out.println("Please enter the name of the task (Add/Done/Delete/Exit) : ");
        return input.next();
    }
}
