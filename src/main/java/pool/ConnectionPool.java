package pool;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.concurrent.ArrayBlockingQueue;

public class ConnectionPool {
    private static  ConnectionPool instance;
    private static ResourceBundle rb = ResourceBundle.getBundle("db");

    private final String URL="jdbc:mysql://localhost:3306/autobase?useUnicode=true&characterEncoding=utf8";
    private final String USER = "root";
    private final  String PASSWORD = "1234";
    private final int COUNT_OF_CONNECTIONS = 4;


    private ArrayBlockingQueue<Connection> freeCon = new ArrayBlockingQueue<>(COUNT_OF_CONNECTIONS);
    private ArrayBlockingQueue<Connection> usedCon = new ArrayBlockingQueue<>(COUNT_OF_CONNECTIONS);

    public static synchronized ConnectionPool getInstance(){
        if(instance == null){
            instance = new ConnectionPool();
        }
        return instance;
    }

    private void createPool() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }

        if(rb.getKeys().hasMoreElements()){
            createPoolWithBundle();
        }else {
            createPoolWithConstants();
        }

    }

    private void createPoolWithConstants(){
        for(int i = 0; i<COUNT_OF_CONNECTIONS;i++) {
            try {
                freeCon.add(DriverManager.getConnection(URL, USER, PASSWORD));
            } catch (SQLException e) {
                System.out.println("Connection failed...");
                e.printStackTrace();
            }
        }
    }

    private void createPoolWithBundle(){
        for(int i = 0; i<Integer.parseInt(rb.getString("count_of_connections"));i++) {
            try {
                freeCon.add(DriverManager.getConnection(rb.getString("url"), rb.getString("user"),
                        rb.getString("password")));
            } catch (SQLException e) {
                System.out.println("Connection failed...");
                e.printStackTrace();
            }
        }
    }

    public Connection getConnection(){
        Connection con = null;

        try {
            con = freeCon.take();
            if(freeCon.isEmpty() && !usedCon.isEmpty()){
                swapQueue(freeCon,usedCon);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return con;
    }



    public void closeConnection(Connection c) {
        if(c != null) {
            try {
                usedCon.put(c);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private synchronized void swapQueue(ArrayBlockingQueue<Connection> queue1, ArrayBlockingQueue<Connection> queue2){
        queue1.addAll(queue2);
        queue2.clear();
    }

    public ConnectionPool() {
        this.createPool();
    }
}
