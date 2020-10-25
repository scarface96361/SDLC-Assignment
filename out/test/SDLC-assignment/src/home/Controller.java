package home;

import DataProcessors.FileInput;
import DataProcessors.ListAnalyzer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

//The controller class is the primary class that handles the javaFX and FXML files
public class Controller {


    @FXML
    public TextArea textOutput;

    /**runCounter is the equivalent of the old main in the former version of this program. the code does the same thing
     * as main used to do in the original version, however now it only triggers when the user clicks the scan button in the window. once
     * that button is pushed the application thread calls this method which behaves exactly the same as the original version.
     * The other main difference is the output now appendTexts the dialogue to the textOutput textarea so that all functionallity
     * is acheived within the window
     *
     * @param actionEvent
     */
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
