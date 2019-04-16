package WorkerManager.Farmer;
import WorkerManager.Farmer.States.BobStates.BobGlobalState;
import WorkerManager.WorkerManager;
import WorkerManager.Farmer.States.State;
import WorkerManager.Farmer.States.StateMachine;

import java.util.Random;

public class FarmerBob extends Worker {

    private int Thirst = 0;

    private int Pocket = 3;

    private int Wealthy = 20;

    private int Fadige = 20;

    private boolean BillyWorked = false;

    public FarmerBob(String name, State<FarmerBob> initialState){
        super("Bob");
        m_stateMachine = new StateMachine<> (this);
        m_stateMachine.ChangeState(initialState);
        m_stateMachine.ChangeGlobalState(BobGlobalState.getInstance());
    }

    public void Run(){
        m_stateMachine.Update();
    }

    public StateMachine<FarmerBob> GetStateMachine(){
        return m_stateMachine;
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
        Random random = new Random();
        if (random.nextInt(10) < 1){
            Pocket++;
            System.out.printf("WorkerManager/Farmer " + GetName() + " Achou uma pepita! bolsos em %d\n", Pocket);
        }else {
            System.out.printf("WorkerManager/Farmer " + GetName() + " Mineirou e não conseguiu nada!\n");
        }

    }

    public boolean PocketsFull(){
        return Pocket >= 5;
    }

    public void DepositGold(){
        Wealthy += Pocket;
        Pocket = 0;
        System.out.printf("WorkerManager/Farmer " + GetName() + " Depositei muita grana! Agora no banco eu tenho %d\n", Wealthy);
    }

    public boolean IsWealthy(){
        return Wealthy > 10;
    }

    public void BuyDrink(){
        Wealthy--;
        Thirst--;
        System.out.printf("WorkerManager/Farmer " + GetName() + " Tomando suquinho... sede em %d\n", Thirst);
    }

    public void Rest(){
        Fadige--;
        System.out.printf("WorkerManager/Farmer " + GetName() + " Dormindo... fadiga em %d\n", Fadige);
    }

    public boolean IsRested(){
        return Fadige <= 0;
    }

    public void BillyWorkIsDone(boolean worked) {
        BillyWorked = worked;
    }

    public boolean BillyHasWorked(){
        return BillyWorked;
    }

}
