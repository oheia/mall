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
