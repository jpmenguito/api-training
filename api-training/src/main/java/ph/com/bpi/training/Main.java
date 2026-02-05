package ph.com.bpi.training;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
	
	private static final Logger logger =  LoggerFactory.getLogger(Main.class);
	private static final ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) {
    	
        try {
        	
        	Person person = new Person();
            person.setId(1517L);
            person.setName("James");
            person.setAge(20);
            
        	// Serialize "person" into a JSON String
        	String personJson = mapper.writeValueAsString(person);
            
        	// let's try logging both person and personJson;
        	logger.info("person = {}", person);
        	logger.info("personJson={}", personJson);
        	
        	
        	// Deserialize a JSON string into a Person object
        	String anotherJson = "{ \"id\": 2, \"name\": \"Mark\", \"age\": 25}";
        	Person person2 =  mapper.readValue(anotherJson, Person.class);
        	
        	logger.info("anotherJson = {}", anotherJson);
        	logger.info("person2 = {}", person2.getName() );

            
        } catch (Exception e) {
        	e.printStackTrace();
        }
        
    }

}
