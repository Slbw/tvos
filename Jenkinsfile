pipeline {
  agent {
    node {
      label 'slbw'
    }
    
  }
  stages {
    stage('build') {
      steps {
        echo 'build start'
        sh '''./gradlew clean
./gradlew build'''
      }
    }
  }
}