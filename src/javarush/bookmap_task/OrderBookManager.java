package javarush.bookmap_task;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class OrderBookManager {
    private static final String INPUT_FILE_NAME = "input.txt";
    private static final String OUTPUT_FILE_NAME = "output.txt";

    private final TreeMap<Integer, Integer> bid = new TreeMap<>();
    private final TreeMap<Integer, Integer> ask = new TreeMap<>();
    private StringBuilder queries = new StringBuilder();

    private void update(String order) {
        String[] splitData = split(order);
        int price = Integer.parseInt(splitData[1]);
        int size = Integer.parseInt(splitData[2]);
        TreeMap<Integer, Integer> orders = splitData[3].equals("bid") ? ask : bid;

        if (size == 0) {
            orders.remove(price);
        } else {
            orders.put(price, size);
        }
    }

    // int long -> Integer, Long
    private void print(String order) {
        String[] splitData = split(order);
        String command = splitData[1];
        //q,size,10
        switch (command) {
            case "best_bid":
                Map.Entry<Integer, Integer> bestBid = bid.lastEntry();
                if (!bid.isEmpty()) {
                    queries.append(bestBid.getKey()).append(',').append(bestBid.getValue()).append('\n');
                }
                break;
            case "best_ask":
                Map.Entry<Integer, Integer> bestAsk = ask.firstEntry();
                if (!ask.isEmpty()) {
                    queries.append(bestAsk.getKey()).append(',').append(bestAsk.getValue()).append('\n');
                }
                break;
            case "size":
                int price = Integer.parseInt(splitData[2]);
                Integer size = bid.containsKey(price) ? bid.get(price) : ask.get(price);
                if (size == null) {
                    size = 0;
                }
                queries.append(size).append('\n');
                break;
            default:
                System.out.println("Incorrect command");
        }

    }
/*
o,buy,<size>
o,sell,<size>
 */
    private void remove(String order) {
        String[] splitData = split(order);
        boolean isBid = splitData[1].equals("buy");
        int size = Integer.parseInt(splitData[2]);

        Map.Entry<Integer, Integer> orderEntry;

        if (isBid) {

           while (size != 0) {

                orderEntry = ask.firstEntry();
                int priceLvlSize = orderEntry.getValue(); // kolichestvo
                if (priceLvlSize <= size) {
                    ask.remove(orderEntry.getKey());
                    size -= priceLvlSize;
                } else {
                    ask.put(orderEntry.getKey(), priceLvlSize - size);
                    size = 0;
                }
            }
        } else {
            while (size != 0) {

                orderEntry = bid.lastEntry();
                int priceLvlSize = orderEntry.getValue();
                if (priceLvlSize <= size) {
                    bid.remove(orderEntry.getKey());
                    size -= priceLvlSize;
                } else {
                    bid.put(orderEntry.getKey(), priceLvlSize - size);
                    size = 0;
                }
            }
        }

    }

    public void start() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(INPUT_FILE_NAME))) {
            String order;
            while (bufferedReader.ready()) {
                order = bufferedReader.readLine();
                char command = order.charAt(0);
                switch (command) {
                    case 'u':
                        update(order);
                        break;
                    case 'q':
                        print(order);
                        break;
                    case 'o':
                        remove(order);
                        break;
                    default:
                        System.out.println("Incorrect command");
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(OUTPUT_FILE_NAME))) {
            bufferedWriter.write(queries.toString());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private String[] split(String data) {
        String[] arr = new String[4];
        int begin = 0;
        int index = 0;

        for (int i = 0; i < data.length(); i++) {
            if (data.charAt(i) == ',') {
                arr[index++] = data.substring(begin, i);
                begin = i + 1;
            }
        }
        arr[index] = data.substring(begin);
        return arr;
    }

}
