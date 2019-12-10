package com.xiaochen.shiro;

import com.xiaochen.pojo.Admin;
import com.xiaochen.pojo.User;
import com.xiaochen.service.AdminService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;

public class AdminRealm extends AuthorizingRealm {

    @Resource
    private AdminService adminService;

    @Override
    //认证
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        Admin admin = null;
        // 把AuthenticationToken实质为UsernamePasswordToken，直接转换即可
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        admin = adminService.getAdmin(usernamePasswordToken.getUsername());          // 通过service查询用户名是否存在
        if (admin == null)
            throw new UnknownAccountException("用户不存在！");
        System.out.println("doGetAuthenticationInfo username Admin=" + admin.getAdminName());
        System.out.println("doGetAuthenticationInfo password Admin=" + admin.getAdminPassword());

        //  spring_database.xml文件中已经对此UserRealm bean对象设置了加密方式和次数，固这里无需重复配置，如果xml文件中没有配置，则需要代码配置
//        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
//        hashedCredentialsMatcher.setHashAlgorithmName("MD5");                      // 加密方式，与注册一致
//        hashedCredentialsMatcher.setHashIterations(11);                            // 加密次数，与注册一致
//        hashedCredentialsMatcher.setStoredCredentialsHexEncoded(true);           // true是默认值，代表16机制值，如果设置false则为base64
//        setCredentialsMatcher(hashedCredentialsMatcher);                           // 保存加密设置
        ByteSource credentialsSalt = ByteSource.Util.bytes(admin.getAdminName());    // 以用户名为加密盐值
        String realmName = getName();                                              // 当前realm对象的name，调用父类的getName()方法即可

        //认证的核心
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(admin, admin.getAdminPassword(), credentialsSalt, realmName);

        // 在没有加盐的情况下，三个参数就可以进行初步的简单认证信息对象的包装
//        AuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(), this.getClass().getSimpleName());
        return info;
    }

    @Override
    // 权限
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Object principal1 = principalCollection.getPrimaryPrincipal();  //获取登录的用户pojo对象
        Integer adminPower  = 10;
        if ("User".equals(principal1.getClass())){
            User user = (User) principal1;
            adminPower = user.getUserAuth();
        }else {
            Admin admin = (Admin) principal1;
            adminPower = admin.getAdminPower();
        }
        System.out.println("AuthorizationInfo principal=" + principal1);
    /*
       根据不同的权限判断可访问的资源
       info.addRole("1")中的形参值，在spring_database.xml中shiroFilter进行配置
    */
        if(adminPower == 0){//超级管理员权限分配
            info.addRole("superadmin");
            info.addRole("admin");
        }
        if(adminPower == 1){//客服权限分配
            System.out.println("power-------------------");
            info.addRole("admin");
        }
        info.addRole("all");

        return info;

    }
}
