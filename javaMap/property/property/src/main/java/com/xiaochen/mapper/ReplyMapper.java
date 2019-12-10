package com.xiaochen.mapper;

import com.xiaochen.pojo.Reply;

public interface ReplyMapper {

    int ccInsert(Reply reply);


    int deleteByPrimaryKey(Integer replyId);

    int insert(Reply record);

    int insertSelective(Reply record);

    Reply selectByPrimaryKey(Integer replyId);

    int updateByPrimaryKeySelective(Reply record);

    int updateByPrimaryKey(Reply record);

    /**
     * 报修回复
     */
    int clInsert(Reply record);

    /**
     * 投诉回复
     */
    int cflInsert(Reply record);
}