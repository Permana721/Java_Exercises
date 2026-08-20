package permana.surya.dharma.view;

import permana.surya.dharma.entity.Todolist;
import permana.surya.dharma.service.TodoListService;
import permana.surya.dharma.util.InputUtil;

import java.util.List;

public class TodoListView {
    private TodoListService todoListService;

    public TodoListView(TodoListService todoListService) {
        this.todoListService = todoListService;
    }

    public void showTodoList(){
        while (true) {
            todoListService.findAll();

            System.out.println("MENU: ");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("0. Keluar");

            var input = InputUtil.input("Pilih: ");

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

        var todo = InputUtil.input("Todo: ");

        if (todo.equals("0")) {
            return;
        } else {
            Todolist todolist = new Todolist(todo);
            todoListService.addTodoList(todolist);
        }
    }

    public void removeTodoList(){
        System.out.println("MENGHAPUS TODOLIST");

        var number = InputUtil.input("Nomor yang dihapus: ");

        if (number.equals("0")) {
            return;
        } else {
            todoListService.removeTodoList(Integer.valueOf(number));
        }
    }
}
