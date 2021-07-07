package com.viniciusfinger.game.model.node;

import com.viniciusfinger.game.model.FoodPlate;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class FinalNode extends Node {

    private FoodPlate foodPlate;
    private static final int CORRECT = 0;

    public FinalNode(JFrame parent) {
        super(parent);
    }

    public FoodPlate getPrato() {
        return this.foodPlate;
    }

    public void setPrato(FoodPlate foodPlate) {
        this.foodPlate = foodPlate;
    }

    public void askForPlate() {
        Boolean isCorrect = (JOptionPane.showConfirmDialog(getParentJFrame(),
                "O prato que você pensou é " + this.foodPlate.getNome() + "?",
                "Confirm", 0) == CORRECT);

        if (isCorrect) {
            this.showSuccessMessage();
        } else {
            this.insertNewNode();
        }
    }

    private void insertNewNode() {
        Node newNode = new Node(this.getParentJFrame());
        FoodPlate newFoodPlate = this.createFoodPlate();

        newNode.setQuestion(newFoodPlate.getQuestion());

        FinalNode newEndNode = new FinalNode(this.getParentJFrame());
        newEndNode.setPrato(newFoodPlate);

        if (this.isYesNode()) {
            getParentNode().setYesNode(newNode);
        } else {
            getParentNode().setNoNode(newNode);
        }

        newNode.setYesNode(newEndNode);
        newNode.setNoNode(this);
    }

    private void showSuccessMessage() {
        JOptionPane.showMessageDialog(getParentJFrame(), "Acertei de novo!",
                "Jogo Gourmet", JOptionPane.NO_OPTION);
    }

    private FoodPlate createFoodPlate() {
        FoodPlate newFoodPlate = new FoodPlate();

        newFoodPlate.setNome(JOptionPane.showInputDialog(this.getParentJFrame(),
                "Qual prato você pensou?", "Desisto", JOptionPane.QUESTION_MESSAGE));

        newFoodPlate.setCharacteristics(JOptionPane.showInputDialog(this.getParentJFrame(),
                newFoodPlate.getNome() + " é __________ mas " + this.foodPlate.getNome()
                + " não", "Complete", JOptionPane.QUESTION_MESSAGE));

        return newFoodPlate;
    }
}
