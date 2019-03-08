package Farmer.States;

import Farmer.Bob;

public class EnterMineAndDigForNugget extends StateMachine{


    @Override
    public void Run(Bob bob){
        bob.Fadige++;
        bob.Thirst++;
        bob.Pocket++;
        System.out.printf("Mineirando... bolsos em %d\n", bob.Pocket);

        if (bob.Pocket >= 20){
            bob.ChangeState(new VisitBankAndDepositGold());
            return;
        }

        if (bob.Thirst >= 80){
            bob.ChangeState(new QuenchThirst());
        }

    }
}
