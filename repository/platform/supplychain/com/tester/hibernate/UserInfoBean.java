package com.tester.hibernate;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SelectBeforeUpdate;

import com.thinkgem.jeesite.common.hibernate.persistence.EntityInterfaceHBT; 

/**
 * UserInfoBean entity. @author MyEclipse Persistence Tools
 */
@DynamicUpdate(true)
@SelectBeforeUpdate(true)
@Entity
@Table(name = "UserInfoBean", schema = "dbo", catalog = "AIS20170502093932")
public class UserInfoBean  implements EntityInterfaceHBT
{

	// Fields

	private String id;
	private String nickName;
	private Timestamp date;

	// Constructors

	/** default constructor */
	public UserInfoBean()
	{
	}

	/** full constructor */
	public UserInfoBean(String nickName, Timestamp date)
	{
		this.nickName = nickName;
		this.date = date;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "org.hibernate.id.UUIDGenerator")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "id", length = 50)
	public String getId()
		{
			return this.id;
		}

	public void setId(String id)
		{
			this.id = id;
		}

	@Column(name = "nickName", length = 50)
	public String getNickName()
		{
			return this.nickName;
		}

	public void setNickName(String nickName)
		{
			this.nickName = nickName;
		}

	@Column(name = "date", length = 23)
	public Timestamp getDate()
		{
			return this.date;
		}

	public void setDate(Timestamp date)
		{
			this.date = date;
		}

}
 

 