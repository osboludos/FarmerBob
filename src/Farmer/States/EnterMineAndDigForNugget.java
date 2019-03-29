package Farmer.States;

import Farmer.Bob;

public class EnterMineAndDigForNugget extends StateMachine{

    @Override
    public void Enter(Bob bob) {
        System.out.println("Indo TRAMPAR");
    }

    @Override
    public void Run(Bob bob){
        bob.Mine();
        if (bob.PocketsFull()){
            bob.ChangeState(new VisitBankAndDepositGold());
            return;
        }

        if (bob.IsThirsty()){
            bob.ChangeState(new QuenchThirst());
        }
    }

    @Override
    public void Exit(Bob bob) {
        System.out.println("saindo da FIRMA");
    }
}
