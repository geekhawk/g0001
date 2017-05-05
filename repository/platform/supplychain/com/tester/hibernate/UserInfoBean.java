package com.tester.hibernate;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.thinkgem.jeesite.common.hibernate.persistence.IEntityHBT;

/**
 * 
 * @ClassName: UserInfoBean
 * @Description: TODO(用户信息类)
 * @author dapeng
 * @date 2014年5月7日 上午12:13:44
 * @version V1.0
 * 
 */
@Entity
public class UserInfoBean implements IEntityHBT {

    private static final long serialVersionUID = 7280747949998651159L;

    @Id
    private String id;
    /**
     * 昵称
     */
    private String nickName;
     
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

	public void setNickName(String nickName)
	{
		this.nickName = nickName;
	}

     

}