package com.silka.mysharedlib

import com.silka.mysharedlib.MySharedlibWithUT
import org.apache.maven.model.Model
import static org.junit.Assert.*
import org.junit.Test

public class MySharedlibWithUTTest {

	def steps = new Object()//this is the jenkins object
	
	@Test
	void testGetVersionFromPom() {
		/** test return empty in the case pom does not exist
		 * 
		 */
		this.steps.metaClass.fileExists = { String a -> return false } 	// mocking jenkins function fileExists = false		
		assertEquals(new MySharedlibWithUT(steps).getVersionFromPom(), "")

		/** test return pom version in the case pom exists
		 *
		 */
		this.steps.metaClass.fileExists = { String a -> return true } 	// mocking jenkins function fileExists = true
		def model = new Model()
		model.setVersion("1.0.0")										// creationg pom object with version "1.0.0"
		this.steps.metaClass.readMavenPom = { Map a -> return model } 	// readMavenPom returns pom object with version "1.0.0"		
		assertEquals(new MySharedlibWithUT(steps).getVersionFromPom(), "1.0.0")
		
		/**
		 * test return empty in case pom exists but version is not defined
		 */
		this.steps.metaClass.fileExists = { String a -> return true } 	// mocking jenkins function fileExists = true
		model = new Model()												// creating empty pom object
		this.steps.metaClass.readMavenPom = { Map a -> return model } 	// readMavenPom returns pom empty
		assertEquals(new MySharedlibWithUT(steps).getVersionFromPom(), "")
				
	}

	
}
