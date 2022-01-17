import java.util.ArrayList;

public class Stations {
    static int amountOfStations;

    ArrayList<String> stationName = new ArrayList<>();
    ArrayList<Integer> stationCapacity = new ArrayList<>();
    ArrayList<Integer> curentAmountOfBikes = new ArrayList<>();
    ArrayList<Integer> stationX = new ArrayList<>();
    ArrayList<Integer> stationY = new ArrayList<>();
    //testowe

    public static void main(String[] args) {
        Stations stations = new Stations();
        stations.stationY.add(9);
        stations.stationX.add(6);

    }


    public Stations() {

    }

    public static void getStationsFromFile(){

    }


    public Integer getStationX(int index) {
        return stationX.get(index);
    }

    public Integer getStationY(int index) {
        return stationY.get(index);
    }


}
