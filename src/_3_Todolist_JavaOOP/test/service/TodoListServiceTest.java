package _3_Todolist_JavaOOP.test.service;

import _3_Todolist_JavaOOP.entity.Todolist;
import _3_Todolist_JavaOOP.repository.TodoListRepository;
import _3_Todolist_JavaOOP.repository.TodoListRepositoryImpl;
import _3_Todolist_JavaOOP.service.TodoListService;
import _3_Todolist_JavaOOP.service.TodoListServiceImpl;

public class TodoListServiceTest {
    static void main(String[] args) {
        testAddTodoList();
    }

    public static void testShowTodoList(){
        TodoListRepositoryImpl todoListRepository = new TodoListRepositoryImpl();
        todoListRepository.data[0] = new Todolist("Belajar Java Dasar");
        todoListRepository.data[1] = new Todolist("Belajar Java OOP");
        todoListRepository.data[2] = new Todolist("Belajar Java Collection");

        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);

        todoListService.showTodoList();
    }

    public static void testAddTodoList() {
        TodoListRepository todoListRepository = new TodoListRepositoryImpl();
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);

        todoListService.addTodoList("Belajar Java Dasar");
        todoListService.addTodoList("Belajar Java OOP");
        todoListService.addTodoList("Belajar Java Collection");

        todoListService.showTodoList();
    }
}
