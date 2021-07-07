package com.viniciusfinger.game.frame;

import com.viniciusfinger.game.model.node.Node;
import com.viniciusfinger.game.model.node.FinalNode;
import com.viniciusfinger.game.model.FoodPlate;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.Box;
import javax.swing.BoxLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {

    private Node rootNode;

    public MainFrame() {
        initializeFrame();
        createPanel();
        createFirstNodes();
    }

    private void initializeFrame() {
        this.setTitle("Jogo Gourmet");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void createPanel() {
        JPanel panel = new JPanel();

        BoxLayout layout = new BoxLayout(panel, BoxLayout.PAGE_AXIS);
        panel.setLayout(layout);

        Border border = BorderFactory.createEmptyBorder(25, 45, 25, 45);
        panel.setBorder(border);

        JButton button = new JButton("OK");
        button.setAlignmentY(0.5F);
        button.setAlignmentX(0.5F);
        button.addActionListener((ActionEvent e) -> {
            this.actionBtnOk();
        });

        JLabel label = new JLabel("Pense em um prato que gosta");
        label.setAlignmentY(0.5F);
        label.setAlignmentX(0.5F);

        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(button);

        this.setContentPane(panel);
        this.setLocationRelativeTo(null);
        pack();
    }

    private void actionBtnOk() {
        this.rootNode.askForPlate();
    }

    private void createFirstNodes() {
        FinalNode yesNode = new FinalNode(this);
        FinalNode noNode = new FinalNode(this);

        FoodPlate oneFoodPlate = new FoodPlate();
        oneFoodPlate.setNome("Lasanha");

        FoodPlate anotherFoodPlate = new FoodPlate();
        anotherFoodPlate.setNome("Bolo de chocolate");

        yesNode.setPrato(oneFoodPlate);
        noNode.setPrato(anotherFoodPlate);

        this.rootNode = new Node(this);
        this.rootNode.setQuestion("O prato que você pensou é massa?");
        this.rootNode.setYesNode(yesNode);
        this.rootNode.setNoNode(noNode);
    }
}
