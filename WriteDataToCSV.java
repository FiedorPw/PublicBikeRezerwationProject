import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Formatter;

public class WriteDataToCSV {
    private ArrayList<Station> records = new ArrayList<>();

    private String fileName;
    private String separator;

    public WriteDataToCSV(String fileName, String separator, ArrayList<Station> records) {
        this.fileName = fileName;
        this.separator = separator;
        this.records = records;
    }

    public ArrayList<Station> write() {

        File file = new File(fileName);
        //wyjątek może wystąpić, gdyż może się zdarzyć, iż nie będziemy mieli uprawnień w danym katalogu
        if(!file.exists())
        {
            try
            {
                file.createNewFile();
            } catch(Exception e)
            {
                System.out.println(e.getMessage());
            }
        }
        if(file.canWrite())
        {
            try
            {
                FileWriter fileWriter = new FileWriter(file, false);
                Formatter formatter = new Formatter(fileWriter);
                formatter.format("%s \r\n","Index" +separator+ "StationName" + separator + "StationCapacity" + separator + "CurrentAmountOfBikes");
                for(int i=0; i< records.size(); i++)
                {
                    formatter.format("%s \r\n",records.get(i).getIndex()+separator+records.get(i).getStationName()+
                            separator + records.get(i).getStationCapacity()
                            +separator+ records.get(i).getCurrentAmountOfBikes());
                }

                fileWriter.close();
                formatter.close();


            }catch(Exception e)
            {
                System.out.println(e.getMessage());
            }

        }


        return records;
    }


}
