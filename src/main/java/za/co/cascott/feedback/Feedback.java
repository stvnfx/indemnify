package za.co.cascott.feedback;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import java.awt.*;

public class Feedback extends JDialog {

    private final JPanel contentPanel = new JPanel();

    public Feedback() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(Feedback.class.getResource("/assets/icons/balloon.png")));
        setTitle("Feedback");
        setBounds(100, 100, 483, 330);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(new FormLayout(new ColumnSpec[]{
                FormFactory.RELATED_GAP_COLSPEC,
                FormFactory.DEFAULT_COLSPEC,
                FormFactory.RELATED_GAP_COLSPEC,
                ColumnSpec.decode("default:grow"),},
                new RowSpec[]{
                        FormFactory.RELATED_GAP_ROWSPEC,
                        FormFactory.DEFAULT_ROWSPEC,
                        FormFactory.RELATED_GAP_ROWSPEC,
                        FormFactory.DEFAULT_ROWSPEC,
                        FormFactory.RELATED_GAP_ROWSPEC,
                        FormFactory.DEFAULT_ROWSPEC,
                        FormFactory.RELATED_GAP_ROWSPEC,
                        RowSpec.decode("default:grow"),}));
        {
            JLabel label = new JLabel("");
            label.setIcon(new ImageIcon(Feedback.class.getResource("/assets/icons/balloon_big.png")));
            contentPanel.add(label, "2, 2");
        }
        {
            JLabel lblThankYou = new JLabel("<html>\r\n<h3>Indemnity Insurance Feedback.</h3>\r\nThank you for taking the time to send us your feedback.\r\nPlease send us any feedback related to the Indemnity Insurance application.\r\n<br><br>\r\n<i>*This requires internet access.</i>\r\n</html>");
            contentPanel.add(lblThankYou, "4, 2");
        }
        {
            JLabel lblEmail = new JLabel("Title:");
            contentPanel.add(lblEmail, "2, 6, right, default");
        }
        {
            JFormattedTextField formattedTextField = new JFormattedTextField();
            contentPanel.add(formattedTextField, "4, 6, fill, default");
        }
        {
            JLabel lblMessage = new JLabel("Message:");
            contentPanel.add(lblMessage, "2, 8, right, top");
        }
        {
            JPanel panel = new JPanel();
            panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
            contentPanel.add(panel, "4, 8, fill, fill");
            panel.setLayout(new BorderLayout(0, 0));
            {
                JTextPane textPane = new JTextPane();
                panel.add(textPane);
            }
        }
        {
            JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
                JButton okButton = new JButton("OK");
                okButton.setIcon(new ImageIcon(Feedback.class.getResource("/assets/icons/tick.png")));
                okButton.setActionCommand("OK");
                buttonPane.add(okButton);
                getRootPane().setDefaultButton(okButton);
            }
            {
                JButton cancelButton = new JButton("Cancel");
                cancelButton.setIcon(new ImageIcon(Feedback.class.getResource("/assets/icons/cross.png")));
                cancelButton.setActionCommand("Cancel");
                buttonPane.add(cancelButton);
            }
        }
    }

}
