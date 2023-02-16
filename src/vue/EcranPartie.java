package vue;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

import controlleur.Controlleurs;

public class EcranPartie extends JPanel implements ActionListener {

    private Controlleurs contr;

    public EcranPartie(Controlleurs contr) {

        this.contr = contr;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }
}
