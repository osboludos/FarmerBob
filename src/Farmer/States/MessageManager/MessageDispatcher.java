package Farmer.States.MessageManager;

import Farmer.Farmer;

import java.awt.*;

public class MessageDispatcher
{
    //Begin Singleton: private static MessageDispatcher instance = null;
    private MessageDispatcher() { }

    private static MessageDispatcher m_instance = null;

    public static MessageDispatcher getInstance() {  return m_instance != null ? m_instance : (m_instance = new MessageDispatcher());  }


    //Com info extra
    public void DispatchMessage(Farmer sender, Farmer receiver, String myMessage, Object extraInfo)
    {
        Message m_msg = new Message(sender, receiver, myMessage, extraInfo);

        DelieverMessage(receiver, m_msg);
    }
    //Sem info extra
    public void DispatchMessage(Farmer sender, Farmer receiver, String myMessage)
    {

    }

    private void DelieverMessage(Farmer receiver, Message m_msg) {
        System.out.println("Mensagem: " +receiver.getID() + ":  Entregue!\n" );
    }
}
