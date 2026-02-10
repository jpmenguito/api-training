package ph.com.bpi.training;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;


public class Main {
	
	private static final Logger logger =  LoggerFactory.getLogger(Main.class);
	private static final ObjectMapper mapper = new ObjectMapper();
	 
    public static void main(String[] args) {
    	// intialize entityManager;
        EntityManager em = EntityManagerUtil.getInstance().createEntityManager();
    	
        // initialize movieRepository
    	MovieRepository movieRepository = new MovieRepository(em);
    	
    	 // Start server on port 4567 (default)
        port(4567);
        
        // add routes here

        // Get Profile List
        
        
        // Create Profile List
        
    }
    
    

}
