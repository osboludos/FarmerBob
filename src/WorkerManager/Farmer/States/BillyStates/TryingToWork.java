package WorkerManager.Farmer.States.BillyStates;

import WorkerManager.Farmer.FarmerBilly;
import WorkerManager.Farmer.States.MessageManager.Message;
import WorkerManager.Farmer.States.MessageManager.MessageDispatcher;
import WorkerManager.Farmer.States.State;
import WorkerManager.WorkerManager;

import java.util.Random;

public class TryingToWork implements State<FarmerBilly>
{
    private TryingToWork(){ }

    private static TryingToWork m_instance = null;

    public static TryingToWork getInstance(){
        return m_instance != null ? m_instance : (m_instance = new TryingToWork());
    }

    @Override
    public void Enter(FarmerBilly farmer) { System.out.printf("Indo tentar trabalhar......zzzzzzzz"); }

    @Override
    public void Run(FarmerBilly farmer) {

        System.out.println("Fingindo que to trabalhando kkk");

        Random r = new Random();
        if (r.nextInt(2) == 1){
            farmer.GetStateMachine().RevertToPreviousState();
        }

    }

    @Override
    public void Exit(FarmerBilly farmer) { System.out.printf("Chega de trampar, bora fazer outra coisa mais importante");
        MessageDispatcher.getInstance().DispatchMessage(farmer, WorkerManager.getInstance().GetWorker("Bob"), "JobsDone!");
    }

    @Override
    public boolean onMessage(FarmerBilly farmer, Message msg) {
        return false;
    }
}
