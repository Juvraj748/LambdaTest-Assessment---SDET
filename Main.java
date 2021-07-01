package Main;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		String str="";
		while (s.hasNextLine()){ 
		    String read = s.nextLine();
		    if(read == null || read.isEmpty()){ 
		        break;  
		    }
			str+= read;
		}
		
		ArrayList<Product> arr = eachObj(str);
		
		java.util.Collections.sort(arr ,new Comparator<Product>() {

			public int compare(Product a, Product b) {
				if(a.price > b.price)
		            return 1;
		          else
		          if(a.price < b.price)
		            return -1;
		          else
		             return 0; 
			}
			
		});
		
		for(int i = 0 ; i<arr.size() ; i++) {
			System.out.println(arr.get(i).fullName);
		}
		
		
	}
	
	public static ArrayList<Product> eachObj(String str) {
		
		ArrayList<Product> arr = new ArrayList<Product>();
		
		for(int i = 0; i<str.length() ;i++) {
			int brackets = 0;
			int strSi = i, strEi=i;
			while(i<str.length() && brackets<2) {
				if(str.charAt(i)==39) brackets++;
				i++;
			}
			while(i<str.length() && (str.charAt(i)<'0' || str.charAt(i)>'9')) {
				i++;
			}
			int pi=i,pe=i;
			while(i<str.length() && str.charAt(i)>='0' && str.charAt(i)<='9') {
				i++;
			}
			int price = (str.substring(pi, i)=="")?0:Integer.parseInt(str.substring(pi,i));
			strEi=i;
			
			Product product = new Product(str.substring(strSi, strEi), price);
			arr.add(product);
		}
		
		return arr;
	}

}

class Product{
	String fullName="";
	int price = 0;
	
	public Product(String name, int price) {
		fullName = name;
		this.price = price;
	}
}
