package Farmer;

import Farmer.States.EnterMineAndDigForNugget;
import Farmer.States.StateMachine;

public class Bob {

    private StateMachine m_currentState;

    public int Thirst = 0;

    public int Pocket = 0;

    public int Wealthy = 0;

    public int Fadige = 0;

    public Bob(){
        ChangeState(new EnterMineAndDigForNugget());
    }

    public void Run(){
        while (true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            m_currentState.Run(this);
        }
    }

    public void ChangeState(StateMachine next){
        m_currentState = next;
    }

}
