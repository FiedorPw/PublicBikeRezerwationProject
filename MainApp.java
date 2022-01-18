import java.util.ArrayList;

public class MainApp {

    private ArrayList<Station> stations = new ArrayList<>();
    private ArrayList<User> customers = new ArrayList<>();
    MainApp(String path1, String path2)
    {
        CSVReaderStation stationReader = new CSVReaderStation(path1, ";");
        CSVReaderUser userReader = new CSVReaderUser(path2, ";");

        stations = stationReader.read();
        customers = userReader.read();
    }


    double findClosestDestinance(int userX, int userY){
        double distanceToStation;
        int xComponent;
        int yComponent;
        double productOfXY;
        double closestStation = 102400;


        for (int i = 0;i < stations.size(); i++) {
            //basic pitagorasy
            xComponent = stations.get(i).getStationX() - userX;
            yComponent = stations.get(i).getStationY() - userY;
            productOfXY = xComponent * xComponent + yComponent * yComponent;
            distanceToStation = java.lang.Math.sqrt(productOfXY);
            //sprawdzanie najmniejszej odległosci
            if (distanceToStation < closestStation) {
                closestStation = distanceToStation;
            }
        }
        return closestStation;
    }

    Station findClosestStation(int userX, int userY){
        double distanceToStation;
        int xComponent;
        int yComponent;
        double productOfXY;
        Station searchedStation = null;
        double closestStation = 10000000;


        for (int i = 0;i < stations.size(); i++) {
            //basic pitagorasy
            xComponent = stations.get(i).getStationX() - userX;
            yComponent = stations.get(i).getStationY() - userY;
            productOfXY = xComponent * xComponent + yComponent * yComponent;
            distanceToStation = java.lang.Math.sqrt(productOfXY);
            //sprawdzanie najmniejszej odległosci
            if (distanceToStation < closestStation) {
                closestStation = distanceToStation;
                searchedStation=stations.get(i);
            }
        }
        System.out.println(searchedStation.getStationName());
        return searchedStation;
    }

    Station findClosestStation(User customer){
        int userX = customer.getCoordinateX();
        int userY = customer.getCoordinateY();
        double distanceToStation;
        int xComponent;
        int yComponent;
        double productOfXY;
        Station searchedStation = null;
        double closestStation = 19600;


        for (int i = 0;i < stations.size(); i++) {
            //basic pitagorasy
            xComponent = stations.get(i).getStationX() - userX;
            yComponent = stations.get(i).getStationY() - userY;
            productOfXY = xComponent * xComponent + yComponent * yComponent;
            distanceToStation = java.lang.Math.sqrt(productOfXY);
            //sprawdzanie najmniejszej odległosci
            if (distanceToStation < closestStation) {
                closestStation = distanceToStation;
                searchedStation=stations.get(i);
            }
        }
        System.out.println(searchedStation.getStationName());
        return searchedStation;
    }

    void usersClosestStations()
    {
        for(int i=0; i< customers.size(); i++)
        {
            findClosestStation(customers.get(i));
        }
    }

    public void rent(int userId){
    for(int i=0; i<customers.size(); i++){
        if(customers.get(i).getIndex()==userId){
            Station closestStation=findClosestStation(customers.get(1));
            customers.get(i).setStationId(closestStation.getIndex());
            closestStation.rentBike();
            }
        }
    }

    public void rent(User user){

        Station closestStation=findClosestStation(user);
        user.setStationId(closestStation.getIndex());
        closestStation.rentBike();

    }

}
