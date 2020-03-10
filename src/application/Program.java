package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {
	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter the client data: ");
		System.out.print("Name : ");
		String name = sc.nextLine();
		System.out.print("Email : ");
		String email = sc.nextLine();
		System.out.print("Birth Date (DD/MM/YYYY): ");
		String birthDate = sc.nextLine();
		Client client = new Client(name,email,sdf.parse(birthDate));
		
		System.out.println("Enter the order data");
		System.out.print("Status : ");
		String satus = sc.nextLine();
		System.out.print("How many items to this order : ");
		int n = sc.nextInt();
		
		Order order = new Order(new Date(), OrderStatus.valueOf(satus),client);
		
		for (int i = 0; i < n; i++) {
			System.out.println("Enter #"+(i+1) + " item data:");
			sc.nextLine();
			System.out.print("Product Name: ");
			String nameProduct = sc.nextLine();
			System.out.print("Product Price: ");
			double priceProduct = sc.nextDouble();
			System.out.print("Product Quantity: ");
			int quantity = sc.nextInt();
			order.addItem(new OrderItem(quantity,priceProduct,new Product(nameProduct, priceProduct)));
			
		}
		
		System.out.println(order);
		
		
		
		sc.close();
	}
}
