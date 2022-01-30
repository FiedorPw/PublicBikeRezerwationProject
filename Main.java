public class Main {
    public static void main(String[] args) {

        MainApp mainApp = new MainApp("stations.csv", "users.csv");
        mainApp.usersClosestStations();
        mainApp.writingCSV();



    }
}
