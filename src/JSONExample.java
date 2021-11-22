import jdk.swing.interop.SwingInterOpUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.Scanner;

public class JSONExample {

    public static void main(String[] args) {
        String s;
        try {
            Scanner sc = new Scanner(new File("sample.json"));
            sc.useDelimiter("\\Z");
            s = sc.next();
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(s);
            JSONObject jsonObject = (JSONObject)obj;

            JSONArray songArray = (JSONArray)jsonObject.get("songs");
            for (Object song : songArray) {
                JSONObject jsong = (JSONObject)song;
                System.out.println(jsong.get("title"));
            }


        } catch (FileNotFoundException e) {
            System.out.println("File not found " + e);
        } catch (ParseException e1) {
            System.out.println("Parser error");
        }
    }
}
