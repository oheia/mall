###### **Mac下安装docker**

- 使用 cask 安装docker客户端
```$xslt
$ brew install --cask docker
```

- 常用命令  
```
查看本地镜像：
$ docker images
=>
REPOSITORY          TAG       IMAGE ID       CREATED        SIZE
docker101tutorial   latest    8da735e4d698   35 hours ago   27.9MB
tomcat              latest    bf4709e77b18   9 days ago     667MB
ubuntu              latest    f63181f19b2f   4 weeks ago    72.9MB
alpine/git          latest    04dbb58d2cea   4 weeks ago    25.1MB
training/webapp     latest    6fae60ef3446   5 years ago    349MB
ubuntu              13.10     7f020f7bf345   6 years ago    185MB
```
```
启动镜像：
$ docker run -t -i ubuntu:15.10 /bin/bash 
指定端口
$ docker run --name webserver -d -p 81:80 nginx
-d 后台运行
-p 81:80 将该容器的80端口指定到本机的81端口
--name 重命名
```
```
查看启动的容器信息
$ docker ps

CONTAINER ID   IMAGE     COMMAND                  CREATED         STATUS         PORTS                     NAMES
e9c4c8d66891   redis     "docker-entrypoint.s…"   4 minutes ago   Up 4 minutes   0.0.0.0:63791->6379/tcp   redis-slave
4aa6f7be6a03   redis     "docker-entrypoint.s…"   4 minutes ago   Up 4 minutes   0.0.0.0:63790->6379/tcp   redis-master

查看所有容器信息, -a 列出所有容器，包含未启动的 ,与 docker container ls -a
$ docker ps -a
CONTAINER ID   IMAGE                 COMMAND                  CREATED        STATUS                     PORTS                                                                                              NAMES
e9c4c8d66891   redis                 "docker-entrypoint.s…"   24 hours ago   Up 24 hours                0.0.0.0:63791->6379/tcp                                                                            redis-slave
4aa6f7be6a03   redis                 "docker-entrypoint.s…"   24 hours ago   Up 24 hours                0.0.0.0:63790->6379/tcp                                                                            redis-master
894b9a51d14a   jenkinsci/blueocean   "/sbin/tini -- /usr/…"   4 weeks ago    Exited (143) 4 weeks ago                                                                                                      jenkins-blueocean
ae3df610d916   rabbitmq              "docker-entrypoint.s…"   5 weeks ago    Exited (255) 4 weeks ago   4369/tcp, 0.0.0.0:5672->5672/tcp, 5671/tcp, 15691-15692/tcp, 25672/tcp, 0.0.0.0:15672->15672/tcp   rabbitmq
cc8f8dca553c   mongo                 "docker-entrypoint.s…"   5 weeks ago    Exited (0) 4 weeks ago                                                                                                        mongo
4892f07cdf64   kibana:6.8.0          "/usr/local/bin/kiba…"   5 weeks ago    Exited (255) 4 weeks ago   0.0.0.0:5602->5601/tcp   
```

```$xslt
进入容器
$ docker exec -it tomcat bash
```
```$xslt
获取一个新镜像
$ docker pull ubuntu:13.10
```
```$xslt
查找镜像：我们可以从 Docker Hub 网站来搜索镜像，Docker Hub 网址为： https://hub.docker.com/
$ docker search httpd
```
```$xslt
拖取镜像
$ docker pull httpd
```
```$xslt
删除镜像
$ docker rmi ubuntu
如本地有多个镜像重名时，需要带上TAG，或使用 IMAGE ID 来删除
$ docker rmi ubuntu:13.10
$ docker rmi 7f020f7bf345
```
