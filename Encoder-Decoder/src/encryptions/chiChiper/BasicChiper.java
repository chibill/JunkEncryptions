package encryptions.chiChiper;

public class BasicChiper {

	private char[] Normal = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
	
	private char[] Offset = new char[Normal.length]; 

	public BasicChiper(int Offset){
		int temp = 0;
		System.out.println(Offset);
		while(temp < Normal.length){
						if(Offset > 61){
				Offset = Offset - 61;
			}
			if(temp + Offset < Normal.length){

				this.Offset[(temp + Offset)] = Normal[temp];
			}else{
				if(Offset < 1){
					this.Offset[temp + Offset-Normal.length] = Normal[temp];
				}else{
				this.Offset[temp + Offset-Normal.length] = Normal[temp];
				}
			}

			++temp;

		}



	}

	private char get(char in){

		for (int x = 0; x < Normal.length; ++x){

			if(Normal[x] == in){

				return this.Offset[x];

			}

		}
		return in;

	}

	public String Encode(String in){

		String out = "";

		for(int i = 0; i<in.length(); ++i){

			out = out + this.get(in.charAt(i));

		}

		return out;

	}
	
	public String Decode(String in){

		String out = "";

		for(int i = 0; i<in.length(); ++i){

			out = out + this.Dget(in.charAt(i));

		}

		return out;

	}

	public int getPostion(char in){

		for (int x = 0; x < Offset.length - 1; ++x){

			if(Offset[x] == in){

				return x;

			}

		}
		return 0;

	}
	private char Dget(char in){

		for (int x = 0; x < Offset.length - 1; ++x){

			if(Offset[x] == in){

				return this.Normal[x];

			}

		}
		return in;

	}
}

