package com.keimons.eoc.modular.player;

import com.keimons.eoc.launcher.EocBaseProcessor;
import com.keimons.eoc.launcher.Player;
import com.keimons.eoc.launcher.PlayerManager;
import com.keimons.platform.annotation.AProcessor;
import com.keimons.platform.network.Packet;
import com.keimons.platform.process.ThreadLevel;
import com.keimons.platform.session.Session;

/**
 * 注册
 *
 * @author monkey1993
 * @version 1.0
 * @since 1.8
 **/
@AProcessor(MsgCode = 1001, Desc = "注册", ThreadLevel = ThreadLevel.L_LEVEL)
public class RegisterProcessor1001 extends EocBaseProcessor {

	@Override
	public Packet process(Session session) {
		Player player = PlayerManager.registerPlayer("1234");

		if (player == null) {
			return build("Name Already Exits!");
		}
		session.setPlayer(player);
		player.setSession(session);
		return build();
	}
}