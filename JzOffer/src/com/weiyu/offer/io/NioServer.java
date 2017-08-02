package com.weiyu.offer.io;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Wei Yu on 2017/7/19.
 */
public class NioServer {
    public static void main(String... args) throws IOException {
        Selector selector = Selector.open();
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.bind(new InetSocketAddress(1234));
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while(selector.select() > 0){
            Set<SelectionKey> keys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = keys.iterator();
            while(iterator.hasNext()){
                SelectionKey key = iterator.next();
                iterator.remove();
                if(key.isAcceptable()){
                    ServerSocketChannel acceptServerSocketChannel = (ServerSocketChannel) key.channel();
                    SocketChannel socketChannel = acceptServerSocketChannel.accept();
                    socketChannel.configureBlocking(false);
                    System.out.println("remoteAddress:" + socketChannel.getRemoteAddress());
                    socketChannel.register(selector,SelectionKey.OP_READ);
                }else if(key.isReadable()){
                    SocketChannel socketChannel = (SocketChannel) key.channel();
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    int count = socketChannel.read(buffer);
                    if(count <= 0){
                        socketChannel.close();
                        key.cancel();
                        System.out.println("Received the invalid data, close the channel");
                        continue;
                    }

                    System.out.println("Received data: " + new String(buffer.array()));
                }
                keys.remove(key);
            }
        }

    }
}
