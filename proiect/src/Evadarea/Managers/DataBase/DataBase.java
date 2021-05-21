package Evadarea.Managers.DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DataBase
{
    private Connection c;

    private Statement s;

    private static DataBase instance = new DataBase();


    public static DataBase getInstance()
    {
        return instance;
    }


    // manager pentru baza de date
    // aici am metode pentru creare de tabele, initializare tabele, modificare tabele, si citire din tabele
    private DataBase()
    {
        c = null;
        s = null;
    }


    public void CreateMaps(int length1, int length2)
    {
        System.out.println("Create Maps BD.");
        try
        {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:DataBase/DataBase.db");
            c.setAutoCommit(false);

            s = c.createStatement();


            String mat1 = "CREATE TABLE IF NOT EXISTS FirstMap (col INT, linie CHAR(" + length1 + "));";
            String mat2 = "CREATE TABLE IF NOT EXISTS SecondMap (col INT, linie CHAR(" + length2 + "));";

            String del1 = "DROP TABLE IF EXISTS FirstMap;";
            String del2 = "DROP TABLE IF EXISTS SecondMap;";

            s.executeUpdate(del1);
            s.executeUpdate(del2);

            s.executeUpdate(mat1);
            s.executeUpdate(mat2);


            c.commit();

            s.close();
            c.close();


        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void Create()
    {
        System.out.println("Create BD.");
        try
        {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:DataBase/DataBase.db");
            c.setAutoCommit(false);

            s = c.createStatement();

            String exe1 = "CREATE TABLE IF NOT EXISTS FirstLevel (" +
                    "PlayerX                REAL," +
                    "PlayerY                REAL," +
                    "score                  INT," +
                    "foarfece               INT," +
                    "bani                   INT," +
                    "tarnacop               INT," +
                    "lingura                INT," +
                    "hasTarnacop            INT," +
                    "escaped1               INT" +
                    ");";

            String exe2 = "CREATE TABLE IF NOT EXISTS SecondLevel (" +
                    "PlayerX                REAL," +
                    "PlayerY                REAL," +
                    "score                  INT," +
                    "foarfece               INT," +
                    "bani                   INT," +
                    "tarnacop               INT," +
                    "topor                  INT," +
                    "vasla                  INT," +
                    "hasTarnacop            INT," +
                    "escaped2               INT" +
                    ");";


            String del1 = "DROP TABLE IF EXISTS FirstLevel;";
            String del2 = "DROP TABLE IF EXISTS SecondLevel;";

            s.executeUpdate(del1);
            s.executeUpdate(del2);

            s.executeUpdate(exe1);
            s.executeUpdate(exe2);


            c.commit();

            s.close();
            c.close();


        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void CreateSettings()
    {
        System.out.println("Create and Insert Settings BD.");
        try
        {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:DataBase/DataBase.db");
            c.setAutoCommit(false);

            s = c.createStatement();

            String exe1 = "CREATE TABLE IF NOT EXISTS Settings (sound INT);";

            String exe2 = "INSERT INTO Settings (sound) VALUES (1);";

            String del1 = "DROP TABLE IF EXISTS Settings;";

            s.executeUpdate(del1);

            s.executeUpdate(exe1);
            s.executeUpdate(exe2);


            c.commit();

            s.close();
            c.close();


        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    public void InsertMap(int level, int index)
    {
        System.out.println("Insert Maps BD.");
        try
        {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:DataBase/DataBase.db");
            c.setAutoCommit(false);

            s = c.createStatement();

            String exe = "INSERT INTO ";

            if(level == 1)
            {
                exe += "FirstMap (col, linie) VALUES (" + index + ", '000000000000000000000000000000000000000000000000000000');";
            }
            else
            {
                exe += "SecondMap (col, linie) VALUES (" + index + ", '0000000000000000000000000000000000000000000000000000000000000000000000');";
            }


            s.executeUpdate(exe);

            c.commit();

            s.close();
            c.close();


        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void Insert()
    {
        System.out.println("Insert BD.");
        try
        {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:DataBase/DataBase.db");
            c.setAutoCommit(false);

            s = c.createStatement();

            String exe1 = "INSERT INTO FirstLevel (" +
                    "PlayerX," +
                    "PlayerY," +
                    "score," +
                    "foarfece," +
                    "bani," +
                    "tarnacop," +
                    "lingura," +
                    "hasTarnacop," +
                    "escaped1)" +
                    " VALUES (" +
                    "0,0,0,0,0,0,0,1,0);";


            String exe2 = "INSERT INTO SecondLevel (" +
                    "PlayerX," +
                    "PlayerY," +
                    "score," +
                    "foarfece," +
                    "bani," +
                    "tarnacop," +
                    "topor," +
                    "vasla," +
                    "hasTarnacop," +
                    "escaped2)" +
                    " VALUES (" +
                    "0,0,0,0,0,0,0,0,1,0);";


            s.executeUpdate(exe1);
            s.executeUpdate(exe2);

            c.commit();

            s.close();
            c.close();


        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }



    public void UpdateMap(int level, int index , String newLine)
    {
        System.out.println("Update Map BD.");
        try
        {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:DataBase/DataBase.db");
            c.setAutoCommit(false);

            s = c.createStatement();

            String instr = "UPDATE ";
            if(level == 1)
            {
                instr += "FirstMap";
            }
            else
            {
                instr += "SecondMap";
            }
            instr += " set linie = '" + newLine + "' where col=" + index + ";";

//            System.out.println(instr);

            s.executeUpdate(instr);


            c.commit();

            s.close();
            c.close();


        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void Update(int level, String field, float n)
    {
        System.out.println("Update BD.");
        try
        {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:DataBase/DataBase.db");
            c.setAutoCommit(false);

            s = c.createStatement();

            String instr = "UPDATE ";
            if(level == 1)
            {
                instr += "FirstLevel";
            }
            else
            {
                instr += "SecondLevel";
            }
            instr += " set " + field + " = " + n + ";";

            System.out.println(instr);

            s.executeUpdate(instr);


            c.commit();

            s.close();
            c.close();


        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void Update(int level, String field, int n)
    {
        try
        {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:DataBase/DataBase.db");
            c.setAutoCommit(false);

            s = c.createStatement();

            String instr = "UPDATE ";
            if(level == 1)
            {
                instr += "FirstLevel";
            }
            else
            {
                instr += "SecondLevel";
            }
            instr += " set " + field + " = '" + n + "';";

            System.out.println(instr);

            s.executeUpdate(instr);


            c.commit();

            s.close();
            c.close();


        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void UpdateSettings(int n)
    {
        try
        {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:DataBase/DataBase.db");
            c.setAutoCommit(false);

            s = c.createStatement();

            String instr = "UPDATE Settings ";

            instr += " set sound = '" + n + "';";

            System.out.println(instr);

            s.executeUpdate(instr);


            c.commit();

            s.close();
            c.close();


        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    public String SelectMap(int level, int index)
    {
        String rez = "";
        try
        {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:DataBase/DataBase.db");
            c.setAutoCommit(false);

            s = c.createStatement();

            String instr = "SELECT * FROM ";

            if(level == 1)
            {
                instr += "FirstMap;";
            }
            else
            {
                instr += "SecondMap;";
            }

//            System.out.println(instr);

            ResultSet rs = s.executeQuery(instr);

            while(rs.next() && index>0)
            {
                index--;
            }

            rez = rs.getString("linie");

            c.commit();

            s.close();
            c.close();


        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return rez;
    }

    public int SelectInt(int level, String var)
    {
        int rez = 0;
        try
        {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:DataBase/DataBase.db");
            c.setAutoCommit(false);

            s = c.createStatement();

            String instr = "SELECT * FROM ";

            if(level == 1)
            {
                instr += "FirstLevel;";
            }
            else
            {
                instr += "SecondLevel;";
            }

//            System.out.println(instr);

            ResultSet rs = s.executeQuery(instr);

            rez = rs.getInt(var);

            c.commit();

            s.close();
            c.close();


        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return rez;
    }

    public float SelectFloat(int level, String var)
    {
        float rez = 0.0f;
        try
        {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:DataBase/DataBase.db");
            c.setAutoCommit(false);

            s = c.createStatement();

            String instr = "SELECT * FROM ";

            if(level == 1)
            {
                instr += "FirstLevel;";
            }
            else
            {
                instr += "SecondLevel;";
            }

//            System.out.println(instr);

            ResultSet rs = s.executeQuery(instr);

            rez = rs.getFloat(var);

            c.commit();

            s.close();
            c.close();


        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return rez;
    }

    public int SelectSettings()
    {
        int rez = -1;
        try
        {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:DataBase/DataBase.db");
            c.setAutoCommit(false);

            s = c.createStatement();

            String instr = "SELECT * FROM Settings;";



//            System.out.println(instr);

            ResultSet rs = s.executeQuery(instr);

            rez = rs.getInt("sound");

            c.commit();

            s.close();
            c.close();


        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return rez;
    }




}
