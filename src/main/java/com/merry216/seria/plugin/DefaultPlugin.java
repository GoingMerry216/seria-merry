package com.merry216.seria.plugin;

import net.lz1998.cq.event.message.CQPrivateMessageEvent;
import net.lz1998.cq.robot.CQPlugin;
import net.lz1998.cq.robot.CoolQ;
import org.springframework.stereotype.Component;

/**
 * default显示菜单
 */
@Component
public class DefaultPlugin extends CQPlugin {

    /**
     * 收到私聊消息时会调用这个方法
     *
     * @param cq    机器人对象，用于调用API，例如发送私聊消息 sendPrivateMsg
     * @param event 事件对象，用于获取消息内容、群号、发送者QQ等
     * @return 是否继续调用下一个插件，IGNORE表示继续，BLOCK表示不继续
     */
    @Override
    public int onPrivateMessage(CoolQ cq, CQPrivateMessageEvent event) {
        long userId = event.getUserId();
        String replyMsg ="1. hi -> hello\n2.$商品名 -> 商品信息";
        cq.sendPrivateMsg(userId, replyMsg, false);
        return MESSAGE_BLOCK;
    }
}
