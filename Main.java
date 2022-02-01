public class Main {
    public static void main(String[] args) {

        MainApp mainApp = new MainApp("stations.csv", "users.csv");
        //wyświetlanie stacji dla użytkownika wraz z liczbą pozostałych rowerów na stacji
        mainApp.usersClosestStations();

        //zapisywanie danych do pliku capacity.csv
        mainApp.writingCSV("capacity.csv");

        //wyświetlanie aktualnego stanu wszystkich stacji
        mainApp.allStationsCapacity();

        //zwracanie wszystkich rowerów
        mainApp.returnAllBikes();

        //wyświetlanie stanu stacji po zwróceniu
        mainApp.allStationsCapacity();

        //późniejszy zapis do pliku
        mainApp.writingCSV("capacity2.csv");



    }
}
