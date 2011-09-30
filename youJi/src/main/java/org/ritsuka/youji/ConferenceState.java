package org.ritsuka.youji;

import org.jivesoftware.smackx.muc.MultiUserChat;

/**
 * Date: 9/29/11
 * Time: 11:35 PM
 */
public class ConferenceState {

    private ConferenceData confdata = null;
    private Integer attemptsCount = 0;
    private MultiUserChat muc = null;
    private String lastNick = null;
    private Boolean nickConflict = false;

    public ConferenceState(ConferenceData a_data, MultiUserChat a_chat) {
        confdata = a_data;
        muc = a_chat;
    }

    public ConferenceData conferenceData() {
        return confdata;
    }

    public Integer attempts() {
        return attemptsCount;
    }

    public Integer pauseBeforeNextAttempt() {
        Integer pause = attempts() * 4000;
        if (pause > 10000)
            pause = 10000;
        return pause;
    }


    public MultiUserChat muc() {
        return muc;
    }

    public void newAttempt() {
        if (null == lastNick)
            lastNick = confdata.nick();
        ++attemptsCount;
    }

    public void success() {
        attemptsCount = 0;
        nickConflict = false;
    }

    public void nickConflict() {
        nickConflict = true;
    }

    public String nick() {
        if (nickConflict)
            return confdata.goodNick(lastNick);
        return confdata.nick();
    }
}
