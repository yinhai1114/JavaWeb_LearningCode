package com.yinhai.furns.test;

import com.yinhai.furns.javabean.Member;
import com.yinhai.furns.service.MemberService;
import com.yinhai.furns.service.impl.MemberServiceImpl;
import com.yinhai.furns.utils.JDBCUtilsByDruid;
import org.junit.jupiter.api.Test;

/**
 * @author 银小海
 * @version 1.0
 * @email yinhai14@qq.com
 */
public class MemberServiceTest {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        if (memberService.isExistsUsername("admin")){
            System.out.println("用户存在");
        }else{
            System.out.println("用户不存在");
        }
    }
    @Test
    public void test(){
        Member member = new Member(null, "tom", "tom", "643013242@qq.com");
        MemberService memberService = new MemberServiceImpl();
        boolean b = memberService.registerMember(member);
        if (b){
            System.out.println("注册成功");
            JDBCUtilsByDruid.commit();
        }else{
            System.out.println("注册失败");
        }
        JDBCUtilsByDruid.commit();
    }
}
