package com.ortech.app.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.Version;

@MappedSuperclass
public class BaseEntity implements Serializable {

	/**
	 * Serial Version ID.
	 */
	@Transient
	private static final long serialVersionUID = 1L;

	/**
	 * Id. Auto-Generated.
	 */
	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;

	/**
	 * Version.
	 */
	@Version
	private Integer version = 0;

	/**
	 * Creation Date.
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created")
	private Date created;

	/**
	 * Updated Date.
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated")
	private Date updated;

	/**
	 * Pre-Persist Logic.
	 */
	@PrePersist
	protected void onCreate() {
		this.created = new Date();
		this.updated = this.created;
	}

	/**
	 * Pre-Update Logic.
	 */
	@PreUpdate
	protected void onUpdate() {
		this.updated = new Date();
	}

	/**
	 * Get the created.
	 * 
	 * @return the created
	 */
	public Date getCreated() {
		Date date = null;
		if (this.created != null) {
			date = new Date(this.created.getTime());
		}
		return date;
	}

	/**
	 * Set the created.
	 * 
	 * @param newCreated
	 *            the newCreated to set
	 */
	public void setCreated(final Date newCreated) {
		if (newCreated == null) {
			this.created = null;
		} else {
			this.created = new Date(newCreated.getTime());
		}
	}

	/**
	 * Get the updated.
	 * 
	 * @return the updated
	 */
	public Date getUpdated() {
		Date date = null;
		if (this.updated != null) {
			date = new Date(this.updated.getTime());
		}
		return date;
	}

	/**
	 * Set the updated.
	 * 
	 * @param newUpdated
	 *            the updated to set
	 */
	public void setUpdated(final Date newUpdated) {
		if (newUpdated == null) {
			this.updated = null;
		} else {
			this.updated = new Date(newUpdated.getTime());
		}
	}

	/**
	 * Get the version.
	 * 
	 * @return the version
	 */
	public Integer getVersion() {
		return this.version;
	}

	/**
	 * Set the id.
	 * 
	 * @param pId
	 *            the id to set
	 */
	public void setId(final Integer pId) {
		this.id = pId;
	}

}
