import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.Date;

public class MainApp {
    public int peopleonStation1 = 0;
    public int peopleonStation2 = 0;
    public int peopleonStation3 = 0;
    public int peopleonStation4 = 0;


    private ArrayList<Station> stations = new ArrayList<>();
    private ArrayList<User> customers = new ArrayList<>();
    MainApp(String path1, String path2)
    {
        CSVReaderStation stationReader = new CSVReaderStation(path1, ";");
        CSVReaderUser userReader = new CSVReaderUser(path2, ";");

        stations = stationReader.read();
        customers = userReader.read();
    }

    public MainApp() {

    }


    double findClosestDestinance(int userX, int userY){

        double distanceToClosestStation = 10000000;

        for (int i = 0;i < stations.size(); i++) {
            Station currentStation =  stations.get(i);
            double currentDistance = currentStation.distance(userX,userY);

            //sprawdzanie najmniejszej odległosci dla stacji, ktora ma jakiekolwiek rowery
            if (currentDistance < distanceToClosestStation && stations.get(i).getCurrentAmountOfBikes() != 0) {
                distanceToClosestStation = currentDistance;
            }
        }
        return distanceToClosestStation;
    }

    double findClosestDestinance(User customer)
    {
        int userX = customer.getCoordinateX();
        int userY = customer.getCoordinateY();

        return findClosestDestinance(userX,userY);
    }

    void usersClosestStationsDestinance()
    {
        for(int i=0; i< customers.size(); i++)
        {
            System.out.println(findClosestDestinance(customers.get(i)));

        }
    }

    Station findClosestStation(int userX, int userY){

        Station searchedStation = null;
        double closestStation = 10000000;
        double distanceToClosestStation = 10000000;

        for (int i = 0;i < stations.size(); i++) {
            Station currentStation =  stations.get(i);
            double currentDistance = currentStation.distance(userX,userY);

            //sprawdzanie najmniejszej odległosci
            if (currentDistance < distanceToClosestStation && stations.get(i).getCurrentAmountOfBikes() != 0) {
                distanceToClosestStation = currentDistance;
                searchedStation = stations.get(i);
            }
        }

        //assert searchedStation != null;
         //searchedStation.rentBike();
        //System.out.println(searchedStation.getStationName() + " bikes left: "+ searchedStation.getCurrentAmountOfBikes());
        return searchedStation;

    }


    Station findClosestStation(User customer){
        int userX = customer.getCoordinateX();
        int userY = customer.getCoordinateY();
        return findClosestStation(userX,userY);
    }


    void rentBike(User customer,int stationIndex){
        customer.setStationId(stationIndex);
    }

    void usersClosestStations()
    {
        for(int i=0; i< customers.size(); i++)
        {
            Station currentStation = findClosestStation(customers.get(i));
            String name = currentStation.getStationName();
            rent(customers.get(i));
            //currentStation.rentBike();
            int amount = currentStation.getCurrentAmountOfBikes();
            System.out.println("Dla użykownika: " + customers.get(i).getName() +" "+ customers.get(i).getSurname()
                    +" "+ "rower znajduje się na stacji: " + name + " ");
            System.out.println("liczba pozostałych rowerów na stacjach: " + amount);

        }
    }

    void allStationsCapacity()
    {
        for(int i=0; i<stations.size(); i++)
        {
            System.out.println(stations.get(i).getStationName() +" " + stations.get(i).getCurrentAmountOfBikes());
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
                        System.out.println("rower został zwrócony");
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

    public void rent(int userId){
        for(int i=0; i<customers.size(); i++){
            if(customers.get(i).getIndex()==userId){
                Station closestStation=findClosestStation(customers.get(i));
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




    public void writingCSV(String fileName)
    {
        WriteDataToCSV writeDataToCSV = new WriteDataToCSV(fileName, ";", stations);
        writeDataToCSV.write();
    }

    public void getAmountOfPoeopleOnStations(){
        for(int i = 0 ; i < customers.toArray().length; i++){
            if (customers.get(i).getStationid() == 1) peopleonStation1++;
            else if (customers.get(i).getStationid() == 2) peopleonStation2++;
            else if (customers.get(i).getStationid() == 3) peopleonStation3++;
            else if (customers.get(i).getStationid() == 4) peopleonStation4++;

        }
    }

}
