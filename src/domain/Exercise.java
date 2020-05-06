package domain;

public class Exercise {
    /**
     * Encoding algorythm
     */
    public static String Calculate(String sentence){
        /**
         * First off, initial String "sentence" is split into words String array, using space as separator.
         * "arrlength" and "longest" is initiated for later use
         */
        String[] words = sentence.split(" ");  
        byte arrlength = 0;
        byte longest = 0;
        /**
         * Calculating the longest word
         */
        for(byte i=0;i<words.length;i++){
            if(words[i].length()>longest && words[i]!="END_POINT")
                    longest=(byte) words[i].length();
        }
        /** Special cycle, that unites words
         * It uses "longest" word, to determine if words need to be united
         * If words can be united to be smaller or equal to longest word, it unites them
         * Words in array shift to the left, and "END_POINT" is set at the end of words.
         */
        for(byte i=0;i<words.length;i++){
            /** Unite with left word*/
            if(i>0 && words[i-1].length()<=longest && words[i].length() < longest-words[i-1].length()){
                words[i-1] = words[i-1] + "_" + words[i];
                for(byte j=(byte) (i);j<words.length;j++){
                    if(j==words.length-1 || words[j+1] == "END_POINT")
                        words[j]="END_POINT";
                    else if (i>0)
                    words[j] = words[j+1];
                    }
                }
                /** Unite with right word*/
            else if(i<words.length-1 && words[i+1]!="END_POINT"&& words[i+1].length()<=longest && words[i].length() < longest-words[i+1].length()){
                words[i] = words[i] + "_" + words[i+1];
                for(byte j=(byte) (i+1);j<words.length;j++){
                    if(j==words.length-1 || words[j+1] == "END_POINT")
                        words[j]="END_POINT";
                    else
                    words[j] = words[j+1];
                    }
                }
                /** 
                 * Because "words" count changes if words unite, arrlength is calculated
                 */
            if(words[i]!="END_POINT"){
                arrlength++;
            }
        }
        /**
         * Now that words are optimized, they are separated into sequence of characters
         */
        char[][] symbols = new char[arrlength][longest]; 
        for(byte i=0;i<arrlength;i++){ 
            char[] temp = words[i].toCharArray(); 
            for(byte j=0;j<words[i].length();j++){ 
                symbols[i][j]=temp[j];
            }
            /** When it's not enough space in word to be equal to longest, this cycle fills in "_" */
            for(byte j=(byte) words[i].length();j<longest;j++){
                symbols[i][j]='_';
            }
        }

        /** Finally, "result" string is filled up with letters, to form encrypted message */
        String result = "";
        for(byte i=0;i<longest;i++){ //Иду по словам
            for(byte j=0;j<arrlength;j++) //Иду по буквам
                result = result + symbols[j][i];
        }
        result = result + "\nMessage encoded with " + longest + " letters shift";
        /** Returns encrypted message */
        return result;
    }
}