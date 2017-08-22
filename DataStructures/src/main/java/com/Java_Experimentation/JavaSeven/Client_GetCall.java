package com.Java_Experimentation.JavaSeven;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author Manoj.Mohanan Nair
 * @Date 8/20/17
 */
public class Client_GetCall {

    static String uri1= "http://redsky.target.com/v2/pdp/tcin/52029877?excludes=taxonomy";
    static String uri2="http://redsky.target.com/v2/pdp/tcin/52029895?excludes=taxonomy";

    public static void main(String[] args){
        getResponseClient(uri1);
        //postResponseClient(uri1);
    }

    public static void getResponseClient(String uri){

        try {

            URL url = new URL(uri);
            HttpURLConnection connect = (HttpURLConnection)url.openConnection();
            connect.setRequestMethod("GET");
            connect.setRequestProperty("Accept", "application/json");
            if(connect.getResponseCode()!=HttpURLConnection.HTTP_OK){
                throw new RuntimeException("Failed: Http connection error"+connect.getResponseCode());
            }

            InputStreamReader inputStReader = new InputStreamReader(connect.getInputStream());
            BufferedReader br = new BufferedReader(inputStReader);

            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }

            connect.disconnect();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void postResponseClient(String uri){

        try {

            URL url = new URL(uri);
            HttpURLConnection connect = (HttpURLConnection)url.openConnection();
            connect.setRequestMethod("POST");
            connect.setDoOutput(true);
            connect.setRequestProperty("Content-Type", "application/json");
            if(connect.getResponseCode()!=HttpURLConnection.HTTP_CREATED){
                throw new RuntimeException("Failed: Http connection error"+connect.getResponseCode());
            }

            InputStreamReader inputStReader = new InputStreamReader(connect.getInputStream());
            BufferedReader br = new BufferedReader(inputStReader);

            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }

            connect.disconnect();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
