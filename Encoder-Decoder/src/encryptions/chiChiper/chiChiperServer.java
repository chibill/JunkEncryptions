package encryptions.chiChiper;

import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import org.simpleframework.http.Request;
import org.simpleframework.http.Response;
import org.simpleframework.http.core.Container;
import org.simpleframework.http.core.ContainerSocketProcessor;
import org.simpleframework.transport.connect.Connection;
import org.simpleframework.transport.connect.SocketConnection;
import encryptions.chiChiper.Decoder;
import encryptions.chiChiper.Encoder;


public class chiChiperServer implements Container {


	public void handle(Request request, Response response) {
		System.out.println("Request Start");
		try {
			PrintStream body = response.getPrintStream();
			long time = System.currentTimeMillis();
			//System.out.println(request.getClientAddress().toString());
			response.setValue("Content-Type", "text/html");
			response.setValue("Server", "ChiChiper");
			response.setDate("Date", time);
			response.setDate("Last-Modified", time);
			
			Merge(request,body);
			body.close();
		} catch(Exception e) {
			System.out.println("Request EXCEPTION " + e.toString());
			e.printStackTrace();
		}
		System.out.println("Request End");
	} 

	public static void main(String[] list) throws Exception {
		Container container = new chiChiperServer();
		ContainerSocketProcessor server = new ContainerSocketProcessor(container,16,3);
		Connection connection = new SocketConnection(server);
		SocketAddress address = new InetSocketAddress(8000);

		connection.connect(address);
	}

	private void Merge(Request request,PrintStream body) {
		System.out.println(request.getTarget());
		body.print("<title>ChiChiper</title>");
		if(request.getPath().toString().toLowerCase().equals("/encode")){
			if( request.getParameter("Password").matches("[0-9a-zA-Z]*")){
				System.out.println("Encode Start");
				String temp = Encoder.Encode(request.getParameter("Data"), request.getParameter("Password"));
				body.println(temp);
				System.out.println("Encode End");
			body.flush();
			}else{
				
				body.println("<h1>INVALID PASSWORD DATA</h1>");
				body.flush();
			}
		}else{
			if(request.getPath().toString().toLowerCase().equals("/decode")){
				body.println(Decoder.decode(request.getParameter("Data"), request.getParameter("Password")));
				body.flush();
			}else{
				
				
				//body.println("<img src="+'"'+"http://img.talkandroid.com/uploads/2014/06/help.jpg"+'"'+"height="+'"'+42+'"'+ "width="+ '"'+42+'"'+"alt="+'"'+"HELP!"+'"'+">");
				body.print("<h2>Welcome to ChiChiper</h2><p>This is the help menu it will show anytime an invalid URL is give to the server so please be careful.</p><p>The URLs that work are adress:8000/encode?Data=data&Password=password and adress:8000/decode?Data=data&Password=password</p><p>But you need to make sure to put your data instead of data  and your password in instead of password</p>");
				body.flush();

			}
		}




	}
}