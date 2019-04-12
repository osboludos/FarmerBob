package Companhia;

import Farmer.*;
import Farmer.States.BobStates.*;
import Farmer.States.BillyStates.*;

import java.util.ArrayList;

public class CompanhiaDeGraos {

    private static CompanhiaDeGraos instance = null;

    private CompanhiaDeGraos(){
    }

    public static CompanhiaDeGraos getInstance(){
        return instance != null ? instance : (instance = new CompanhiaDeGraos());
    }

    private ArrayList<Farmer> m_workers = new ArrayList<>();
    private ArrayList<Farmer> m_deadWorkers = new ArrayList<>();

    public void FarmerIsDead(FarmerBob farmerBob){
        m_deadWorkers.add(farmerBob);
    }


    public void Run() throws InterruptedException {

        m_workers.add(new FarmerBob("Jozoal", QuenchThirst.getInstance()));
        m_workers.add(new FarmerBilly(LookAtSky.getInstance()));

        while (true) {
            Thread.sleep(1000);
            m_workers.forEach(farmer -> {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                farmer.Run();
            });

            while (!m_deadWorkers.isEmpty()) {
                Farmer dead = m_deadWorkers.get(0);
                m_workers.remove(dead);
                m_deadWorkers.remove(dead);
            }
        }
    }
}
