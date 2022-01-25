import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.Date;

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

     // DZIAŁAJĄCY NIEUZYWANY KOD
    /*
    double findClosestDestinance(int userX, int userY){
        double distanceToStation;
        int xComponent;
        int yComponent;
        double productOfXY;
        double distanceToClosestStation = 10000000;


        for (int i = 0;i < stations.size(); i++) {
            //basic pitagorasy
            xComponent = stations.get(i).getStationX() - userX;
            yComponent = stations.get(i).getStationY() - userY;
            productOfXY = xComponent * xComponent + yComponent * yComponent;
            distanceToStation = java.lang.Math.sqrt(productOfXY);
            //sprawdzanie najmniejszej odległosci
            if (distanceToStation < distanceToClosestStation) {
                distanceToClosestStation = distanceToStation;
            }
        }
        return distanceToClosestStation;
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
    */
    Station findClosestStation(User customer){

        int userX = customer.getCoordinateX();
        int userY = customer.getCoordinateY();
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
            if (distanceToStation < closestStation && stations.get(i).getCurrentAmountOfBikes() != 0 ) {
                closestStation = distanceToStation;
                searchedStation=stations.get(i);
            }


        }
        //rowerki minus 1
        searchedStation.setCurrentAmountOfBikes(searchedStation.getCurrentAmountOfBikes()-1);
        System.out.println(searchedStation.getStationName() + " bikes left: "+ searchedStation.getCurrentAmountOfBikes());

        return searchedStation;

    }

    void rentBike(User customer,int index){
        customer.setIndex(index);


    }

    void usersClosestStations()
    {
        for(int i=0; i< customers.size(); i++)
        {
            findClosestStation(customers.get(i));

        }
    }
     void returnBike (User customer, Date Time) { //zwróć rower danego użytkownika
        for(int i=0; i< stations.size(); i++)
        {
                if (customer.getStationid() == stations.get(i).getIndex()) {
                    if(customer.getTime().after(Time)) {
                    stations.get(i).returnBike();
                    customer.setStationId(-1);
                    long diff = customer.getTime().getTime() - Time.getTime();//Liczenie różnicy czasów
                    TimeUnit time = TimeUnit.MINUTES;
                    long diffrence = time.convert(diff, TimeUnit.MILLISECONDS);
                    System.out.println("Rower został zwrócony po czasie " +diffrence +" minut");
                    return;
                }else{
                        stations.get(i).returnBike();
                        customer.setStationId(-1);
                        System.out.println("Rower został zwrócony przed czasem");
                        return;
                    }
            }
        }
    }

    void returnAllBikes(Date Time){//zwróć wszystkie rowery po danym czasie
        for(int a =0; a<customers.size();a++){
            for(int i=0; i< stations.size(); i++)
            {
                if(customers.get(a).getTime().after(Time)){
                    if(customers.get(a).getStationid()==stations.get(i).getIndex()){
                        stations.get(i).returnBike();
                        customers.get(a).setStationId(-1);
                   }
                }
            }
        }
    }

    void returnAllBikes(){//zwróć wszystkie rowery 
        for(int a =0; a<customers.size();a++){
            for(int i=0; i< stations.size(); i++)
            {
                    if(customers.get(a).getStationid()==stations.get(i).getIndex()){
                        stations.get(i).returnBike();
                        customers.get(a).setStationId(-1);
                    }
            }
        }
    }
}
