### Docker下安装ElasticSearch和Kibana
- 1、docker下安装elasticsearch
```shell script
docker pull elasticsearch:6.8.0
```
- 2、启动es
```shell script
docker run --name elasticsearch -p 9200:9200 -p 9300:9300 -e "discovery.type=single-node" -d elasticsearch:6.8.0
```
- 3、测试
```shell script
curl http://localhost:9200
```
或者在浏览器中打开http://localhost:9200这个网址，如果能看到以下信息则说明我们的es是已经安装好了的。
```
{
  "name" : "530dd7820315",
  "cluster_name" : "docker-cluster",
  "cluster_uuid" : "7O0fjpBJTkmn_axwmZX0RQ",
  "version" : {
    "number" : "7.2.0",
    "build_flavor" : "default",
    "build_type" : "docker",
    "build_hash" : "508c38a",
    "build_date" : "2019-06-20T15:54:18.811730Z",
    "build_snapshot" : false,
    "lucene_version" : "8.0.0",
    "minimum_wire_compatibility_version" : "6.8.0",
    "minimum_index_compatibility_version" : "6.0.0-beta1"
  },
  "tagline" : "You Know, for Search"
}
```
- 4、修改配置，解决跨域访问问题
首先进入到容器中，然后进入到指定目录修改elasticsearch.yml文件。
```shell script
docker exec -it elasticsearch /bin/bash
cd /usr/share/elasticsearch/config/
vi elasticsearch.yml
```
在elasticsearch.yml的文件末尾加上:
```shell script
http.cors.enabled: true
http.cors.allow-origin: "*"
exit
```
修改配置后重启容器即可。
```shell script
docker restart elasticsearch
```

- 5、安装ik分词器
es自带的分词器对中文分词不是很友好，所以我们下载开源的IK分词器来解决这个问题。首先进入到plugins目录中下载分词器，下载完成后然后解压，再重启es即可。具体步骤如下:
注意：elasticsearch的版本和ik分词器的版本需要保持一致，不然在重启的时候会失败。可以在这查看所有版本，选择合适自己版本的右键复制链接地址即可。
```shell script
cd /usr/share/elasticsearch/plugins/
elasticsearch-plugin install https://github.com/medcl/elasticsearch-analysis-ik/releases/download/v6.8.0/elasticsearch-analysis-ik-6.8.0.zip
exit
docker restart elasticsearch 
```
然后可以在kibana界面的dev tools中验证是否安装成功；
```shell script
POST test/_analyze
{
  "analyzer": "ik_max_word",
  "text": "你好我是东邪Jiafly"
}

```
不添加"analyzer": "ik_max_word",则是每个字分词，可以在下面kibana安装完成以后尝试一下。

- 6、docker安装kibana
```shell script
docker pull kibana:7.2.0
```

- 7、启动kibana
安装完成以后需要启动kibana容器，使用--link连接到elasticsearch容器，命令如下:

```shell script
docker run --name kibana --link=elasticsearch:test  -p 5601:5601 -d kibana:6.8.0
docker start kibana
```
启动以后可以打开浏览器输入http://localhost:5601就可以打开kibana的界面了。
