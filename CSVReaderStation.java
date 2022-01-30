import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVReaderStation {
    //stworzenie listy skladajacej sie z obiektow station - do odczytu z pliku i wrzucenia do kolekcji
    private ArrayList<Station> records = new ArrayList<>();

    private String fileName;
    private String separator;


    public CSVReaderStation(String fileName, String separator) {
        this.fileName = fileName;
        this.separator = separator;
    }
    public ArrayList<Station> read() {

        try  (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            int index =0;
            while ((line = br.readLine()) != null) {
                //odczytywanie po kolei elementow z wiersza, index, nazwa stacji, etc.
                //zapisane jest to wszystko do tablicy stringow
                String[] t = line.split(separator);

                //index wiekszy 0, bo nie bierzemy pierwszego wiersza z nazwami pól
                if(index>0)
                {
                    //tworzymy obiekt stacji - czli wszystko to, co bedzie sie znajdowac w naszej liscie
                    //nie-stringi zamieniamy na inty,
                    Station station = new Station(Integer.parseInt(t[0]),t[1],Integer.parseInt(t[2]),Integer.parseInt(t[3]),
                            Integer.parseInt(t[4]),Integer.parseInt(t[5]));

                    System.out.println(station);
                    records.add(station);
                }
                index++;
            }
            return records;
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return null;
    }

    @Override
    public String toString() {
        String column= "";
        for(int i=0; i<records.size(); i++)
        {
            column+=records.get(i);
        }
        return column;
    }



}
