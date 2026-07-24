package _3_Todolist_JavaOOP.test.view;

import _3_Todolist_JavaOOP.repository.TodoListRepository;
import _3_Todolist_JavaOOP.repository.TodoListRepositoryImpl;
import _3_Todolist_JavaOOP.service.TodoListService;
import _3_Todolist_JavaOOP.service.TodoListServiceImpl;
import _3_Todolist_JavaOOP.view.TodoListView;

public class TodoListViewTest {
    static void main(String[] args) {
        testAddTodoList();
    }

    public static void testShowTodoList(){
        TodoListRepository todoListRepository = new TodoListRepositoryImpl();
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);
        TodoListView todoListView = new TodoListView(todoListService);

        todoListService.addTodoList("Belajar Java Dasar");
        todoListService.addTodoList("Belajar Java OOP");
        todoListService.addTodoList("Belajar Java Collection");

        todoListView.showTodoList();
    }

    public static void testAddTodoList(){
        TodoListRepository todoListRepository = new TodoListRepositoryImpl();
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);
        TodoListView todoListView = new TodoListView(todoListService);

        todoListView.addTodoList();
    }
}
