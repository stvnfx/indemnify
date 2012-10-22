package za.co.cascott.fop;

import org.apache.fop.apps.FOPException;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;
import za.co.cascott.Utils;
import za.co.cascott.template.ITemplateEngine;

import javax.xml.transform.*;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;

public class FOP {

    private static FOP instance = null;

    private FopFactory fopFactory;

    protected FOP() {
        fopFactory = FopFactory.newInstance();
    }

    public static FOP getInstance() {
        if (instance == null) {
            instance = new FOP();
        }
        return instance;
    }

    public void processFile(final String fileinput, final String fileoutput, final ITemplateEngine templateEngine) {

        StringBuilder templateIn = new StringBuilder();
        OutputStream out;

        try {
            String tmpfilename = Utils.TempFiles.getInstance().getInternalFile(fileinput);
            File file = new File(tmpfilename);
            FileReader fr;
            //Read the input and place it inside templateIn
            {
                int r = 0;
                try {
                    fr = new FileReader(file);
                    r = fr.read();
                    while (r != -1) {
                        templateIn.append((char) r);
                        r = fr.read();
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            templateEngine.setTemplate(templateIn.toString());
            templateEngine.generate();
            out = new BufferedOutputStream(new FileOutputStream(new File(fileoutput)));
            // Step 3: Construct fop with desired output format
            Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, out);
            // Step 4: Setup JAXP using identity transformer
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(); // identity transformer
            // Step 5: Setup input and output for XSLT transformation
            // Setup input stream
            InputStream is = new ByteArrayInputStream(templateEngine.getTemplate().getBytes());
            //Source src = new StreamSource(new File(fileinput));
            Source src = new StreamSource(is);
            // Resulting SAX events (the generated FO) must be piped through to FOP
            Result res = new SAXResult(fop.getDefaultHandler());
            // Step 6: Start XSLT transformation and FOP processing
            transformer.transform(src, res);
            out.close();
        } catch (FOPException | TransformerFactoryConfigurationError | TransformerException | IOException e) {
        } finally {
            //Clean-up
        }
    }

}
