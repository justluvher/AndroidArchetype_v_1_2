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
package m2.android.archetype.example.aquery.fb.base;

import m2.android.archetype.base.M3Application;
import m2.android.archetype.example.R;
import m2.android.archetype.example.aquery.fb.FacebookFriendsListActivity;


public enum FeedMode {
	FRIENDS(R.string.fb_friends, R.drawable.ic_menu_allfriends,"https://graph.facebook.com/me/friends", FacebookFriendsListActivity.class),
	
	/*
	LIKES(R.string.like, "https://graph.facebook.com/me/likes"),
	MOVIES(R.string.n_movies, "https://graph.facebook.com/me/movies"),
	MUSIC(R.string.n_music, "https://graph.facebook.com/me/music"),
	BOOKS(R.string.n_books, "https://graph.facebook.com/me/books"),
	NOTES(R.string.n_notes, "https://graph.facebook.com/me/notes"),
	ALBUMS(R.string.photo_album, "https://graph.facebook.com/me/albums"),
	VIDEOS(R.string.n_videos, "https://graph.facebook.com/me/videos/uploaded"),
	EVENTS(R.string.n_events, "https://graph.facebook.com/me/events"),
	GROUPS(R.string.n_groups, "https://graph.facebook.com/me/groups"),
	CHECKINS(R.string.n_checkins, "https://graph.facebook.com/me/checkins"),
	*/
	;
	
	
	private String url;
	private int display;
	private Class<?> act;
	private int icon;
	
	private FeedMode(int display, String url){
		this(display, 0, url, null);
	}
	
	private FeedMode(int display, int icon, String url, Class<?> act){
		this.display = display;
		this.icon = icon;
		this.url = url;
		this.act = act;
	}
	
	
	public String getUrl(){
		return url;
	}
	
	public String getDisplay(){
		return M3Application.getGlobalContext().getString(display);
	}
	
	public Class<?> getHandler(){
		return act;
	}

	public String toString(){
		return getDisplay();
	}

	public int getIcon() {
		return icon;
	}
	
}
