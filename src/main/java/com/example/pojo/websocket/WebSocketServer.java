package com.example.pojo.websocket;


import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.stereotype. Component ;

import javax.websocket.*;
import javax.websocket.server. PathParam ;
import javax.websocket.server. ServerEndpoint ;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

/*
 * WebSocket服务类
 * */
@ServerEndpoint("/webSocket/{sid}")
@Component
public class WebSocketServer {

    static Log log = (Log) LogFactory.getLog(WebSocketServer.class);
    // 静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
    private static int onlineCount = 0;
    //接收sid
    private String sid = "";
    // concurrent 包的线程安全 Set ，用来存放每个客户端对应的 MyWebSocket 对象。
    private static CopyOnWriteArraySet<WebSocketServer>
            webSocketServers = new CopyOnWriteArraySet<WebSocketServer>();

    // 与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;

    /*
     * 连接成功调用方法
     * */
    @OnOpen
    public void onOpen(Session session,@PathParam ("sid") String sid) {
        this.session = session;
        webSocketServers.add(this);
        addOnlineCount();//在线数+1
        log.info("成功连接一个用户:" + sid + "在线人数为:" + getOnlineCount());
        this.sid = sid;
        try {
            sendMessage("连接成功");
        } catch (IOException e) {
            log.error("websocket IO 异常 ");
        }
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        webSocketServers.remove(this); // 从 set 中删除
        subOnlineCount(); // 在线数减 1
        log.info(" 有一连接关闭！当前在线人数为 " + getOnlineCount());
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        log.info(" 收到来自窗口 " + sid + " 的信息 :" + message);
// 群发消息
        for (WebSocketServer item : webSocketServers) {
            try {
                item.sendMessage(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        log.error(" 发生错误 ");
        error.printStackTrace();
    }

    /**
     * 实现服务器主动推送
     */
    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }


    /**
     * 群发自定义消息
     */
    public static void sendInfo(String message, String sid) throws IOException {
        log.info(" 推送消息到窗口 " + sid + " ，推送内容 :" + message);
        for (WebSocketServer item : webSocketServers) {
            try {
// 这里可以设定只推送给这个 sid 的，为 null 则全部推送
                if (sid == null) {
                    item.sendMessage(message);
                } else if (item.sid.equals(sid)) {
                    item.sendMessage(message);
                }
            } catch (IOException e) {
                continue;
            }
        }
    }


    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        WebSocketServer.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        WebSocketServer.onlineCount--;
    }
}
