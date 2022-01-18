import java.util.ArrayList;
import java.util.Objects;

public class Station {

    private int index;
    private String stationName;
    private int stationCapacity;
    private int currentAmountOfBikes;
    private int stationX;
    private int stationY;

    public Station(int index, String stationName, int stationCapacity, int currentAmountOfBikes, int stationX, int stationY) {
        this.index = index;
        this.stationName = stationName;
        this.stationCapacity = stationCapacity;
        this.currentAmountOfBikes = currentAmountOfBikes;
        this.stationX = stationX;
        this.stationY = stationY;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public int getStationCapacity() {
        return stationCapacity;
    }

    public void setStationCapacity(int stationCapacity) {
        this.stationCapacity = stationCapacity;
    }

    public int getCurrentAmountOfBikes() {
        return currentAmountOfBikes;
    }

    public void setCurrentAmountOfBikes(int currentAmountOfBikes) {
        this.currentAmountOfBikes = currentAmountOfBikes;
    }

    public int getStationX() {
        return stationX;
    }

    public void setStationX(int stationX) {
        this.stationX = stationX;
    }

    public int getStationY() {
        return stationY;
    }

    @Override
    public String toString() {
        return "Station{" +
                "index=" + index +
                ", stationName='" + stationName + '\'' +
                ", stationCapacity=" + stationCapacity +
                ", currentAmountOfBikes=" + currentAmountOfBikes +
                ", stationX=" + stationX +
                ", stationY=" + stationY +
                '}' ;

    }

    public void setStationY(int stationY) {
        this.stationY = stationY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Station station = (Station) o;
        return index == station.index && stationCapacity == station.stationCapacity && currentAmountOfBikes == station.currentAmountOfBikes && stationX == station.stationX && stationY == station.stationY && stationName.equals(station.stationName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, stationName, stationCapacity, currentAmountOfBikes, stationX, stationY);
    }
}
