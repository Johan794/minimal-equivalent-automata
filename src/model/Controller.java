package model;

import java.util.ArrayList;

public class Controller {
    ArrayList<Vertice<String>> states;
    ArrayList<Edge<Vertice<String>>> transitions;

    public Controller(){
        states = new ArrayList<>();
        transitions = new ArrayList<>();
    }
}
