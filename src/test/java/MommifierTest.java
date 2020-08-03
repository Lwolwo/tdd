import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MommifierTest {
    @Test
    void should_insert_mommy_into_continuous_set_of_vowels_when_numbers_of_vowels_more_than_30percent_given_string() throws StringNullException {
        String result = new Momifier().convert("aaabbooba");
        assertEquals("amommyamommyamommybbomommyomommyba", result);
    }

    @Test
    void should_return_string_when_numbers_of_vowels_more_than_30percent_but_not_continuous_given_string() throws StringNullException {
        String result = new Momifier().convert("ababab");
        assertEquals("ababab", result);
    }

    @Test
    void should_return_string_when_numbers_of_vowels_equal_or_less_than_30percent_given_string() throws StringNullException {
        String result = new Momifier().convert("abCCC");
        assertEquals("abCCC", result);
    }

    @Test
    void throw_exception_when_string_is_null() throws StringNullException {
        StringNullException stringNullException = assertThrows(StringNullException.class, () -> {
            new Momifier().convert("");
        });
        assertEquals("String is Null", stringNullException.getMessage());
    }
}
