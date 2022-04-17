@Library('mysharedlib') _ // declare the shared library 'mysharedlib' in your jenkins master configuration

// Declarative pipeline
pipeline {
    //definition de l'agent
    agent any
    
    stages {

        stage('test') {
            steps {
                sh "mvn -U clean test"                
            }
        }

        stage('test sharedlib getVersionFromPom') {
            steps {
            	getVersionFromPom()
            }
        }

    }
}
