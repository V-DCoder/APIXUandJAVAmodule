package com.sample.hackerrank;

public class NetworkManager {

    private static NetworkManager networkManager;

    public static NetworkManager getInstance()
    {
        if(networkManager == null)
        {
            networkManager = new NetworkManager();
        }

    return networkManager;
    }

}
