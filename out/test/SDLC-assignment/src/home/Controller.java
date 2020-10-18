package home;

import DataProcessors.FileInput;
import DataProcessors.ListAnalyzer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Controller {


    @FXML
    public TextArea textOutput;

    public void runCounter(ActionEvent actionEvent) {
        FileInput getfile = new FileInput();



        ArrayList<String> list =   getfile.InputFromWeb();

        ListAnalyzer checker = new ListAnalyzer();

        HashMap<String, Integer> map = checker.listanalyzer(list);
        //System.out.println("this is for debugging");

        map = checker.MapSorter(map);

        //printing out the final sorted list
        map.forEach((k,v)-> textOutput.appendText(k + " Has appeared " + v +" number of times\n"));
        System.out.println("printing complete");
    }
}
