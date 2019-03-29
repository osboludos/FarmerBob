package Farmer;

import Farmer.States.EnterMineAndDigForNugget;
import Farmer.States.StateMachine;

public class Bob {

    private StateMachine m_currentState;

    private int Thirst = 0;

    private int Pocket = 0;

    private int Wealthy = 0;

    private int Fadige = 0;

    public Bob(){
        ChangeState(new EnterMineAndDigForNugget());
    }

    public void Run(){
        while (true){
            try {
                Thread.sleep(600);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            m_currentState.Run(this);
        }
    }

    public void ChangeState(StateMachine next){
        if (m_currentState != null){
            m_currentState.Exit(this);
        }
        m_currentState = next;
        m_currentState.Enter(this);
    }

    public boolean IsSatisfied(){
        return Thirst <= 0;
    }

    public boolean IsThirsty(){
        return Thirst > 20;
    }

    public void Mine(){
        Fadige++;
        Thirst++;
        Pocket++;
        System.out.printf("Mineirando... bolsos em %d\n", Pocket);
    }

    public boolean PocketsFull(){
        return Pocket >= 5;
    }

    public void DepositGold(){
        Wealthy += Pocket;
        Pocket = 0;
        System.out.printf("Depositei muita grana! Agora no banco eu tenho %d\n", Wealthy);
    }

    public boolean IsWealthy(){
        return Wealthy > 10;
    }

    public void BuyDrink(){
        Wealthy--;
        Thirst--;
        System.out.printf("Tomando suquinho... sede em %d\n", Thirst);
    }

    public void Rest(){
        Fadige--;
        System.out.printf("Dormindo... fadiga em %d\n", Fadige);
    }

    public boolean IsRested(){
        return Fadige <= 0;
    }


}
