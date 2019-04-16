package WorkerManager.Farmer.States.BobStates;

import WorkerManager.Farmer.FarmerBob;
import WorkerManager.Farmer.States.MessageManager.Message;
import WorkerManager.Farmer.States.State;

public class VisitBathroom implements State<FarmerBob> {


    private VisitBathroom(){ }

    private static VisitBathroom m_instance = null;

    public static VisitBathroom GetInstance(){
        return m_instance != null ? m_instance : (m_instance = new VisitBathroom());
    }
    
    @Override
    public void Enter(FarmerBob farmer) {
        
    }

    @Override
    public void Run(FarmerBob farmer) {
        System.out.println("Bathroom time!");
        farmer.GetStateMachine().RevertToPreviousState();
    }

    @Override
    public void Exit(FarmerBob farmer) {

    }

    @Override
    public boolean onMessage(FarmerBob farmer, Message msg) {
        return false;
    }
}
