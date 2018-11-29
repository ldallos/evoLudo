package evoLudoMain;


import java.util.ArrayList;

public class Route {

    private ArrayList<Point> route = new ArrayList<>();
    private static Route instance = null;


    public Route() {

    }



    public static Route getInstance() {
        if (instance == null)
            return new Route();

        return instance;
    }


    /**
     * This method refreshes the coordinates of the route.
     * @param scaleUnitWidth Defines the width of routes which are layed down, and also the standing routes' height.
     * @param scaleUnitHeight Defines the height of routes which are layed down, and also the standing routes' width.
     * @param shiftWidth The value which the board has to be pushed from the side, to be exactly in the middle.
     * @param shiftHeight The value which the board has to be pushed from the top, to be exactly in the middle.
     */
    public void resetPointPositions(int scaleUnitWidth, int scaleUnitHeight, double shiftWidth, double shiftHeight) {

        /*
        Each coordinate define the left upper corner of the given square (field).
         */

        route.clear();

        //RED UP RIGHT
        for (int i = 0; i <= 6; i ++)
            route.add(new Point(shiftWidth + scaleUnitWidth / 6.0 * i, shiftHeight + scaleUnitHeight));

        //BLUE LEFT UP
        for (int i = 5; i >= 0; i--)
            route.add(new Point(shiftWidth + scaleUnitWidth, shiftHeight + scaleUnitHeight / 6.0 * i));

        //BLUE MIDDLE UP
        route.add(new Point(shiftWidth + scaleUnitWidth / 6.0 * 7, shiftHeight));

        //BLUE RIGHT DOWN
        for (int i = 0; i <= 6; i++)
            route.add(new Point(shiftWidth + scaleUnitWidth + scaleUnitWidth / 6.0 * 2, shiftHeight + scaleUnitHeight / 6.0 * i));


        //GREEN UP RIGHT
        for (int i = 0; i <= 5; i ++)
            route.add(new Point((shiftWidth + scaleUnitWidth + scaleUnitWidth / 2.0) + scaleUnitWidth / 6.0 * i, shiftHeight + scaleUnitHeight));

        //GREEN MIDDLE RIGHT
        route.add(new Point(shiftWidth + scaleUnitWidth + scaleUnitWidth / 2.0 + scaleUnitWidth /6.0 *5 , shiftHeight + scaleUnitHeight / 6.0 *7));


        //GREEN DOWN LEFT
        for (int i = 6; i >= 0; i--)
            route.add(new Point((shiftWidth + scaleUnitWidth + scaleUnitWidth / 6.0 * 2) + scaleUnitWidth / 6.0 * i, shiftHeight + scaleUnitHeight / 6.0 * 8));

        //YELLOW RIGHT DOWN
        for (int i = 0; i <= 5; i++)
            route.add(new Point(shiftWidth + scaleUnitWidth + scaleUnitWidth / 6.0 * 2, (shiftHeight + scaleUnitHeight + scaleUnitHeight / 2.0) + scaleUnitHeight / 6.0 * i));

        //YELLOW MIDDLE DOWN
        route.add(new Point(shiftWidth + scaleUnitWidth + scaleUnitWidth / 6.0, shiftHeight + scaleUnitHeight + scaleUnitHeight / 2.0 + scaleUnitHeight / 6.0 * 5));


        //YELLOW LEFT UP
        for (int i = 6; i >= 0; i--)
            route.add(new Point(shiftWidth + scaleUnitWidth, (scaleUnitHeight + shiftHeight + scaleUnitHeight / 6.0 * 2) + scaleUnitHeight / 6.0 * i));

        //RED DOWN LEFT
        for (int i = 5; i >= 0; i--)
            route.add(new Point(shiftWidth + scaleUnitWidth / 6.0 * i, shiftHeight + scaleUnitHeight + scaleUnitHeight / 6.0 * 2));

        //RED MIDDLE LEFT
        route.add(new Point(shiftWidth, scaleUnitHeight + shiftHeight + scaleUnitHeight / 6.0));


    }


    public ArrayList<Point> getRoute() {
        return route;
    }



}
