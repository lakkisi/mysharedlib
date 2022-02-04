package com.silka.mysharedlib

import com.silka.sharedlib.MySharedlibWithUT
import static org.junit.Assert.*
import org.junit.Test

public class MySharedlibWithUTTest {

	def steps = new Object()//this is the jenkins object
	
	@Test
	void testGetVersionFromPom() {
		/** test return null in case of pom does not exist
		 * 
		 */
		this.steps.metaClass.fileExists = { String a -> return false } // mocking jenkins function fileExists = false		
		assertNull(new MySharedlibWithUT(steps))

		/** test return pom version
		 *
		 */
		this.steps.metaClass.fileExists = { String a -> return true } // mocking jenkins function fileExists = true
		this.steps.metaClass.readMavenPom = { Map a -> return "1.0.0" } // readMavenPom returns version "1.0.0"		
		assertEquals(new MySharedlibWithUT(steps), "1.0.0")
	}

	
}
