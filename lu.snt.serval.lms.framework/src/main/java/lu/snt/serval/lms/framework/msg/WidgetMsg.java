package lu.snt.serval.lms.framework.msg;/*
* Author : Gregory Nain (developer.name@uni.lu)
* Date : 20/11/12
* (c) 2012 University of Luxembourg – Interdisciplinary Centre for Security Reliability and Trust (SnT)
* All rights reserved
*/

import lu.snt.serval.lms.framework.graphics.Widget;

public class WidgetMsg {

    private Widget widget;

    public WidgetMsg(Widget w) {
        this.widget = w;
    }

    public Widget getWidget() {
        return widget;
    }
}
