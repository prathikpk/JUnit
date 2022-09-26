package comm.Aurionpro.model2;

public class LineItem {
	public int id;
	public int quantity;
	Product product;

	public LineItem(int id, int quantity, Product product) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.product = product;
	}

	public int getId() {
		return id;
	}

	public int getQuantity() {
		return quantity;
	}

	public Product getProduct() {
		return product;
	}
	
	public double calculateLineItemcost() {
		return product.calculatePriceAfterDiscount()*quantity;
	}

	@Override
	public String toString() {
		return "LineItem [id=" + id + ", quantity=" + quantity + ", product=" + product + "]";
	}

}
