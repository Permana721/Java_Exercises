package _03_Todolist_JavaOOP.view;

import _03_Todolist_JavaOOP.service.TodoListService;
import _03_Todolist_JavaOOP.util.InputUtil;

public class TodoListView {
    private TodoListService todoListService;

    public TodoListView(TodoListService todoListService) {
        this.todoListService = todoListService;
    }

    public void showTodoList(){
        while (true) {
            todoListService.showTodoList();

            System.out.println("MENU: ");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("0. Keluar");

            var input = InputUtil.input("pilih");

            if (input.equals("1")){
                addTodoList();
            } else if (input.equals("2")) {
                removeTodoList();
            } else if (input.equals("0")) {
                break;
            } else {
                System.out.println("Input tidak valid!");
            }
        }
    }

    public void addTodoList(){
        System.out.println("MENAMBAH TODOLIST");

        var todo = InputUtil.input("Todo (0 jika batal): ");

        if (todo.equals("0")){

        } else {
            todoListService.addTodoList(todo);
        }
    }

    public void removeTodoList(){
        System.out.println("MENGHAPUS TODOLIST");

        var number = InputUtil.input("Nomor yang dihapus (0 jika batal)");

        if (number.equals("0")){

        } else {
            todoListService.removeTodoList(Integer.valueOf(number));
        }
    }
}
