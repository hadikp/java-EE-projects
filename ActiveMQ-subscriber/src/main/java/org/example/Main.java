package org.example;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class Main {
    public static void main(String[] args) {
        try {
            MessageConsumer consumer = null;
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://127.0.0.1:61616");
            Connection connection = connectionFactory.createConnection();
            connection.start();

            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Queue queue = session.createQueue("PublishQueue");
            consumer = session.createConsumer(queue);

            Message response;
            while ((response = consumer.receive()) != null) {
                if (response instanceof TextMessage) {
                    TextMessage textMessage = (TextMessage) response;
                    String messageText = textMessage.getText();
                    System.out.println("Response: " + messageText);
                }
                connection.close();
            }
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
    }
}