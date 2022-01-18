public class User {

    private int index;
    private String name;
    private String surname;
    //na razie zapisuje godzine jako Stringa
    private String bookedAt;
    private int time;
    private int coordinateX;
    private int coordinateY;
    private int stationId;

    public User(int index, String name, String surname, String bookedAt, int time, int coordinateX, int coordinateY) {
        this.index = index;
        this.name = name;
        this.surname = surname;
        this.bookedAt = bookedAt;
        this.time = time;
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        this.stationId = -1;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getBookedAt() {
        return bookedAt;
    }

    public void setBookedAt(String bookedAt) {
        this.bookedAt = bookedAt;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getCoordinateX() {
        return coordinateX;
    }

    public void setCoordinateX(int coordinateX) {
        this.coordinateX = coordinateX;
    }

    public int getCoordinateY() {
        return coordinateY;
    }

    public void setCoordinateY(int coordinateY) {
        this.coordinateY = coordinateY;
    }

    public void setStationId(int stationId){
        this.stationId=stationId;
    }
    public int getStationid(){
        return this.stationId;
    }

}
