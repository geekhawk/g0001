package com.thinkgem.jeesite.common.hibernate.persistence;

import java.io.Serializable;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;
@DynamicUpdate(true)
@SelectBeforeUpdate(true)
public interface  EntityInterfaceHBT extends Serializable, Cloneable
{
 
}
