package test.clients;

public enum Scores {
    HIGH("High"),
    MEDIUM("Medium"),
    LOW("Low");

    final String score;

    Scores(String score) {
        this.score = score;
    }

    public String get() {
        return score;
    }
}
