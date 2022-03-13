package model;

import java.util.ArrayList;

public class Machine {
    private ArrayList<String> internalStates;
    private ArrayList<String> inputAlphabet;
    private ArrayList<String> outPutAlphabet;
    private String type;

    



    /**
     * @param internalStates
     * @param inputAlphabet
     * @param outPutAlphabet
     * @param type
     */
    public Machine(ArrayList<String> internalStates, ArrayList<String> inputAlphabet, ArrayList<String> outPutAlphabet,
            String type) {
        this.internalStates = internalStates;
        this.inputAlphabet = inputAlphabet;
        this.outPutAlphabet = outPutAlphabet;
        this.type = type;
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
        return outPutAlphabet;
    }
    /**
     * @param outPutAlphabet the outPutAlphabet to set
     */
    public void setOutPutAlphabet(ArrayList<String> outPutAlphabet) {
        this.outPutAlphabet = outPutAlphabet;
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
    



    

    
}
