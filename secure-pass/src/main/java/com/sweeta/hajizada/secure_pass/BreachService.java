package com.sweeta.hajizada.secure_pass;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Service to handle external security API communications.
 * Demonstrates the use of RESTful services and the K-Anonymity privacy model.
 */
@Service
public class BreachService {

    /**
     * Fetches a list of leaked password hash suffixes from the HIBP API.
     * @param hashPrefix The first 5 characters of the SHA-1 password hash.
     * @return A raw String of all matching hash suffixes found in data breaches.
     */
    public String getBreachData(String hashPrefix) {
        // We use the HIBP Range API. This is the "Gold Standard" for security apps.
        String url = "https://api.pwnedpasswords.com/range/" + hashPrefix;

        RestTemplate restTemplate = new RestTemplate();

        try {
            // This actually makes the call to the internet
            return restTemplate.getForObject(url, String.class);
        } catch (Exception e) {
            return "CONNECTION_ERROR";
        }
    }
}
