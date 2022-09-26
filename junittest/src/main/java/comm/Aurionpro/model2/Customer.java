package comm.Aurionpro.model2;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	public int id;
	public String name;
	List<Order> orders = new ArrayList<>();

	public Customer(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void addOrder(Order order) {
		orders.add(order);
	}

	public int getOrdercount() {
		return orders.size();
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", orders=" + orders + "]";
	}

}
