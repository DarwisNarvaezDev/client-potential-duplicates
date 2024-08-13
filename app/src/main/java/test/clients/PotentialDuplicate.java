package test.clients;

/**
 * Yields the set of data of a matched pair of clients
 *
 */
public class PotentialDuplicate {
    String sourceId, matchId, accuracy;

    public PotentialDuplicate() {
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getMatchId() {
        return matchId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }

    public String getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(String accuracy) {
        this.accuracy = accuracy;
    }

    @Override
    public String toString() {
        return "PotentialDuplicate{" +
                "sourceId='" + sourceId + '\'' +
                ", matchId='" + matchId + '\'' +
                ", accuracy='" + accuracy + '\'' +
                '}';
    }
}
