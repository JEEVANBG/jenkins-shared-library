def call(String git_branch = 'main', String git_credentials = null, String git_url = null) {    
    pipeline {
        agent any 

        environment {
            GIT_BRANCH = "${git_branch}"
            GIT_CREDS = "${git_credentials}"
            GIT_URL = "${git_url}"
        }

        stages {
            stage('Checkout code') {
                steps {
                    sh 'pwd; ls -lrt'    
                     echo "This is dockerBuildComplete.groovy"
                     checkout([$class: 'GitSCM', 
                              branches: [[name: "*/${GIT_BRANCH}"]], 
                              userRemoteConfigs: [[credentialsId: "${GIT_CREDS}", url: "${GIT_URL}"]]
                            ])
                    sh 'pwd; ls -lrt'        
                }
            }
        }
    }

}
