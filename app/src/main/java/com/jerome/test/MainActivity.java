package com.jerome.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String testPalindrome1 = "Hello World!";
        TextView textView1 = (TextView) findViewById(R.id.text1);
        textView1.setText("Reverse (" + testPalindrome1 + ") : " + reverse(testPalindrome1) + "\n");
        String testPalindrome2 = "Laval";
        TextView textView2 = (TextView) findViewById(R.id.text2);
        textView2.setText("Is palindrome (" + testPalindrome2 + ")? " + String.valueOf(isPalindrome(testPalindrome2)) + "\n");
        String testTrim = "       1   2    3        4       5       ";
        TextView textView3 = (TextView) findViewById(R.id.text3);
        textView3.setText("ManualTrim (" + testTrim + ")? >>>" + manualOverallTrim(testTrim) + "<<<" + "\n");
        TextView textView4 = (TextView) findViewById(R.id.text4);
        textView4.setText("AutoTrim (" + testTrim + ")? >>>" + autoOverallTrim(testTrim) + "<<<" + "\n");
        String strBrackets = "((toto)())";
        TextView textView5 = (TextView) findViewById(R.id.text5);
        textView5.setText("Check brackets (" + strBrackets + ")? " + String.valueOf(checkBrackets(strBrackets)) + "\n");
        String strToScramble = "les lapins bleus ont mangé toutes les carottes";
        TextView textView6 = (TextView) findViewById(R.id.text6);
        textView6.setText("Text to scamble (" + strToScramble + ")? " + String.valueOf(scrambleTextWords(strToScramble)) + "\n");
    }

    // get a string with each word (separated only by space) scrambled
    public String scrambleTextWords(String mot) {
        // result string
        StringBuilder result = new StringBuilder("");
        // current word to be scrambled when complete
        StringBuilder unMot = new StringBuilder("");
        // for each input character
        for (int i = 0; i < mot.length(); i++) {
            // if there is a space it means a new word may have ended (or heading space case)
            if (mot.charAt(i) == ' ') {
                // if a word had started it is now ended
                if (!unMot.equals("")) {
                    // append the scrambled word to the result
                    result.append(scrambleString(unMot.toString()) + " ");
                // the space is added to the result (no current word)
                } else {
                    result.append(' ');
                }
                // the current word is emptied
                unMot = new StringBuilder("");
            } else {
                // the current word is appended with the current character
                unMot.append(mot.charAt(i));
            }
        }
        // if there is still a current word (string not finishing by space)
        if (!unMot.equals("")) {
            // append the scrambled word to the result
            result.append(scrambleString(unMot.toString()));
        }
        // return the result as a string
        return result.toString();
    }

    // change the order of characters in a string
    private String scrambleString(String mot) {
        // result string
        StringBuilder result = new StringBuilder("");
        // this will be modified by removing each character already used
        StringBuilder tmp_result = new StringBuilder(mot);
        // random object
        java.util.Random rand = new java.util.Random();
        // random number
        int nombreAleatoire = 0;
        // for each input character
        for (int i = 0; i < mot.length(); i++) {
            // get a new random offset in the remaining characters
            nombreAleatoire = rand.nextInt(tmp_result.length());
            // add the character at the random offset to the result
            result.append(tmp_result.charAt(nombreAleatoire));
            // remove the used random character
            tmp_result.deleteCharAt(nombreAleatoire);
        }
        // return the result as a string
        return result.toString();
    }

    // check if the opening and closing brackets are well ordered
    public boolean checkBrackets(String bracketsString) {
        boolean result = true;
        int nbOpenedBrackets = 0;
        for (int i = 0; i < bracketsString.length(); i++) {
            // only 2 interesting cases here, opening and closing brackets
            if (bracketsString.charAt(i) == '(') {
                // add 1 level of opened brackets
                nbOpenedBrackets++;
            } else if (bracketsString.charAt(i) == ')') {
                // check if at least 1 bracket has been opened
                if (nbOpenedBrackets > 0) {
                    nbOpenedBrackets--;
                // else there has been a problem, exit the loop
                } else {
                    result = false;
                    break;
                }
            }
        }
        // there are nbOpenedBrackets closing brackett missing
        if (nbOpenedBrackets > 0) {
            result = false;
        }
        return result;
    }

    public String autoOverallTrim(String mot) {
        return mot.trim().replaceAll("\\s+", " ");
    }

    public String manualOverallTrim(String mot) {
        StringBuilder result = new StringBuilder("");
        StringBuilder result_tmp = new StringBuilder(manualLTrim(manualRTrim(mot)));
        boolean testMultipleSpaces = false;
        for (int i = 0; i < result_tmp.length(); i++) {
            if (result_tmp.charAt(i) == ' ') {
                if (!testMultipleSpaces) {
                    result.append(result_tmp.charAt(i));
                    testMultipleSpaces = true;
                }
            } else {
                testMultipleSpaces = false;
                result.append(result_tmp.charAt(i));
            }
        }
        return result.toString();
    }

    public String manualLTrim(String mot) {
        StringBuilder result = new StringBuilder(mot);
        while (result.charAt(0) == ' ') {
            result.deleteCharAt(0);
        }
        return result.toString();
    }

    public String manualRTrim(String mot) {
        StringBuilder result = new StringBuilder(mot);
        while (result.charAt(result.length() - 1) == ' ') {
            result.deleteCharAt(result.length() - 1);
        }
        return result.toString();
    }

    public boolean isPalindrome(String mot) {
        boolean result = true;
        String stringLower = mot.toLowerCase();
        int longueur = stringLower.length();
        for (int i = longueur; i > longueur / 2; i--) {
            result = result && (stringLower.charAt(i - 1) == stringLower.charAt(longueur - i));
        }
        return result;
    }

    public String reverse(String mot) {
        StringBuilder result = new StringBuilder("");
        for (int i = mot.length(); i > 0; i--) {
            result.append(mot.charAt(i - 1));
        }
        return result.toString();
    }
}
