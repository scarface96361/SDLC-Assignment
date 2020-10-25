package tests;

import DataProcessors.ListAnalyzer;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class testAnalyzer {

    @Test
    public void testAnalyze(){
        ArrayList<String> testlist = new ArrayList<String>();
        //adding word to sort to a dummy arraylist
        testlist.add("Word");
        testlist.add("Word");
        testlist.add("Word");
        testlist.add("One");

        //creating and adding a set hashmap to test against
        HashMap<String, Integer> standardList = new HashMap<String, Integer>();
        standardList.put("Word", 3 );
        standardList.put("One", 1);

        //creating a temporary object in order to run the counting method to test against controlled inputs and outputs
        ListAnalyzer testObject = new ListAnalyzer();

        assertEquals(standardList, testObject.listanalyzer(testlist));

    }

    @Test
    public void testSort(){
        //creating a dummy object to test the tests against
        ListAnalyzer testObject = new ListAnalyzer();

        //creating and inputting the expected output for a list
        HashMap<String, Integer> expectedOutput =  new HashMap<String , Integer>();
        expectedOutput.put("Word",3);
        expectedOutput.put("String", 2);
        expectedOutput.put("The", 1);

        //creating a list that needs to be sorted
        HashMap<String, Integer> input=  new HashMap<String , Integer>();
        input.put("String", 2);
        input.put("The", 1);
        input.put("Word",3);

        assertEquals(expectedOutput, testObject.MapSorter(input));


    }

}
