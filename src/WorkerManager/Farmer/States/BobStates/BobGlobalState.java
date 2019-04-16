package WorkerManager.Farmer.States.BobStates;

import WorkerManager.Farmer.FarmerBob;
import WorkerManager.Farmer.States.MessageManager.Message;
import WorkerManager.Farmer.States.State;

import java.util.Random;

public class BobGlobalState implements State<FarmerBob> {

    private BobGlobalState(){ }

    private static BobGlobalState m_instance = null;

    public static BobGlobalState getInstance(){
        return m_instance != null ? m_instance : (m_instance = new BobGlobalState());
    }

    @Override
    public void Enter(FarmerBob farmer) {

    }

    @Override
    public void Run(FarmerBob farmer) {
        Random r = new Random();
        int rand = r.nextInt(100);
        if(rand == 1) {
            farmer.GetStateMachine().ChangeState(VisitBathroom.GetInstance());
        }
    }

    @Override
    public void Exit(FarmerBob farmer) {

    }

    @Override
    public boolean onMessage(FarmerBob farmer, Message msg) {

        if (msg.GetMessage().compareToIgnoreCase("JobsDone!") == 0) {
            farmer.BillyWorkIsDone(true);
            return true;
        }
        return false;
    }
}
