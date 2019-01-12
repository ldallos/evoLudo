package evoLudoMain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Tokens {

    public static final int RED1TOKENSTARTING = 76;
    public static final int RED2TOKENSTARTING = 77;
    public static final int RED3TOKENSTARTING = 78;
    public static final int RED4TOKENSTARTING = 79;
    public static final int BLUE1TOKENSTARTING = 80;
    public static final int BLUE2TOKENSTARTING = 81;
    public static final int BLUE3TOKENSTARTING = 82;
    public static final int BLUE4TOKENSTARTING = 83;
    public static final int GREEN1TOKENSTARTING = 84;
    public static final int GREEN2TOKENSTARTING = 85;
    public static final int GREEN3TOKENSTARTING = 86;
    public static final int GREEN4TOKENSTARTING = 87;
    public static final int YELLOW1TOKENSTARTING = 88;
    public static final int YELLOW2TOKENSTARTING = 89;
    public static final int YELLOW3TOKENSTARTING = 90;
    public static final int YELLOW4TOKENSTARTING = 91;

    /**
     *  redTokens represents the token with its position
     */
    /*
     The key is which token, the value is the which element of the list its stands.
     For example redToken with Map<1, 10> means, the first token of red is standing at the 10th field in the board.
      */
    private Map<Integer, Integer> redTokens = new HashMap<>();
    private Map<Integer, Integer> blueTokens = new HashMap<>();
    private Map<Integer, Integer> yellowTokens = new HashMap<>();
    private Map<Integer, Integer> greenTokens = new HashMap<>();
    private ArrayList<Boolean> hadReachTheEnd = new ArrayList<>();
    private static Tokens instance = null;

    public static Tokens getInstance() {
        if (instance == null)
            return new Tokens();
        return instance;
    }

    public Tokens() {

        for (int i = 0; i < 16; i++)
            hadReachTheEnd.add(false);

        redTokens.put(1, RED1TOKENSTARTING);
        redTokens.put(2, RED2TOKENSTARTING);
        redTokens.put(3, RED3TOKENSTARTING);
        redTokens.put(4, RED4TOKENSTARTING);
        redTokens.put(0, 0);


        blueTokens.put(1, BLUE1TOKENSTARTING);
        blueTokens.put(2, BLUE2TOKENSTARTING);
        blueTokens.put(3, BLUE3TOKENSTARTING);
        blueTokens.put(4, BLUE4TOKENSTARTING);
        blueTokens.put(0, 0);

        greenTokens.put(1, GREEN1TOKENSTARTING);
        greenTokens.put(2, GREEN2TOKENSTARTING);
        greenTokens.put(3, GREEN3TOKENSTARTING);
        greenTokens.put(4, GREEN4TOKENSTARTING);
        greenTokens.put(0, 0);

        yellowTokens.put(1, YELLOW1TOKENSTARTING);
        yellowTokens.put(2, YELLOW2TOKENSTARTING);
        yellowTokens.put(3, YELLOW3TOKENSTARTING);
        yellowTokens.put(4, YELLOW4TOKENSTARTING);
        yellowTokens.put(0, 0);
    }

    public Map<Integer, Integer> getRedTokens() {
        return redTokens;
    }

    public Map<Integer, Integer> getBlueTokens() {
        return blueTokens;
    }

    public Map<Integer, Integer> getYellowTokens() {
        return yellowTokens;
    }

    public Map<Integer, Integer> getGreenTokens() {
        return greenTokens;
    }

    public ArrayList<Boolean> getHadReachTheEnd() { return this.hadReachTheEnd;}

}
