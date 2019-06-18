package com.iroshnk.demo.websocket;

import com.iroshnk.demo.util.DemoBeanUtil;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.*;

@WebSocket
public class RandomNameSocket {
    @OnWebSocketConnect
    public void onConnect(Session session) {
        DemoBeanUtil.getRandomNameService().addSession(session);
    }

    @OnWebSocketClose
    public void onClose(Session session, int _closeCode, String _closeReason) {
        DemoBeanUtil.getRandomNameService().removeSession(session);
    }
}
