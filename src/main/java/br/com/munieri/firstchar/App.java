package br.com.munieri.firstchar;

import java.util.*;

public class App {

    public static char firstChar(Stream stream) {

        Map<Character, Integer> chars = new LinkedHashMap();
        String vogais = "(?i)[aeiou]";

        while (stream.hasNext()) {
            final char next = stream.getNext();
            int size = chars.getOrDefault(next, 0);
            ++size;
            chars.put(next, size);
        }

        for (Map.Entry<Character, Integer> entry : chars.entrySet()) {
            if(entry.getValue() == 1 && entry.getKey().toString().matches(vogais)){
                return entry.getKey();
            }
        }
        throw new IllegalArgumentException("Não foi encontrato caracter com apenas uma ocorrência.");
    }
}
