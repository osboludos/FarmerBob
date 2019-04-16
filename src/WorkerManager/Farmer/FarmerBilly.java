package WorkerManager.Farmer;

import WorkerManager.Farmer.States.State;
import WorkerManager.Farmer.States.StateMachine;

import java.util.Random;

public class FarmerBilly extends Worker {

    public int tedio = 0;

    public int next;

    private int working = 0;

    private boolean m_worked = false;

    public FarmerBilly(String name, State<FarmerBilly> initialState)
    {
        super("Billy");
        m_stateMachine = new StateMachine<FarmerBilly>(this);
        m_stateMachine.ChangeState(initialState);

    }

    public void Run(){
        m_stateMachine.Update();
    }

    public StateMachine<FarmerBilly> GetStateMachine(){
        return m_stateMachine;
    }

    public int Randomi(){
        Random rand = new Random();
        return rand.nextInt(4);
    }

    public void Working()
    {
        working++;
        System.out.printf("Tentando trabalhar...zzzzzzzz....zzzzzz");
    }

    public boolean WorkIsDone() {return working >= 10;  }

    public void Worked(boolean worked){ m_worked = worked;}


}
