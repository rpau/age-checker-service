#!groovy
@Library('github.com/walkmod/jenkins-pipeline-shared@master') _

node {
   def mvnHome
   stage('Preparation') { // for display purposes
      // Get some code from a GitHub repository
      git 'https://github.com/rpau/age-checker-service.git'
      // Get the Maven tool.
      // ** NOTE: This 'M3' Maven tool must be configured
      // **       in the global configuration.           
      mvnHome = tool 'M3'
   }
   
   stage ('Fixing Release'){
      walkmodApply { 
        mvnHomeDir = "${mvnHome}"
        validatePatch = true	
      }        
   }
   stage ('Check conventions'){
      sh "${mvnHome}/bin/mvn pmd:check"
   }
   stage('Build') {
      // Run the maven build
      sh "${mvnHome}/bin/mvn package"
      
   }
   stage('Results') {
      //junit '**/target/surefire-reports/TEST-*.xml'
      archive 'target/*.jar'
   }
}
