package Farmer.States.BillyStates;

import Farmer.FarmerBilly;
import Farmer.States.State;

public class TryingToWork implements State<FarmerBilly>
{
    private TryingToWork(){ }

    private static TryingToWork m_instance = null;

    public static TryingToWork getInstance(){
        return m_instance != null ? m_instance : (m_instance = new TryingToWork());
    }

    @Override
    public void Enter(FarmerBilly farmer) { System.out.printf("Indo tentar trabalhar......zzzzzzzz"); }

    @Override
    public void Run(FarmerBilly farmer) {


    }

    @Override
    public void Exit(FarmerBilly farmer) { System.out.printf("Chega de trampar, bora fazer outra coisa mais importante");

    }
}
