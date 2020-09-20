package DataProcessors;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class FileInput {


    String html = "https://www.gutenberg.org/files/1065/1065-h/1065-h.htm";


    private String URL = "C:/Users/joebo/Documents/school/CEN-3024C/Java Projects/SDLC-assignment/src/Raven.txt";


    /**Generic Constructor for the FileInput Class
     *
     */
    public FileInput(){

    }


    /**This method was used early on for testing purposes so that I
     *  could properly test and validate file input and the counting method
     *  It is no longer useful but was left in for future testing purposes
     * @return
     */
     public ArrayList<String> inputfile (){
        //creating the arraylist to store very word parsed from the file in
        ArrayList<String> list = new ArrayList<String>();
        File file = new File(URL);

        try {
             Scanner sc = new Scanner(file);


             while (sc.hasNext()){
                 list.add(sc.next());
             }



             return list;
        }catch(Exception e){
            System.out.println(e.getLocalizedMessage() + "something went wrong reading the file!");
        }




        //this is a failover in case something in the scanner fails
        return null;
     }

    /**this method parses the website and gets its string input from the website
     * ignoring all html and css tag
     *
     *
     * @return
     */
     public  ArrayList<String> InputFromWeb(){
        try {
            ArrayList<String> wordList = new ArrayList<String>();

            //creating and connecting to the site to parse data from\
            Document document = Jsoup.connect(html).get();


            //this prints the title of the webpage
            System.out.println(document.title());

            //this line gets elements by tag and parses the "p" tag in html for its data
            Elements Poem = document.getElementsByTag("p");

            //calling a method to split and sanitze the elements retrieved by getelements
            SplitSanitize(wordList, Poem);

            //header scan
            Poem = document.getElementsByTag("h1");

            //calling a method to split and sanitze the elements retrieved by getelements
            SplitSanitize(wordList, Poem);


            //header scan for by
            Poem = document.getElementsByTag("h4");

            //calling a method to split and sanitze the elements retrieved by getelements
            SplitSanitize(wordList, Poem);

            //retrieving the tags from the header for the title
            Poem = document.getElementsByTag("h3");

            //calling a method to split and sanitze the elements retrieved by getelements
            SplitSanitize(wordList, Poem);





            //the following line was used for testing and was left in case further testing was needed
           // System.out.println("this is for breakline");








            return wordList;
        }catch (Exception e){
            System.out.println("error in jsoup" + e.getLocalizedMessage());
        }

         //this was placed in case something went wrong during try catch the method would return null
         // this also allows for further error checking
         return null;

     }

    /**This method takes an arraylist of words to be filled and an elements object to clean and split into
     * individual words
     *
     * @param Wordlist
     * @param Poem
     */
     public void SplitSanitize(ArrayList<String> Wordlist, Elements Poem){
         //this section is resposible for sanitizing the paragraphs and splitting all words into their
         //individual components
         for(Element text : Poem){
             String poem = text.text();

             //this like removes all
             String cleanedPoem = poem.replaceAll("[-+^\",;.—]", "");



             String[] arrTest = cleanedPoem.split(" ");


             //nexted foreach loop to add individual words to the final output of this methoid
             for (String word: arrTest) {

                 String temp = word.toLowerCase();
                 Wordlist.add(temp);
             }
         }

     }

}
