package com.merry216.seria.plugin;

import net.lz1998.cq.event.message.CQPrivateMessageEvent;
import net.lz1998.cq.robot.CQPlugin;
import net.lz1998.cq.robot.CoolQ;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * 简单信息处理
 */
@Component
public class SimpleMsgPlugin extends CQPlugin {
    /**
     * 简单回复map
     */
    public static Map<String, String> SIMPLE_REPLIES = new HashMap<>();

    {
        SIMPLE_REPLIES.put("hi", "hello");
    }

    /**
     * 收到私聊消息时会调用这个方法
     *
     * @param cq    机器人对象，用于调用API，例如发送私聊消息 sendPrivateMsg
     * @param event 事件对象，用于获取消息内容、群号、发送者QQ等
     * @return 是否继续调用下一个插件，IGNORE表示继续，BLOCK表示不继续
     */
    @Override
    public int onPrivateMessage(CoolQ cq, CQPrivateMessageEvent event) {
        // 获取 发送者QQ 和 消息内容
        long userId = event.getUserId();
        String msg = event.getMessage().trim();

        if (SIMPLE_REPLIES.containsKey(msg.toLowerCase())) {
            // 简单信息：直接返回预设信息
            cq.sendPrivateMsg(userId, SIMPLE_REPLIES.get(msg.toLowerCase()), false);
            return MESSAGE_BLOCK;
        } else {
            // 复杂信息:直接进入下一个plugin
            return MESSAGE_IGNORE;
        }
    }
}
