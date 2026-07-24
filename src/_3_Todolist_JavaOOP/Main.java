package _3_Todolist_JavaOOP;

import _3_Todolist_JavaOOP.repository.TodoListRepository;
import _3_Todolist_JavaOOP.repository.TodoListRepositoryImpl;
import _3_Todolist_JavaOOP.service.TodoListService;
import _3_Todolist_JavaOOP.service.TodoListServiceImpl;
import _3_Todolist_JavaOOP.view.TodoListView;

public class Main {
    static void main(String[] args) {
        TodoListRepository todoListRepository = new TodoListRepositoryImpl();
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);
        TodoListView todoListView = new TodoListView(todoListService);

        todoListView.showTodoList();
    }
}
