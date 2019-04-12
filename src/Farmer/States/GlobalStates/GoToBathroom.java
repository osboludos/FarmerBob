package Farmer.States.GlobalStates;

import Farmer.Farmer;
import Farmer.States.GlobalState;

public class GoToBathroom implements GlobalState {

    private GoToBathroom(){ }

    private static GoToBathroom m_instance = null;

    public static GoToBathroom getInstance(){
        return m_instance != null ? m_instance : (m_instance = new GoToBathroom());
    }

    @Override
    public void Enter(Farmer farmer) {
        System.out.println("Indo pro banheiro...");
    }

    @Override
    public void Run(Farmer farmer) {
        System.out.println("Fazendo minhas coisas");
        farmer.ChangeState(farmer.GetStateMachine().GetLastState());

    }

    @Override
    public void Exit(Farmer farmer) {
        System.out.println("Indo embora do banheiro!");
    }
}
