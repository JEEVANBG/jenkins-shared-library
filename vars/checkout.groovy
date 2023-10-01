def call (String git_branch = 'main' , String git_crendentials = null , String git_url = null) {
    echo "This is one way , where we call this function within pipeline block"
    checkout ([$Class: 'GitSCM',
                branches: [[ name: "/*${git_branch}"]],
                userRemoteConfigs:[[ credentialsID: "$git_crendentials", url: "$git_url"]]
    ])
    sh 'pwd; ls -lrt'

}


