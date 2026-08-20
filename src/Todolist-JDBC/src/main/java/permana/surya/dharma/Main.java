package permana.surya.dharma;

import permana.surya.dharma.repository.TodoListRepository;
import permana.surya.dharma.repository.TodoListRepositoryImpl;
import permana.surya.dharma.service.TodoListService;
import permana.surya.dharma.service.TodoListServiceImpl;
import permana.surya.dharma.util.DatabaseUtil;
import permana.surya.dharma.view.TodoListView;

import javax.sql.DataSource;

public class Main {
    static void main(String[] args) {
        DataSource dataSource = DatabaseUtil.getDataSource();
        TodoListRepository todoListRepository = new TodoListRepositoryImpl(dataSource);
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);
        TodoListView todoListView = new TodoListView(todoListService);

        todoListView.showTodoList();
    }
}
