package Chapter19_ParallelComputing;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Parallel_04_ThreadPoolWebServer {
    public static class Worker {
        public static void handleRequest(Socket connection) {
            System.out.println("handling request");
        }
    }

    public static class ThreadPoolWebServer {
        private static final int NTHREADS = 100;
        private static final int SERVERPORT = 8080;
        private static final Executor executor = Executors.newFixedThreadPool(NTHREADS);

        public static void main(String[] args) throws IOException {
            ServerSocket serverSocket = new ServerSocket(ThreadPoolWebServer.SERVERPORT);
            while (true) {
                final Socket connection = serverSocket.accept();
                Runnable task = new Runnable() {
                    @Override
                    public void run() {
                        Worker.handleRequest(connection);
                    }
                };
                executor.execute(task);
            }
        }
    }
}
