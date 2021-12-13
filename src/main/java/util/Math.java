package util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Math {
    public static boolean canParseToInt(String s){
        try{
            Integer.parseInt(s);
            return true;
        }catch (NumberFormatException ex){
            return false;
        }
    }
    public static String getLetters(String s){
        return s.split("(?<=\\D)(?=\\d)")[1];
    }

    public static String[] splitToIntString(String s){
        List<String> output = new ArrayList<String>();
        Matcher match = Pattern.compile("[0-9]+|[a-z]+|[A-Z]+").matcher(s);
        while (match.find()) {
            output.add(match.group());
        }
        System.out.println(output.get(0));
        return output.toArray(String[]::new);
    }


}

/*
    public static int removeLetters(String s){
            StringBuilder result = new StringBuilder();
            for(Character c : s.toCharArray()){
                String string = String.valueOf(c);

                if(canParseToInt(string))result.append(string);
            }
            return Integer.parseInt(result.toString());
        }
 */