package Farmer.States.BobStates;

import Farmer.FarmerBob;
import Farmer.States.State;

public class GoHomeAndSleepTilRested implements State<FarmerBob> {

    private GoHomeAndSleepTilRested(){ }

    private static GoHomeAndSleepTilRested m_instance = null;

    public static GoHomeAndSleepTilRested getInstance(){
        return m_instance != null ? m_instance : (m_instance = new GoHomeAndSleepTilRested());
    }

    @Override
    public void Enter(FarmerBob farmerBob) {
        System.out.println("Farmer " + farmerBob.getName() + " Indo TORAR");
    }

    @Override
    public void Run(FarmerBob farmerBob) {
        farmerBob.Rest();
        if (farmerBob.IsRested()){
            farmerBob.ChangeState(EnterMineAndDigForNugget.getInstance());
        }
    }

    @Override
    public void Exit(FarmerBob farmerBob) {
        System.out.println("Farmer " + farmerBob.getName() + " ALVORADAAAAAAAA");
    }
}
