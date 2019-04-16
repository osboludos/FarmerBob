package WorkerManager.Farmer.States.BillyStates;

import WorkerManager.Farmer.FarmerBilly;
import WorkerManager.Farmer.States.MessageManager.Message;
import WorkerManager.Farmer.States.State;

public class WalkingFarm implements State<FarmerBilly> {

    private WalkingFarm(){ }

    private static WalkingFarm m_instance = null;

    public static WalkingFarm getInstance(){
        return m_instance != null ? m_instance : (m_instance = new WalkingFarm());
    }

    @Override
    public void Enter(FarmerBilly farmer) {
        farmer.tedio=15;
        farmer.next = farmer.Randomi();
    }

    @Override
    public void Run(FarmerBilly farmer) {
        farmer.tedio--;
        System.out.printf("Andando pela fazenda... %d\n", farmer.tedio);
        if (farmer.tedio <= 0){
            farmer.tedio=0;
            farmer.next = farmer.Randomi();
            System.out.printf("%d\n", farmer.next);
            if(farmer.next != 1) {
                farmer.GetStateMachine().ChangeState(LookAtSky.getInstance());
            }
        }
    }

    @Override
    public void Exit(FarmerBilly farmer) {
        System.out.println("Indo fazer outra coisa.");
    }

    @Override
    public boolean onMessage(FarmerBilly farmer, Message msg) {
        return false;
    }

}
