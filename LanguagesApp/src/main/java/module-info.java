module com.mycompany.languagesapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.mycompany.languagesapp to javafx.fxml;
    exports com.mycompany.languagesapp;
}