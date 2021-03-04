package cp213;

import java.util.Scanner;

public class Decipher {
    public static final String ALPHA = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final int ALPHA_LENGTH = ALPHA.length();

    public static void main(String[] args) {
        final String CIPHERTEXT = "AVIBROWNZCEFGHJKLMPQSTUXYD";
        Scanner keyboard = new Scanner(System.in);
        
        String cipher = "";
        int shiftNum = 0;
        String finalShift = "";
        String Sub = "";
        
        
        System.out.println("Enter a cipher string: ");
        cipher = keyboard.nextLine();
        
        System.out.println("Enter a shift length: ");
        shiftNum = keyboard.nextInt();
        
        finalShift = shift(cipher,shiftNum);
        Sub = subsitute(cipher,CIPHERTEXT);
        
        System.out.println("Plain text for shift: "+finalShift);
        System.out.println("Plain text for substitute: "+Sub);
        
        keyboard.close();
        
    }
    
    public static String shift(String s, int n) {
        String shifted = "";
        
        for(int i=0; i<s.length(); i++) {
            int x = 0;
            if(Character.isLetter(s.charAt(i))) {
                while(!(ALPHA.substring(x, x+1)).equals(s.substring(i, i+1).toUpperCase())) {
                    x += 1;
                }
            int shift = 0;
            while(shift != n) {
                if(x==0) {
                    x = 25;
                }else {
                    x -= 1;
                }
                shift +=  1;
            }
            shifted = shifted + ALPHA.substring(x, x+1);
            }else {
                shifted = shifted + s.substring(i, i+1);
            }
        }
        return shifted;
    }
    public static String subsitute(String s, String ciphertext) {
        String shifted = "";
        
        for(int i = 0; i<s.length(); i++) {
            int x = 0;
            if(Character.isLetter(s.charAt(i))) {
                while(!(ciphertext.substring(x, x+1)).equals(s.substring(i, i+1).toUpperCase())) {
                    x += 1;
                }
                shifted = shifted + ALPHA.substring(x, x+1);
            }
        }
        return shifted;
        
    }

}

