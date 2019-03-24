package com.quycntt;

import java.io.IOException;
import java.io.InputStream;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.quycntt.entity.Location;

@Service
public class demo {
	
	public Location getLocationInfo( String lat, String lng) throws JsonProcessingException, IOException {
        HttpGet httpGet = new HttpGet("https://maps.googleapis.com/maps/api/geocode/json?latlng="+lat+","+lng+"&key=AIzaSyDr7x12TXwl10KP624u9kwupMu8ZrRWyHY");
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpResponse response;
        StringBuilder stringBuilder = new StringBuilder();

        try {
            response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            InputStream stream = entity.getContent();
            int b;
            while ((b = stream.read()) != -1) {
                stringBuilder.append((char) b);
            }
        } catch (ClientProtocolException e) {
            } catch (IOException e) {
        }

        ObjectMapper mapper = new ObjectMapper();
        JsonNode array =  mapper.readValue(stringBuilder.toString(), JsonNode.class);
        JsonNode object = array.get("results").get(0);
        
        Location location = new Location();
        location.setLat_number(object.get("geometry").get("location").get("lat").floatValue());
        location.setLong_number(object.get("geometry").get("location").get("lng").floatValue());
        location.setPosition(object.get("formatted_address").textValue());
        return location;
    }
	
//	Geocoder geocoder;
//	List<Address> addresses;
//	geocoder = new Geocoder(this, Locale.getDefault());
//
//	addresses = geocoder.getFromLocation(latitude, longitude, 1); // Here 1 represent max location result to returned, by documents it recommended 1 to 5
//
//	String address = addresses.get(0).getAddressLine(0); // If any additional address line present than only, check with max available address lines by getMaxAddressLineIndex()
//	String city = addresses.get(0).getLocality();
//	String state = addresses.get(0).getAdminArea();
//	String country = addresses.get(0).getCountryName();
//	String postalCode = addresses.get(0).getPostalCode();
//	String knownName = addresses.get(0).getFeatureName();
}       