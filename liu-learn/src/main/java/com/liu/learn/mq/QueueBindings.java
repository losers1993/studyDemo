package com.liu.learn.mq;

public interface QueueBindings {
	String getExchange();
    
    String getRoutingKey();
    
    class DefaultQueueBindings implements QueueBindings {
    	
    	private String exchange;
    	private String routingKey;
    	
		public DefaultQueueBindings(String exchange, String routingKey) {
			this.exchange = exchange;
			this.routingKey = routingKey;
		}

		@Override
		public String getExchange() {
			return exchange;
		}

		@Override
		public String getRoutingKey() {
			return routingKey;
		}
    	
    }
    
}
