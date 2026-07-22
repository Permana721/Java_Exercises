package _01_Mahasiswa.model;

public enum StudentStatus {
    ACTIVE("Active"),
    LEAVE("Leave"),
    GRADUATED("Graduate"),
    DROPOUT("Drop out");

    private String displayName;

    StudentStatus(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
