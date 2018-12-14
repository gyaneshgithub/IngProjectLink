package com.ing.atm.locator.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ing.atm.locator.model.Location;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
@PropertySource("classpath:application.properties")
@ConfigurationProperties
public class AtmLocatorDao
{
    private List<Location> list = new ArrayList<>();
    @Value("${atmUrl}")
    private String url;

    public Location[] getAllLocations() {
        ObjectMapper mapper = new ObjectMapper();
        RestTemplate restTemplate = new RestTemplate();
        System.out.println(url);
        String response = restTemplate.getForObject(url, String.class);
        Location[] location = null;
        try {
            if(null != response && response.length() > 6) {
                location = mapper.readValue(response.substring(6), Location[].class);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return location;
    }

    public List<Location> getAllLocation()
    {
        List<Location> res = Arrays.asList(getAllLocations());
        res.addAll(list);
        return res;
    }

    public void addLocation(Location location) {
        list.add(location);
    }
}
