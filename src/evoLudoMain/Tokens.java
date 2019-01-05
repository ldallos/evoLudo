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
        redTokens.put(1, 76);
        redTokens.put(2, 77);
        redTokens.put(3, 78);
        redTokens.put(4, 79);


        blueTokens.put(1, 80);
        blueTokens.put(2, 81);
        blueTokens.put(3, 82);
        blueTokens.put(4, 83);


        greenTokens.put(1, 84);
        greenTokens.put(2, 85);
        greenTokens.put(3, 86);
        greenTokens.put(4, 87);


        yellowTokens.put(1, 88);
        yellowTokens.put(2, 89);
        yellowTokens.put(3, 90);
        yellowTokens.put(4, 91);
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
