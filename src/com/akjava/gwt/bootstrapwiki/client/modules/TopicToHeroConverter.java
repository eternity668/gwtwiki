/*
 * Created on 2004/11/23
 * Author aki@www.xucker.jpn.org
 * License Apache2.0 or Common Public License
 */
package com.akjava.gwt.bootstrapwiki.client.modules;

//import java.io.UnsupportedEncodingException;
//import java.net.URLEncoder;

import com.akjava.wiki.client.core.Node;
import com.akjava.wiki.client.htmlconverter.AbstractConverter;
import com.akjava.wiki.client.modules.Topic;

/**
 * 
 *
 */
public class TopicToHeroConverter extends AbstractConverter{
private Class targetClass=Topic.class;
public static boolean ignoreLevel1;
public boolean canConvert(Node node){
    return node.getClass().equals(targetClass);
	}




public String toHeader(Node node){
    String result="";
   //TODO re support anchor
    //result+="<a name='"+toEncode(((Topic)node).getTitle())+"'></a>";
    
    if(getLevel(node)==1){
    	if(ignoreLevel1){
    	return "";
    	}
    }
    
    if(getLevel(node)==2 && !getTitle(node).isEmpty()){
    	result+="<div class='hero-unit'>";
    }
    result+="<h";
    result+=getLevel(node);
    result+=">";
    result+=toTitle(getTitle(node));
    result+="</h"+getLevel(node)+">\r\n";
    
    return result;
	}
private String getTitle(Node node){
	return ((Topic)node).getTitle();
}

private String toTitle(String text){
	String ret="";
	int comma=text.indexOf(",");
	if(comma!=-1){
		String title=text.substring(0,comma);
		String small=text.substring(comma+1);
		ret=title+"<small>"+small+"</small>";
	}else{
		ret=text;
	}
	return ret;
}

private int getLevel(Node node){
	return ((Topic)node).getLevel();
}

public String toFooter(Node node){
   //return "";
	 if(getLevel(node)==2 && !getTitle(node).isEmpty()){
	return "</div>";
	 }else{
		 return "";
	 }
}
/*
public String toEncode(String string){
    try {
        return URLEncoder.encode(string,"Shift_JIS");
    } catch (UnsupportedEncodingException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    return null;
}
*/
}