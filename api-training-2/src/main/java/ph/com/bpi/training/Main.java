package ph.com.bpi.training;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;


public class Main {
	
	private static final Logger logger =  LoggerFactory.getLogger(Main.class);
	private static final ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) {
    	
    	 // Start server on port 4567 (default)
        port(4568);
        
        // We create a route for checking if the server is active.
        get("/check-connection", (req, res) -> {
            res.type("application/json");	// define the MIME type of the response
            								// we're telling the client that the response
            								// is of JSON format

            // return a map (A map is basically a JSON formatted object)
            Map<String, String> response = new HashMap<>();
            response.put("status", "Server is running");

            return JsonUtil.toJson(response);
        });
        
        // A basic hello world route
        get("/hello-world", (req, res) -> {
            res.type("application/json");

            // if a 'name' parameter was provided, we use that in the message.
            // else, we default to World
            String name = req.queryParams("name");
            if (name == null) {
                name = "World";
            }

            Map<String, String> response = new HashMap<>();
            response.put("message", "Hello " + name);

            return JsonUtil.toJson(response);
        });
        
        // An example POST method that returns the payload that you send.
        post("/echo", (req, res) -> {
            res.type("application/json");

            // Just return the request body
            return req.body();
        });
    }

}
