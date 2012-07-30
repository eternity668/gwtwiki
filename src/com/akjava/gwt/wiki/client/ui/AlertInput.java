package com.akjava.gwt.wiki.client.ui;

import com.akjava.gwt.wiki.client.TextInsertTarget;
import com.github.gwtbootstrap.client.ui.ListBox;
import com.github.gwtbootstrap.client.ui.base.TextBox;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.user.client.ui.HorizontalPanel;

public class AlertInput extends HorizontalPanel{
TextInsertTarget target;
	public AlertInput(TextInsertTarget ta){
		this.target=ta;
		final ListBox list=new ListBox();
		list.setWidth("80px");
		list.addItem("-alert-");
		list.addItem("info");
		list.addItem("error");
		list.addItem("success");
		list.addItem("block");
		list.setSelectedIndex(0);
		add(list);
		/*
		final TextBox text=new TextBox();
		text.setWidth("80px");
		add(text);
		*/
		list.addChangeHandler(new ChangeHandler() {
			
			@Override
			public void onChange(ChangeEvent event) {
				int selection=list.getSelectedIndex();
				if(selection>0){
				
					//String input=text.getText();
					
					String label=list.getItemText(selection);
					/*
					if(input.isEmpty()){
						input=label;
					}
					*/
					target.insertAndCursorCenter("#alert("+label+")\n","\n#text\n");
					list.setSelectedIndex(0);
				}
			}
		});
	}
}
