/*******************************************************************************
 * Copyright 2012 AndroidQuery (tinyeeliu@gmail.com)
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 * Additional Note:
 * 1. You cannot use AndroidQuery's Facebook app account in your own apps.
 * 2. You cannot republish the app as is with advertisements.
 ******************************************************************************/
package m2.android.archetype.example.aquery.fb.util;

import java.util.Locale;

import m2.android.archetype.base.M3Application;
import m2.android.archetype.example.R;
import m2.android.archetype.example.aquery.fb.base.FeedMode;
import m2.android.archetype.example.aquery.fb.obj.FacebookFriend;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;

import com.androidquery.auth.FacebookHandle;
import com.androidquery.util.AQUtility;

public class AQueryFBUtility {

	public static final String USER_NAME = "aq.fb.user.name"; 
	
	public final static String APP_ID = "304050252938418";
	//private static String PERMISSIONS = "read_stream,read_friendlists,manage_friendlists,manage_notifications,publish_stream,publish_checkins,offline_access,user_photos,user_likes,user_groups,friends_photos";
	private static String PERMISSIONS = "read_stream,read_friendlists,manage_friendlists,manage_notifications,publish_stream,publish_checkins,offline_access,user_about_me,friends_about_me,user_activities,friends_activities,user_checkins,friends_checkins,user_events,friends_events,user_groups,friends_groups,user_interests,friends_interests,user_likes,friends_likes,user_notes,friends_notes,user_photos,friends_photos,user_status,friends_status,user_videos,friends_videos";
	
	public static FacebookHandle makeHandle(Activity act){
		
		FacebookHandle handle = new FacebookHandle(act, APP_ID, PERMISSIONS);
		
		handle.message(act.getString(R.string.connecting_facebook));
		return handle;
		
	}
	
	public static void logout(Activity act){
		
		makeHandle(act).unauth();		
		//handle = null;
		PrefUtility.put(USER_NAME, (String) null);
	}
	
	
	private static Locale locale;
	
	public static void presetLocale(Context context){
		
		try{
		
			String value = PrefUtility.get("locale", null);
		
			AQUtility.debug("user locale", value);
			
			if(value != null && value.length() > 0){
				locale = new Locale(value);
				resetLocale(context);
			}
			
			
		}catch(Exception e){
			AQUtility.report(e);
		}
	}
	
	public static void setLocale(String lang){
		
		if(lang.equals("")){
			locale = Locale.getDefault();
		}else{		
			locale = new Locale(lang);
		}
		
	}
	
	public static void resetLocale(Context context){
		
		
		Configuration config = new Configuration();
		config.locale = locale;
		context.getResources().updateConfiguration(config, context.getResources().getDisplayMetrics());
		
		AQUtility.debug("reset locale", locale);
	
		
	}
	
	public static String getUserName(){
    	return PrefUtility.get(AQueryFBUtility.USER_NAME, M3Application.getGlobalContext().getString(R.string.me));    
    }
	
	public static String getUserName(String fallback){
    	return PrefUtility.get(AQueryFBUtility.USER_NAME, fallback);    
    }
	
	public static FeedMode getDefaultMode(){
    	return PrefUtility.getEnum(FeedMode.class, FeedMode.FRIENDS);
    }
    
    public static FacebookFriend getDefaultSource(FeedMode mode){
    	
    	FacebookFriend entity = new FacebookFriend();
    	return entity;
    }
	
}
