package _02_Todolist_JavaDasar;

public class Todolist {
    private int id = 0;
    private String judul;

    public Todolist(String judul) {
        this.id++;
        this.judul = judul;
    }

    public int getId() {
        return id;
    }

    public String getJudul() {
        return judul;
    }

}
