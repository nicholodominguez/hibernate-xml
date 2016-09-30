package com.ecc.ems;

import java.util.Scanner;
import org.apache.commons.lang3.StringUtils;
public final class InputValidator{
    
    public static int getInputInt(String msg, boolean nonZero){
        Scanner sc = new Scanner(System.in);
        boolean isAlpha = true;
        int floor = nonZero?1:0;
        String limit = nonZero?"one":"zero";
        int row = 0;
        
        while(isAlpha){
            try{
                System.out.print(msg);
                row = Integer.parseInt(sc.nextLine());
                if(row < floor){
                    System.out.println("Integer too low, it should be greater than "+limit);    
                }
                else isAlpha = false;
            }catch(NumberFormatException e){
                isAlpha = true;
                System.out.println("Input not an integer");
            }
        }    
        

        return row;    
    }

    public static int getInputMenu(String msg, int size){
        Scanner sc = new Scanner(System.in);
        boolean isAlpha = true;
        int floor = 1;
        String limit = "one";
        int row = 0;
        
        while(isAlpha){
            try{
                System.out.print(msg);
                row = Integer.parseInt(sc.nextLine());
                if(row < floor){
                    System.out.println("Integer too low, it should be greater than "+limit);    
                }
                else if(row > size){
                    System.out.println("Integer too high, it should be less than "+size);    
                }
                else isAlpha = false;
            }catch(NumberFormatException e){
                isAlpha = true;
                System.out.println("Input not an integer");
            }
        }    
        

        return row;    
    }
    
    public static String getInputStr(String msg, int maxLen){
        Scanner sc = new Scanner(System.in);
        boolean isValid = false;
        String input = "";

        while(!isValid){
            System.out.print(msg);
            if(sc.hasNextLine()){
                input = sc.nextLine();
                if(input.length() > maxLen*2){
                    System.out.println("Input too long. Max char of " + maxLen);               
                }
                else if (!StringUtils.isAsciiPrintable(input)) {
                    System.out.println("Contains invalid character.");
                }
                else{
                    return input;     
                }
            }           
        }
        
        return null;
    } 
}
