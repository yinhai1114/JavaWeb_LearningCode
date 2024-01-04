package com.yinhai.furns.service;

import com.yinhai.furns.javabean.Member;

/**
 * @author 银小海
 * @version 1.0
 * @email yinhai14@qq.com
 */
public interface MemberService {

    //注册用户
    public boolean registerMember(Member member);

    //判断用户名是否存在
    public boolean isExistsUsername(String username);

    /**
     * 根据登录传入的member信息，返回对应的在DB中的member对象
     * @param member 是根据用户登录构建一个member
     * @return 返回的是对应的db中的member对象，如果不存在,返回null
     */
    public Member login(Member member);
}

