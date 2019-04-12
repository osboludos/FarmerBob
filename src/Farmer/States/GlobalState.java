package Farmer.States;

import Farmer.Farmer;

public interface GlobalState {
    void Enter(Farmer farmer);
    void Run(Farmer farmer);
    void Exit(Farmer farmer);
}
