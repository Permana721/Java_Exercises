package permana.surya.dharma.repository;

import permana.surya.dharma.entity.Todolist;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class TodoListRepositoryImpl implements TodoListRepository {
    private final List<Todolist> todolistData;

    public TodoListRepositoryImpl() {
        this.todolistData = new ArrayList<>();
    }

    @Override
    public Todolist save(Todolist todolist) {
        todolistData.add(todolist);
        return todolist;
    }

    @Override
    public Todolist findById(Integer id) {
        for (Todolist todolist : todolistData) {
            if (todolist.getId().equals(id)) {
                return todolist;
            }
        }
        throw new InputMismatchException("Todolist dengan nomor " + id + " tidak ditemukan!");
    }

    @Override
    public Todolist delete(Integer id) {
        Todolist todolist = findById(id);
        todolistData.remove(todolist);
        System.out.println("Todolist " + todolist.getTodo() + " berhasil dihapus!");
        return todolist;
    }

    @Override
    public List<Todolist> findAll() {
        return todolistData;
    }
}