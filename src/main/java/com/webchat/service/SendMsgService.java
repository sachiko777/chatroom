package com.webchat.service;

import com.webchat.pojo.Messages;

public interface SendMsgService {

    /**
     * 新增聊天记录
     * @param messages
     * @return
     */
    int insertMessage(Messages messages);

    /**
     * 通过用户查询聊天记录
     * @param fromId 发送者
     * @param toId 接收者
     * @return
     */
    Messages selectMessageRecord(Integer fromId ,Integer toId);



}
