package encryptions.chiChiper;


public class Decoder {

	
	/**
	 * @param args
	 */
	public static String decode(String data,String Password) {
		
		String[] datas = data.split(Encoder.separator);
		
		final int mid = datas[0].length() / 2;
	    String[] parts = {
	        datas[0].substring(0, mid),
	        datas[0].substring(mid),
	    };
		int offset = new FindOffset().getOffset(Integer.parseInt(parts[0]));
		
		
		BasicChiper chiper = new BasicChiper(offset);
		
		BasicChiper chiperData4 = new BasicChiper(new FindOffset().getPasswordOffset(chiper,parts[1]));
		
		String password = chiperData4.Decode(datas[2]);
		
		BasicChiper chiper3 = new BasicChiper(new FindOffset().getPasswordOffset(chiper,password));
		
		String temp = chiper3.Decode(parts[1]);
	
		if(!temp.equals(parts[0])){
			return "error";
		}
	   
		
		BasicChiper chiperData = new BasicChiper(new FindOffset().getPasswordOffset(chiper,Password));
		
		
		String Data = chiperData.Decode(datas[1]);
		
		BasicChiper chiper2 = new BasicChiper(new FindOffset().getPasswordOffset(chiper,Data));
		
		
		
		
		Data = chiper.Decode(Data);
		password = chiper2.Decode(password);
		
		if(!password.equals(Password)){
			
			return "Invalid Passcode";
			
		}else{
			
			return Data;
		}
		
	}

}
