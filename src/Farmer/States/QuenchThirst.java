package Farmer.States;

import Farmer.Bob;

public class QuenchThirst extends StateMachine {
    @Override
    public void Run(Bob bob) {
        bob.Thirst--;
        System.out.printf("Tomando suquinho... sede em %d\n", bob.Thirst);
        if (bob.Thirst <= 0){
            bob.Thirst = 0;
            bob.ChangeState(new EnterMineAndDigForNugget());
        }
    }
}
