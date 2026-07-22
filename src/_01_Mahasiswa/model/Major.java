package _01_Mahasiswa.model;

public enum Major {
    INFORMATIKA("Informatika"), // IF coyy
    MANAJEMEN("Manajemen"),
    PSIKOLOGI("Psikologi");

    private String displayName;

    Major(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}