package com.keimons.eoc.launcher;

import com.google.protobuf.Message;
import com.keimons.platform.network.Packet;
import com.keimons.platform.process.BaseProcessor;
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
	public Packet process(Session session) {
		return null;
	}

	@Override
	public Packet process(Session session, T t) {
		return null;
	}

	@Override
	public Packet process(Player player) {
		return null;
	}

	@Override
	public Packet process(Player player, T t) {
		return null;
	}
}