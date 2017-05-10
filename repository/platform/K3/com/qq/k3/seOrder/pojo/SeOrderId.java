package com.qq.k3.seOrder.pojo;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * SeorderId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class SeOrderId implements java.io.Serializable
{

	// Fields

	private String fbrNo;
	private Integer finterId;

	// Constructors

	/** default constructor */
	public SeOrderId()
	{
	}

	/** full constructor */
	public SeOrderId(String fbrNo, Integer finterId)
	{
		this.fbrNo = fbrNo;
		this.finterId = finterId;
	}

	// Property accessors

	@Column(name = "FBrNo", nullable = false, length = 10)
	public String getFbrNo()
		{
			return this.fbrNo;
		}

	public void setFbrNo(String fbrNo)
		{
			this.fbrNo = fbrNo;
		}

	@Column(name = "FInterID", nullable = false)
	public Integer getFinterId()
		{
			return this.finterId;
		}

	public void setFinterId(Integer finterId)
		{
			this.finterId = finterId;
		}

	public boolean equals(Object other)
		{
			if ((this == other))
				return true;
			if ((other == null))
				return false;
			if (!(other instanceof SeOrderId))
				return false;
			SeOrderId castOther = (SeOrderId) other;

			return ((this.getFbrNo() == castOther.getFbrNo()) || (this.getFbrNo() != null && castOther.getFbrNo() != null && this.getFbrNo().equals(castOther.getFbrNo())))
					&& ((this.getFinterId() == castOther.getFinterId()) || (this.getFinterId() != null && castOther.getFinterId() != null && this.getFinterId().equals(
							castOther.getFinterId())));
		}

	public int hashCode()
		{
			int result = 17;

			result = 37 * result + (getFbrNo() == null ? 0 : this.getFbrNo().hashCode());
			result = 37 * result + (getFinterId() == null ? 0 : this.getFinterId().hashCode());
			return result;
		}

}