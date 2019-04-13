package Farmer.States.BobStates;

import Farmer.Farmer;
import Farmer.FarmerBob;
import Farmer.States.Entity.EntityManager;
import Farmer.States.MessageManager.Message;
import Farmer.States.MessageManager.MessageDispatcher;
import Farmer.States.State;

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
        Farmer billy = EntityManager.getInstance().getEntity("Billy");

        MessageDispatcher.getInstance().DispatchMessage(farmerBob, billy, "VAI TRABALHAR VAGABUNDO");

        System.out.println("Farmer " + farmerBob.getName() + " Indo TORAR");
    }

    @Override
    public void Run(FarmerBob farmerBob)
    {
        farmerBob.Rest();
        if (farmerBob.IsRested()){
            farmerBob.ChangeState(EnterMineAndDigForNugget.getInstance());
        }
    }

    @Override
    public void Exit(FarmerBob farmerBob) {
        System.out.println("Farmer " + farmerBob.getName() + " ALVORADAAAAAAAA");
    }

    public boolean onMessage(Farmer farmer, Message msg) {
        return false;
    }

}
