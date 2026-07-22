package _01_Mahasiswa.model;

public enum IsPaid {
    PAID("Paid"),
    PARTIAL("Partial"),
    UNPAID("Unpaid"); // bayar wok

    private String displayName;

    IsPaid(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
