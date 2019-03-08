package com.crady;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * author:Crady
 * date:2019/1/11 12:38
 * desc:
 **/
public class SmsComsumer {
    public ActiveMQConnection getConnection(){
//        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("failover:(tcp://192.168.221.180:61616,tcp://192.168.221.181:61616)?randomize=false");
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://192.168.221.181:61616");
        ActiveMQConnection connection = null;
        try {
            connection = (ActiveMQConnection) connectionFactory.createConnection();
        } catch (JMSException e) {
            e.printStackTrace();
        }
        return connection;
    }
    public void receiveMsg(){
        ActiveMQConnection connection = getConnection();
        try {
            connection.start();
            Session session = connection.createSession(true, Session.SESSION_TRANSACTED);
            Queue queue = session.createQueue("first-queue");

            MessageConsumer consumer = session.createConsumer(queue);
            TextMessage message = (TextMessage) consumer.receive();
            System.out.println(message.getText());
            session.commit();
            consumer.close();
            session.close();
            connection.close();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
    public static void main(String []args){
        SmsComsumer comsumer = new SmsComsumer();
        for (int i = 0; i < 2; i++) {
            comsumer.receiveMsg();
        }

    }
}
