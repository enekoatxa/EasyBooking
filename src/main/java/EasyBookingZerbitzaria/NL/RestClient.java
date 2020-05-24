package EasyBookingZerbitzaria.NL;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.json.simple.JSONObject;

import com.mysql.fabric.xmlrpc.Client;

public class RestClient<T extends DF_Printable> {

	protected Client client;
	protected WebTarget webTarget;

	public boolean request_OK(int response_status) {
		return response_status == Status.OK.getStatusCode() || // Code: 200
				response_status == Status.CREATED.getStatusCode() || // Code:
																		// 201
				response_status == Status.ACCEPTED.getStatusCode(); // Code: 202
	}

	public RestClient(String hostname, String port) {
		this.client = (Client) ClientBuilder.newClient();
		this.webTarget = ((javax.ws.rs.client.Client) client).target(String.format("http://%s:%s", hostname, port));
	}

	public Invocation.Builder createInvocationBuilder(String resource_URL) throws Exception {
		WebTarget requestController = this.webTarget.path(resource_URL);
		Invocation.Builder invocationBuilder = requestController.request(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		System.out.println("Java Client preparing Jersey request call to " + String.format("http://%s:%s%s",
				webTarget.getUri().getHost(), webTarget.getUri().getPort(), webTarget.getUri().getRawPath()));

		return invocationBuilder;
	}

	public Response makeGetRequest(Invocation.Builder invocationBuilder) throws Exception {
		System.out.println("Sending GET Request");
		return invocationBuilder.get();
	}

	public Response makePostRequest(Invocation.Builder invocationBuilder, JSONObject obj) throws Exception {
		System.out.println("Content of message to send in POST Request");
		((DF_Printable) obj).print();

		return invocationBuilder.post(Entity.entity(obj, MediaType.APPLICATION_JSON));
	}

	public Response makePutRequest(Invocation.Builder invocationBuilder, T objectToSend) throws Exception {
		System.out.println("Content of message to send in PUT Request");
		objectToSend.print();

		return invocationBuilder.put(Entity.entity(objectToSend, MediaType.APPLICATION_JSON));
	}

	public void simplePrint(Response response) {

		System.out.println("Java Jersey Client received the following output:");
		System.out.println(response.toString());

		if (request_OK(response.getStatus())) {

			System.out.println("Successfully made Rest request... ");
			System.out.println("Goint to print response content as string");

			System.out.println(response.readEntity(String.class));
		}

		else {

			System.out.println("Error happened. Can't print result.");
		}
	}

}
