package za.co.cascott.rpncalculator;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorDialog extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTextField textField;
    private JButton btn7;
    private JButton btn8;
    private JButton btn9;
    private JButton btnEnter;
    private JButton btn4;
    private JButton btn5;
    private JButton btn6;
    private JButton btn1;
    private JButton btn2;
    private JButton btn3;
    private JButton Clear;
    private JButton btnDot;
    private JButton btn0;
    private RPN r;
    private JButton btnplus;

    public CalculatorDialog() {
        r = new RPN();
        setBounds(100, 100, 450, 300);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(new MigLayout("", "[grow]", "[][grow]"));

        textField = new JTextField();
        textField.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPanel.add(textField, "cell 0 0,growx");
        textField.setColumns(10);
        {
            JPanel panel = new JPanel();
            contentPanel.add(panel, "cell 0 1");
            panel.setLayout(new MigLayout("", "[117px][117px][117px][117px]", "[55px][55px][55px][55px]"));

            btn7 = new JButton("7");
            btn7.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    textField.setText(textField.getText() + "7");
                }
            });
            panel.add(btn7, "cell 0 0,grow");

            btn8 = new JButton("8");
            btn8.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    textField.setText(textField.getText() + "8");
                }
            });
            panel.add(btn8, "cell 1 0,grow");

            btn9 = new JButton("9");
            btn9.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    textField.setText(textField.getText() + "9");
                }
            });
            panel.add(btn9, "cell 2 0,grow");

            btnEnter = new JButton("Enter");
            btnEnter.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    r.enter(Double.parseDouble(textField.getText()));
                    System.out.println("Entered " + Double.parseDouble(textField.getText()));
                    textField.setText("");
                }
            });
            panel.add(btnEnter, "cell 3 0,grow");

            btn4 = new JButton("4");
            btn4.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    textField.setText(textField.getText() + "4");
                }
            });
            panel.add(btn4, "cell 0 1,grow");

            btn5 = new JButton("5");
            btn5.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    textField.setText(textField.getText() + "5");
                }
            });
            panel.add(btn5, "cell 1 1,grow");

            btn6 = new JButton("6");
            btn6.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    textField.setText(textField.getText() + "6");
                }
            });
            panel.add(btn6, "cell 2 1,grow");

            Clear = new JButton("Clear");
            Clear.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    textField.setText("");
                }
            });
            panel.add(Clear, "cell 3 1,grow");

            btn1 = new JButton("1");
            btn1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    textField.setText(textField.getText() + "1");
                }
            });
            panel.add(btn1, "cell 0 2,grow");

            btn2 = new JButton("2");
            btn2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    textField.setText(textField.getText() + "2");
                }
            });
            panel.add(btn2, "cell 1 2,grow");

            btn3 = new JButton("3");
            btn3.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    textField.setText(textField.getText() + "3");
                }
            });
            panel.add(btn3, "cell 2 2,grow");

            btn0 = new JButton("0");
            btn0.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    textField.setText(textField.getText() + "0");
                }
            });

            btnplus = new JButton("+");
            btnplus.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    r.add();
                    textField.setText(r.get().toString());
                }
            });
            panel.add(btnplus, "cell 3 2");
            panel.add(btn0, "cell 0 3 2 1,grow");

            btnDot = new JButton(".");
            btnDot.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    textField.setText(textField.getText() + ".");
                }
            });
            panel.add(btnDot, "cell 2 3,grow");

        }
    }

}
