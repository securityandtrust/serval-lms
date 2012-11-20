package lu.snt.serval.lms.model.policy

import java.io.File
import org.junit.Assert._
import scala.Some
import org.slf4j.LoggerFactory
import org.junit.Test
import lu.snt.serval.acon.loader.PolicyLoader
import lu.snt.serval.acon.serializer.ModelSerializer

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
    val localModel = PolicyLoader.loadModel(new File(getClass.getResource("/libraryPolicy.xmi").toURI))
    localModel match {
      case Some(m) => {
        logger.info(m.getRoles.mkString("Roles: ",",","\n"))
      }
      case None => fail("Model not loaded!")
    }
  }


  def modelSavingTest() {

    val localModel = PolicyLoader.loadModel(new File(getClass.getResource("/LMS.art").toURI))
    localModel match {
      case Some(m) => {
        val serializer = new ModelSerializer
        System.out.println(serializer.serialize(m))
      }
      case None => fail("Model not loaded!")
    }
  }

}
