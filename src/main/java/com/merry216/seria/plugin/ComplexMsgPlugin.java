package com.merry216.seria.plugin;

import com.merry216.grandis.api.IGrandisPrivateRouterService;
import net.lz1998.cq.event.message.CQPrivateMessageEvent;
import net.lz1998.cq.robot.CQPlugin;
import net.lz1998.cq.robot.CoolQ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 复杂信息处理：就包给我grandis吧
 */
@Component
public class ComplexMsgPlugin extends CQPlugin {
    /**
     * grandis：复杂信息路由分发
     */
    @Autowired
    private IGrandisPrivateRouterService grandisPrivateRouterService;

    /**
     * 收到私聊消息时会调用这个方法
     *
     * @param cq    机器人对象，用于调用API，例如发送私聊消息 sendPrivateMsg
     * @param event 事件对象，用于获取消息内容、群号、发送者QQ等
     * @return 是否继续调用下一个插件，IGNORE表示继续，BLOCK表示不继续
     */
    @Override
    public int onPrivateMessage(CoolQ cq, CQPrivateMessageEvent event) {
        try {
            long userId = event.getUserId();
            String msg = event.getMessage().trim();
            String rsp = grandisPrivateRouterService.distributePrivateMsg(userId, msg);
            cq.sendPrivateMsg(userId, rsp, false);
        } catch (Exception e) {
            return MESSAGE_IGNORE;
        }
        return MESSAGE_BLOCK;
    }
}
