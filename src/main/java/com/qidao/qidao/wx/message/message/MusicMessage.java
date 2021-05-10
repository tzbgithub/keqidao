package com.qidao.qidao.wx.message.message;

import lombok.Getter;
import lombok.Setter;

/**
 * @author zhoumin
 * @create 2018-07-11 10:19
 */
@Setter
@Getter
public class MusicMessage extends BaseMessage {
    /**
     * 音乐
     */
    private com.qidao.qidao.wx.message.message.Music Music;

}
