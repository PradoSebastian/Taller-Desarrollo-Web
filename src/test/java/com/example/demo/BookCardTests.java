package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.demo.useCases.BookCardFinder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookCardTests {

    private BookCardFinder bookCardFinder;

    @BeforeEach
    public void setUp() {
        //bookCardFinder = new BookCardFinder();
    }

    @Test
    @DisplayName("Book card from a book - Html")
    void bookCardVersion1Test() {
        //bookCardFinder = new BookCardFinder(new HtmlFormater(), new RaleyEmailSender("ejemplo@gmail.com"));
        String result = bookCardFinder.execute();
        String expected = "<p>The book La bruma infinita has been written by David and was published in 2010. The book's price is 42000.0</p>";
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Book card from a book - Json")
    void bookCardVersion2Test() {
        //bookCardFinder = new BookCardFinder(new JsonFormater(), new RaleyEmailSender("ejemplo@gmail.com"));
        String result = bookCardFinder.execute();
        String expected = "{ 'bookCard' : 'The book La bruma infinita has been written by David and was published in 2010. The book's price is 42000.0' }";
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Book card from a book - Xml")
    void bookCardVersion3Test() {
        //bookCardFinder = new BookCardFinder(new XmlFormater(), new RaleyEmailSender("ejemplo@gmail.com"));
        String result = bookCardFinder.execute();
        String expected = "<element att='bookCard'>The book La bruma infinita has been written by David and was published in 2010. The book's price is 42000.0</element>";
        assertEquals(expected, result);
    }

}
