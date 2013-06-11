package lu.snt.serval.lms.sandbox;/*
* Author : Gregory Nain (developer.name@uni.lu)
* Date : 29/05/13
*/

import org.kevoree.ContainerRoot;
import org.kevoree.KevoreeFactory;
import org.kevoree.impl.DefaultKevoreeFactory;
import org.kevoree.tools.marShell.KevsEngine;

public class KevScriptExample {


    public static void main(String[] args) {

        //Gets the Kevoree factory
        KevoreeFactory factory = new DefaultKevoreeFactory();

        //Creates an empty KevoreeModel
        ContainerRoot emptyBaseModel = factory.createContainerRoot();

        StringBuilder sb = new StringBuilder();
        sb.append("addRepo 'http://maven.kevoree.org/release'");
        sb.append("merge 'mvn:org.kevoree.corelibrary.javase/org.kevoree.library.javase.javaseNode/2.0.0-ALPHA'");
        sb.append("merge 'mvn:org.kevoree.corelibrary.javase/org.kevoree.library.javase.defaultChannels/2.0.0-ALPHA'");
        sb.append("merge 'mvn:org.kevoree.corelibrary.javase/org.kevoree.library.javase.fakeDomo/2.0.0-ALPHA'");
        sb.append("addNode node0:JavaSENode");
        sb.append("addComponent light@node0 : FakeSimpleLight");
        sb.append("addComponent switch@node0 : FakeSimpleSwitch");
        sb.append("addChannel offChannel : defMSG");
        sb.append("addChannel onChannel : defMSG");
        sb.append("bind light.off@node0 => offChannel");
        sb.append("bind light.on@node0 => onChannel");
        sb.append("bind switch.off@node0 => offChannel");
        sb.append("bind switch.on@node0 => onChannel");

        scala.Option<ContainerRoot> newModel = KevsEngine.executeScript(sb.toString(), emptyBaseModel);
        newModel.get();
        System.out.println("Number of component on node0: " + newModel.get().getNodes().get(0).getComponents().size());

    }


}
