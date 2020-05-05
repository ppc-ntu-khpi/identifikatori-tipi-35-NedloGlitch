package domain;

public class Exercise {
    public static String Calculate(String sentence){
        String[] words = sentence.split(" ");  
        int arrlength = 0;
        byte longest = 0;

        for(byte i=0;i<words.length;i++){
            if(words[i].length()>longest && words[i]!="END_POINT")
                    longest=(byte) words[i].length();
        }
        for(byte i=0;i<words.length;i++){
                if(i>0 && words[i-1].length()<=longest && words[i].length() < longest-words[i-1].length()){
                    words[i-1] = words[i-1] + "_" + words[i];
                    for(byte j=(byte) (i);j<words.length;j++){
                        if(j==words.length-1 || words[j+1] == "END_POINT")
                            words[j]="END_POINT";
                        else if (i>0)
                        words[j] = words[j+1];
                    }
                }

                else if(i<words.length-1 && words[i+1]!="END_POINT"&& words[i+1].length()<=longest && words[i].length() < longest-words[i+1].length()){
                    words[i] = words[i] + "_" + words[i+1];
                    for(byte j=(byte) (i+1);j<words.length;j++){
                        if(j==words.length-1 || words[j+1] == "END_POINT")
                            words[j]="END_POINT";
                        else
                        words[j] = words[j+1];
                    }
                }
            if(words[i]!="END_POINT"){
                arrlength++;
            }
        }
        

        char[][] symbols = new char[arrlength][longest]; //Должно получится [Слово][Его буквы]
        for(byte i=0;i<arrlength;i++){ //Иду по словам
            char[] temp = words[i].toCharArray(); //Создал временный массив с нужным словом по буквам
            for(byte j=0;j<words[i].length();j++){ //Иду по буквам
                symbols[i][j]=temp[j]; //Ставлю буквы
            }

            for(byte j=(byte) words[i].length();j<longest;j++){
                symbols[i][j]='_';
            }
        }

        String result = "";
        for(byte i=0;i<longest;i++){ //Иду по словам
            for(byte j=0;j<arrlength;j++) //Иду по буквам
                result = result + symbols[j][i];
        }
        result = result + "\nMessage encoded with " + longest + " letters shift";
        return result;
    }
}