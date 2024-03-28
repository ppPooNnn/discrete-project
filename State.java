public class State {
    
    private String name;
    private State next0;
    private State next1;
    
    public State(String name, State next0, State next1){
        this.name = name;
        this.next0 = next0;
        this.next1 = next1;
    }

    public State(String name){
        this.name = name;
    }

    public State(){

    }
    
    public String getName() {
        return name;
    }
    
    public State getNext0() {
        return next0;
    }

    public void setNext0(State next0) {
        this.next0 = next0;
    }
    
    public State getNext1() {
        return next1;
    }

    public void setNext1(State next1) {
        this.next1 = next1;
    }
    
    public String toString(){
        return name;
    }

    public void setValues(String name, State next0, State next1){
        this.name = name;
        this.next0 = next0;
        this.next1 = next1;
    }
}
