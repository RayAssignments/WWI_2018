package q1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Q1 {

	/*
	Question 1:
		There is a file containing a word and its possible meanings (like a Dictionary). The contents of the file look like this:
		Apple – a fruit, a tech firm
		Table – an object, contains rows and columns when used in context of computers
		Orange – a fruit
		
		Given a path to the file, do the following:
			a) Create a method called doesFileExist(String path) which takes the path of the file and
		tells the user if the file exists at that path or not. Assume all paths are relative to your
		project structure. If the file does not exist, catch the requisite exception.
			b) Read each word and its possible meanings and print them out. Your output should look
		like this:
			Word1
			Meaning 1
			Meaning 2
			Word2
			Meaning1
			Meaning2
		Use appropriate data structures wherever necessary.
   */
	
	public File getDict() {
        return dict;
    }

    public void setDict(File dict) {
        this.dict = dict;
    }

    public List<String> getOutput() {
        return output;
    }

    public void setOutput(List<String> output) {
        this.output = output;
    }

    
    private File dict;
    private List<String> output = new ArrayList<String>();


    public boolean doesFileExist(String filePath) {
        try {
            dict = new File(filePath);
            if (dict.exists() && dict.isFile()) {
                System.out.println("File exist.");
            }
        }
        catch (Exception ex){
            System.out.println("Requested file does not exist.");
            return false;
        }
        return false;
    }

    
    public void readAndParse(File file){
        BufferedReader bf = null;
        try {
            bf = new BufferedReader(new FileReader(file));
            String read = null;
            while ((read = bf.readLine()) != null) {
                String[] wordAndMeanings = read.split("\\s*–\\s*");
                for (String entry : wordAndMeanings) {
                    output.add(entry.replace(", ", "\n"));
                }
            }
         
        } catch (IOException ex) {
            System.out.println("There was a problem: "+ex);
            ex.printStackTrace();
        }
        finally {
            try {
                bf.close();
            } catch (Exception ex) {
            }
        }
    }

    
    public void printOutput(List<String> outputList){
        for (String text: outputList){
            System.out.println(text);
        }
    }

    
    public static void main(String args[]){
        Q1 q = new Q1();
        q.doesFileExist("resource/Dictionary.txt");
        q.readAndParse(q.getDict());
        q.printOutput(q.getOutput());
    }


}//end class
