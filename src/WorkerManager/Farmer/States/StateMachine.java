package WorkerManager.Farmer.States;

import WorkerManager.Farmer.States.MessageManager.Message;

public class StateMachine<T> {

    private T m_owner;

    private State<T> m_currentState, m_lastState;

    private State<T> m_currentGlobalState;

    public StateMachine(T owner){
        m_owner = owner;
    }

    public void ChangeState(State<T> nextState){
        m_lastState = m_currentState;
        if (m_currentState != null){
            m_currentState.Exit(m_owner);
        }
        m_currentState = nextState;
        m_currentState.Enter(m_owner);
    }

    public void ChangeGlobalState(State<T> state){
        if (m_currentGlobalState != null){
            m_currentGlobalState.Exit(m_owner);
        }
        m_currentGlobalState = state;
        m_currentGlobalState.Enter(m_owner);
    }

    public void Update(){

        if (m_currentState != null){
            m_currentState.Run(m_owner);
        }
        if (m_currentGlobalState != null){
            m_currentGlobalState.Run(m_owner);
        }
    }

    public boolean handleMessage(Message msg)
    {
        //Global state
        if(m_currentState.onMessage(m_owner, msg)) {
            return true;
        }

        //Normal State
        if(m_currentGlobalState != null) {
            return m_currentGlobalState.onMessage(m_owner, msg);
        }

        return false;

    }

    public void RevertToPreviousState(){
        ChangeState(m_lastState);
    }

    public State<T> GetCurrentState(){
        return m_currentState;
    }

    public State<T> GetLastState(){
        return m_lastState;
    }

    public State<T> GetGlobalState(){
        return m_currentGlobalState;
    }

}
