package org.example;

import java.util.ArrayList;
import java.util.List;

public class BackendServers {
    private static List<String> servers=new ArrayList<>();

    public static int count=0;

    static{
        //Add your own servers links
        servers.add("localhost:8081");
        servers.add("localhost:8082");
        servers.add("localhost:8083");
    }

    public static String getHost(){
        String host =servers.get(count%servers.size());
        count++;
        return host;
    }
}
