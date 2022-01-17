public class Main {
    public static void main(String[] args) {

        User user = new User(1, "adad", "aD", "s", 12,-500,450);
        MainApp mainApp = new MainApp("stations.csv", "users.csv");
        mainApp.findClosestStation(user);
        mainApp.usersClosestStations();

    }
}
