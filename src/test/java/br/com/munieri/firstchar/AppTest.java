package br.com.munieri.firstchar;

import org.testng.annotations.Test;

import java.util.Date;

import static org.testng.Assert.*;

public class AppTest {

    private char firstUniqueChar(Stream stream) {
        Long timeStart = new Date().getTime();
        char result = App.firstChar(stream);
        Long timeEnd = new Date().getTime();
        System.out.println("Time[" + (timeEnd - timeStart) + "]ms");
        return result;
    }

    @Test
    public void should_return_a() {
        String input = "zdfaghx";
        Stream stream = new StreamImpl(input);

        char result = firstUniqueChar(stream);
        assertEquals(result, 'a');

    }

    @Test
    public void should_return_A() {
        String input = "ABB";
        Stream stream = new StreamImpl(input);

        char result = firstUniqueChar(stream);
        assertEquals(result, 'A');

    }

    @Test
    public void should_return_e() {
        String input = "ABCDeFABCDF1";
        Stream stream = new StreamImpl(input);

        char result = firstUniqueChar(stream);
        assertEquals(result, 'e');

    }

    @Test
    public void should_return_E() {
        String input = "eeeeeeeeeeeeE";
        Stream stream = new StreamImpl(input);

        char result = firstUniqueChar(stream);
        assertEquals(result, 'E');

    }

    @Test
    public void should_return_first_char_from_all_uniques() {
        String input = "aQWERTYUIOPASDFGHJKLZXCVBNM!@#$%^&*()1234567890_+-=";
        Stream stream = new StreamImpl(input);

        char result = firstUniqueChar(stream);
        assertEquals(result, 'a');

    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void should_throw_exception(){
        String input = "AABB";
        Stream stream = new StreamImpl(input);

        char result = firstUniqueChar(stream);

    }
}