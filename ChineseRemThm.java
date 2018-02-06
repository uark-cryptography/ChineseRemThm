import java.util.Arrays;

class ChineseRemThm{

	void run(int a, int b, int c, int d){
		int[] cons = {a,c};
		int[] mods = {b,d};
		
		solve(cons, mods);
		
	}
	
	void solve(int[] cons, int[] mods){
		System.out.println(Arrays.toString(cons));
		System.out.println(Arrays.toString(mods));
	}

	public static void main(String args[]){
		ChineseRemThm one = new ChineseRemThm();
		ChineseRemThm two = new ChineseRemThm();
		ChineseRemThm three = new ChineseRemThm();
		ChineseRemThm four = new ChineseRemThm();
		ChineseRemThm five = new ChineseRemThm();
		
		one.run(3,7,4,9);
		two.run(137, 423, 87, 191);
		three.run(133, 451, 237, 697);
	}
}