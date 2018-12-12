package com.kass.lang.dao;

import com.kass.lang.domain.Language;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import javax.inject.Named;
import javax.inject.Singleton;

/**
 * Created by Kassem A. Ali on 2018-06-17.
 */
@Named
@Singleton
public class StreamrDao {
    boolean isSendToStreamr = true;
    Client client = Client.create();
    WebResource webResource = client
            .resource("https://www.streamr.com/api/v1/streams/Br9WdVM2RTKO8B_gAgk3Xw/data");

    public void sendToStreamr(Language lang) {
        if (! isSendToStreamr) {
            System.out.println("Streamr is disabled...");
            return;
        }

        try {
            ClientResponse response = webResource
                    .type("application/json")
                    .header("Authorization", "token Eo-tEc-DTw2dQDitO-0JIgYuJTeW8XQyeGCKITAmMB4w")
                    .post(ClientResponse.class, lang);

            if (response.getStatus() != 201 && response.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatus());
            }
            System.out.println("Sent to Streamr: " + lang);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

