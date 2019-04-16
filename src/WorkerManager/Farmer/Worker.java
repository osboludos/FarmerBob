package WorkerManager.Farmer;

import WorkerManager.Farmer.States.MessageManager.Message;
import WorkerManager.Farmer.States.StateMachine;
import WorkerManager.WorkerManager;

public abstract class Worker {

    protected String m_name;

    protected int m_id;

    protected StateMachine m_stateMachine;

    public abstract void Run();

    //Entity<Daqui pra baixo>
    public Worker(String name) {
        m_name = name;
    }

    public String GetName() {
        return m_name;
    }

    public void SetID(int id) {
        m_id = id;
    }

    public int GetID() {
        return m_id;
    }

    public boolean HandleMessage(Message msg) {
        return m_stateMachine.handleMessage(msg);
    }
}
