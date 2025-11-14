package ToDoList;

public class Task{
    String name;
    int id;

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    boolean isCompleted;

    Task(String name, int id){
        this.name=name;
        this.id=id;
    }

    @Override
    public String toString() {
        return id + " : " + name + " - " + (isCompleted ? "✅ Completed" : "❌ Not completed");
    }
}
