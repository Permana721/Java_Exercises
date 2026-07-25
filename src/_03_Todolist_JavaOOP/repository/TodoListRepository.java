package _03_Todolist_JavaOOP.repository;

import _03_Todolist_JavaOOP.entity.Todolist;

public interface TodoListRepository {
    Todolist[] getAll();
    void add(Todolist todolist);
    boolean remove(Integer number);
}
