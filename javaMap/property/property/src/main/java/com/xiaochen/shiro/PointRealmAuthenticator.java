package com.xiaochen.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.realm.Realm;

import java.util.Map;

/**
 * 自定义认证器
 *
 * @author Sunny
 */
public class PointRealmAuthenticator extends ModularRealmAuthenticator {
    /**
     * 存放realm
     */
    private Map<String, Object> definedRealms;

    public void setDefinedRealms(Map<String, Object> definedRealms) {
        this.definedRealms = definedRealms;
    }

    /**
     * 根据用户类型判断使用哪个Realm
     */
    @Override
    protected AuthenticationInfo doAuthenticate(AuthenticationToken authenticationToken)
            throws AuthenticationException {
        super.assertRealmsConfigured();
        Realm realm = null;
        // 使用自定义Token
        UsernamePasswordByUserTypeToken token = (UsernamePasswordByUserTypeToken) authenticationToken;
        // 判断用户类型
        if ("1".equals(token.getUserType())) {
            realm = (Realm) this.definedRealms.get("adminRealm");
        } else if ("2".equals(token.getUserType())) {
            realm = (Realm) this.definedRealms.get("userRealm");
        }
        return this.doSingleRealmAuthentication(realm, authenticationToken);
    }
}