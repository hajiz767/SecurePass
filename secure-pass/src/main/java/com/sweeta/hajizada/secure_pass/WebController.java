package com.sweeta.hajizada.secure_pass;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

/**
 * WebController is the central hub for the SecurePass Manager.
 * It manages the HTTP request lifecycle: receiving user passwords,
 * coordinating security analysis, and returning results to the UI.
 */
@Controller
public class WebController {

    // Dependency Injection: Spring automatically provides these services
    @Autowired
    private PasswordService passwordService;

    @Autowired
    private BreachService breachService;

    /**
     * Handles the root ("/") web request.
     * * @param pwd - The password string submitted by the user via the HTML form.
     * @param model - The UI container used to send data back to the browser.
     * @return The name of the Thymeleaf template (index) to display.
     */
    @GetMapping("/")
    public String home(@RequestParam(name="pwd", required=false) String pwd, Model model) {

        //performs analysis only if the user actually submitted a password
        if (pwd != null && !pwd.isEmpty()) {

            // 1. strength analysis: Checks for length, numbers, and special characters.
            String strength = passwordService.checkStrength(pwd);

            //2. Cryptography hashing: converts it to a SHA-1 Hash(never store||send the plain password).
            String fullHash = passwordService.convertToSha1(pwd).toUpperCase();

            // Using K-Anonymity here: only sends the first 5 chars to the API
            // This keeps the full password private even from the breach provider
            String prefix = fullHash.substring(0, 5);
            String suffix = fullHash.substring(5);

            // EXTERNAL API CALL: Fetches a list of all leaked password hashes that start with our prefix.
            String apiResponse = breachService.getBreachData(prefix);


            //search the API's list for our specific suffix.
            //This keeps the full password secret even from the API provider! */
            boolean isLeaked = apiResponse != null && apiResponse.contains(suffix);

            // Mapping the results to the HTML template
            model.addAttribute("strength", strength);
            model.addAttribute("hash", fullHash);
            model.addAttribute("status", isLeaked ? "⚠️ BREACHED" : "✅ SECURE");
            model.addAttribute("message", "Security Analysis Complete.");

        } else {
            // Default state when the page first loads
            model.addAttribute("message", "Awaiting Input...");
        }

        return "index";
    }
}
