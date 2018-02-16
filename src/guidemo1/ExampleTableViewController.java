/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guidemo1;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author jeffr
 */
public class ExampleTableViewController implements Initializable {
    
    // Configure the table
    @FXML private TableView<Person> tableView;
    @FXML private TableColumn<Person, String> firstNameColumn; 
    @FXML private TableColumn<Person, String> lastNameColumn;
    @FXML private TableColumn<Person, LocalDate> birthdayColumn;

    /**
     * Initializes the controller class.
     * @param event
     * @throws java.io.IOException
     */
     public void changeScreenButtonPushed2(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        
        // This line gets the stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // Set up the columns in the table
       firstNameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));
       lastNameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));
       birthdayColumn.setCellValueFactory(new PropertyValueFactory<Person, LocalDate>("birthday"));
       
       // load dummy Data
       tableView.setItems(getPeople());
    }    
    
    /**
     * This method will return an ObservableList of People Objects
     */
    
    public ObservableList<Person> getPeople() {
        
        ObservableList<Person> People = FXCollections.observableArrayList();
        People.add(new Person("Frank", "Sinatra", LocalDate.of(1915, Month.DECEMBER, 12)));
        People.add(new Person("Rebecca", "Fergusson", LocalDate.of(1986, Month.JULY, 21)));
        People.add(new Person("Mr.", "T", LocalDate.of(1952, Month.MAY, 21)));
        return People;
    }
    
}
