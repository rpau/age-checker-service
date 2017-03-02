node {
   def mvnHome
   stage('Preparation') { // for display purposes
      // Get some code from a GitHub repository
      git 'https://github.com/rpau/age-checker-service.git'
      // Get the Maven tool.
      // ** NOTE: This 'M3' Maven tool must be configured
      // **       in the global configuration.           
      //mvnHome = tool 'M3'
   }
   stage('Build') {
      // Run the maven build
      echo “'${mvnHome}/bin/mvn'”
      sh "'${mvnHome}/bin/mvn' -Dmaven.test.failure.ignore clean package"
      
   }
   stage('Results') {
      //junit '**/target/surefire-reports/TEST-*.xml'
      archive 'target/*.jar'
   }
}
