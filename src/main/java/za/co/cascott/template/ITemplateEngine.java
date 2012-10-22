package za.co.cascott.template;

import java.util.Map;

public interface ITemplateEngine {

    /**
     * Set the template input.
     */
    public void setTemplate(String location);

    /**
     * get template output.
     */
    public String getTemplate();

    /**
     * Set a hole lot of variables at once.
     */
    public void setVariables(Map vars);

    /**
     * Add a variable to the template
     */
    public void setVariable(String varname, String varvalue);

    /**
     * Remove a variable from the document
     */
    public void removeVariable(String varname);

    /**
     * Get a var from the engine.
     */
    public String getVariable(String varname);

    /**
     * Remove all variables
     */
    public void clearVariables();

    /**
     * Generate output from template and variables.
     */
    public void generate();
}
