package permana.surya.dharma;

import permana.surya.dharma.repository.TodoListRepository;
import permana.surya.dharma.repository.TodoListRepositoryImpl;
import permana.surya.dharma.service.TodoListService;
import permana.surya.dharma.service.TodoListServiceImpl;
import permana.surya.dharma.view.TodoListView;

public class Main {
    static void main(String[] args) {
        TodoListRepository todoListRepository = new TodoListRepositoryImpl();
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);
        TodoListView todoListView = new TodoListView(todoListService);

        todoListView.showTodoList();
    }
}
