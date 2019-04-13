package Farmer;

import Farmer.States.State;
import Farmer.States.StateMachine;

import java.util.Random;

public class FarmerBilly extends Farmer {

    public int tedio = 0;

    public int next;

    private int working = 0;

    private boolean m_worked = false;

    public FarmerBilly(State<FarmerBilly> initialState)
    {
        super("Billy");
        m_stateMachine = new StateMachine(this);
        ChangeState(initialState);
    }

    public void Run(){
        m_stateMachine.Update();
    }

    @Override
    public void Update() { m_stateMachine.Update(); }

    public void ChangeState(State next){
        m_stateMachine.ChangeState(next);
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
