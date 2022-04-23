package channel.socketchannel;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.TimeUnit;

public class ServersocketChannelDemo {
    public static void main(String[] args) {
        int port = 8218;

        ByteBuffer buffer = ByteBuffer.wrap("hello".getBytes());

        try {
            ServerSocketChannel ssc = ServerSocketChannel.open();
            ssc.bind(new InetSocketAddress(port));
            ssc.configureBlocking(false);

            while (true) {
                SocketChannel sc = ssc.accept();
                if (sc == null) {
                    System.out.println("no connection");
                    TimeUnit.SECONDS.sleep(2);
                } else {
                    System.out.println("Incoming connection from: " + sc.socket().getRemoteSocketAddress());
                    buffer.rewind();
                    sc.write(buffer);
                    sc.close();
                }
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
