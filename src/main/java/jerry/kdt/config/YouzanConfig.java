package jerry.kdt.config;

import java.io.IOException;
import java.io.Serializable;
import java.util.Properties;

@SuppressWarnings("serial")
public class YouzanConfig implements Serializable {
	public static Properties properties = new Properties();
	public enum SysInfoKey {
		APP_ID,
		APP_SECRET
	}

	static {
		try {
			String config="/youzan_config.properties";
			properties.load(YouzanConfig.class.getResourceAsStream(config));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 获取配置值String类型
	 * @param key	配置名称
	 * @return
	 */
	public static String getStrValue(String key) {
		return properties.getProperty(key);
	}
	public static String getStrValue(SysInfoKey key) {
		return properties.getProperty(key.name());
	}
	
	public static String getAppId() {
		return getStrValue(SysInfoKey.APP_ID);
	}
	public static String getAppSecret() {
		return getStrValue(SysInfoKey.APP_SECRET);
	}
}
