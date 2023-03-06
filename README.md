"# Selenoid-Docker" 
**Running Selenium Tests using Selenoid in Docker**

- Navigate to users-\> \<localname\>. Create a config folder and add a browsers.json file. Selenoid parses this json file to understand the possible combinations to run the tests. The images mentioned in the json file needs to be manually pulled from docker hub.

![](RackMultipart20230306-1-z6uxol_html_9051e98c0bd221da.png)

- Pull the below images from Dockerhub

Selenoid - docker pull aerokube/selenoid:latest-release

Selenoid Configuration Manager - docker pull aerokube/cm:latest-release

Selenoid UI to view the execution - docker pull aerokube/selenoid-ui

Selenoid Video Recorder to store videos of execution- docker pull selenoid/video-recorder

Chromebrowser (Choose vnc) - selenoid/vnc\_chrome:\<Version needed\>

Firefox browser (choose vnc)- docker pull selenoid/vnc\_firefox:\<version needed\>

- Spin up the containers with Selenoid,selenoid-ui, selenoid/video-recorder images using windows powershell

docker run -d --name selenoid -p 4444:4444 -v //var/run/docker.sock:/var/run/docker.sock -v ${current}/config/:/etc/selenoid/:ro -v /c/Users/\<username\>/selenoid/video/:/opt/selenoid/video/ -e OVERRIDE\_VIDEO\_OUTPUT\_DIR=/c/Users/\<username\>/selenoid/video/ aerokube/selenoid:latest-release

- Point the selenium tests to [http://localhost:4444/wd/hub/](http://localhost/wd/hub/)
- To view live execution, point to [http://localhost:8090/](http://localhost:8090/)

docker run --rm -d --name selenoid-ui --link selenoid -p 8090:8080 aerokube/selenoid-ui --selenoid-uri=http://selenoid:4444

- Selenoid by default allows 5 parallel sessions. If more needed, override with -limit parameter
- Run the scripts. Videos of tests can be accessed with [http://localhost:4444/video/](http://localhost:4444/video/#)
