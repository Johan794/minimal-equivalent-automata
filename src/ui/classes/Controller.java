package ui.classes;

import java.io.IOException;
import java.util.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Machine;
import model.MachineTransition;

public class Controller {

    @FXML
    private BorderPane mainPane;
    @FXML
    private ToggleGroup machine;

    @FXML
    private TableColumn<MachineTransition,String>  cNextState;

    @FXML
    private TableColumn<MachineTransition,String> cStates;

    @FXML
    private TableColumn<MachineTransition,String>  cInputs;

    @FXML
    private TableColumn<MachineTransition,String> cStimulusResponse;


    @FXML
    private Label selectedMachine;

    @FXML
    private TableView<MachineTransition> tbMachine;

    @FXML
    private TextField txInitalState;

    @FXML
    private TextField txtInputAlphabet;

    @FXML
    private TextField txtInternalStates;

    @FXML
    private TextField txtOutputAlphabet;

    @FXML
    private RadioButton rbMealy;

    @FXML
    private RadioButton rbMoore;


    @FXML
    private TableColumn<MachineTransition,String> cInputs_outPut;

    @FXML
    private TableColumn<MachineTransition,String> cNextState_outPut;

    @FXML
    private TableColumn<MachineTransition,String> cStates_outPut;

    @FXML
    private TableColumn<MachineTransition,String> cStimulusResponse_outPut;

    @FXML
    private TableView<MachineTransition> tbMachine_outPut;



    private String typeOfmachine;

    //La que recibe desde la gui
    private Machine current;

    // La mimina conexa equivalente
    private Machine reducedAndEquivalentManchine;


    //Carga la segunda pantalla
    @FXML
    public void changeScreen(ActionEvent event){
        if(machine.getSelectedToggle()!=null){
            if(rbMealy.isSelected()){
                typeOfmachine = "Mealy Machine";
                loadScreen("../screens/machineScreen.fxml");
                cInputs.setVisible(false);
            }else{
                typeOfmachine = "Moore Machine";
                loadScreen("../screens/machineScreen.fxml");
                cStates.setText("PRESENT STATE/OUTPUT");
                cStimulusResponse.setVisible(false);
            }
            
          
            selectedMachine.setText(typeOfmachine);
    
        }else{
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please selected a type of machine");

            alert.showAndWait();
        }
     
    }

    //Muestra la tabla del autmata minimo conexo equivalente

    @FXML
    public void outPut(ActionEvent event) throws IOException{
        FXMLLoader open = new FXMLLoader(getClass().getResource("../screens/outPut.fxml"));
        open.setController(this);
        Parent root = open.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();

        if(typeOfmachine.equals("Mealy Machine")){
            cInputs_outPut.setVisible(false);
        }else{
            cStimulusResponse_outPut.setVisible(false);
            cStates_outPut.setText("PRESENT STATE/OUTPUT");
        }   


        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.setTitle("Result");
        stage.showAndWait();
    }


    //Llena los valores de la tabala del automata que se recibie por entrada y se inizializa el objeto current
    //La clase Machine tiene relacion con el grafo, esto es con fines de podes llenar las tablas usando las propiedades del objeto

