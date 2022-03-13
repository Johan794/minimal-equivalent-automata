package ui.classes;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Machine;

public class Controller {

    @FXML
    private BorderPane mainPane;
    @FXML
    private ToggleGroup machine;

    @FXML
    private TableColumn<Machine,String> cOutPutMoore;

    @FXML
    private TableColumn<Machine,String> cStates;

    @FXML
    private TableColumn<Machine,String> cTransitionsAndInputs;


    @FXML
    private Label selectedMachine;

    @FXML
    private TableView<Machine> tbMachine;

    @FXML
    private TextField txInitalState;

    @FXML
    private TextField txtInputAlphabet;

    @FXML
    private TextField txtInternalStates;

    @FXML
    private TextField txtOutputAlphabet;


    @FXML
    public void changeScreen(ActionEvent event){
        if(machine.getSelectedToggle()!=null){
            loadScreen("../screens/machineScreen.fxml");
        }else{
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please selected a type of machine");

            alert.showAndWait();
        }
     
    }


    @FXML
    public void outPut(ActionEvent event) throws IOException{
        FXMLLoader open = new FXMLLoader(getClass().getResource("../screens/outPut.fxml"));
        open.setController(this);
        Parent root = open.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.setTitle("Result");
        stage.showAndWait();
    }



    public void loadScreen(String path){
        FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
        loader.setController(this);
        try {
            Parent center = loader.load();
            mainPane.setCenter(center);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

    
}
