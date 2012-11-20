package lu.snt.serval.lms.model.base

import java.io.File
import org.junit.Assert._
import scala.Some
import lu.snt.serval.art.loader.SystemLoader
import lu.snt.serval.art.serializer.ModelSerializer
import org.slf4j.LoggerFactory
import org.junit.Test

/*
* Author : Gregory Nain (developer.name@uni.lu)
* Date : 20/11/12
* (c) 2012 University of Luxembourg – Interdisciplinary Centre for Security Reliability and Trust (SnT)
* All rights reserved
*/

class ModelTest {

  val logger = LoggerFactory.getLogger(this.getClass)

  @Test
  def modelLoadingTest() {
    val localModel = SystemLoader.loadModel(new File(getClass.getResource("/LMS.art").toURI))
    localModel match {
      case Some(m) => {
        logger.info(m.getRoot.getSubComponent.mkString("Components: ",",","\n"))
      }
      case None => fail("Model not loaded!")
    }
  }


  def modelSavingTest() {

    val localModel = SystemLoader.loadModel(new File(getClass.getResource("/LMS.art").toURI))
    localModel match {
      case Some(m) => {
        val serializer = new ModelSerializer
        System.out.println(serializer.serialize(m))
      }
      case None => fail("Model not loaded!")
    }
  }

}
