package permana.surya.dharma.entity;

public class Todolist {
    private String todo;
    private Integer id;
    private static int counter = 1;

    public Todolist(String todo) {
        this.todo = todo;
        setId(increaseID());
    }

    public static int increaseID() {
        return counter++;
    }

    public String getTodo() {
        return todo;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
