package Farmer.States;

public interface StateMachine<NPC> {

    void Enter(NPC farmer);
    void Run(NPC farmer);
    void Exit(NPC farmer);

}
