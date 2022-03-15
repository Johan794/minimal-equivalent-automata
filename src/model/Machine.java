package model;

import java.util.ArrayList;
import java.util.Arrays;

public class Machine {
    private String initalSate;

    private ArrayList<String> internalStates; // nombra los nodos
    private ArrayList<String> inputAlphabet; // nombra la conexion con la arista,es decir, dice cuales son los nodos que se conecta
    private ArrayList<String> transitions; // da el valor de a arista
    private String type;
    private ArrayList<MachineTransition> machineTransitions;
    //Los vertices son los estados
    //las aristas las transiciones
    //Se hace de esta manera para aprovechar las cualidades del grafo y poder hacer los algoritmos necesarios para obtener lo esparado
    private Graph<String> finalStateMachie;

    



    /**
     * @param list
     * @param list2
     * @param list3
     * @param type
     * Se asume que el estado inicial siempre es el prinero de la lista 
     */
    public Machine(String type, String initalSate) {
        this.type = type;
        inputAlphabet = new ArrayList<>();
        internalStates = new ArrayList<>();
        transitions = new ArrayList<>();
        finalStateMachie = new Graph<>(true);
        machineTransitions = new ArrayList<>();
        this.initalSate = initalSate;
    }

     /**
     * @return the initalSate
     */
    public String getInitalSate() {
        return initalSate;
    }
    /**
     * @param initalSate the initalSate to set
     */
    public void setInitalSate(String initalSate) {
        this.initalSate = initalSate;
    }


    /**
     * @return the internalStates
     */
    public ArrayList<String> getInternalStates() {
        return internalStates;
    }
    /**
     * @param internalStates the internalStates to set
     */
    public void setInternalStates(ArrayList<String> internalStates) {
        this.internalStates = internalStates;
    }
    /**
     * @return the inputAlphabet
     */
    public ArrayList<String> getInputAlphabet() {
        return inputAlphabet;
    }
    /**
     * @param inputAlphabet the inputAlphabet to set
     */
    public void setInputAlphabet(ArrayList<String> inputAlphabet) {
        this.inputAlphabet = inputAlphabet;
    }
    /**
     * @return the outPutAlphabet
     */
    public ArrayList<String> getOutPutAlphabet() {
        return transitions;
    }
    /**
     * @param outPutAlphabet the outPutAlphabet to set
     */
    public void setOutPutAlphabet(ArrayList<String> outPutAlphabet) {
        this.transitions = outPutAlphabet;
    }
    /**
     * @return the type
     */
    public String getType() {
        return type;
    }
    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the machineTransitions
     */
    public ArrayList<MachineTransition> getMachineTransitions() {
        return machineTransitions;
    }

    /**
     * @param machineTransitions the machineTransitions to set
     */
    public void setMachineTransitions() {
        String []aux = null;
        for (int i = 0; i < internalStates.size(); i++) {
            aux =  inputAlphabet.get(i).split("->");
            
            machineTransitions.add(new MachineTransition(internalStates.get(i), transitions.get(i),aux[1]));
            System.out.println("se crea la MachimeTransition: "+internalStates.get(i)+" "+transitions.get(i)+" "+aux[1]);
        }
       
    }


    
    

   



    

    
}
