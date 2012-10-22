package za.co.cascott.template.engine;

import com.samskivert.mustache.Mustache;
import com.samskivert.mustache.Template;
import za.co.cascott.template.ITemplateEngine;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MustacheEngine implements ITemplateEngine {

    private static Logger logger = Logger.getLogger(MustacheEngine.class.getName());
    private Template template;
    private String templateData;
    private HashMap vars;
    private String filename;

    public MustacheEngine() {
        vars = new HashMap();
    }

    public void setTemplate(String data) {
        this.templateData = data;
    }

    public String getTemplate() {
        return templateData;
    }

    public void setVariables(Map map) {
        vars.putAll(map);
    }

    public void setVariable(String varname, String varvalue) {
        if (vars.containsKey(varname) && vars.containsValue(varvalue)) {
            logger.log(Level.FINE, "Variable " + varname + " with the value of " + varvalue + " already exists.");
            return;
        } else {
            vars.put(varname, varvalue);
            logger.log(Level.FINE, "Added variable " + varname + " with the value of " + varvalue + ".");
        }
    }

    public void removeVariable(String varname) {
        if (vars.containsKey(varname))
            vars.remove(varname);
        logger.log(Level.FINE, "Removed " + varname + " variable.");
    }

    public String getVariable(String varname) {
        if (vars.containsKey(varname)) {
            return (String) vars.get(varname);
        }
        logger.log(Level.FINE, "Variable " + varname + ", does not exist.");
        return null;
    }

    public void clearVariables() {
        vars = new HashMap();
        logger.log(Level.FINE, "New variable HashMap.");
    }

    public void generate() {
        logger.log(Level.FINE, "Generating Template");
        //Use defaultValue not to throw Exception on missing or null variables.
        this.template = Mustache.compiler().defaultValue("").compile(templateData);
        this.templateData = this.template.execute(vars);
    }


    public String getLastGenFileString() {
        return filename;
    }

}
