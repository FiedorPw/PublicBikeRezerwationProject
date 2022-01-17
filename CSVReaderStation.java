import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVReaderStation {
    private ArrayList<Station> records = new ArrayList<>();
    private ArrayList<String[]> rows = new ArrayList<>();
    //List<List<String>> records = new ArrayList<List<String>>();

    private String fileName;
    private String separator;

    Stations stations = new Stations();
    public CSVReaderStation(String fileName, String separator) {
        this.fileName = fileName;
        this.separator = separator;
    }
    public ArrayList<Station> read() {

        try  (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            int index =0;
            while ((line = br.readLine()) != null) {
                String[] t = line.split(separator);
                rows.add(t);

                if(index>0)
                {
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
