package Farmer.States;

import Farmer.Bob;

public class QuenchThirst extends StateMachine {
    @Override
    public void Enter(Bob bob) {
        System.out.println("Indo pro bar bebe cachaçaaaaaaaaaaa");
    }

    @Override
    public void Run(Bob bob) {
        bob.BuyDrink();

        if (bob.IsSatisfied()){
            bob.ChangeState(new EnterMineAndDigForNugget());
        }
    }

    @Override
    public void Exit(Bob bob) {
        System.out.println("Saindo do bar BEM CALIBRADO");
    }
}
