package Farmer;

import Farmer.States.State;
import Farmer.States.StateMachine;

public abstract class Farmer {

    protected StateMachine m_stateMachine;

    public StateMachine GetStateMachine(){
        return m_stateMachine;
    }

    public abstract void ChangeState(State state);
    public abstract void Run();
}
