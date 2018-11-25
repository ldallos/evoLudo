package evoLudoMain;

import java.util.HashMap;
import java.util.Map;

public class Tokens {

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
    private static Tokens instance = null;

    public static Tokens getInstance() {
        if (instance == null)
            return new Tokens();
        return instance;
    }

    public Tokens() {
        redTokens.put(1, null);
        redTokens.put(2, null);
        redTokens.put(3, null);
        redTokens.put(4, null);


        blueTokens.put(1, null);
        blueTokens.put(2, null);
        blueTokens.put(3, null);
        blueTokens.put(4, null);


        yellowTokens.put(1, null);
        yellowTokens.put(2, null);
        yellowTokens.put(3, null);
        yellowTokens.put(4, null);


        greenTokens.put(1, null);
        greenTokens.put(2, null);
        greenTokens.put(3, null);
        greenTokens.put(4, null);
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


}
