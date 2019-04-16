package WorkerManager.Farmer.States.BillyStates;

import WorkerManager.Farmer.FarmerBilly;
import WorkerManager.Farmer.States.MessageManager.Message;
import WorkerManager.Farmer.States.State;

public class BillyGlobalState implements State<FarmerBilly> {
    @Override
    public void Enter(FarmerBilly farmer) {

    }

    @Override
    public void Run(FarmerBilly farmer) {

    }

    @Override
    public void Exit(FarmerBilly farmer) {

    }

    @Override
    public boolean onMessage(FarmerBilly farmer, Message msg) {
        if(msg.GetMessage().compareTo("GetToWork!")==0) {
            farmer.GetStateMachine().ChangeState(TryingToWork.getInstance());
            return true;
        }
        return false;
    }
}
