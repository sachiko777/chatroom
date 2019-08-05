package com.webchat.controller;

import com.webchat.pojo.util.EasyUiTree;
import com.webchat.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("friends")
public class FriendsController {
    @Autowired
    private FriendService friendService;

    /**
     * 根据parent_id返回数据列表
     */
    @RequestMapping("/list")
    @ResponseBody
    public List<EasyUiTree> getProductCategoryByParentId(Short userid,@RequestParam(value = "id",defaultValue = "0") Short parentId){
        List<EasyUiTree> easyUiTrees=friendService.findFriendListByParentId(userid,parentId);
        return easyUiTrees;
    }


}
