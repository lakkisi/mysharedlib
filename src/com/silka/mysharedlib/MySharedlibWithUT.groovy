package com.silka.mysharedlib ;

public class MySharedlibWithUT implements Serializable   {

	def steps //this is the jenkins object

	/**
	* initializing the steps object in the constructor
	**/
	public MySharedlibWithUT (steps) {
		this.steps = steps
	}

	/**
	* this function gets version from pom or return nuls if the pom.xml file does not exists
	**/
	public def getVersionFromPom () {
		if (steps.fileExists("pom.xml")) {
			return steps.readMavenPom(file: 'pom.xml').getVersion() ?: ""			
		} else {
			return ""
		}
	}

}
