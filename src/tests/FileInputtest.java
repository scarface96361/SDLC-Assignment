package tests;

import DataProcessors.FileInput;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileInputtest {
    /** this is a file input test that mostly just tests the output of file input against itself.
     *
     */
    @Test
    public void testInput(){

        FileInput test = new FileInput();
        ArrayList<String> testagainst = test.InputFromWeb();

        assertEquals(testagainst, test.InputFromWeb());
    }

}
