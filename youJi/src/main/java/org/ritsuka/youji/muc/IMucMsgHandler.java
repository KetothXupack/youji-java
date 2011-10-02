package org.ritsuka.youji.muc;

import akka.actor.ActorRef;
import org.jivesoftware.smack.packet.Packet;
import org.jivesoftware.smackx.muc.MultiUserChat;

/**
 * Date: 10/2/11
 * Time: 5:25 PM
 */
public interface IMucMsgHandler {
    void handleMucMsg(ActorRef worker, MultiUserChat chat, Packet message);
}
