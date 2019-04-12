package Farmer.States.BobStates;

import Farmer.FarmerBob;
import Farmer.States.GlobalStates.GoToBathroom;
import Farmer.States.State;

public class EnterMineAndDigForNugget implements State<FarmerBob> {

    private EnterMineAndDigForNugget(){ }

    private static EnterMineAndDigForNugget m_instance = null;

    public static EnterMineAndDigForNugget getInstance(){
        return m_instance != null ? m_instance : (m_instance = new EnterMineAndDigForNugget());
    }

    @Override
    public void Enter(FarmerBob farmerBob) {
        System.out.println("Farmer " + farmerBob.getName() +" Indo TRAMPAR");
    }

    @Override
    public void Run(FarmerBob farmerBob){
        farmerBob.Mine();
        if (farmerBob.PocketsFull()){
            farmerBob.ChangeState(VisitBankAndDepositGold.getInstance());
            return;
        }

        if (farmerBob.IsThirsty()){
            farmerBob.ChangeState(QuenchThirst.getInstance());
        }

        farmerBob.GetStateMachine().ChangeGlobalState(GoToBathroom.getInstance());
    }

    @Override
    public void Exit(FarmerBob farmerBob) {
        System.out.println("Farmer " + farmerBob.getName() + " saindo da FIRMA");
    }
}
