package com.offering.common.utils;

import io.rong.ApiHttpClient;
import io.rong.models.FormatType;
import io.rong.models.SdkHttpResult;
import io.rong.models.TxtMessage;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

/**
 * 融云接口
 * @author surfacepro3
 *
 */
public class RCUtils {

	//测试环境pvxdm17jx829r/TYkLhjaVE7,正式环境uwd1c0sxd3lt1/Vm4N3C2JLcS1
	private final static String APP_KEY = "pvxdm17jx829r";
	private final static String APP_SECRET = "TYkLhjaVE7";
	
	private final static int CODE_OK = 200;
	
	/**
	 * 用户登录获取token
	 * @param userId
	 * @param userName
	 * @return
	 */
	public static String getToken(String userId,String userName,String url)
	{
		SdkHttpResult result = null;
		try {
			result = ApiHttpClient.getToken(APP_KEY, APP_SECRET, userId, userName,
					url, FormatType.json);
			if(CODE_OK == result.getHttpCode())
			{
				JSONObject jsonObj = new JSONObject(result.getResult());
				if(jsonObj.has("token"))
					return jsonObj.getString("token");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 私聊服务
	 * @param fromUserId
	 * @param toUserId
	 * @param msg
	 */
	public static void privateChat(String fromUserId,String toUserId,String msg)
	{
		List<String> toUserIds = new ArrayList<String>();
		toUserIds.add(toUserId);
		try {
			ApiHttpClient.publishMessage(APP_KEY, APP_SECRET, fromUserId, toUserIds, 
					new TxtMessage(msg), FormatType.json);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 创建群组
	 * @param userIds
	 * @param groupId
	 * @param groupName
	 */
	public static void createGroup(List<String> userIds,String groupId,String groupName)
	{
		try {
			ApiHttpClient.createGroup(APP_KEY, APP_SECRET, 
					userIds, groupId, groupName, FormatType.json);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 加入群组
	 * @param userId
	 * @param groupId
	 * @param groupName
	 */
	public static void joinGroup(String userId,String groupId,String groupName)
	{
		try {
			ApiHttpClient.joinGroup(APP_KEY, APP_SECRET, userId, groupId, groupName,  FormatType.json);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 离开群组
	 * @param userId
	 * @param groupId
	 */
	public static void quitGroup(String userId,String groupId)
	{
		try {
			ApiHttpClient.quitGroup(APP_KEY, APP_SECRET, userId, groupId, FormatType.json);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 解散群组
	 * @param userId
	 * @param groupId
	 */
	public static void dismissGroup(String userId,String groupId)
	{
		try {
			ApiHttpClient.dismissGroup(APP_KEY, APP_SECRET, userId, groupId, FormatType.json);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void refreshUser(String userId,String userName,String url)
	{
		try {
			ApiHttpClient.refreshUser(APP_KEY, APP_SECRET, userId, userName, url, FormatType.json);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
