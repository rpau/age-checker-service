node {

   def mvnHome
   stage('Preparation') { // for display purposes
      // Get some code from repository
      checkout scm
      mvnHome = tool 'M3'
   }

   stage('Build') {
      sh "'${mvnHome}/bin/mvn' clean test-compile"
   }

   stage('Consumer Tests') {
      withEnv(['skipDeployment=true']) {
           sh "'${mvnHome}/bin/mvn' clean test"
      }
   }

}