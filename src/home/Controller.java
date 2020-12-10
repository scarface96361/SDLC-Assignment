package home;

import DataProcessors.DatabaseTool;
import DataProcessors.FileInput;
import DataProcessors.ListAnalyzer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
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
        DatabaseTool dbtool = new DatabaseTool();

        //creating the database
        //the database has already been created localy so this has been canceled
        //dbtool.CreateDB();



        ArrayList<String> list =   getfile.InputFromWeb();

        ListAnalyzer checker = new ListAnalyzer();

        HashMap<String, Integer> map = checker.listanalyzer(list);
        //System.out.println("this is for debugging");

        map = checker.MapSorter(map);

        dbtool.fillDB(map);

        //printing out the final sorted list
        map.forEach((k,v)-> textOutput.appendText(k + " Has appeared " + v +" number of times\n"));
        System.out.println("printing complete");
    }

    /**Getting the database records and printing them locally. must be run after the database has been filled once
     *
     * @param actionEvent
     */
    public void readDB(ActionEvent actionEvent) {
        String url = "jdbc:mysql://localhost:3306/word_counts";
        String user = "root";
        String password = "secret";

        Connection conn = null;
        Statement stmt = null;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            //connecting to database
            textOutput.setText("Connecting to a selected database...");
            conn = DriverManager.getConnection(url, user, password);
            textOutput.appendText("\nConnected database successfully...");

            textOutput.appendText("\nCreating Statement...");


            //executing and creating query
            stmt = conn.createStatement();

            String sql = "SELECT  * FROM words_table ORDER BY  wordcount Desc";

            ResultSet rs = stmt.executeQuery(sql);

            //extracting and printing the data

            while(rs.next()){
                String word = rs.getString("words");
                int count = rs.getInt("wordcount");

                //output values
                textOutput.appendText("\n " + word + " Occured " + count + " times");
            }
            rs.close();
            conn.close();



        }catch (Exception e){

            System.out.println("Something went wrong");
            System.out.println(e.getMessage());
        }


    }
}
