package com.webchat.service.impl;

import com.webchat.mapper.SendMsgMapper;
import com.webchat.pojo.Messages;
import com.webchat.service.SendMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SendMsgServiceImpl implements SendMsgService {
    @Autowired
    private SendMsgMapper sendMsgMapper;

    @Override
    public int insertMessage(Messages messages) {
        sendMsgMapper.insert(messages);
        return 0;
    }

    @Override
    public Messages selectMessageRecord(Integer fromId, Integer toId) {
        sendMsgMapper.selectMessageRecord(fromId,toId);
        return null;
    }
}
