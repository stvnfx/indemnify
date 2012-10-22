package za.co.cascott.template.engine;

import org.junit.*;
import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;
import java.util.HashMap;

import za.co.cascott.template.engine.*;

public class MustacheEngineTest {

    MustacheEngine tEngine;

    @Before
    public void setUp() {
        tEngine = new MustacheEngine();
    }

    @Test
    public void getVariable() {
        tEngine.setVariable("Green", "Day");
        assertThat(tEngine.getVariable("Green"), is("Day"));
    }

    @Test
    public void addVariables() {
        //Add a few vars to Map type
        HashMap m = new HashMap();
        m.put("Donkey", "Kong");
        m.put("Half", "Life");
        m.put("Indemnity", "Insurance");
        m.put("Live", "Dead");
        m.put("Keyboard", "Mouse");
        tEngine.setVariables(m);

        assertThat(tEngine.getVariable("Donkey"), is("Kong"));
        assertThat(tEngine.getVariable("Half"), is("Life"));
        assertThat(tEngine.getVariable("Indemnity"), is("Insurance"));
        assertThat(tEngine.getVariable("Live"), is("Dead"));
        assertThat(tEngine.getVariable("Keyboard"), is("Mouse"));
    }

    @Test
    public void addSingleVariable() {
        tEngine.setVariable("Half", "Life");
        assertThat(tEngine.getVariable("Half"), is("Life"));
        assertThat(tEngine.getVariable("Half"), is(not("Portal")));
    }

    @Test
    public void removeVariables() {
        //Add a few vars to Map type
        HashMap m = new HashMap();
        m.put("Donkey", "Kong");
        m.put("Half", "Life");
        m.put("Indemnity", "Insurance");
        m.put("Live", "Dead");
        m.put("Keyboard", "Mouse");
        tEngine.setVariables(m);
        tEngine.removeVariable("Donkey");
        tEngine.removeVariable("Keyboard");
        assertNull(tEngine.getVariable("Donkey"));
        assertNotNull(tEngine.getVariable("Half"));
    }

    @Test
    public void clearVariables() {
        tEngine.setVariable("Cake", "Is a Lie");
        tEngine.clearVariables();
        assertNull(tEngine.getVariable("Cake"));
    }

    @Test
    public void generate() {
        String templateReal = "Hi Mickey Mouse, Please fetch your Mustang Convertable at Oak Avenue.";
        String templateGen = "Hi {{name}}, Please fetch your {{object}} at {{address}}.";

        String templateIncReal = "Hi Mickey Mouse, Please fetch your {{object}} at Oak Avenue.";
        String templateIncorrect = "Hi {{name}}, Please fetch your {{object}} at {{address}}.";

        tEngine.setVariable("name", "Mickey Mouse");
        tEngine.setVariable("object", "Mustang Convertable");
        tEngine.setVariable("address", "Oak Avenue");
        tEngine.setTemplate(templateGen);
        tEngine.generate();
        assertThat(tEngine.getTemplate(), is(templateReal));
        assertThat(tEngine.getTemplate(), is(templateReal));
    }

}
