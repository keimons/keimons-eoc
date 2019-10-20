package com.keimons.eoc.launcher;

import com.google.protobuf.Message;
import com.keimons.eoc.protobuf.PbPacket;
import com.keimons.platform.session.Session;

/**
 * 基础实现
 *
 * @author monkey1993
 * @version 1.0
 * @since 1.8
 **/
public class EocBaseProcessor<T extends Message> extends BaseProcessor<T, Player> {

	@Override
	public PbPacket.Packet.Builder process(Session session) {
		return null;
	}

	@Override
	public PbPacket.Packet.Builder process(Session session, T t) {
		return null;
	}

	@Override
	public PbPacket.Packet.Builder process(Player player) {
		return null;
	}

	@Override
	public PbPacket.Packet.Builder process(Player player, T t) {
		return null;
	}
}