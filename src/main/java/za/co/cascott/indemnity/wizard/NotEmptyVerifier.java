/*
 * === C.A. Scott Consulting Actuary ===
 *   ________     ____         __  __
 *  / ___/ _ |   / __/______  / /_/ /_
 * / /__/ __ |  _\ \/ __/ _ \/ __/ __/
 * \___/_/ |_| /___/\__/\___/\__/\__/
 *
 * Copyright (c) 2012. CA Scott
 */

package za.co.cascott.indemnity.wizard;

import javax.swing.*;
import java.awt.*;

public class NotEmptyVerifier extends InputVerifier {
    static Color color = new Color(255, 181, 181); //Soft-ish red color
    Color defColor;

    public NotEmptyVerifier() {
        defColor = Color.WHITE;
    }

    public NotEmptyVerifier(JComponent input) {
        defColor = input.getBackground();
    }

    @Override
    public boolean verify(JComponent input) {
        JTextField tf = (JTextField) input;
        if (tf.getText().isEmpty()) {
            input.setBackground(color);
            return false;
        } else {
            input.setBackground(defColor);
            return true;
        }
    }

}
