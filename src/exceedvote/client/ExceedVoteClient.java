package exceedvote.client;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPDigestAuthFilter;

import exceedvote.new_model.Contestant;
 
public class ExceedVoteClient {
 
	public static void main(String[] args) {
		/*try {
		 
		Client client = Client.create();
		//client.addFilter(new HTTPDigestAuthFilter("chanon", "gg"));
		
		WebResource webResource = client
		   .resource("http://localhost:8080/project");
 
 
		ClientResponse response = webResource.accept("application/xml")
		   .get(ClientResponse.class);
 
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
			     + response.getStatus());
		}
 
		System.out.println("Output from Server .... \n");
		String output = response.getEntity(String.class);
		System.out.println(output);
 
	  } catch (Exception e) {
 
		e.printStackTrace();
 
	  }
 
	}*/
	}	
}