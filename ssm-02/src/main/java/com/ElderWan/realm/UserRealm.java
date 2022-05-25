package com.ElderWan.realm;


import com.ElderWan.entity.User;
import com.ElderWan.mapper.PermsMapper;
import com.ElderWan.mapper.UserMapper;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserRealm extends AuthorizingRealm {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PermsMapper permsMapper;
    //    认证    doGetAuthenticationInfo
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("=========认证==========");
        //获取
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String name = token.getUsername();
        System.out.println("----------"+name);
        //在db中查找
        User user = userMapper.getByName(name);

        //salt
        ByteSource salt = ByteSource.Util.bytes(name);
        //给shiro比对
        SimpleAuthenticationInfo simple = new SimpleAuthenticationInfo(user,user.getPwd(),salt,getName());
        //System.out.println("-----=-==-=-=-=-="+simple);

        return simple;
    }
//    授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("***********************授权******************* ");

       // Set<String> perms = new HashSet<>();
        User primaryPrincipal = (User) principalCollection.getPrimaryPrincipal();
       /* if("wtfegg".equals(primaryPrincipal.getUser_name())){
                perms.add("emp:add");
                perms.add("emp:update");
                perms.add("emp:del");
        }else if("tqcegg".equals(primaryPrincipal.getUser_name())){
                 perms.add("emp:add");
        }else if("mgl".equals(primaryPrincipal.getUser_name())){
                perms.add("emp:update");
                 perms.add("emp:del");
        }*/
        Set<String> perms = this.permsMapper.queryPerms(primaryPrincipal.getUser_name());
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setStringPermissions(perms);
        return info;
    }

    public static void main(String[] args) {
        String hashAlgorithmName = "MD5";
        Object credentials = "123";
        ByteSource salt1 = ByteSource.Util.bytes("mgl");
        Object result = new SimpleHash(hashAlgorithmName,credentials,salt1,1024);
        System.out.println(result);
    }
}
