package WorkerManager.Farmer.States.BobStates;

import WorkerManager.Farmer.FarmerBob;
import WorkerManager.Farmer.States.MessageManager.Message;
import WorkerManager.Farmer.States.State;

public class EnterMineAndDigForNugget implements State<FarmerBob> {

    private EnterMineAndDigForNugget(){ }

    private static EnterMineAndDigForNugget m_instance = null;

    public static EnterMineAndDigForNugget getInstance(){
        return m_instance != null ? m_instance : (m_instance = new EnterMineAndDigForNugget());
    }

    @Override
    public void Enter(FarmerBob farmerBob) {
        System.out.println("WorkerManager/Farmer " + farmerBob.GetName() +" Indo TRAMPAR");
    }

    @Override
    public void Run(FarmerBob farmerBob){
        farmerBob.Mine();
        if (farmerBob.PocketsFull()){
            farmerBob.GetStateMachine().ChangeState(VisitBankAndDepositGold.getInstance());
            return;
        }

        if (farmerBob.IsThirsty()){
            farmerBob.GetStateMachine().ChangeState(QuenchThirst.getInstance());
        }
    }

    @Override
    public void Exit(FarmerBob farmerBob) {
        System.out.println("WorkerManager/Farmer " + farmerBob.GetName() + " saindo da FIRMA");
    }

    @Override
    public boolean onMessage(FarmerBob farmer, Message msg) {
        return false;
    }
}
