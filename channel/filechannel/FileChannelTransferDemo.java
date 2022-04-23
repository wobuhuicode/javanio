package channel.filechannel;

import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/**
 * 使用Transfer方法高效传递两个FileChannel中的内容
 * 不拷贝数据到JVM内存
 */
public class FileChannelTransferDemo {
    public static void main(String[] args) {
        try {
            RandomAccessFile fromFile = new RandomAccessFile("from.txt", "r");
            RandomAccessFile toFile = new RandomAccessFile("to.txt", "rw");

            FileChannel fromChannel = fromFile.getChannel();
            FileChannel toChannel = toFile.getChannel();

            System.out.println(fromChannel.size());

            toChannel.transferFrom(fromChannel, 0, fromChannel.size());
            // 效果相似，区别在于position参数
            // fromChannel.transferTo(0, fromChannel.size(), toChannel);
            
            fromFile.close();
            toFile.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
