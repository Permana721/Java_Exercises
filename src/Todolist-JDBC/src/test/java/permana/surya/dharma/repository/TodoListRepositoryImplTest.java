package permana.surya.dharma.repository;

import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import permana.surya.dharma.entity.Todolist;
import permana.surya.dharma.util.DatabaseUtil;

import java.util.List;

public class TodoListRepositoryImplTest {
    private HikariDataSource dataSource;
    private TodoListRepository todoListRepository;

    @BeforeEach
    void setUp() {
        dataSource = DatabaseUtil.getDataSource();
        todoListRepository = new TodoListRepositoryImpl(dataSource);
    }

    @Test
    void testAdd() {
        todoListRepository.save(new Todolist("Cihuy"));
        todoListRepository.save(new Todolist("Prikitiw"));
        todoListRepository.save(new Todolist("Seleketep"));
        todoListRepository.save(new Todolist("Satu dua"));
    }

    @Test
    void testRemove() {
        System.out.println(todoListRepository.delete(1));
        System.out.println(todoListRepository.delete(2));
        System.out.println(todoListRepository.delete(3));
    }

    @Test
    void testFindAll() {
        List<Todolist> todolists = todoListRepository.findAll();
        for (Todolist todolist : todolists) {
            System.out.println(todolist.getId() + ". " + todolist.getTodo());
        }
    }

    @AfterEach
    void tearDown() {
        dataSource.close();
    }
}
