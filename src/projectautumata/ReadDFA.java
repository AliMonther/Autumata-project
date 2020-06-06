/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectautumata;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author حسين
 */
public class ReadDFA 
{
        String thisLine="";
        String statesNumber="";
        String finalStatesNumber="";
        String Alphapet="";
        String states="";
        int lineNumber=0;
        int lenght=0;
        int width=0;
        //----------
        
        void getDFA(String fileName) throws FileNotFoundException, IOException
        {
            FileReader r = new FileReader("javaAutomata.txt"); 
            BufferedReader br = new BufferedReader(r);
             while((thisLine=br.readLine())!=null )
       {
           //System.out.println(thisLine);
           lineNumber++;
           //System.out.println(lineNumber);
            if(lineNumber == 1)
                {
                    statesNumber=thisLine;
                }
            else if(lineNumber == 2)
                {
                    finalStatesNumber=thisLine;
                    
                }
            else if(lineNumber == 3)
                {
                    Alphapet=thisLine;
                    
                }
            else if (lineNumber == 4)
                {
              
                     states=thisLine;    
                }
       }
	        br.close();
	        r.close();
       // System.out.println("\n-----------------------------------");
        // System.out.println("statesNumber ="+statesNumber);
        //  System.out.println("finalStatesNumber ="+finalStatesNumber);
         //  System.out.println("Alphapet = "+Alphapet);
            ///System.out.println("States"+states);
    //           System.out.println("charArray"+statesTables);     
            // System.out.println("charalpapet"+charAlpahpet);
        }
        
    
        
    
}
