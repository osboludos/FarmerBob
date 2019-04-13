package Farmer.States;

import Farmer.Farmer;
import Farmer.States.MessageManager.Message;

public interface GlobalState
{
    void Enter(Farmer entityFarmer);
    void Run(Farmer entityFarmer);
    void Exit(Farmer entityFarmer);
    boolean onMessage(Farmer entityFarmer, Message msg);
}
