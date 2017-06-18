package activemq.queues;
/*  
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MessageConsumer;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class RequestProcessor {
	
	
	public void requestHandler(HashMap<Serializable, Serializable> requestParam) throws Exception {
		System.out.println("requestHandler....." + requestParam.toString());
		for (Map.Entry<Serializable, Serializable> entry : requestParam.entrySet()) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
	}

	public static void main(String[] args) throws Exception {
		// 1. 获得JMS connection factory. 通过我们提供特定环境的连接信息来构造factory
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_USER,
				ActiveMQConnection.DEFAULT_PASSWORD, "tcp://127.0.0.1:61616");
		// 2. 利用factory构造JMS connection
		Connection connection = connectionFactory.createConnection();
		// 3. 启动connection
		connection.start();
		// 4. 通过connection创建JMS session.
		Session session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
		// 5. 指定JMS destination.
		Destination destination = session.createQueue("RequestQueue");
		// 6. 创建JMS producer或者创建JMS message并提供destination. (????
		// 7. 创建JMS consumer或注册JMS message listener.
		// 消息消费（接收）者
		MessageConsumer consumer = session.createConsumer(destination);

		RequestProcessor processor = new RequestProcessor();

		while (true) {
			ObjectMessage message = (ObjectMessage) consumer.receive(1000);
			if (null != message) {
				System.out.println(message);
				HashMap<Serializable, Serializable> requestParam = (HashMap<Serializable, Serializable>) message
						.getObject();
				// 发送和接收JMS message.
				processor.requestHandler(requestParam);
			} else {
				break;
			}
		}
	}
	
	// end: 关闭所有JMS资源，包括connection, session, producer, consumer等。
	 
	
} */