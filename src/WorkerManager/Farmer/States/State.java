package WorkerManager.Farmer.States;

import WorkerManager.Farmer.States.MessageManager.Message;

public interface State<NPC> {

    void Enter(NPC farmer);
    void Run(NPC farmer);
    void Exit(NPC farmer);
    boolean onMessage(NPC farmer, Message msg);

}
