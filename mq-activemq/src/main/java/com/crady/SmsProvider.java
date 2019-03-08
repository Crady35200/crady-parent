package com.crady;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * author:Crady
 * date:2019/1/11 12:38
 * desc:
 **/
public class SmsProvider {
        public Connection getConnection(){
//            ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("failover:(tcp://192.168.221.180:61616,tcp://192.168.221.181:61616)?randomize=false");
            ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://192.168.221.180:61616");
            Connection connection = null;
            boolean n = connectionFactory.isUseAsyncSend();
                //connectionFactory.setUseAsyncSend(true); //使用异步发送方式
                //connectionFactory.setProducerWindowSize(100000);//设置异步情况下，消息回执，消息队列中达到阀值时，同步等待
                //connectionFactory.setAlwaysSyncSend(true);//非持久话消息下默认是异步方式，如需要在该模式下每次发送消息都需要等待回执，则设置。
                try {
                    connection = connectionFactory.createConnection();
                } catch (JMSException e) {
                e.printStackTrace();
            }
            return connection;
        }
        public void sendMsg(String msg){
            Connection connection = getConnection();
            try {
                connection.start();
                Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
                Queue queue = session.createQueue("first-queue");
                MessageProducer producer = session.createProducer(queue);
                int a = producer.getDeliveryMode();
//                producer.setDeliveryMode(DeliveryMode.PERSISTENT);
                Message message = session.createTextMessage(msg);
                producer.send(message);
                session.commit();
                producer.close();
                session.close();
                connection.close();
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
        public static void main(String []args){
            SmsProvider provider = new SmsProvider();
            for (int i = 0; i <100000 ; i++) {
                 provider.sendMsg("nice to meet you " + i);
            }
        }

}
