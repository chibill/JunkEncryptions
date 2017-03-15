package encryptions.RubikChiper;

import java.io.IOException;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

import org.simpleframework.http.Request;
import org.simpleframework.http.Response;
import org.simpleframework.http.core.Container;
import org.simpleframework.http.core.ContainerSocketProcessor;
import org.simpleframework.transport.connect.Connection;
import org.simpleframework.transport.connect.SocketConnection;


public class RubikServer implements Container {

	public static void Main(String[] args) throws IOException {
		Container container = new RubikServer();
		ContainerSocketProcessor server = new ContainerSocketProcessor(container,16,3);
		Connection connection = new SocketConnection(server);
		SocketAddress address = new InetSocketAddress(8000);

		connection.connect(address);
	}

	@Override
	public void handle(Request request, Response response) {
		System.out.println("Request Start");
		try {
			PrintStream body = response.getPrintStream();
			long time = System.currentTimeMillis();
			//System.out.println(request.getClientAddress().toString());
			response.setValue("Content-Type", "text/html");
			response.setValue("Server", "RubikChiper");
			response.setDate("Date", time);
			response.setDate("Last-Modified", time);
			
			Run(request,body);
			body.close();
		} catch(Exception e) {
			System.out.println("Request EXCEPTION " + e.toString());
			e.printStackTrace();
		}
		System.out.println("Request End");
	}

	private void Run(Request request, PrintStream body) {

	}

}
