package Farmer.States;

import Farmer.Bob;

public abstract class StateMachine {

    public abstract void Enter(Bob bob);
    public abstract void Run(Bob bob);
    public abstract void Exit(Bob bob);

}
