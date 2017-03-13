#!groovy
@Library('github.com/walkmod/jenkins-pipeline-shared@maven') _

pipeline {
   agent any
  
   stages {

   stage ('Fixing Release'){
      steps {
         walkmodApply(validatePatch: true, 
         branch: env.BRANCH_NAME, 
         alwaysApply: true,
         alwaysFail: true)
      }        
   }
   stage ('Check conventions'){
      steps {
         sh "mvn pmd:check"
      }
   }
   stage('Build') {
      steps {
         sh "mvn package"
      }
   }
   stage('Results') {
      steps {
          archive 'target/*.jar'
      }
   }
   }
}
