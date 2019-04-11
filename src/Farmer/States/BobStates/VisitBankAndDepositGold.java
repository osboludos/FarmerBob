package Farmer.States.BobStates;

import Farmer.FarmerBob;
import Farmer.States.StateMachine;

public class VisitBankAndDepositGold implements StateMachine<FarmerBob> {

    private VisitBankAndDepositGold(){ }

    private static VisitBankAndDepositGold m_instance = null;

    public static VisitBankAndDepositGold getInstance(){
        return m_instance != null ? m_instance : (m_instance = new VisitBankAndDepositGold());
    }

    @Override

    public void Enter(FarmerBob farmerBob) {
        System.out.println("Farmer " + farmerBob.getName() + " Indo pro banco...");
    }

    @Override
    public void Run(FarmerBob farmerBob) {
        farmerBob.DepositGold();
        if (farmerBob.IsWealthy()){
            farmerBob.ChangeState(GoHomeAndSleepTilRested.getInstance());
        }
        else{
            farmerBob.ChangeState(EnterMineAndDigForNugget.getInstance());
        }
    }

    @Override
    public void Exit(FarmerBob farmerBob) {
        System.out.println("Farmer " + farmerBob.getName() + " saindo do banco...");
    }
}