    @FXML
    public void fillTable(ActionEvent event){
        String [] internalStates = txtInternalStates.getText().split(",");
        String [] inputAlphabet = txtInputAlphabet.getText().split(",");
        current = new Machine(typeOfmachine,"->"+internalStates[0]);
     


        TextInputDialog dialog1 = new TextInputDialog("");
        dialog1.setTitle("Build the machine");


        List<String> choices = new ArrayList<>();
        for (int i = 0; i < internalStates.length; i++) {
            choices.add(internalStates[i]);
            
        }
        ChoiceDialog<String> dialog = new ChoiceDialog<>("", choices);
        dialog.setTitle("Let us build the machine");


        Optional<String> result1; // de la entrada estinulo/respuesta
        Optional<String> result; //de la entrada del siguiente estado que seleccionó
        ArrayList<String> inAlphabet = new ArrayList<String>(Arrays.asList(inputAlphabet));
        if(typeOfmachine.equals("Mealy Machine")){

            //current.setInputAlphabet(inAlphabet);
          //  current.setInputAlphabet((ArrayList<String>) Arrays.asList(inputAlphabet));
            current.setInternalStates(new ArrayList<>(Arrays.asList(internalStates)));

            //Aca ingresa la parte de estumulo/respuesta
            dialog1.setHeaderText("Please write the stimulus/response behavior of the machine");
            for (int index = 0; index < internalStates.length; index++) {
                for (int i = 0; i <inAlphabet.size() ; i++) {
                    dialog1.setContentText("For the state "+internalStates[index]+" and the simbol "+inAlphabet.get(i)+" Please enter the following the stimulus/response format :");
                    result1 = dialog1.showAndWait();
                    if (result1.isPresent()){
                        current.getTransitions().add(result1.get()); //llama al arreglo transitions es que no se hizo refractor al get :(
                        //aca selecciona el estado al que llega

                        dialog.setHeaderText("Now the nex state");
                        dialog.setContentText("Select the next state:");

                        result = dialog.showAndWait();
                        if (result.isPresent()){
                            current.getInputAlphabet().add(internalStates[index]+"->"+result.get());// estado en el que está -> al que seleccionó
                            //  current.getTransitions().add(internalStates[index]+"->"+result.get());
                            //eso puede ayudar para saber hacia donde va despues de la transicion
                        }

                    }
                }
            }
            System.out.println(Arrays.asList(current.getInputAlphabet()).toString());
            System.out.println(Arrays.asList(current.getTransitions().toString()));
            current.conexumMachine();
            //Aca es donde se supone que se llenan las tablas cuando es de Mealy
           
        }else{

         
            dialog1.setHeaderText("Please write the state/output behavior of the machine");
            for (int index = 0; index < internalStates.length; index++) {
                dialog1.setContentText("For the state "+internalStates[index]+" Please enter it following the state/output format :");
                result1 = dialog1.showAndWait();
                if (result1.isPresent()){
                     current.getInternalStates().add(result1.get()); 
                    //aca selecciona el input
                    dialog1.setHeaderText("Please write the input for the next state");
                    dialog1.setContentText(null);
                    result1 = dialog1.showAndWait();
                    if(result1.isPresent()){
                        current.getOutPutAlphabet().add(result1.get());

                         //aca selecciona el estado al que llega    
                        dialog.setTitle("Let us build the machine");
                        dialog.setHeaderText("Now the nex state");
                        dialog.setContentText("Select the next state:");
                    
                        result = dialog.showAndWait();
                        if (result.isPresent()){
                        current.getInputAlphabet().add(internalStates[index]+"->"+result.get());// estado en el que está -> al que seleccionó
                        //eso puede ayudar para saber hacia donde va despues de la transicion 
                        }
                    }
                     

                }

            }

               //Aca es donde se supone que se llenan las tablas cuando es de Moore


           
           
        }

        current.setMachineTransitions();
        loadtable(typeOfmachine);
    }


    public void loadtable(String type){
        ObservableList<MachineTransition> observableList;
        observableList = FXCollections.observableArrayList(current.getMachineTransitions());
        tbMachine.setItems(observableList);
        cStates.setCellValueFactory(new PropertyValueFactory<>("presentState"));
        cNextState.setCellValueFactory((new PropertyValueFactory<>("nextState")));
            if(type.equals("Mealy Machine")){
                System.out.println("Aaaaa");
                cStimulusResponse.setCellValueFactory(new PropertyValueFactory<>("stimulusResponse"));
                tbMachine.refresh(); 

            }else{
                System.out.println("wwwwwww");
                cInputs.setCellValueFactory(new PropertyValueFactory<MachineTransition,String>("stimulusResponse"));
                tbMachine.refresh(); 

            }



    }



    //Carga las pantallas
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
