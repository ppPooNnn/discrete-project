import java.util.Scanner;

public class CreateAutomaton{
    private Automaton automaton;
    private int amtSta;
    private int amtAcc;
    private String iniName;
    private String accName;
    private Scanner sc = new Scanner(System.in);

    public void run(){
        create();
        execute();
    }

    public void runSlide19(){
        automaton = new Automaton();
        State s0 = new State();
        State s1 = new State();
        State s2 = new State();
        s0.setValues("s0", s1, s0);
        s1.setValues("s1", s1, s2);
        s2.setValues("s2", s1, s0);
        automaton.setInitialState(s0);
        automaton.addAccecptingState(s2);
        System.out.println(automaton.getInitialState());
        execute();
    }

    public void create(){
        automaton = new Automaton();
        System.out.println("Enter the amount of states: ");
        amtSta = sc.nextInt();
        System.out.println("Enter the amount of accecpting states: ");
        amtAcc = sc.nextInt();
        sc.nextLine();
        createStates(amtSta);
        setInitialState();
        addAccecptingStates(amtAcc);
        addNextStateFunction();
    }

    public void createStates(int amt){
        String name;
        State tmp;
        for(int i=0; i<amt; i++){
            name = "s" + i;
            tmp = new State(name);
            automaton.addState(name, tmp);
        }
        System.out.println(automaton.getStates());
    }

    public void setInitialState(){
        System.out.println("Enter the initial state: ");
        iniName = sc.nextLine();
        automaton.setInitialState(automaton.getStateFromName(iniName));
    }

    public void addAccecptingStates(int amt){
        for(int i=0; i<amt; i++){
            System.out.printf("Enter accepting state number %d%n: ", i+1);
            accName = sc.nextLine();
            automaton.addAccecptingState(automaton.getStateFromName(accName));
        }
    }

    public void addNextStateFunction(){
        String n0, n1;
        for(int i=0; i<amtSta; i++){
            System.out.printf("Enter next0 for %s%d%n: ", "s", i);
            n0 = sc.nextLine();
            System.out.printf("Enter next1 for %s%d%n: ", "s", i);
            n1 = sc.nextLine();
            automaton.setStateValues(automaton.getStateFromName("s"+i), n0, n1);
        }
    }

    public void execute(){
        boolean running = true;
        while(running){
            System.out.println("Enter Input String (type 2 to exit): ");
            String str = sc.nextLine();
            if(str.equals("2")){
                return;
            }
            automaton.runAutomaton(str);
        }
    }
}