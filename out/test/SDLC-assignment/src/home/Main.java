package home;

import DataProcessors.FileInput;
import DataProcessors.ListAnalyzer;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {



        FileInput getfile = new FileInput();



       ArrayList<String> list =   getfile.InputFromWeb();

        ListAnalyzer checker = new ListAnalyzer();

        HashMap<String, Integer> map = checker.listanalyzer(list);
        //System.out.println("this is for debugging");

        map = checker.MapSorter(map);

        //printing out the final sorted list
        map.forEach((k,v)->System.out.println("Key: " + k + "Value: " + v));
        System.out.println("printing complete");
    }
}