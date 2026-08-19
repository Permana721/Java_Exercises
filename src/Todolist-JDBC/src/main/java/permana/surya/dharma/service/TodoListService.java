package permana.surya.dharma.service;

import permana.surya.dharma.entity.Todolist;

import java.util.List;

public interface TodoListService {
    Todolist addTodoList(Todolist todo);
    Todolist removeTodoList(Integer id);
    List<Todolist> findAll();
}
