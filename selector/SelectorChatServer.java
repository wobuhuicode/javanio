package selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

public class SelectorChatServer {
    public static void main(String[] args) {
        try {
            Selector selector = Selector.open();

            ServerSocketChannel ssc = ServerSocketChannel.open();
            ssc.bind(new InetSocketAddress(9999));

            ssc.configureBlocking(false);

            SelectionKey selectionKey = ssc.register(selector, SelectionKey.OP_ACCEPT);

            int interestSet = selectionKey.interestOps();
            System.out.println(interestSet);
            boolean isInterestedInAccept = (interestSet & SelectionKey.OP_ACCEPT) == SelectionKey.OP_ACCEPT;
            System.out.println(isInterestedInAccept);

            selector.select();

/*
            int isInterestedInConnect = interestSet & SelectionKey.OP_CONNECT;
            int isInterestedInRead = interestSet & SelectionKey.OP_READ;
            int isInterestedInWrite = interestSet & SelectionKey.OP_WRITE;
*/

            ssc.close();
            selector.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
