package readfilecharacters;

/*
Programer: Jasen Ratnam
Date: 2016-11-16
Assignment 4_B
Purpose: Write a Java program that inputs the contents of a test file and outputs 
         a frequency histogram of the characters appearing in the string.
*/                // author presentation
import java.io.File;
import java.io.IOException;
import java.util.Scanner;         // Declare tools

public class ReadFileCharacters   //start programme
{
    public static void main(String[] args)  throws IOException  //declare main method with throws exception
    {
        //step 1: Define a File object
        String fileName = "E:\\school\\programming\\assigngement-4B\\ReadFileCharacters\\input.txt"; //save location of file in filename
        File textToBeRead = new File(fileName);  //create a File with imported file
        
        // Step 2: make sure the file opened properly
        if( ! textToBeRead.exists())
        {
            System.out.println("Could not open file: " + fileName);  // if file is not opened proprely display error message and exit
            System.exit(1);
        }

        // Step 3: Attach the file to a Scanner object
        Scanner fileReader = new Scanner(textToBeRead); // create scanner with file as the scanner

        //inalize values
        int totalChars = 0;  //for total numbers of characters
        char ch;        //for every letter of alphabet
        int[] alphabet= new int [26]; //create range for alphabet
        //int nextChar;
        //char stars;
        
        //Step 4: Read input values
        
        while(fileReader.hasNextLine())  //create loop to read file line by line
        {
            String line = fileReader.nextLine(); //save line x of file
            
            for(int i=0;i<line.length();i++) // create loop for each character of the line x
            {
//                if(line.charAt(i)!=' ' && line.charAt(i)!='\n') //if character is not a space or line skip save number of chars
//                {
//                    totalChars ++; //add 1 chars
//                }
                totalChars += line.length();
                ch = line.charAt(i); //save x character of line
                ch = Character.toLowerCase(ch); // conver to lowercase
                
                //if (ch >= 'a' && ch <= 'z') // if ch is an alphabet
                if( Character.isLetter(ch))
                {
                    alphabet[ch - 'a']++; //add into the range
                }
                /*for(int x = 0; x < alphabet.length; x++)
                {
                    if (alphabet [x] > 0)
                    {
                        ch = (char) (i+ 'a');
                        System.out.println(ch + " : " + alphabet[x]);
                    }
                }*/
                
            }
        }
        
        // display results
        System.out.println("Total characters : " + totalChars); // display total characters
        
        for(int x = 0; x < alphabet.length; x++) //sart loop to display all alphabets repetions
        {
           /*if (alphabet [x] == 0)
            {
                System.out.println("'" + ch + "':");
            }*/
            /*for(int y = 0; y < alphabet[x]; y++)
            {
                stars += '*';
            }*/
           
            ch = (char) (x + 'a'); //save letter of alphabet + number of time loop is repeated
            
            //if (alphabet [x] > 0)  //if letter is appeared 1 or more times
            {
               // ch = (char) (x + 'a');
                System.out.print("'" + ch + "' : "); //display letter to be shown
                for(int y = 0; y < alphabet[x]; y++) //start loop for rep of stars
                {
                    System.out.print("*"); //reapet stares as long as time x is reapeated
                    //System.out.print(y);
                }
               
                System.out.println(); // skip line

                //System.out.println("'" + ch + "' : " + stars);
            }
            
//            else if (alphabet [x] == 0)  //if letter never appeared
//            {
//                System.out.println("'" + ch + "':"); //display letter to be shown
//            }
        }
        
        // Step 5:lose the logical file
        fileReader.close(); //close file reading.
    }
        
}
    

