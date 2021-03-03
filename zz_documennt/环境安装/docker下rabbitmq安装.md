## Docker下安装RabbitMq

- 1、拉取镜像
```shell script
docker pull rabbitmq
```
- 2、启动
```shell script
docker run -d --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq
```

- 3、进入容器开启rabbitmq-management
```shell script
## 进入容器
docker exec -it rabbitmq bash
## 开启management
rabbitmq-plugins enable rabbitmq_management 
```

- 4、 创建用户
启动镜像之后，浏览器内输入 http://localhost:15672,默认的用户名密码都是guest,登录后可以在Admin那一列菜单内添加自己的用户。