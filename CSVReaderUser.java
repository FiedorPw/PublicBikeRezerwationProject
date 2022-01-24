import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;

public class CSVReaderUser {
    private ArrayList<User> records = new ArrayList<>();
    private ArrayList<String[]> rows = new ArrayList<>();

    private String fileName;
    private String separator;

    Stations stations = new Stations();
    public CSVReaderUser(String fileName, String separator) {
        this.fileName = fileName;
        this.separator = separator;
    }
    public ArrayList<User> read() {

        try  (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            int index =0;
            while ((line = br.readLine()) != null) {
                String[] t = line.split(separator);
                rows.add(t);

                if(index>0)
                {
                    //konwersja Stringa na date w nastepujacej postaci
                    DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss", Locale.ENGLISH);
                    Date d1 = dateFormat.parse(t[3]);
                    Date d2 = dateFormat.parse(t[4]);
                    System.out.println(d2 + " ");
                    User user = new User(Integer.parseInt(t[0]), t[1], t[2], d1 , d2,
                            Integer.parseInt(t[5]),Integer.parseInt(t[6]));

                    records.add(user);
                }
                index++;
            }
            return records;
        } catch (IOException | ParseException ioe) {
            ioe.printStackTrace();
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        rows.forEach(row -> {
            sb.append(String.join(" ", row));
            sb.append(System.lineSeparator());
        });
        return sb.toString();
    }
}

