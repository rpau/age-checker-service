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
      sh 'mvn walkmod:patch'
      if (fileExists('walkmod.patch')) {
        echo 'walkmod has produced a patch'
        sh 'git apply walkmod.patch'
        sh 'rm walkmod.patch'
        sh 'git commit -a --amend -m "Fixing style violations"'
        sh 'git push'
        currentBuild.result = 'FAILURE'
        error("Build failed by the lack of consistent coding style")
      }
      echo 'no pending quick fixes to apply'
   }
   
   stage('Build') {
      // Run the maven build
      echo "${mvnHome}/bin/mvn"
      sh "'${mvnHome}/bin/mvn' -Dmaven.test.failure.ignore clean package"
      
   }
   stage('Results') {
      //junit '**/target/surefire-reports/TEST-*.xml'
      archive 'target/*.jar'
   }
}
