@Library('mysharedlib') _ // declare the shared library 'mysharedlib' in your jenkins master configuration

// Declarative pipeline
pipeline {
    //definition de l'agent
    agent any

    tools {
        jdk "JDK sun 1.8"
        maven "Maven 3.2.5"
    }
    
    stages {

        stage('test') {
            steps {
                sh "mvn clean test"                
            }
        }

        stage('test sharedlib getVersionFromPom') {
            steps {
            	getVersionFromPom()
            }
        }

    }
}
