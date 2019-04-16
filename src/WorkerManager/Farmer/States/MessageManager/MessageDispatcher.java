package WorkerManager.Farmer.States.MessageManager;

import WorkerManager.Farmer.Worker;

public class MessageDispatcher
{
    //Begin Singleton: private static MessageDispatcher instance = null;
    private MessageDispatcher() { }

    private static MessageDispatcher m_instance = null;

    public static MessageDispatcher getInstance() {  return m_instance != null ? m_instance : (m_instance = new MessageDispatcher());  }


    //Com info extra
    public void DispatchMessage(Worker sender, Worker receiver, String myMessage, Object extraInfo)
    {
        Message m_msg = new Message(sender, receiver, myMessage, extraInfo);

        DelieverMessage(receiver, m_msg);
    }
    //Sem info extra
    public void DispatchMessage(Worker sender, Worker receiver, String myMessage)
    {
        Message m_msg = new Message(sender, receiver, myMessage);

        DelieverMessage(receiver, m_msg);
    }

    private void DelieverMessage(Worker receiver, Message msg) {
        if (!receiver.HandleMessage(msg)){
            System.out.println("O caminhão do carteiro tombou!");
            return;
        }
        System.out.println("Mensagem: " +receiver.GetName() + ":  Entregue!\n" );
    }
}
