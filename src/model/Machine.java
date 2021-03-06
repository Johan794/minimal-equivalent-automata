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
    private int alphabetSize;
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
        alphabetSize = 0;
    }

    public void conexumMachine(){

        ArrayList<String> conectedStates = new ArrayList<>();
        String actualState = initalSate.split("->")[1];
        int elements = 1;

        conectedStates.add(actualState);
        ArrayList<String[]> trans = new ArrayList<>();
        for(String a: inputAlphabet){
            if(a.contains("->")){
                trans.add(a.split("->"));
            }
        }

        for(int i = 0; i < elements; i++){
            actualState = conectedStates.get(i);
            for(String[] a : trans){
                if(a[0].equals(actualState)){
                    if(!conectedStates.contains(a[1])){
                        conectedStates.add(a[1]);
                        elements++;
                    }
                }
            }

        }
        System.out.println(Arrays.asList(conectedStates));





        /*
        ArrayList<String> conectedStates = new ArrayList<>();
        String actualState = initalSate.split("->")[1];
        conectedStates.add(initalSate.split("->")[1]);
        for(int j = 0; j < conectedStates.size(); j++){
            System.out.println("Actual: "+actualState+ " Tama??o"+ conectedStates.size());
            for(int i = 0; i < transitions.size(); i++){
                //! Look up which element in the list are we visiting including stimulus/response
                System.out.println(transitions.get(i).split("->")[0]);
                System.out.println(transitions.get(i).split("->")[0].equals(actualState));
                if(transitions.get(i).split("->")[0].equals(actualState)){
                    String posibleState = transitions.get(i).split("->")[1];
                    System.out.println("Posible state "+posibleState );
                    if(!conectedStates.contains(posibleState)){
                        conectedStates.add(posibleState);
                    }
                }
            }

            actualState = conectedStates.get(j);
            System.out.println("Actual: "+actualState+ " Tama??o"+ conectedStates.size());
            System.out.println(Arrays.asList(conectedStates).toString());
        }

        System.out.println(Arrays.asList(internalStates).toString());
        */

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

    public ArrayList<String> getTransitions() {
        return transitions;
    }

    public void setTransitions(ArrayList<String> transitions) {
        this.transitions = transitions;
    }

    public Graph<String> getFinalStateMachie() {
        return finalStateMachie;
    }

    public void setFinalStateMachie(Graph<String> finalStateMachie) {
        this.finalStateMachie = finalStateMachie;
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
    public void setMachineTransitions(ArrayList<MachineTransition> machineTransitions) {
        this.machineTransitions = machineTransitions;
    }

    /**
     * @return the alphabetSize
     */
    public int getAlphabetSize() {
        return alphabetSize;
    }

    /**
     * @param alphabetSize the alphabetSize to set
     */
    public void setAlphabetSize(int alphabetSize) {
        this.alphabetSize = alphabetSize;
    }

    public void setMachineTransitions() {
        String []aux = null;
       // int count = internalStates.size()*alphabetSize;
      // int count = 0;
        /*
        for (int i = 0; i < (inputAlphabet.size()); i++) {
            aux =  inputAlphabet.get(i).split("->");
            machineTransitions.add(new MachineTransition(internalStates.get(i), transitions.get(i),aux[1]));
            System.out.println("se crea la MachimeTransition: "+internalStates.get(i)+" "+transitions.get(i)+" "+aux[1]);
        }

          System.out.println("tama??o del alfabeto "+internalStates.size());
        System.out.println("Tama??o "+alphabetSize);
       // System.out.println();
        

        for (int i = 0; i < (internalStates.size()); i++) {
            aux =  inputAlphabet.get(i).split("->");
            for (int index = 0; index <=alphabetSize; index++) {
                machineTransitions.add(new MachineTransition(internalStates.get(index), transitions.get(index),aux[1]));
                System.out.println("se crea la MachimeTransition: "+internalStates.get(index)+" "+transitions.get(index)+" "+aux[1]);
            }
           
        }

        
        */

        for (int index = 0; index <inputAlphabet.size(); index++) {
            aux =  inputAlphabet.get(index).split("->");
            machineTransitions.add(new MachineTransition(aux[0], transitions.get(index),aux[1]));
        }

        

      

      
       
    }


    
    

   



    

    
}
