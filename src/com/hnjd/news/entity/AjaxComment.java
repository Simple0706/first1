package com.hnjd.news.entity;

public class AjaxComment {

	
	
private String cid;
private String author;
private String ip;
private String text;
public AjaxComment(String cid, String author, String ip, String text) {
	super();
	this.cid = cid;
	this.author = author;
	this.ip = ip;
	this.text = text;
}
public AjaxComment() {
	super();
}
public String getCid() {
	return cid;
}
public void setCid(String cid) {
	this.cid = cid;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
public String getIp() {
	return ip;
}
public void setIp(String ip) {
	this.ip = ip;
}
public String getText() {
	return text;
}
public void setText(String text) {
	this.text = text;
}
@Override
public String toString() {
	return "AjaxComment [cid=" + cid + ", author=" + author + ", ip=" + ip + ", text=" + text + "]";
}


}
