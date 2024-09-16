package shopping;

import java.util.*;
//pojo object(fiels/getter/setter)+ identity field => entity
public class ProductEntity implements java.io.Serializable {

	private int productNo;

	private double price;

	private int stock;

	private List<OrderEntity> orders;

	public int getProductNo() { return productNo; }
	public void setProductNo(int value) { productNo = value; }

	public double getPrice() { return price; }
	public void setPrice(double value) { price = value; }

	public int getStock() { return stock; }
	public void setStock(int value) { stock = value; }

	public List<OrderEntity> getOrders() { return orders; }
}

