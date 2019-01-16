- pstack
```
显示每个进程的栈跟踪
```
- pstree
```
树结构显示进程
```
- jstack
```
jstack需要在java进程启动用户下运行，否则提示：
35606: Unable to open socket file: target process not responding or HotSpot VM not loaded
The -F option can be used when the target process is not respondin
```
- docker国内镜像
```
https://i16tmfo8.mirror.aliyuncs.com
sudo mkdir -p /etc/docker
sudo tee /etc/docker/daemon.json <<-'EOF'
{
  "registry-mirrors": ["https://i16tmfo8.mirror.aliyuncs.com"]
}
EOF
sudo systemctl daemon-reload
sudo systemctl restart docker   
```
- docker查看所有后台容器
```
docker build -t nginx:v3 .
docker run --name web2 -d -p81:80 nginx:v3
docker ps -a -q 
#exec是进入已经存在的容器，run是创建新容器
docker exec -it ${ID/容器名称} /bin/bash
docker stop containerId
docker stop $(docker ps -a -q) //  stop停止所有容器
docker  rm $(docker ps -a -q) //   remove删除所有容器
```