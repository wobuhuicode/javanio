package channel.socketchannel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class DatagramChannelDemo {
    public static void main(String[] args) {
        try {
            DatagramChannel dc = DatagramChannel.open();
            dc.configureBlocking(false);

            // send
            dc.send(ByteBuffer.wrap("hello".getBytes()), new InetSocketAddress("localhost", 8218));

            // receive
            ByteBuffer receivBuffer = ByteBuffer.allocate(512);
            dc.receive(receivBuffer);

            // connect后，可以使用write和read
            // 那么read就只会接收特定地址的消息
            dc.connect(new InetSocketAddress("localhost", 8218));


            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
}
