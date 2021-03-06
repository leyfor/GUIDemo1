/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guidemo1;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;


/**
 *
 * @author jeffr
 */
public class FXMLDocumentController implements Initializable {
    
     // These items are for the CheckBox example
    @FXML private Label label;
    @FXML private CheckBox pepperoniCheckBox;
    @FXML private CheckBox pineAppleCheckBox;
    @FXML private CheckBox beconCheckBox;
    @FXML private Button button;

    // These items are for the ChoiceBox examples
    @FXML private ChoiceBox choiceBox;
    @FXML private  Label choiceBoxLabel;
    
    // These items are for the ComboBox examples
    @FXML private ComboBox comboBox;
    @FXML private Label comboBoxLabel;
    
    // These items are for the RadioButton examples
    @FXML private RadioButton phpRadioButton;
    @FXML private RadioButton javaRadioButton;
    @FXML private RadioButton cSharpRadioButton;
    @FXML private RadioButton CPlusPlusRadioButton;
    @FXML private Label radioButtonLabel;
    private ToggleGroup favLangToggleGroup;
    
     // These items are for the ListViews and TextArea examples
    @FXML private ListView listView;
    @FXML private TextArea golfTextArea;
    
    
    /**
     * When this method is called, it will change the Scene to 
     * a TableView example
     * @param event 
     * @throws java.io.IOException 
     */
    
    public void changeScreenButtonPushed(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("ExampleTableView.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        
        // This line gets the stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
        
    }
    
    
    @FXML private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        this.label.setText("Hello World!");
    }

    /**
     * This is update the label for the ChoiceBox
     */

    public void choiceBoxButtonPushed() {
        this.choiceBoxLabel.setText("My favourite fruit is:\n " +  this.choiceBox.getValue().toString());
        
    }
    
    
    /**
     *This will update the comboBoxLabel, when the ComboBox is changed
     */
    
    public void comboBoxWasUpdated() {
        this.comboBoxLabel.setText("Course selected: \n" + this.comboBox.getValue().toString());
    }
    
    
    /**
     * This will select one element in the RadioButton object
     */
    
    public void courseButtonPush() {
        
        if (this.favLangToggleGroup.getSelectedToggle().equals(this.CPlusPlusRadioButton)) {
            
             this.radioButtonLabel.setText("The selected  item is: C++");
        }
        if(this.favLangToggleGroup.getSelectedToggle().equals(this.cSharpRadioButton)) {
            this.radioButtonLabel.setText("The selected  item is: C#");
        } 
        if(this.favLangToggleGroup.getSelectedToggle().equals(this.javaRadioButton)) {
            this.radioButtonLabel.setText("The selected  item is: Java");
        } 
        if(this.favLangToggleGroup.getSelectedToggle().equals(this.phpRadioButton)){
            this.radioButtonLabel.setText("The selected  item is: PHP");
        }
        
      
    }
    
    /**
     * This method will copy the strings from the ListView and put them in the text area
     */
    public void listViewButtonPushed() {
        String textAreaString = "";
        
        ObservableList listOfItems = this.listView.getSelectionModel().getSelectedItems();
        
        for (Object item : listOfItems) {
            textAreaString += String.format("%s%n", (String) item);
        }
        this.golfTextArea.setText(textAreaString);
    }

    /**
     * This is for the CheckBox example
     */
    public void pizzaOrderButtonPush() {
        String order = "Toppings are: ";
        
        if(this.pineAppleCheckBox.isSelected()) {
            order += "\npineapple";
        } 
        if(this.beconCheckBox.isSelected()) {
            
            order += "\nbecon";
            
        } 
        if (this.pepperoniCheckBox.isSelected()) {
            order += "\npeperoni";
        }
        
        this.label.setText(order);
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.label.setText("");
        this.choiceBoxLabel.setText("");
        this.comboBoxLabel.setText("");
        this.radioButtonLabel.setText("");

        // This items are for the configuring the choiceBox example
        this.choiceBox.getItems().add("apples");
        this.choiceBox.getItems().add("bananas");
        this.choiceBox.getItems().addAll("oranges", "pears", "strawberries");
        this.choiceBox.setValue("apples");
        
        // This items are for the configuring the choiceBox example
        this.comboBox.getItems().addAll("COMP1030", "COMP1008", "MGMT2003", "MGMT2010");
        
         // This items are for the configuring the radioButton example
        this.favLangToggleGroup = new ToggleGroup();
        this.CPlusPlusRadioButton.setToggleGroup(favLangToggleGroup);
        this.cSharpRadioButton.setToggleGroup(favLangToggleGroup);
        this.javaRadioButton.setToggleGroup(favLangToggleGroup);
        this.phpRadioButton.setToggleGroup(favLangToggleGroup);
        
        // This items are for the configuring the ListArea example
        this.listView.getItems().addAll("Golf Balls", "Wedges", "irons", "Tees", "Driver", "Putter");
        
        // Ability to select multiple option at a time
        this.listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
         
        
    }
    
}
