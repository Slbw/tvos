pipeline {
  agent none
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