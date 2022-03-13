package ui.classes;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application{
    private Controller gui;


    public Main(){
        gui = new Controller();
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage arg0) throws Exception {
      FXMLLoader loader = new FXMLLoader(getClass().getResource("../screens/welcomeScreen.fxml"));
      loader.setController(gui);
      Parent root = loader.load();

      Scene scene = new Scene(root);

      arg0.setScene(scene);
      arg0.setTitle("Minimal and equivalent automata");
      arg0.show();
        
    }
}
