import java.util.ArrayList;
import java.util.HashMap;

public class Automaton {
    private HashMap<String, State> states;
    private State initialState;
    private State currentState;
    private ArrayList<State> acceptingStates;

    public Automaton(){
        states = new HashMap<>();
        initialState = new State();
        currentState = new State();
        acceptingStates = new ArrayList<>();
    }

    public State input0(){
        return currentState.getNext0();
    }
    public State input1(){
        return currentState.getNext1();
    }

    public void addState(String str, State s){
        states.putIfAbsent(str, s);
    }
    
    public void setStateValues(State s, String n0, String n1){
        s.setNext0(getStateFromName(n0));
        s.setNext1(getStateFromName(n1));
    }
    
    public State getStateFromName(String str){
        return states.get(str);
    }
    
    public HashMap<String, State> getStates(){
        return states;
    }

    public State getInitialState() {
        return initialState;
    }
    
    public void setInitialState(State initialState){
        this.initialState = initialState;
        this.currentState = initialState;
    }
    
    public State getCurrentState() {
        return currentState;
    }
    
    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }
    
    public ArrayList<State> getAcceptingStates() {
        return acceptingStates;
    }
    
    public void addAcceptingState(State s){
        acceptingStates.add(s);
    }

    public void runAutomaton(String input){
        String[] tokens = input.split("");
        for(int i=0; i<input.length(); i++){
            if(tokens[i].trim().equals("0")){
                currentState = input0();
            }
            else if(tokens[i].trim().equals("1")){
                currentState = input1();
            }
            else{
                System.out.printf("! only 0 and 1 are allowed in the input string !%n%n");
                return;
            }
        }

        System.out.println("Final State: " + currentState);

        if(acceptingStates.contains(currentState)){
            System.out.println("--input " + input + " accepted--");
        }
        else{
            System.out.println("--input " + input + " rejected--");
        }
        System.out.println();
    }
    
}
