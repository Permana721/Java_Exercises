package _01_Mahasiswa.model;

public enum Semester {
    SEMESTER1("Semester 1"),
    SEMESTER2("Semester 2"),
    SEMESTER3("Semester 3"),
    SEMESTER4("Semester 4"),
    SEMESTER5("Semester 5"),
    SEMESTER6("Semester 6"),
    SEMESTER7("Semester 7"),
    SEMESTER8("Semester 8");

    private String displayName;

    public String getDisplayName() {
        return displayName;
    }

    Semester(String displayName) {
        this.displayName = displayName;
    }
}
