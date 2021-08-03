package sol;

import java.util.Scanner;

public class LostBracket {
	public static void main(String[] args){
		int ans = 0;
		boolean isOn = false;
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		String[] numbers = str.split("-|\\+");
		String[] expressions = str.split("[0-9]+");
		if(expressions.length == 0){
			expressions = new String[]{"+"};
		}else{
			expressions[0] = "+";
		}
		sc.close();
		int number = 0;
		for(int i=0;i<numbers.length;i++){
			number = Integer.parseInt(numbers[i]);
			isOn = !isOn && expressions[i].equals("-") ? true : isOn;
			ans += isOn ? -number : number;
		}
		System.out.println(ans);
	}
}