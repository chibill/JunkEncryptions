package encryptions.chiChiper;


public class Encoder {
	
	 public final static String separator = "\u2300";
	
	public static String Encode(String Data,String Password){
		int[] temp = new FindOffset().getOffset();
		
		String outData = "";
		
		BasicChiper chiper = new BasicChiper(temp[0]);
		
		BasicChiper chiperData = new BasicChiper(new FindOffset().getPasswordOffset(chiper,Password));
		
		outData = chiper.Encode(Data);
		
		BasicChiper chiper2 = new BasicChiper(new FindOffset().getPasswordOffset(chiper,outData));
		
		outData = chiperData.Encode(outData); 
		
		String passout = chiper2.Encode(Password);
		
		BasicChiper chiperData3 = new BasicChiper(new FindOffset().getPasswordOffset(chiper,passout));
		
		String front = chiperData3.Encode(temp[1] + "");

		BasicChiper chiperData4 = new BasicChiper(new FindOffset().getPasswordOffset(chiper,front));
		
		passout = chiperData4.Encode(passout);
		
		return temp[1] + front + separator + outData + separator + passout;
			
	}
	
	
	
}
