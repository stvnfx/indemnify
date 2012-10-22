package za.co.cascott.feedback;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.BoxLayout;
import javax.swing.border.EtchedBorder;
import javax.swing.JCheckBox;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URLEncoder;

import za.co.cascott.ui.Spinner;

public class BugReport extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private Spinner spinner;
    private JTextArea textArea;

    /**
     * Create the dialog.
     */
    public BugReport() {
        setTitle("Report an Issue...");
        setBounds(100, 100, 467, 363);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(new MigLayout("", "[grow]", "[][][grow][][grow]"));
        {
            JLabel lblBugReport = new JLabel("<html><h2>Whats Wrong?</h2></html>");
            //lblBugReport.setIcon(new ImageIcon(BugReport.class.getResource("/assets/icons/bug_big.png")));
            contentPanel.add(lblBugReport, "cell 0 0");
        }
        {
            JLabel lblDescription = new JLabel("Tell us what is happening:");
            lblDescription.setFont(new Font("Dialog", Font.PLAIN, 12));
            contentPanel.add(lblDescription, "cell 0 1");
        }
        {
            JPanel panel = new JPanel();
            panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
            contentPanel.add(panel, "cell 0 2,grow");
            panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
            {
                textArea = new JTextArea();
                panel.add(textArea);
            }
        }
        {
            JLabel lblbySubmittingThis = new JLabel("<html>\n<p>By submitting this feedback, you agree that <b><font color=\"#6e2636\">CA Scott</font></b> may use feedback that you provide to improve any <b><font color=\"#6e2636\">CA Scott</font></b> product or service.</p><html>");
            lblbySubmittingThis.setFont(new Font("Dialog", Font.PLAIN, 12));
            contentPanel.add(lblbySubmittingThis, "cell 0 3");
        }
        {
            spinner = new Spinner();
            spinner.setVisible(false);
            contentPanel.add(spinner, "cell 0 4,grow");
        }
        {
            JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
                JButton okButton = new JButton("Submit");
                okButton.setIcon(new ImageIcon(BugReport.class.getResource("/assets/icons/tick.png")));
                okButton.setActionCommand("OK");
                buttonPane.add(okButton);
                okButton.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseReleased(MouseEvent e) {
                        submitBugReport(textArea.getText());
                    }
                });
                getRootPane().setDefaultButton(okButton);
            }
            {
                JButton cancelButton = new JButton("Cancel");
                cancelButton.setIcon(new ImageIcon(BugReport.class.getResource("/assets/icons/cross.png")));
                cancelButton.setActionCommand("Cancel");
                cancelButton.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseReleased(MouseEvent e) {

                    }
                });
                buttonPane.add(cancelButton);
            }
        }
    }

    private void submitBugReport(String issuesDescription) {
        spinner.setVisible(true);
        spinner.start();
    }


}
