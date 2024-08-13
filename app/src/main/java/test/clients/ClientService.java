package test.clients;

import java.util.ArrayList;
import java.util.List;

/**
 * Yields the client potential duplicates rationale
 *
 */
public class ClientService {

    int nameThreshold, lastNameThreshold, addressThreshold;

    public ClientService(int nameThreshold, int lastNameThreshold, int addressThreshold) {
        this.nameThreshold = nameThreshold;
        this.lastNameThreshold = lastNameThreshold;
        this.addressThreshold = addressThreshold;
    }

    public ClientService() {
    }

    /**
     * Searches for potential duplicates, outputs a list of matches
     *
     * @param clients
     * @return
     */
    List<PotentialDuplicate> searchPotentialDuplicates(List<ClientInfo> clients) {
        if( clients.size() <= 1 ){
            throw new ClientServiceException("Not enough clients to check");
        }
        // A set to double-check for duplicates
        List<PotentialDuplicate> matches = new ArrayList<>();
        final int its = clients.size();
        for (int i = 0; i < its; i++) {
            for (int j = i + 1; j < its; j++) {
                int score = calcScore(clients.get(i), clients.get(j));
                if (score > 0) {
                    PotentialDuplicate match = new PotentialDuplicate();
                    match.setSourceId(clients.get(i).getId());
                    match.setMatchId(clients.get(j).getId());
                    match.setAccuracy(translateScoreToAccuracy(score));
                    matches.add(match);
                }
            }
        }
        return matches;
    }

    /**
     * Translates to a string score between 'Low', 'Medium' and 'High'
     *
     * @param score
     * @return
     */
    static String translateScoreToAccuracy(int score) {
        switch (score) {
            case 1:
                return Scores.LOW.get();
            case 2:
                return Scores.MEDIUM.get();
            case 3:
                return Scores.HIGH.get();
        }
        return "None";
    }

    /**
     * Calculates the likeness score from two client infos
     * Criteria explanation:
     * 1) if clients has the same email address the score will be increased
     * 2) if clients coincide in the name or last name with at least one word, the
     * score will be increased
     * 3) if two or more words in the address are written in the same way, the score
     * will be increased.
     * <p>
     * note: we'll not estimate the zip code, since could output a false positive
     */
    int calcScore(ClientInfo source, ClientInfo test) {
        int score = 0;
        if (source.getEmail().equals(test.getEmail())) {
            score++;
        }
        if (compareFullNamesStrict(source, test)) {
            score++;
        }
        if (compareAddressesStrict(source, test)) {
            score++;
        }
        return score;
    }

    /**
     * Compares names and last names regardless of the order in which each composing string
     * is aligned.
     */
    boolean compareFullNamesStrict(ClientInfo source, ClientInfo test) {
        return compareFirstNameStrict(source, test) && compareLastNameStrict(source, test);
    }

    /**
     * Compares all the words of the source and test names to find at least <threshold> words
     *
     * @param source
     * @param test
     * @return
     */
    boolean compareLastNameStrict(ClientInfo source, ClientInfo test) {
        if (source.getLastName().isEmpty()) {
            return false;
        } else if (test.getLastName().isEmpty()) {
            return false;
        }
        String[] decompSourceLastName = source.getLastName().split(" ");
        String[] decompTestLastName = test.getLastName().split(" ");
        int iterationResult = iterateForMatches(
                decompSourceLastName,
                decompTestLastName,
                this.lastNameThreshold
        );
        return iterationResult >= this.lastNameThreshold;
    }

    /**
     * Compares all the words of the source and test last name to find at least <threshold> words
     *
     * @param source
     * @param test
     * @return
     */
    boolean compareFirstNameStrict(ClientInfo source, ClientInfo test) {
        if (source.getFirstName().isEmpty()) {
            return false;
        } else if (test.getFirstName().isEmpty()) {
            return false;
        }
        String[] decompSourceName = source.getFirstName().split(" ");
        String[] decompTestName = test.getFirstName().split(" ");
        int iterationResult = iterateForMatches(
                decompSourceName,
                decompTestName,
                this.nameThreshold
        );
        return iterationResult >= this.nameThreshold;
    }

    /**
     * Extract arrays from the addresses and compare each position to see if any word matches.
     * <p>
     * similarity threshold: 2 words
     *
     * @param source
     * @param test
     * @return
     */
    boolean compareAddressesStrict(ClientInfo source, ClientInfo test) {
        if (source.getAddress().isEmpty()) {
            return false;
        } else if (test.getAddress().isEmpty()) {
            return false;
        }
        String[] decompSourceAddress = source.getAddress().split(" ");
        String[] decompTestAddress = test.getAddress().split(" ");
        int iterationThreshold = iterateForMatches(
                decompSourceAddress,
                decompTestAddress,
                this.addressThreshold
        );
        return iterationThreshold >= this.addressThreshold;
    }

    /**
     * Iterates all the words between two arrays and evaluates if the source
     * array contains at least <threshold> words in the test array
     *
     * @param source
     * @param test
     * @return
     */
    static int iterateForMatches(String[] source, String[] test, final int threshold) {
        int iterationThreshold = 0;
        for (String s : source) {
            for (String string : test) {
                if (s.equalsIgnoreCase(string)) {
                    if (iterationThreshold <= threshold) {
                        if (iterationThreshold == threshold) {
                            break;
                        }
                        iterationThreshold++;
                    }
                }
            }
        }
        return iterationThreshold;
    }
}
