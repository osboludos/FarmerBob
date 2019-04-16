package WorkerManager.Farmer.States.BobStates;

import WorkerManager.Farmer.FarmerBob;
import WorkerManager.Farmer.States.MessageManager.Message;
import WorkerManager.Farmer.States.State;

public class VisitBankAndDepositGold implements State<FarmerBob> {

    private VisitBankAndDepositGold(){ }

    private static VisitBankAndDepositGold m_instance = null;

    public static VisitBankAndDepositGold getInstance(){
        return m_instance != null ? m_instance : (m_instance = new VisitBankAndDepositGold());
    }

    @Override

    public void Enter(FarmerBob farmerBob) {
        System.out.println("WorkerManager/Farmer " + farmerBob.GetName() + " Indo pro banco...");
    }

    @Override
    public void Run(FarmerBob farmerBob) {
        farmerBob.DepositGold();
        if (farmerBob.IsWealthy()){
            farmerBob.GetStateMachine().ChangeState(GoHomeAndSleepTilRested.getInstance());
        }
        else{
            farmerBob.GetStateMachine().ChangeState(EnterMineAndDigForNugget.getInstance());
        }
    }

    @Override
    public void Exit(FarmerBob farmerBob) {
        System.out.println("WorkerManager/Farmer " + farmerBob.GetName() + " saindo do banco...");
    }

    @Override
    public boolean onMessage(FarmerBob farmer, Message msg) {
        return false;
    }
}
