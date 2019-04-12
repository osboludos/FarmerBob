package Farmer;

import Farmer.States.State;
import Farmer.States.StateMachine;

import java.util.Random;

public class FarmerBilly extends Farmer {

    public int tedio=0;

    public int next;

    public FarmerBilly(State<FarmerBilly> initialState){
        m_stateMachine = new StateMachine(this);
        ChangeState(initialState);
    }

    public void Run(){
        m_stateMachine.Update();
    }

    public void ChangeState(State next){
        m_stateMachine.ChangeState(next);
    }

    public int Randomi(){
        Random rand = new Random();
        return rand.nextInt(4);
    }

}
