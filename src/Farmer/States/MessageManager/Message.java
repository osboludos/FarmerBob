package Farmer.States.MessageManager;

import Farmer.Farmer;

public class Message
{
    private  Farmer m_sender;
    private Farmer m_receiver;
    private String m_msg;
    private Object m_objectExtra;


    //Com info extra
    public Message(Farmer sender, Farmer receiver, String myMessage, Object extraInfo)
    {
        m_sender = sender;
        m_receiver = receiver;
        m_msg = myMessage;
        m_objectExtra = extraInfo;
    }

    //Sem info extra
    public  Message (Farmer sender, Farmer receiver, String myMessage)
    {
        m_sender = sender;
        m_receiver = receiver;
        m_msg = myMessage;
    }

    public String GetMessage(){return  m_msg;}

    public Farmer GetReceiver() {return m_receiver;}

    public Farmer GetSender() {return m_sender;}

    public Object GetObject() {return m_objectExtra;}

}
