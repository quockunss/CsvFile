
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class CsvWriterAndReader {
    // clean code
    private static final String COMMA = ","; //dau phay
    private static final String NEW_LINE = "\n"; //xuong dong
    //csv file header
    private static final String FILE_HEADER = "id,code,name";

    public static void main(String[] args) throws IOException {
        String filename = "contries.csv";
        writeCsvFile(filename);
        FileReader filereader = new FileReader(filename);
        BufferedReader br = new BufferedReader(filereader);
        String line = null;
        while((line = br.readLine()) != null){
            String[] result = line.split(COMMA);
            if (result.length == 3){
                String id = result[0];
                String code = result[1];
                String name = result[2];
                System.out.println(id + code + name);
            }
        }






    }
    public static void writeCsvFile(String filename) {
        //tao cac doi tuong country
        Country country1 = new Country(1,"VN","Viet Nam");
        Country country2 = new Country(2,"US","United State");
        Country country3 = new Country(3,"AU","Astralia");

        //tao list chua cac doi tuong
        List<Country> countries = new ArrayList<>();
        countries.add(country1);
        countries.add(country2);
        countries.add(country3);

        FileWriter filewriter = null;

        try {

            filewriter = new FileWriter(filename);

            //tao header thu muc csv
            filewriter.append(FILE_HEADER);

            //xuong dong sau header
            filewriter.append(NEW_LINE);
            filewriter.append(NEW_LINE);

            for (Country country: countries){
                filewriter.append(String.valueOf(country.getId()));
                filewriter.append(COMMA);
                filewriter.append(country.getCode());
                filewriter.append(COMMA);
                filewriter.append(country.getName());
                filewriter.append(NEW_LINE);
            }




        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                filewriter.close();
            }catch (IOException ex){
                ex.printStackTrace();
            }
        }
    }
}
