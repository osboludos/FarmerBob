package Farmer;
import Companhia.CompanhiaDeGraos;
import Farmer.States.State;
import Farmer.States.StateMachine;

import java.util.Random;

public class FarmerBob extends  Farmer{

    private int Thirst = 0;

    private int Pocket = 0;

    private int Wealthy = 0;

    private int Fadige = 0;

    private int Whacked = 0;

    private boolean BillyWorked = false;

    private String Name;

    public FarmerBob(String name, State<FarmerBob> initialState){
        super(name);
        Name = name;
        m_stateMachine = new StateMachine (this);
        ChangeState(initialState);
    }

    public void Run(){
        m_stateMachine.Update();
        if (Whacked > 30){
            System.out.println("Farmer " + Name + " trabalhou demais e morreu!");
            CompanhiaDeGraos.getInstance().FarmerIsDead(this);
        }
    }


    @Override
    public void Update() {  m_stateMachine.Update(); }

    public void ChangeState(State next){
        m_stateMachine.ChangeState(next);
    }

    public boolean IsSatisfied(){
        return Thirst <= 0;
    }

    public boolean IsThirsty(){
        return Thirst > 20;
    }

    public void Mine(){
        Fadige++;
        Thirst++;
        Whacked++;
        Random random = new Random();
        if (random.nextInt(10) < 1){
            Pocket++;
            System.out.printf("Farmer " + Name + " Achou uma pepita! bolsos em %d\n", Pocket);
        }else {
            System.out.printf("Farmer " + Name + " Mineirou e não conseguiu nada!\n");
        }

    }

    public boolean PocketsFull(){
        return Pocket >= 5;
    }

    public void DepositGold(){
        Wealthy += Pocket;
        Pocket = 0;
        System.out.printf("Farmer " + Name + " Depositei muita grana! Agora no banco eu tenho %d\n", Wealthy);
    }

    public boolean IsWealthy(){
        return Wealthy > 10;
    }

    public void BuyDrink(){
        Wealthy--;
        Thirst--;
        System.out.printf("Farmer " + Name + " Tomando suquinho... sede em %d\n", Thirst);
    }

    public void Rest(){
        Fadige--;
        System.out.printf("Farmer " + Name + " Dormindo... fadiga em %d\n", Fadige);
    }

    public boolean IsRested(){
        return Fadige <= 0;
    }

    public String getName(){
        return Name;
    }

    public void BillyWorkIsDone(boolean worked)   { BillyWorked = worked; }

}
