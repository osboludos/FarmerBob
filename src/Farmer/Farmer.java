package Farmer;

import Farmer.States.Entity.EntityManager;
import Farmer.States.MessageManager.Message;
import Farmer.States.State;
import Farmer.States.StateMachine;

public abstract class Farmer {


    protected StateMachine m_stateMachine;

    public StateMachine GetStateMachine(){
        return m_stateMachine;
    }

    public abstract void ChangeState(State state);
    public abstract void Run();

    //Entity<Daqui pra baixo>
    private String m_name;
    private int m_id;

    public Farmer(String name)
    {
        m_name = name;
        EntityManager.getInstance().registerEntity(this);
    }

    public String getName(){return m_name;}

    public void setID(int id){m_id = id;}
    public int getID(){ return m_id; }

    public boolean handleMessage(Message msg){return m_stateMachine.handleMessage(msg);}

    public abstract  void Update();

}
