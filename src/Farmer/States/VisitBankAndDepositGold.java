package Farmer.States;

import Farmer.Bob;

public class VisitBankAndDepositGold extends StateMachine {

    @Override
    public void Enter(Bob bob) {
        System.out.println("Indo pro banco...");
    }

    @Override
    public void Run(Bob bob) {
        bob.DepositGold();
        if (bob.IsWealthy()){
            bob.ChangeState(new GoHomeAndSleepTilRested());
        }
        else{
            bob.ChangeState(new EnterMineAndDigForNugget());
        }
    }

    @Override
    public void Exit(Bob bob) {
        System.out.println("saindo do banco...");
    }
}
