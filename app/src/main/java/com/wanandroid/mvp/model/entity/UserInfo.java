package com.wanandroid.mvp.model.entity;

import java.util.List;

/**
 * user info response
 *
 * @author hengtao
 * @since 2019-10-25
 */
public class UserInfo {
	private boolean admin;

	private List<String> chapterTops;

	private List<String> collectIds;

	private String email;

	private String icon;

	private String id;

	private String nickname;

	private String username;

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public List<String> getChapterTops() {
		return chapterTops;
	}

	public void setChapterTops(List<String> chapterTops) {
		this.chapterTops = chapterTops;
	}

	public List<String> getCollectIds() {
		return collectIds;
	}

	public void setCollectIds(List<String> collectIds) {
		this.collectIds = collectIds;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}

