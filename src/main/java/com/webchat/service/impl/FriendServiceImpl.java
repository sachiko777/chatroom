package com.webchat.service.impl;

import com.webchat.mapper.FriendMapper;
import com.webchat.pojo.Friendgroups;
import com.webchat.pojo.Friends;
import com.webchat.pojo.util.EasyUiTree;
import com.webchat.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class FriendServiceImpl implements FriendService {
    @Autowired
    private FriendMapper friendMapper;

    @Override
    public List<EasyUiTree> findFriendListByParentId(Short userid,Short pid) {//用户id，分组id
        List<Friendgroups> friendgroups= Collections.synchronizedList(new ArrayList<Friendgroups>());//分组信息
        List<Friends> friends= Collections.synchronizedList(new ArrayList<Friends>());//分组下的好友名单
        List<EasyUiTree> easyUiTrees;
        try{
            if(pid.equals(0)||pid==0){//查询分组
                friendgroups=friendMapper.queryFriendGroupsByUserId(userid);
                easyUiTrees=new ArrayList<>(friendgroups.size());
                for(Friendgroups groups:friendgroups){
                    EasyUiTree easyUiTree=new EasyUiTree();
                    easyUiTree.setId(groups.getId());
                    easyUiTree.setText(groups.getName());
                    easyUiTree.setState("closed");
                    easyUiTree.setAttributes(groups.getUserid()+"");//自己的id
                    easyUiTrees.add(easyUiTree);
                }
            }else{//查询分组下的好友列表
                friends=friendMapper.queryFriendByGroupId(pid);
                easyUiTrees=new ArrayList<>(friends.size());
                for(Friends friends1:friends){
                    EasyUiTree easyUiTree=new EasyUiTree();
                    easyUiTree.setId(friends1.getId());
                    easyUiTree.setText(friends1.getNickname()+"&nbsp;&nbsp;&nbsp;");
                    easyUiTree.setState("open");
                    easyUiTree.setAttributes(friends1.getFriendAccount()+"");//好友id
                    easyUiTrees.add(easyUiTree);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
        return easyUiTrees;
    }
}
