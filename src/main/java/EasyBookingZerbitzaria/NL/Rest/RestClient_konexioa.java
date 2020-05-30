package EasyBookingZerbitzaria.NL.Rest;

import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.client.ClientBuilder;

public class RestClient_konexioa extends RestClient {

	public RestClient_konexioa(String hostname, String port) {
		super(hostname, port);
	}

	public void makeGetRequest(String resource_URL) throws Exception {
		WebTarget getRequestController = super.webTarget.path(resource_URL);
		Invocation.Builder invocationBuilder = getRequestController.request(MediaType.APPLICATION_JSON);

		System.out.println("Java Jersey Client performing GET request to " + String.format("http://%s:%s%s",
				webTarget.getUri().getHost(), webTarget.getUri().getPort(), webTarget.getUri().getRawPath()));

		Response response = invocationBuilder.get();
		System.out.println("Java Jersey Client received the following output:");
		System.out.println(response.toString());

		if (request_OK(response.getStatus())) {
			System.out.println("Successfully made Get request");
			System.out.println("Goint to print response content without unmarshalling");

			print_with_unmarshalling(response);
		} else {
			System.out.println("BadAss error happened");
			System.exit(-1);
		}
	}

	public void print_with_unmarshalling(Response response) {
		String message = response.readEntity(String.class);
		System.out.println(message);
	}

}
