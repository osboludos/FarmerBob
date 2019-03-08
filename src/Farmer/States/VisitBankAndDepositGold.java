package Farmer.States;

import Farmer.Bob;

public class VisitBankAndDepositGold extends StateMachine {

    @Override
    public void Run(Bob bob) {
        bob.Wealthy += bob.Pocket;
        bob.Pocket = 0;
        System.out.printf("Depositei muita grana! Agora no banco eu tenho %d\n", bob.Wealthy);
        if (bob.Wealthy >= 200){
            bob.ChangeState(new GoHomeAndSleepTilRested());
        }
        else{
            bob.ChangeState(new EnterMineAndDigForNugget());
        }
    }
}
