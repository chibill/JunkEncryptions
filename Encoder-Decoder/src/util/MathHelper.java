package util;

public class MathHelper {

	public static boolean isPerfectSquare(double num){
		
		if(Math.sqrt(num)*Math.sqrt(num) == num){
			return true;
		}else{
			return false;
		}
		
	}
	
	public static boolean isPerfectSquare(int num){
		if(Math.sqrt(num)*Math.sqrt(num) == num){
			return true;
		}else{
			return false;
		}
	}
	
	public static boolean isPerfectSquare(float num){
		if(Math.sqrt(num)*Math.sqrt(num) == num){
			return true;
		}else{
			return false;
		}
	}
	
	public static boolean isPerfectSquare(long num){
		if(Math.sqrt(num)*Math.sqrt(num) == num){
			return true;
		}else{
			return false;
		}
	}
}
