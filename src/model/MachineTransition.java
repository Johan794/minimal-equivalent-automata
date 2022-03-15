package model;

public class MachineTransition {
    private String presentState;
    private String stimulusResponse;
    private String nextState;


    /**
     * @param presentState
     * @param input
     * @param stimulusResponse
     * @param nextState
     */
    public MachineTransition(String presentState,  String stimulusResponse, String nextState) {
        this.presentState = presentState;
         this.stimulusResponse = stimulusResponse;
        this.nextState = nextState;
    }


    /**
     * @return the presentState
     */
    public String getPresentState() {
        return presentState;
    }


    /**
     * @param presentState the presentState to set
     */
    public void setPresentState(String presentState) {
        this.presentState = presentState;
    }


    /**
     * @return the stimulusResponse
     */
    public String getStimulusResponse() {
        return stimulusResponse;
    }


    /**
     * @param stimulusResponse the stimulusResponse to set
     */
    public void setStimulusResponse(String stimulusResponse) {
        this.stimulusResponse = stimulusResponse;
    }


    /**
     * @return the nextState
     */
    public String getNextState() {
        return nextState;
    }


    /**
     * @param nextState the nextState to set
     */
    public void setNextState(String nextState) {
        this.nextState = nextState;
    }
   

    
    
}
