package com.mycompany.languagesapp;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.util.List;

public class MainController {
    @FXML
    private TextField textWord;
    @FXML
    private ListView<String> wordList;
    @FXML
    private TextField messageField;
    @FXML
    private TextArea chatArea;
    @FXML
    protected void onAddWord()
    {
        wordList.getItems().add(textWord.getText());
    }
    @FXML
    protected void onSendMessage()
    {
        chatArea.appendText("You: "+messageField.getText()+"\n");
    }
}