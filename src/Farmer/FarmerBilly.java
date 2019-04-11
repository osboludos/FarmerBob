package Farmer;

import Farmer.States.StateMachine;

import java.util.Random;

public class FarmerBilly implements IFarmer{

    private StateMachine<FarmerBilly> m_currentState;

    public int tedio=0;

    public int next;

    public FarmerBilly(StateMachine<FarmerBilly> initialState){
        ChangeState(initialState);
    }

    public void Run(){
        m_currentState.Run(this);
    }

    public void ChangeState(StateMachine next){
        if (m_currentState != null){
            m_currentState.Exit(this);
        }
        m_currentState = next;
        m_currentState.Enter(this);
    }

    public int Randomi(){
        Random rand = new Random();
        return rand.nextInt(4);
    }

}
