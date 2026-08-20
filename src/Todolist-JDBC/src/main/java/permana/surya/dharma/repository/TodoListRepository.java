package permana.surya.dharma.repository;

import permana.surya.dharma.entity.Todolist;

import java.util.List;

public interface TodoListRepository {
    Todolist save(Todolist todolist);
    Todolist findById(Integer id);
    boolean delete(Integer id);
    List<Todolist> findAll();
}
