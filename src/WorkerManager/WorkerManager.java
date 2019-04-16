package WorkerManager;

import WorkerManager.Farmer.*;
import WorkerManager.Farmer.States.BobStates.*;
import WorkerManager.Farmer.States.BillyStates.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class WorkerManager {

    private static WorkerManager instance = null;

    private WorkerManager(){}

    public static WorkerManager getInstance(){
        return instance != null ? instance : (instance = new WorkerManager());
    }

    private HashMap<String, Worker> m_workers = new HashMap<>();


    public void AddWorker(Worker worker){
        m_workers.put(worker.GetName(), worker);
    }

    public Worker GetWorker(String name){
        return m_workers.get(name);
    }

    public void RemoveWorker(Worker worker){
        m_workers.remove(worker.GetName());
    }


    public void Run() throws InterruptedException {

        AddWorker(new FarmerBob("Bob", EnterMineAndDigForNugget.getInstance()));
        AddWorker(new FarmerBilly("Billy", LookAtSky.getInstance()));

        while (true){
            Thread.sleep(1000);
            m_workers.forEach((k,v) -> {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                v.Run();
            });
        }
    }
}
