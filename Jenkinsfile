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

    stage('Provider Tests') {
        if (agecheckerurl != null && !agecheckerurl.isEmpty()) {
            withEnv(['skipDeployment=true']) {
                sh "'${mvnHome}/bin/mvn' clean test"
            }
        } else {
            sh "'${mvnHome}/bin/mvn' clean test"
        }
    }
}