package GUI;

import backend.Musico;

import javax.swing.*;
import java.awt.*;

public class PainelStats extends JPanel {

    public PainelStats (FramePrincipal framePrincipal, Musico musico) {

        setBackground(new Color(70, 90, 120));;
        setPreferredSize(new Dimension(300, 400));
        setVisible(true);

        JLabel lblTotalUsers = new JLabel("Total Utilizadores");
        lblTotalUsers.setBounds(20,200,200,25);
        lblTotalUsers.setVisible(true);

        JLabel totalUsers = new JLabel(String.valueOf((framePrincipal.getRockstar().getUtilizadores().size())));
        totalUsers.setBounds(20,230,200,25);
        totalUsers.setVisible(true);

        add(lblTotalUsers);
        add(totalUsers);



    }

}
