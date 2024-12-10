package org.example;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.List;

public class ClientSocketHandler implements Runnable{
    private Socket clientSocket;

    public ClientSocketHandler(final Socket socket){
        this.clientSocket=socket;
    }

    @Override
    public void run(){
        try{
            InputStream clientToLoadBalancerInputStream=clientSocket.getInputStream();
            OutputStream loadBalancerToClientOutputStream=clientSocket.getOutputStream();

            String backendHost =BackendServers.getHost();

            System.out.println("Host handling this request is:"+backendHost);

            List<String> breakStr= List.of(backendHost.split(":"));
            // Create a TCP server with backend
            Socket backendSocket=new Socket(breakStr.get(0),Integer.parseInt(breakStr.get(1)));

            InputStream backendServerLBIS=backendSocket.getInputStream();
            OutputStream lbToBackendOS=backendSocket.getOutputStream();

            Thread clientDataHandler=new Thread(){
                public void run(){
                    try{
                        int data;
                        while((data=clientToLoadBalancerInputStream.read())!=-1){
                            lbToBackendOS.write(data);
                        }
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            };
            clientDataHandler.start();

            Thread backendDataHandler=new Thread(){
                public void run(){
                    try{
                        int data;
                        while((data=backendServerLBIS.read())!=-1){
                            loadBalancerToClientOutputStream.write(data);
                        }
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            };

            backendDataHandler.start();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
