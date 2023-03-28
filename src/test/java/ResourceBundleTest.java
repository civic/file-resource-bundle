import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class ResourceBundleTest {
    @Test
    public void test_default() throws Exception{
        ResourceBundle bundle = PropertyResourceBundle.getBundle("mail", Locale.ROOT);

        String resourceName = bundle.getString("body");
        String mailBody =
                new String(this.getClass().getResourceAsStream(resourceName).readAllBytes(), StandardCharsets.UTF_8);

        assertEquals("Hello\nWorld\n", mailBody);
    }
    @Test
    public void test_ja() throws Exception{
        ResourceBundle bundle = PropertyResourceBundle.getBundle("mail", Locale.JAPANESE);

        String resourceName = bundle.getString("body");
        String mailBody =
                new String(this.getClass().getResourceAsStream(resourceName).readAllBytes(), StandardCharsets.UTF_8);

        assertEquals("おはよう\nこんにちは\n", mailBody);
    }

    @Test
    public void test_jaJP() throws Exception{
        ResourceBundle bundle = PropertyResourceBundle.getBundle("mail", Locale.JAPAN);

        String resourceName = bundle.getString("body");
        String mailBody =
                new String(this.getClass().getResourceAsStream(resourceName).readAllBytes(), StandardCharsets.UTF_8);

        assertEquals("おはよう\nこんにちは\n", mailBody);
    }
}
