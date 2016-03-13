package org.lee.util;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.workin.json.util.JSONUtils;

import org.lee.redis.cache.impl.RedisOperation;
import org.lee.vo.GoodsOrder;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.ConsumerCancelledException;
import com.rabbitmq.client.QueueingConsumer;
import com.rabbitmq.client.QueueingConsumer.Delivery;
import com.rabbitmq.client.ShutdownSignalException;

public class GoodsConsumer implements Runnable, InitializingBean {
	public static final long BUYSIZE = 1L;
	public static final String GOODS = "goods:";
	private Connection connection;
	private Channel channel;
	private QueueingConsumer consumer;
	private String host;
	private int port;
	private String userName;
	private String password;
	private String[] exchanges;
	private String[] type;
	private String queueName;
	private String bindExchange;
	private String routeExtrategy;
	@Autowired
	private RedisOperation redisOperation;
	
	private static final Logger logger = LoggerFactory.getLogger(GoodsConsumer.class);

	public void listenGoods(String requestInfo) {
		logger.info(requestInfo);
		/*JSONUtils.toBean(requestInfo, GoodsOrder.class);
		GoodsOrder goodsOrder = (GoodsOrder) MessageConvert.unserizableToObj(requestInfo);*/
		GoodsOrder goodsOrder = JSONUtils.toBean(requestInfo, GoodsOrder.class);
		redisOperation.addCart(GOODS + goodsOrder.getGoodsId(), goodsOrder, "stock");
	}

	public void init() {
		logger.info("init goodsCosumer");
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost(host);
		factory.setPort(port);
		factory.setUsername(userName);
		factory.setPassword(password);
		try {
			connection = factory.newConnection();
			channel = connection.createChannel();
			int i = 0;
			for (String exchange : exchanges) {
				channel.exchangeDeclare(exchange, type[i++]);
			}
			channel.queueDeclare(queueName, false, false, true, null);
			channel.queueBind(queueName, bindExchange, routeExtrategy);
			consumer = new QueueingConsumer(channel);
			channel.basicConsume(queueName, false, consumer);
			new Thread(this).start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void close() {
		if (connection != null) {
			try {
				connection.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void run() {
		while (true) {
			try {

				Delivery delivery = consumer.nextDelivery();
				String msg = new String(delivery.getBody());
				logger.info("reciv "+msg);
				this.listenGoods(msg);
				channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
			} catch (ShutdownSignalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ConsumerCancelledException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public QueueingConsumer getConsumer() {
		return consumer;
	}

	public void setConsumer(QueueingConsumer consumer) {
		this.consumer = consumer;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String[] getExchanges() {
		return exchanges;
	}

	public void setExchanges(String[] exchanges) {
		this.exchanges = exchanges;
	}

	public String[] getType() {
		return type;
	}

	public void setType(String[] type) {
		this.type = type;
	}

	public String getQueueName() {
		return queueName;
	}

	public void setQueueName(String queueName) {
		this.queueName = queueName;
	}

	public String getBindExchange() {
		return bindExchange;
	}

	public void setBindExchange(String bindExchange) {
		this.bindExchange = bindExchange;
	}

	public String getRouteExtrategy() {
		return routeExtrategy;
	}

	public void setRouteExtrategy(String routeExtrategy) {
		this.routeExtrategy = routeExtrategy;
	}

	public RedisOperation getRedisOperation() {
		return redisOperation;
	}

	public void setRedisOperation(RedisOperation redisOperation) {
		this.redisOperation = redisOperation;
	}

	@Override
	public void afterPropertiesSet() throws Exception {

		

	}

}
