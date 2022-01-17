public class NearestStationFinder {
    int userX;
    int userY;

    public NearestStationFinder() {

    }
    static double findClosestStation(int userX, int userY){
        double distanceToStation;
        int xComponent;
        int yComponent;
        double productOfXY;
        double closestStation = 10000000;
        Stations stations = new Stations();

        //tylko do testu
        stations.stationY.add(10);
        stations.stationX.add(3);
        stations.stationY.add(4);
        stations.stationX.add(7);

        for (int i = 0;i < stations.stationX.size();i++) {
            //basic pitagorasy
            xComponent = stations.getStationX(i) - userX;
            yComponent = stations.getStationY(i) - userY;
            productOfXY = xComponent * xComponent + yComponent * yComponent;
            distanceToStation = java.lang.Math.sqrt(productOfXY);
            //sprawdzanie najmniejszej odległosci
            if (distanceToStation < closestStation) {
                closestStation = distanceToStation;
            }
        }
        return closestStation;
    }

}
