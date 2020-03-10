package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	private Date moment;
	private OrderStatus status;
	private List<OrderItem> orderItems = new ArrayList<>();
	private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private Client client;
	
	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public Order(Date moment, OrderStatus status,Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	
	public void removeItem(OrderItem item) {
		orderItems.remove(item);
	}
	
	public void addItem(OrderItem item) {
		orderItems.add(item);
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ORDER SUMMARY:\n");
		sb.append("Order moment : "+ sdf.format(this.moment)+"\n");
		sb.append("Order Status : " + this.status.toString()+"\n");
		sb.append(client + "\n");
		sb.append("Order Items \n");
		double sum = 0;
		for (OrderItem orderItem : orderItems) {
			sb.append(orderItem + "\n");
			sum += orderItem.subTotal();
		}
		sb.append("Total Price " +String.format("%.2f", sum));
		return sb.toString();
	}
}
