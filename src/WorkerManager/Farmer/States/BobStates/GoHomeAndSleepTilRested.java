package WorkerManager.Farmer.States.BobStates;

import WorkerManager.Farmer.FarmerBob;
import WorkerManager.Farmer.States.MessageManager.Message;
import WorkerManager.Farmer.States.MessageManager.MessageDispatcher;
import WorkerManager.Farmer.States.State;
import WorkerManager.Farmer.Worker;
import WorkerManager.WorkerManager;

public class GoHomeAndSleepTilRested implements State<FarmerBob> {

    private GoHomeAndSleepTilRested(){ }

    private static GoHomeAndSleepTilRested m_instance = null;

    public static GoHomeAndSleepTilRested getInstance(){
        return m_instance != null ? m_instance : (m_instance = new GoHomeAndSleepTilRested());
    }

    @Override
    public void Enter(FarmerBob farmerBob)
    {
        farmerBob.BillyWorkIsDone(false);
        Worker billy = WorkerManager.getInstance().GetWorker("Billy");

        MessageDispatcher.getInstance().DispatchMessage(farmerBob, billy, "VAI TRABALHAR VAGABUNDO");

        System.out.println("WorkerManager/Farmer " + farmerBob.GetName() + " Indo TORAR");
    }

    @Override
    public void Run(FarmerBob farmerBob)
    {
        if(farmerBob.BillyHasWorked() && farmerBob.IsRested()) {
            farmerBob.GetStateMachine().ChangeState(EnterMineAndDigForNugget.getInstance());
        }
        else if (farmerBob.IsRested()) {
            System.out.println("Cacete o billy ainda n terminou");
        }
    }

    @Override
    public void Exit(FarmerBob farmerBob) {
        System.out.println("WorkerManager/Farmer " + farmerBob.GetName() + " ALVORADAAAAAAAA");
    }

    @Override
    public boolean onMessage(FarmerBob farmer, Message msg) {
        return false;
    }

}
