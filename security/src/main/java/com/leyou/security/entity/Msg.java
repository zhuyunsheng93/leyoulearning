package com.leyou.security.entity;

/**
 * @Author: zhuyunsheng
 * @Date: 2019/7/15 10:50
 */
public class Msg {
private String title;
private String content;
private String extraMsg;

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getExtraMsg() {
    return extraMsg;
  }

  public void setExtraMsg(String extraMsg) {
    this.extraMsg = extraMsg;
  }

  public Msg(String title, String content, String extraMsg) {
    this.title = title;
    this.content = content;
    this.extraMsg = extraMsg;

  }
}
