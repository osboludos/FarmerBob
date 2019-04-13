package Farmer.States;

import Farmer.Farmer;
import Farmer.States.MessageManager.Message;

public class StateMachine {

    private Farmer m_owner;

    private State<Farmer> m_currentState, m_lastState;

    private GlobalState m_currentGlobalState;

    public StateMachine(Farmer owner){
        m_owner = owner;
    }

    public void ChangeState(State<Farmer> nextState){
        if (m_currentGlobalState != null){
            m_currentGlobalState.Exit(m_owner);
            m_currentGlobalState = null;
        }
        if (m_currentState != null){
            m_currentState.Exit(m_owner);
        }
        m_lastState = m_currentState;
        m_currentState = nextState;
        m_currentState.Enter(m_owner);
    }

    public void ChangeGlobalState(GlobalState state){
        if (m_currentGlobalState != null){
            m_currentGlobalState.Exit(m_owner);
        }
        if (m_currentState != null){
            m_currentState.Exit(m_owner);
            m_lastState = m_currentState;
        }
        m_currentGlobalState = state;
        m_currentGlobalState.Enter(m_owner);
    }

    public void Update(){

        if (m_currentGlobalState == null){
            m_currentState.Run(m_owner);
        } else {
            m_currentGlobalState.Run(m_owner);
        }
    }

    public boolean handleMessage(Message msg)
    {
        //Global state
        if(m_currentState.onMessage(m_owner, msg)) return  true;

        //Normal State
        if(m_currentGlobalState != null && m_currentGlobalState.onMessage(m_owner, msg)) return true;

        return false;

    }
    public State<Farmer> GetCurrentState(){
        return m_currentState;
    }

    public State<Farmer> GetLastState(){
        return m_lastState;
    }
}
