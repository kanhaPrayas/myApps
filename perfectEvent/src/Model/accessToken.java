package Model;
import redis.clients.jedis.Jedis;
public class accessToken {
	int secondsToLive = 1500;
	public boolean set(String key, String value) {
		Jedis jedis = new Jedis("localhost");
		jedis.setex(key, secondsToLive,  value);
		return true;
	}
	
	public boolean get(String key) {
		Jedis jedis = new Jedis("localhost");
		String value = jedis.get(key);
		if(value != null) {
			jedis.expire(key,secondsToLive);
			return true;
		}
		return false;
	}
}
