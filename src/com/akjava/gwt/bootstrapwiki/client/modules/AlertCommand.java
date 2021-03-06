/*
 * Created on 2004/10/23
 * Author aki@www.xucker.jpn.org
 * License Apache2.0 or Common Public License
 */
package com.akjava.gwt.bootstrapwiki.client.modules;

import com.akjava.wiki.client.core.Element;
import com.akjava.wiki.client.core.ElementImp;

/**
 * 
 *
 */
public class AlertCommand extends ElementImp{
    
    public AlertCommand(){
    setName("alert");

    
    }

   
    
    /**
     * only topic and text
     */
    public Element breakUp(Element element,String line){
        if(line.startsWith("#text") ||line.startsWith("#alert")|| line.startsWith("*")){
            return element.getParent();
        }
        return element;
    }
}
