package Farmer.States;

public interface State<NPC> {

    void Enter(NPC farmer);
    void Run(NPC farmer);
    void Exit(NPC farmer);

}
