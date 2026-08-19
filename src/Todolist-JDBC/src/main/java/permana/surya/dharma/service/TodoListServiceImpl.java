package permana.surya.dharma.service;

import permana.surya.dharma.entity.Todolist;
import permana.surya.dharma.repository.TodoListRepository;

import java.util.List;
import java.util.Objects;

public class TodoListServiceImpl implements TodoListService {
    private TodoListRepository todoListRepository;

    public TodoListServiceImpl(TodoListRepository todoListRepository) {
        this.todoListRepository = todoListRepository;
    }

    @Override
    public Todolist addTodoList(Todolist todo) {
        return todoListRepository.save(todo);
    }

    @Override
    public Todolist removeTodoList(Integer id) {
        if (Objects.isNull(id)) {
            throw new NullPointerException("Todolist " + id + " not found!");
        } else {
            return todoListRepository.delete(id);
        }
    }

    @Override
    public List<Todolist> findAll() {
        return todoListRepository.findAll();
    }
}
