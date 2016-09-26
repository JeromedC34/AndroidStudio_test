package com.jerome.test;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

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
        textView6.setText("Text to scramble (" + strToScramble + ")? " + String.valueOf(scrambleTextWords(strToScramble)) + "\n");
        int nbMaxFibonacci = 9;
        TextView textView7 = (TextView) findViewById(R.id.text7);
        textView7.setText("Fibonacci iterative (" + nbMaxFibonacci + ")? " + String.valueOf(getFibonacciSeriesIte(nbMaxFibonacci)) + "\n");
        TextView textView8 = (TextView) findViewById(R.id.text8);
        textView8.setText("Fibonacci recursive (" + nbMaxFibonacci + ")? " + String.valueOf(getFibonacciSeriesRec(nbMaxFibonacci)) + "\n");
        TextView textView9 = (TextView) findViewById(R.id.text9);

        StringBuilder result9 = new StringBuilder("");
        List<String> stringList = new ArrayList<>();
        stringList.add("une chaîne");
        stringList.add("une chaîne bis");
        stringList.set(1, "abcde");
        Map<String, Object> map = new HashMap<>();
        map.put("noel", new Date("24 dec 2016"));
        map.put("fete nationale", new Date("14 jul 2017"));

        for (String key : map.keySet()) {
            result9.append("\nà la clé ").append(key).append(" est associé ").append(map.get(key).toString());
        }

        textView9.setText("List + Map : " + stringList.toString() + " / " + result9 + "\n");

        Intervalle i1 = new Intervalle(0,10);
        Intervalle i2 = new Intervalle(5,25);
        TextView textView10 = (TextView) findViewById(R.id.text10);
        textView10.setText("i1 : " + i1 + "\n");
        TextView textView11 = (TextView) findViewById(R.id.text11);
        textView11.setText("i2 : " + i2 + "\n");
        TextView textView12 = (TextView) findViewById(R.id.text12);
        textView12.setText("i1.intersection(i2) = " + i1.intersection(i2) + "\n");
        TextView textView13 = (TextView) findViewById(R.id.text13);
        textView13.setText("i1.union(i2) = " + i1.union(i2) + "\n");

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public String getFibonacciSeriesIte(int nbMax) {
        StringBuilder result = new StringBuilder("");
        int twoBefore = 1;
        int oneBefore = 1;
        int currentValue;
        if (nbMax > 0) {
            for (int i = 1; i <= nbMax; i++) {
                if (i == 1 || i == 2) {
                    result.append("1 ");
                } else {
                    currentValue = twoBefore + oneBefore;
                    result.append(currentValue).append(" ");
                    twoBefore = oneBefore;
                    oneBefore = currentValue;
                }
            }
        } else {
            return "n/a";
        }
        return result.toString();
    }

    public String getFibonacciSeriesRec(int nbMax) {
        if (nbMax == 1) {
            return "1 ";
        } else if (nbMax == 2) {
            return getFibonacciSeriesRec(1) + "1 ";
        } else if (nbMax > 2) {
            return getFibonacciSeriesRec(nbMax - 1) + (getFibonacci(nbMax - 1) + getFibonacci(nbMax - 2)) + " ";
        } else {
            return "0";
        }
    }

    public int getFibonacci(int nbMax) {
        if (nbMax == 1 || nbMax == 2) {
            return 1;
        } else if (nbMax > 2) {
            return (getFibonacci(nbMax - 1) + getFibonacci(nbMax - 2));
        } else {
            return 0;
        }
    }

    // get a string with each word (separated only by space) scrambled
    public String scrambleTextWords(String aString) {
        StringBuilder result = new StringBuilder("");
        // current word to be scrambled when complete
        StringBuilder aWord = new StringBuilder("");
        for (int i = 0; i < aString.length(); i++) {
            // if there is a space it means a new word may have ended (or heading space case)
            if (aString.charAt(i) == ' ') {
                // if a word had started it is now ended
                if (!(aWord.toString().equals(""))) {
                    // append the scrambled word to the result
                    result.append(scrambleString(aWord.toString())).append(" ");
                    // the current word is emptied
                    aWord.delete(0, aWord.length() - 1);
                } else {
                    // the space is added to the result (no current word)
                    result.append(' ');
                }
            } else {
                // the current word is appended with the current character
                aWord.append(aString.charAt(i));
            }
        }
        // if there is still a current word (string not finishing by space)
        if (!(aWord.toString().equals(""))) {
            // append the scrambled word to the result
            result.append(scrambleString(aWord.toString()));
        }
        return result.toString();
    }

    // change the order of characters in a string
    private String scrambleString(String aString) {
        StringBuilder result = new StringBuilder("");
        // this will be modified by removing each character already used
        StringBuilder result_tmp = new StringBuilder(aString);
        Random rand = new Random();
        int randomInt;
        for (int i = 0; i < aString.length(); i++) {
            // get a new random character index in the remaining ones
            randomInt = rand.nextInt(result_tmp.length());
            // add the character at the random index to the result
            result.append(result_tmp.charAt(randomInt));
            // remove the used character
            result_tmp.deleteCharAt(randomInt);
        }
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
        // there are nbOpenedBrackets closing bracket missing
        if (nbOpenedBrackets > 0) {
            result = false;
        }
        return result;
    }

    public String autoOverallTrim(String aString) {
        return aString.trim().replaceAll("\\s+", " ");
    }

    public String manualOverallTrim(String aString) {
        StringBuilder result = new StringBuilder("");
        StringBuilder result_tmp = new StringBuilder(manualLTrim(manualRTrim(aString)));
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

    public String manualLTrim(String aString) {
        StringBuilder result = new StringBuilder(aString);
        while (result.charAt(0) == ' ') {
            result.deleteCharAt(0);
        }
        return result.toString();
    }

    public String manualRTrim(String aString) {
        StringBuilder result = new StringBuilder(aString);
        while (result.charAt(result.length() - 1) == ' ') {
            result.deleteCharAt(result.length() - 1);
        }
        return result.toString();
    }

    public boolean isPalindrome(String aString) {
        boolean result = true;
        String stringLower = aString.toLowerCase();
        int aLength = stringLower.length();
        for (int i = aLength; i > aLength / 2; i--) {
            result = result && (stringLower.charAt(i - 1) == stringLower.charAt(aLength - i));
        }
        return result;
    }

    public String reverse(String aString) {
        StringBuilder result = new StringBuilder("");
        for (int i = aString.length(); i > 0; i--) {
            result.append(aString.charAt(i - 1));
        }
        return result.toString();
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
