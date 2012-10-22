/*
 * Author: Steven Fourie.
 */

def jarlist = []

def reg = ~/.*\.jar/
new File("dist/jaws/lib/").eachFileMatch(reg) { 
    f ->
    def fsize = new File(f.toString()).length()
    def m = [name: f.getName(), size: fsize]
    jarlist.add(m)
}

def out = ""

jarlist.each {
    f ->
    
    def fname = f["name"]
    def fsize = f["size"]
    def tempString = """<jar href="lib/${fname}" download="eager" size="${fsize}" />\n"""
    out += tempString
}

def jnlp = """
<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<jnlp spec="6.0+" codebase="http://cascott.co.za/download/indemnity/jaws/" href="Indemnify.jnlp">
  <information>
    <title>Indemnity Insurance Document Generator.</title>
    <description>Indemnity Insurance Document generator. Visit http://cascott.co.za/financial-tools/fidelity-insurance-assessment for more information.</description>
    <description kind="short">Indemnity Insurance Document generator.</description>
    <vendor>CA Scott.</vendor>
    <homepage href="http://cascott.co.za/"/>
    <offline-allowed/>
    <icon href="main.ico" kind="shortcut"/>
    <icon href="main.ico"/>
    <shortcut online="true">
      <desktop/>
      <menu submenu="CA Scott"/>
    </shortcut>
  </information>
  <update check="always" policy="prompt-update"/>
  <security>
      <all-permissions/>
  </security>
  <resources>
    <!-- <property name="jnlp.packEnabled" value="true"/> -->
    <j2se version="1.6.0+" />
    <jar href="lib/Indemnify.jar" main="true" download="eager"/>
    ${out}
  </resources>
  <application-desc main-class="za.co.cascott.indemnity.Main"/>
</jnlp>
"""

println jnlp
