package com.yinhai.furns.test;

import com.yinhai.furns.dao.MemberDAO;
import com.yinhai.furns.dao.impl.MemberDAOImpl;
import com.yinhai.furns.javabean.Member;
import com.yinhai.furns.utils.JDBCUtilsByDruid;

/**
 * @author 银小海
 * @version 1.0
 * @email yinhai14@qq.com
 */
public class MemberTest {
    public static void main(String[] args) {
        MemberDAO memberDAO = new MemberDAOImpl();
        if (memberDAO.queryMemberByUsername("jack") == null) {
            System.out.println("null");
        } else {
            System.out.println("exist");
        }
        Member member = new Member(null, "jack", "jack", "135465@qq.com");
        System.out.println(memberDAO.saveMember(member));
        JDBCUtilsByDruid.commit();
    }
}
