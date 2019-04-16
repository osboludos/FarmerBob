package WorkerManager.Farmer.States.MessageManager;

import WorkerManager.Farmer.Worker;

public class Message
{
    private Worker m_sender;
    private Worker m_receiver;
    private String m_msg;
    private Object m_objectExtra;


    //Com info extra
    public Message(Worker sender, Worker receiver, String myMessage, Object extraInfo)
    {
        m_sender = sender;
        m_receiver = receiver;
        m_msg = myMessage;
        m_objectExtra = extraInfo;
    }

    //Sem info extra
    public  Message (Worker sender, Worker receiver, String myMessage)
    {
        m_sender = sender;
        m_receiver = receiver;
        m_msg = myMessage;
    }

    public String GetMessage(){return  m_msg;}

    public Worker GetReceiver() {return m_receiver;}

    public Worker GetSender() {return m_sender;}

    public Object GetObject() {return m_objectExtra;}

}
