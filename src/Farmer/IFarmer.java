package Farmer;

import Farmer.States.StateMachine;

public interface IFarmer {
    void ChangeState(StateMachine state);
    void Run();
}
