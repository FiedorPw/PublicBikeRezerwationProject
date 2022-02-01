import java.util.Date;
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

 /// //wyświetlanie stacji dla użytkownika wraz z liczbą pozostałych rowerów na stacji
               mainApp.usersClosestStations();
            //wyświetlanie aktualnego stanu wszystkich stacji
                mainApp.allStationsCapacity();
                //tworzenie obiektu z godziną o której sprawdzamy zworenie rowerów
             Date Time = new Date(50400000); //godzina 15:00
             mainApp.returnAllBikes(Time);
        //wyświetlanie stanu stacji po zwróceniu
        mainApp.allStationsCapacity();


        //późniejszy zapis do pliku
        mainApp.writingCSV("capacity2.csv");



    }
}
