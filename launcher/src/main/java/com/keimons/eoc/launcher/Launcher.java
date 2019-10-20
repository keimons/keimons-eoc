package com.keimons.eoc.launcher;

import com.google.protobuf.InvalidProtocolBufferException;
import com.keimons.eoc.player.RegisterProcessor1001;
import com.keimons.eoc.protobuf.PbMessage;
import com.keimons.eoc.protobuf.PbPacket;
import com.keimons.platform.KeimonsConfig;
import com.keimons.platform.KeimonsServer;

import java.util.Properties;

/**
 * 启动器
 *
 * @author monkey1993
 * @version 1.0
 * @since 1.8
 **/
public class Launcher {

	public static void main(String[] args) throws InvalidProtocolBufferException {

		PbPacket.Packet packet = PbPacket.Packet.parseFrom(new byte[]{8, (byte) 233, 7, 26, 8, 10, 6, (byte) 229, (byte) 188, (byte) 160, (byte) 228, (byte) 184, (byte) 137});
		System.out.println(PbMessage.RegisterRequest.parseFrom(packet.getData()).getPlayerName());
		Properties properties = new Properties();
		properties.setProperty(KeimonsConfig.DEFAULT_NET_THREAD_SIMPLE, "LoginThread");
		KeimonsConfig config = new KeimonsConfig(properties);
		RegisterProcessor1001 registerProcessor1001 = new RegisterProcessor1001();
		KeimonsServer.start(config, PbPacket.Packet.class, PbPacket.Packet::parseFrom, PbPacket.Packet::toByteArray, PbPacket.Packet::getMsgCode);
	}
}