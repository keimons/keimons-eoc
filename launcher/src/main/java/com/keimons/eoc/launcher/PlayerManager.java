package com.keimons.eoc.launcher;

import com.keimons.platform.datebase.RedissonManager;
import com.keimons.platform.module.ModulesManager;
import org.redisson.client.codec.StringCodec;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 玩家管理
 *
 * @author monkey1993
 * @version 1.0
 * @since 1.8
 **/
public class PlayerManager {

	/**
	 * 所有玩家
	 */
	public static Map<Long, Player> players = new ConcurrentHashMap<>();

	/**
	 * 获取一个玩家
	 *
	 * @param playerId 玩家ID
	 * @return 玩家
	 */
	public static Player getPlayer(long playerId) {
		return players.get(playerId);
	}

	public static AtomicLong playerId = new AtomicLong();

	/**
	 * 注册用户
	 */
	public static Player registerPlayer(String name) {
		long playerId = PlayerManager.playerId.incrementAndGet(); // createPlayerId("", name);
		if (playerId == -1) {
			return null;
		}
		Player player = new Player(playerId);
		ModulesManager.createModules(player);
		players.put(playerId, player);
		return player;
	}

	/**
	 * 创建一个唯一ID
	 * <p>
	 * 这个ID是唯一的，允许同名存在也
	 *
	 * @param redisKey key类型
	 * @param name     昵称
	 * @return -1.标识符已经存在 不为0则表示唯一标识符
	 */
	public static long createPlayerId(String redisKey, String name) {
		Long oldValue = RedissonManager.getMapValue(redisKey, name);
		if (oldValue != null) {
			return -1;
		}
		long playerId = RedissonManager.incrementAndGet(redisKey);
		oldValue = RedissonManager.setMapValueIfAbsent(StringCodec.INSTANCE, redisKey, name, playerId);
		if (oldValue != null) {
			return -1;
		}
		return playerId;
	}
}