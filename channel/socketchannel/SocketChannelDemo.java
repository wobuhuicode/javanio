package channel.socketchannel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class SocketChannelDemo {
    public static void main(String[] args) {
        try {
            SocketChannel sc = SocketChannel.open();
            sc.connect(new InetSocketAddress("localhost", 8218));

            System.out.println(sc.isOpen());
            System.out.println(sc.isConnected());

            sc.configureBlocking(false);
            ByteBuffer buffer = ByteBuffer.allocate(16);
            sc.read(buffer);


            System.out.println("read over");

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
}
