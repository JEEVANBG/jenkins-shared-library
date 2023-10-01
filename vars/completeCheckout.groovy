def call (String git_branch = 'main', String git_credentials = null , String git_url = null) {
    pipeline {
        agent any

        environment {
            GIT_BRANCH = "${git_branch}"
            GIT_CREDENTIALS = "${git_credentials}"
            GIT_URL = "${git_url}"
        }

        stages {
            stage('Check_out_with_pipeline') {
                steps {
                    echo "This is complete groovy checkout script , we don't need to define pipeline in jenkins machine"
                    checkout ([$class : 'GitSCM',
                                branches : [[name: "*/${GIT_BRANCH}"]],
                                userRemoteConfigs: [[ credentialsID: "${GIT_CREDENTIALS}", url: "${GIT_UR}L"]]
                    ])

                    sh 'pwd; ls -lrt'
                }
            }
        }
    }

}
