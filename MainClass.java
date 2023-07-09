//As a customer to Rent a Ride, you book a cab. We charge you as per the distance covered. We charge 8rs/km.
package rentaride;
import java.util.*;
public class MainClass {
	private static int id,smallest;
	private static float distance1;
	private String[] name, car_model,pref_destination;
	private float[] rating;
	private int[] distance;
	public void initialize(int n) {
		name = new String[n];
		car_model = new String[n];
		pref_destination = new String[n];
		rating = new float[n];
		distance = new int[n];
	}
	public void addDriverDetails(int n, Scanner sc) {
		for(int i = 0; i < n;i++) {
			System.out.print("Enter Driver Name : ");
			name[i] = sc.next();
			System.out.print("Enter Car Model : ");
			car_model[i] = sc.next();
			System.out.print("Enter Rating : ");
			rating[i] = sc.nextFloat();
			System.out.print("Enter distance from customer (in meters) : ");
			distance[i] = sc.nextInt();
			System.out.println("Enter preferred destination : ");
			pref_destination[i] = sc.next();
		}
	}
	public void displayDriverDetails(int n) {
		System.out.println("Driver Name - Car Model - Rating - Distance from customer - preferred destination");
		for(int i = 0; i < n;i++) {
			System.out.println(name[i] + "-" + car_model[i] + "-" + rating[i] + "-" + distance[i] + "-" + pref_destination[i]);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number of drivers : ");
	    int n = sc.nextInt();
		MainClass m1 = new MainClass();
		m1.initialize(n);
		m1.addDriverDetails(n, sc);
		m1.displayDriverDetails(n);
		System.out.print("Enetr the Customer ride distance : ");
		String dist = sc.next();
		if(dist.contains("km")) {
			distance1 = Float.parseFloat(dist.substring(0,dist.length() - 2)); 
		}else {
			distance1 = Float.parseFloat(dist);
		}
		sc.nextLine();
		System.out.print("Car Requested (optional) : ");
		String model_name = sc.nextLine();
		if(model_name.length() > 0) {
			while(true) {
				int flag = 0;
				for(int i = 0;i < n;i++)
					if(m1.car_model[i].equals(model_name))
						flag = 1;
				if(flag == 1)
					break;
			}
		}
		//sc.nextLine();
		System.out.print("Destination (optional) : ");
		String destination_preferred = sc.nextLine();
		if(model_name.length() == 0 && destination_preferred.length() == 0) {
			id = 0;
			smallest = m1.distance[0];
			for(int i = 1;i < n; i++) {
				if(m1.distance[i] < smallest && m1.rating[i] >= 4) {
					smallest = m1.distance[i];
					id = i;
				}
			}
			System.out.println("Driver " + m1.name[id] + " will get you to the destination");
			System.out.println("Your charge will be Rs " + distance1 * 8);
		}else if(destination_preferred.length() == 0) {
			id = 0;
			for(int i = 0,flag = 0; i < n;i++) {
				if((m1.car_model[i]).matches(model_name)) {
					if(flag == 0 && m1.rating[i] >= 4) {
						smallest = m1.distance[i];
						flag = 1;
					}
					if(m1.distance[i] < smallest && m1.rating[i] >= 4) {
						smallest = m1.distance[i];
						id = i;
					}
				}
			}
			System.out.println("Driver " + m1.name[id] + " will get you to the destination");
			System.out.println("Your charge will be Rs " + distance1 * 8);
		}else if(destination_preferred.length() > 0) {
      id = 0;
			for(int i = 0,flag = 0; i < n;i++) {
				if((m1.car_model[i]).matches(model_name)) {
					if(flag == 0 && m1.rating[i] >= 4) {
						smallest = m1.distance[i];
						flag = 1;
					}
					if(m1.distance[i] < smallest && m1.rating[i] >= 4 && (m1.pref_destination[i]).contains(destination_preferred)) {
						smallest = m1.distance[i];
						id = i;
					}
				}
			}
			System.out.println("Driver " + m1.name[id] + " will get you to the destination");
			System.out.println("Your charge will be Rs " + distance1 * 8);
		}
	}
}
