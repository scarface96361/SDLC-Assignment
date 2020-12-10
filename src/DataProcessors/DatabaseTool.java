package DataProcessors;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class DatabaseTool {

    static final String url = "jdbc:mysql://localhost/Word_counts";
    static final String user = "root";
    static final String password = "secret";

    public void CreateDB(){
        Connection conn = null;

        String url = "jdbc:mysql://localhost/";
        String user = "root";
        String password = "secret";


        Statement  stmt = null;

        try{


            //register the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //opening the connection
            conn= DriverManager.getConnection(url, user, password);


            //executing sql command
            stmt = conn.createStatement();

            String sql = "CREATE DATABASE WORD";

            stmt.executeUpdate(sql);

            sql = "CREATE TABLE WORDS_Table" +
                    "( word STRING ," +
                    " wordcount INTEGER)";

            stmt.executeUpdate(sql);

            stmt.close();


        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        catch (Exception se){
            System.out.println(se.getMessage());
        }
    }

    public void fillDB(HashMap<String, Integer> wordcount){
        Connection conn = null;
        Statement stmt = null;

        try {
            //getting the driver primed
            Class.forName("com.mysql.cj.jdbc.Driver");

            //getting connection
            System.out.println("Connecting to selected Database");
            conn = DriverManager.getConnection(url, user, password);

            //executing query
            String sql;
            stmt = conn.createStatement();


            for(Map.Entry<String, Integer> entry : wordcount.entrySet() ){
                String k = entry.getKey();
                Integer v = entry.getValue();
                sql ="Insert into words_table values ( '"+ k +"' , "+ v + ") ";
                stmt.executeUpdate(sql);
            }





        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }



}
