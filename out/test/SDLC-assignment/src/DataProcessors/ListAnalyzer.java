package DataProcessors;

import java.util.*;

public class ListAnalyzer {

    /**Generic ListAnalyzer
     *
     */
    public ListAnalyzer(){

    }

    /**listanalyser method used to analyze a list to see how many of each word 
     * is in the list 
     *
     * @param list
     */
    public HashMap<String,Integer> listanalyzer(ArrayList<String> list){

        //using a hashset to only use one item from every object in the list
        Set<String> stringSet = new HashSet<String>(list);

        //hashmap for storing the word and frequency
        HashMap<String, Integer> map = new HashMap<String, Integer>();

        //for loop that checks through every object in the string set and checks how many times it shows up
        //in the list thats delivered to the analyzer
        for (String y: stringSet) {

            //System.out.println(y + " is used" + Collections.frequency(list,y ) + "times");

            //this fills the map with the words as key values and the frequency as the sub value
            map.put(y , Collections.frequency(list,y));
        }



        return map;


    }

    /**The mapsorter method takes a hashmap input and sorts it by the values not the keys.
     *
     * @param toSort
     * @return
     */

    public HashMap<String, Integer> MapSorter(HashMap<String, Integer> toSort){

        //creating an arraylist to store the hashmap entries
        ArrayList<Map.Entry<String, Integer>> maplist = new ArrayList<Map.Entry<String, Integer>>(toSort.entrySet());

        //created a internal method that sorts the list by comparing values
        Collections.sort(maplist, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        //putting the data from the sorted list back into a hashmap
        HashMap<String, Integer> tempmap = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> entry: maplist ) {
            tempmap.put(entry.getKey(), entry.getValue());
        }


        return tempmap;
    }
}
