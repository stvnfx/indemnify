package za.co.cascott;

import java.util.Random;

import org.junit.*;
import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import za.co.cascott.Utils;

public class UtilsTest {

    @Test
    public void databaseTest() {
        Utils.Database.getMap("Test").put("IOD", "C2");
        Utils.Database.save("Test");
    }

    @Test
    public void getRandomStringTest() {
        Random a = new Random();
        int size = a.nextInt(64);
        String randomString = Utils.getRandomString(size);
        assertThat(randomString.length(), is(size));
    }
}
