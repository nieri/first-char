package br.com.munieri.firstchar;

public class StreamImpl implements Stream {

    private int cursor;
    private final char[] stream;

    public StreamImpl(String stream) {
        this.stream = stream.toCharArray();
    }

    public char getNext() {
        char result = stream[cursor];
        cursor++;
        return result;
    }

    public boolean hasNext() {
        return cursor < stream.length;
    }
}
