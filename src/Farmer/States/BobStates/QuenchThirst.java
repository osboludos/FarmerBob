package Farmer.States.BobStates;

import Farmer.FarmerBob;
import Farmer.States.StateMachine;

public class QuenchThirst implements StateMachine<FarmerBob> {

    private QuenchThirst(){ }

    private static QuenchThirst m_instance = null;

    public static QuenchThirst getInstance(){
        return m_instance != null ? m_instance : (m_instance = new QuenchThirst());
    }
    @Override
    public void Enter(FarmerBob farmerBob) {
        System.out.println("Farmer " + farmerBob.getName() + " Indo pro bar bebe cachaçaaaaaaaaaaa");
    }

    @Override
    public void Run(FarmerBob farmerBob) {
        farmerBob.BuyDrink();

        if (farmerBob.IsSatisfied()){
            farmerBob.ChangeState(EnterMineAndDigForNugget.getInstance());
        }
    }

    @Override
    public void Exit(FarmerBob farmerBob) {
        System.out.println("Farmer " + farmerBob.getName() + " Saindo do bar BEM CALIBRADO");
    }
}
