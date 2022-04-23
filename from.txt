package channel.filechannel;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 使用FileChannel读文件
 */
public class FileChannelReadDemo {
    public static void main(String[] args) {
        System.out.println("Hello World");
        try {
            RandomAccessFile readfile = new RandomAccessFile("read.txt", "r");
            FileChannel readChannel = readfile.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(512);
            while (readChannel.read(buffer) != -1) {
                System.out.printf("limit %d, pos %d, cap %d\n", buffer.limit(), buffer.position(), buffer.capacity());
                buffer.flip();
                System.out.printf("limit %d, pos %d, cap %d\n", buffer.limit(), buffer.position(), buffer.capacity());
                while (buffer.hasRemaining()) {
                    System.out.print((char)buffer.get());
                }
                System.out.println();
                System.out.printf("limit %d, pos %d, cap %d\n", buffer.limit(), buffer.position(), buffer.capacity());
                buffer.clear();
                System.out.printf("limit %d, pos %d, cap %d\n", buffer.limit(), buffer.position(), buffer.capacity());
            }

            readfile.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
