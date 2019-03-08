package Farmer.States;

import Farmer.Bob;

public class GoHomeAndSleepTilRested extends StateMachine {
    @Override
    public void Run(Bob bob) {
        System.out.printf("Dormindo... fadiga em %d\n", bob.Fadige);
        bob.Fadige--;
        if (bob.Fadige <= 0){
            bob.Fadige = 0;
            bob.ChangeState(new EnterMineAndDigForNugget());
        }
    }
}
