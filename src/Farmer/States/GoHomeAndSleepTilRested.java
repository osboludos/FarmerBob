package Farmer.States;

import Farmer.Bob;

public class GoHomeAndSleepTilRested extends StateMachine {
    @Override
    public void Enter(Bob bob) {
        System.out.println("Indo TORAR");
    }

    @Override
    public void Run(Bob bob) {
        bob.Rest();
        if (bob.IsRested()){
            bob.ChangeState(new EnterMineAndDigForNugget());
        }
    }

    @Override
    public void Exit(Bob bob) {
        System.out.println("ALVORADAAAAAAAA");
    }
}
