package com.cloud.beetles.pojo;

import com.sun.scenario.effect.impl.prism.PrImage;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
/**
 * @author xiaochen
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class Users implements Serializable {
    private int userId;
    private String userName;
    private String userPassword;
    private String userPhonenumber;
    private String userSources;

    public Users(int userId, String userName, String userPassword, String userPhonenumber, String userSources) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userPhonenumber = userPhonenumber;
        this.userSources = userSources;
    }
    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userPhonenumber='" + userPhonenumber + '\'' +
                ", userSources='" + userSources + '\'' +
                '}';
    }
}
