import org.apache.commons.csv.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.regex.Pattern;
import uy.edu.um.adt.heap.MyHeap;



public class CargaDatos {
    public void datos() throws IOException {
        String[] arrayHashtag;
        MyHashTable<Integer,String> hash1= new HashTableImpl<>(5);
        Reader in = new FileReader("src/DataFile/f1_dataset_test.csv");
        Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(in);
        int counter=0;
        for (CSVRecord record : records) {
            if (record.isConsistent()){
                for (int i=0;i<14;i++){
                    System.out.println(record.get(i));
                }
            } else {
                continue;
            }
            counter++;
            if(counter==2){
                String[] arrayHashtag;
                arrayHashtag=transformarArray(record.get(11));
                System.out.println(arrayHashtag[0]);
                System.out.println(arrayHashtag[1]);
                System.out.println(arrayHashtag[2]);
                break;
//storing the string elements in array after splitting
            }
        }
    }

    public String[] transformarArray(String str){
        String cleanedStr = str.replaceAll("\\[|'|\\]", "");

        // Split the string by comma and space
        String[] splitArray = cleanedStr.split(", ");

        // Create an array and copy the split values

        return splitArray;
    }
}
