package com.viniciusfinger.game.model.node;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Node {

    private JFrame parentJFrame;
    private Node parentNode;
    private Node yesNode;
    private Node noNode;
    private boolean isYesNode;
    private String question;

    public Node(JFrame parenteJFrame) {
        this.parentJFrame = parenteJFrame;
    }

    public void askForPlate() {
        boolean isCorrect = (JOptionPane.showConfirmDialog(this.parentJFrame, this.question, "Confirm", 0) == 0);

        if (isCorrect) {
            this.yesNode.askForPlate();
        } else {
            this.noNode.askForPlate();
        }
    }

    public String getQuestion() {
        return this.question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Node getYesNode() {
        return this.yesNode;
    }

    public void setYesNode(Node yesNode) {
        this.yesNode = yesNode;
        yesNode.setParentNode(this, true);
    }

    public Node getNoNode() {
        return this.noNode;
    }

    public void setNoNode(Node noNode) {
        this.noNode = noNode;
        noNode.setParentNode(this, false);
    }

    public JFrame getParentJFrame() {
        return this.parentJFrame;
    }

    protected Node getParentNode() {
        return this.parentNode;
    }

    protected void setParentNode(Node parentNode, boolean isYesNode) {
        this.parentNode = parentNode;
        this.isYesNode = isYesNode;
    }

    protected boolean isYesNode() {
        return this.isYesNode;
    }
}
