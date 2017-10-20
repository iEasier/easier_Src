package Main;


public class Test {
	private static String a = "in";
	public static void main(String[] args) {
		 new Test2(){
			 @Override
			 public void run(){
				a += "here!"; 
				System.out.println(a);
			 }
		 }.run();
		 System.out.println(a);
	}
}

class Test2{
	public void run(){
		System.out.println("in");
	}
}
