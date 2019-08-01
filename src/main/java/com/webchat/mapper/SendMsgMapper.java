package com.webchat.mapper;

import com.webchat.pojo.Messages;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SendMsgMapper {
    /**
     * 删除记录
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 添加聊天记录
     * @param messages
     * @return
     */
    int insert(Messages messages);

    /**
     * 通过用户查询聊天记录
     * @param fromId 发送者
     * @param toId 接收者
     * @return
     */
    Messages selectMessageRecord(@Param("fromId") Integer fromId ,@Param("toId") Integer toId);

    /**
     * 通过主键查询记录
     * @param id
     * @return
     */
    Messages selectByPrimaryKey(Integer id);

}
