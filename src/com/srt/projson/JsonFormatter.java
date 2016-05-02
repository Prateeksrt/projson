package com.srt.projson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class JsonFormatter {
    private static List<Character> forwardTabDelimiters = Arrays.asList('{', '[');
    private static List<Character> backwardTabDelimiter = Arrays.asList('}', ']');
    private static List<Character> separator = Collections.singletonList(',');

    private List<String> prefixStack = new ArrayList<>();

    public String prettify(String s) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(s));
        StringBuilder prettyString = new StringBuilder();
        int buffer;
        while((buffer =  br.read())!=-1){
            char token = (char) buffer;
            if(forwardTabDelimiters.contains(token)){
                prettyString.append(token);
                prettyString.append("\n");
                prefixStack.add("\t");
                prettyString.append(getStack());
            } else if (backwardTabDelimiter.contains(token)){
                prefixStack.remove(prefixStack.size()-1);
                prettyString.append("\n");
                prettyString.append(getStack());
                prettyString.append(token);
            } else if(separator.contains(token)){
                prettyString.append(token);
                prettyString.append("\n");
                prettyString.append(getStack());
            }else {
                prettyString.append(token);
            }
        }
        return prettyString.toString();
    }

    private String getStack(){
        StringBuilder builder = new StringBuilder();
        for(String string : prefixStack){
            if(string == null) continue;
            builder.append(string);
        }
        return builder.toString();
    }
}
