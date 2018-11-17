package evoLudoMain;

public class Route {

    private String[] Route =  new String[56];

    private void routeValue()
    {
        //array position where the figures will be set up
        Route[0] = "redStart";
        Route[14] = "blueStart";
        Route[28] = "greenStart";
        Route[42] = "yellowStart";
        //values four the four different routes
        for(int i = 1; i  < 14 ; i++)
        {
            Route[i] = "redRoute" + i;
        }
        for(int i = 15; i  < 28 ; i++)
        {
            Route[i] = "blueRoute" + i;
        }
        for(int i = 29; i  < 42 ; i++)
        {
            Route[i] = "greenRoute" + i;
        }
        for(int i = 43; i  < 56 ; i++)
        {
            Route[i] = "yellowRoute" + i;
        }
        for(int i = 0; i  < 56 ; i++)
        {
            System.out.print(Route[i] + "\n");

        }
    }
    //I created an executable main method to test the code
    public static void main(String[] args) {
        new Route().routeValue();
    }
}
