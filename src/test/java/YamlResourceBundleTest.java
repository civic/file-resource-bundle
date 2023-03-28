import dev.akkinoc.util.YamlResourceBundle;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.Locale;
import java.util.ResourceBundle;

public class YamlResourceBundleTest {

    @Test
    public void test_default() throws Exception {
        ResourceBundle bundle = ResourceBundle.getBundle("yaml_resource_bundle.mail", Locale.ROOT,
                YamlResourceBundle.Control.INSTANCE);
        assertEquals("Mail Subject", bundle.getString("mail.title"));
        assertEquals("Hello\nWorld\n", bundle.getString("mail.body"));
        assertEquals("1", bundle.getString("mail.foo"));

    }

    @Test
    public void test_ja() throws Exception {
        ResourceBundle bundle = ResourceBundle.getBundle("yaml_resource_bundle.mail", Locale.JAPANESE,
                YamlResourceBundle.Control.INSTANCE);
        assertEquals("メール件名", bundle.getString("mail.title"));
        assertEquals("おはよう\nこんにちは\n", bundle.getString("mail.body"));
        assertEquals("2", bundle.getString("mail.foo"));
    }

    @Test
    public void test_jaJP() throws Exception {
        ResourceBundle bundle = ResourceBundle.getBundle("yaml_resource_bundle.mail", Locale.JAPAN,
                YamlResourceBundle.Control.INSTANCE);
        assertEquals("メール件名", bundle.getString("mail.title"));
        assertEquals("おはよう\nこんにちは\n", bundle.getString("mail.body"));
        assertEquals("2", bundle.getString("mail.foo"));

    }
}
