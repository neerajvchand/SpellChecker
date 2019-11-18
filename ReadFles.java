
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ReadFles 
{
    public ArrayList<String> readDict()
    {
        ArrayList<String> arr=new ArrayList<String>();
        BufferedReader reader;
        try 
        {
            reader = new BufferedReader(new FileReader("english.0")); //read from file.
            String line = reader.readLine();
            while (line != null) 
            {
                arr.add(line);
                // read next line
                line = reader.readLine();
                line = reader.readLine();
            }
            reader.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return arr;
    }
    public String readA1Properties()
    {
        BufferedReader reader;
        try 
        {
            reader = new BufferedReader(new FileReader("a1properties.txt")); //read from file.
            String line = reader.readLine();
            reader.close();
            String [] data=line.split("=");
            if(data[1].equalsIgnoreCase("trie"))
            {
                return "trie";
            }
            else if(data[1].equalsIgnoreCase("tree"))
            {
                return "tree";
            }
            
        }
        catch (IOException e)
        {
            return "trie";
        }
        return "trie";
    }
    public ArrayList<String> readInputFile(String fileName)
    {
        ArrayList<String> arr=new ArrayList<String>();
        BufferedReader reader;
        try 
        {
            reader = new BufferedReader(new FileReader(fileName)); //read from file.
            String line = reader.readLine();
            while (line != null) 
            {
                arr.add(line);
                // read next line
                line = reader.readLine();
            }
            reader.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return arr;
    }
    public void writeOutput(String filename,String fileContent)
    {
        BufferedWriter writer; //write for write in the file.
        try
        {
            writer = new BufferedWriter(new FileWriter(filename,true)); //write at the end of file.
            writer.write(fileContent+"\n");
            writer.close();
        } 
        catch (IOException ex) 
        {
            ex.printStackTrace();
        }
    }
}

