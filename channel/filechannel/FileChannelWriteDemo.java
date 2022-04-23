package channel.filechannel;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 使用FileChannel写文件
 */
public class FileChannelWriteDemo {
    public static void main(String[] args) {
        try {
            RandomAccessFile writeFile = new RandomAccessFile("write.txt", "rw");
            FileChannel writeChannel = writeFile.getChannel();
            ByteBuffer buffer = ByteBuffer.wrap("data nioyyds".getBytes());

            System.out.printf("limit %d, pos %d, cap %d\n", buffer.limit(), buffer.position(), buffer.capacity());

            int bytesWrite = writeChannel.write(buffer);

            System.out.printf("limit %d, pos %d, cap %d\n", buffer.limit(), buffer.position(), buffer.capacity());

            System.out.println(bytesWrite);

            long size = writeChannel.size();

            System.out.println(size);
            writeChannel.position(size);

            writeChannel.write(ByteBuffer.wrap(", hello world".getBytes()));


            writeFile.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
}
