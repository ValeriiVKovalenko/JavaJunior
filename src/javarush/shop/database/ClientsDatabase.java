package javarush.shop.database;

import javarush.shop.model.Client;

import java.util.HashMap;
import java.util.Map;

public class ClientsDatabase {
    private final Map<Long, Client> clients;
    private long userCount = 0;

    public ClientsDatabase() {
        this.clients = new HashMap<>();
    }

    public Map<Long, Client> getClients() {
        return clients;
    }

    public void setUserCount(long userCount) {
        this.userCount = userCount;
    }

    public long getUserCount() {
        return userCount;
    }
}
