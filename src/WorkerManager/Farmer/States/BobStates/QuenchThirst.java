package WorkerManager.Farmer.States.BobStates;

import WorkerManager.Farmer.FarmerBob;
import WorkerManager.Farmer.States.MessageManager.Message;
import WorkerManager.Farmer.States.State;

public class QuenchThirst implements State<FarmerBob> {

    private QuenchThirst(){ }

    private static QuenchThirst m_instance = null;

    public static QuenchThirst getInstance(){
        return m_instance != null ? m_instance : (m_instance = new QuenchThirst());
    }
    @Override
    public void Enter(FarmerBob farmerBob) {
        System.out.println("WorkerManager/Farmer " + farmerBob.GetName() + " Indo pro bar bebe cachaçaaaaaaaaaaa");
    }

    @Override
    public void Run(FarmerBob farmerBob) {
        farmerBob.BuyDrink();

        if (farmerBob.IsSatisfied()){
            farmerBob.GetStateMachine().ChangeState(EnterMineAndDigForNugget.getInstance());
        }
    }

    @Override
    public void Exit(FarmerBob farmerBob) {
        System.out.println("WorkerManager/Farmer " + farmerBob.GetName() + " Saindo do bar BEM CALIBRADO");
    }

    @Override
    public boolean onMessage(FarmerBob farmer, Message msg) {
        return false;
    }
}
